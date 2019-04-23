package designPatterns.singleton;

/**
 * 懒汉式的单例模式，懒汉式的意思是指，一开始不创建实例，需要用到的时候才创建
 * 此种方法的缺点：不是线程安全的，多个线程同时调用getUniqueInstance时，可能都是null，每个线程都会创建一个Singleton1实例
 * 改进方法：通过给getUniqueInstance()方法加锁，但是会导致效率低下，因为一次只能有一个线程可以调用getUniqueInstance方法
 */
public class Singleton1 {
    private static Singleton1 uniqueInstance;
    //构造方法设置为私有，防止调用构造 方法构建出实例
    private Singleton1(){

    }
    public synchronized Singleton1 getUniqueInstance(){
        if(uniqueInstance==null) {
            return new Singleton1();
        }
        return uniqueInstance;
    }
}
