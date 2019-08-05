package thinkInJava;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

//所有方法都被Synchronized修饰了
class Car {
    private final int id;
    private boolean engine = false, driveTrain = false, wheels = false;
    public Car(int id){
        this.id = id;
    }
    //
    public Car(){
        this.id = -1;
    }

    public synchronized int getId(){
        return this.id;
    }
    public synchronized void addEngine(){
        this.engine = true;
    }
    public synchronized void addDriveTrain(){
        this.driveTrain = true;
    }
    public synchronized void addWheels(){
        this.wheels = true;
    }

    @Override
    public synchronized String toString(){
        return "Car" + id + "[" + "engine:" +engine + " driveTrain:"+driveTrain + " wheels:" + wheels +"]";
    }
}

class CarQueue extends LinkedBlockingQueue<Car>{}

// 底盘制造
class ChassisBuilder implements Runnable{
    private CarQueue carQueue;
    private int counter = 0;
    //构造方法
    public ChassisBuilder(CarQueue cq){
        this.carQueue = cq;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(500);
                //Make Chassis
                Car c = new Car(counter++);
                System.out.println("ChassisBuilder created " + c);
                carQueue.put(c);
            }
        }catch (InterruptedException e){
            System.out.println("Interrupted:ChassisBuilder");
        }
        System.out.println("ChassisBuilder off");
    }
}

// 负责组装的类
class Assembler implements Runnable{
    private CarQueue chassisQueue, finishingQueue;
    private Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4);//需要4步来组装一辆车
    private RobotPool robotPool;
    public Assembler(CarQueue cq, CarQueue fq, RobotPool rp){
        this.chassisQueue = cq;
        this.finishingQueue = fq;
        this.robotPool = rp;
    }

    public Car car(){return car;}
    public CyclicBarrier barrier(){return barrier;}

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                // 在chassis可获取前都阻塞
                car = chassisQueue.take();

                // 让机器人们来干活
                robotPool.hire(EngineRobot.class,this);
                robotPool.hire(DriveTrainRobot.class,this);
                robotPool.hire(WheelRobot.class,this);
                barrier.await(); //机器人都干完活之前阻塞
                //将组装完成的car放入finishing队列
                finishingQueue.put(car);
            }
        }catch (InterruptedException e){
            System.out.println("Exiting Assembler via interrupt");
        }catch (BrokenBarrierException e){
            //这个异常我们需要捕获
            throw new RuntimeException(e);
        }
    }
}

//完成装配后的汽车通过该类来打印
class Reporter implements Runnable{
    private CarQueue carQueue;

    public Reporter(CarQueue cq){
        this.carQueue = cq;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                System.out.println(carQueue.take());
            }
        }catch (InterruptedException e){
            System.out.println("Exiting Reporter via interrupt");
        }
        System.out.println("Reporter off");
    }
}

abstract class Robot implements Runnable{
    private RobotPool pool;
    public Robot(RobotPool p){
        this.pool = p;
    }
    protected Assembler assembler;
    public Robot assignAssembler(Assembler assembler){
        this.assembler = assembler;
        return this;
    }
    private boolean engage = false;//是否被占用了
    public synchronized void engage(){
        this.engage = true;
        notifyAll();//在哪里wait呢？
    }

    //这里定义每个不同机器人的行为
    abstract protected void performService();

    @Override
    public void run() {
        try{
            powerDown();
            while(!Thread.interrupted()){
                performService();
                assembler.barrier().await();
                powerDown();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting" + this + "via interrupt");
        }catch (BrokenBarrierException e){
            throw new RuntimeException(e);
        }
        System.out.println(this + "off");
    }

    private synchronized void powerDown() throws InterruptedException{
        engage = false;
        assembler = null; //与Assembler断开连接
        // 将自己放回池子里
        pool.release(this);
        while (engage == false){
            wait();
        }
    }

    @Override
    public String toString(){
        return getClass().getName();
    }
}

class EngineRobot extends Robot {

    public EngineRobot(RobotPool pool){
        super(pool);
    }
    @Override
    protected void performService() {
        System.out.println(this + "installing engine");
        assembler.car().addEngine();
    }
}
class DriveTrainRobot extends Robot {

    public DriveTrainRobot(RobotPool pool){
        super(pool);
    }
    @Override
    protected void performService() {
        System.out.println(this + "installing DraveTrain");
        assembler.car().addDriveTrain();
    }
}
class WheelRobot extends Robot {

    public WheelRobot(RobotPool pool){
        super(pool);
    }
    @Override
    protected void performService() {
        System.out.println(this + "installing Wheels");
        assembler.car().addWheels();
    }
}

class RobotPool{
    //
    private Set<Robot> pool = new HashSet<Robot>();

    public synchronized void add(Robot r){
        pool.add(r);
        notifyAll(); //Notify的是等待RobotPool上的锁的
    }

    public synchronized void hire(Class<? extends Robot> robotType, Assembler d) throws InterruptedException {
        for(Robot r : pool){
            if(r.getClass().equals(robotType)){
                pool.remove(r);
                r.assignAssembler(d);
                r.engage(); // 使其工作起来
                return;
            }
        }
        wait(); // 没有Robot可用
        hire(robotType,d); // 重新hire一次
    }
    public synchronized void release(Robot r) {
        add(r);
    }
}

public class CarBuilder {
    public static void main(String[] args) throws InterruptedException {
        CarQueue chassisQueue = new CarQueue(), finishingQueue = new CarQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        RobotPool robotPool = new RobotPool();
        exec.execute(new EngineRobot(robotPool));
        exec.execute(new DriveTrainRobot(robotPool));
        exec.execute(new WheelRobot(robotPool));
        exec.execute(new Assembler(chassisQueue,finishingQueue,robotPool));
        exec.execute(new Reporter(finishingQueue));
        // 开始正式工作
        exec.execute(new ChassisBuilder(chassisQueue));
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }
}
