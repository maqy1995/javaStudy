package designPatterns.singleton;

/**
 * 双重校验的单例模式，改进之处在于，当判断uniqueInstance为null时，才对创建uniqueInstance部分加锁
 *
 * 注意：如果通过序列化和反序列化是可以破坏单例模式的，原因是序列化会通过反射调用无参数的构造方法创建一个新的对象。
 * 解决方法：通过readResolve()方法来返回
 */
public class Singleton2 {
    private static volatile Singleton2 uniqueInstance;//注意这里一定要用volatile修饰
    // 起码可以避免，uniqueInstance指向的引用已经不是空了，但是还没初始化完成的情况。即禁止初始化的时候指令重排

    private Singleton2() {}

    public static Singleton2 getUniqueInstance() {
        if(uniqueInstance==null) {
            synchronized(Singleton2.class) { //
                if(uniqueInstance == null) { //必须还要校验一次，因为可能别的线程已经初始化过了
                    uniqueInstance = new Singleton2();
                }
            }
        }
        return uniqueInstance;
    }

    private Object readResolve(){
        return  uniqueInstance;
    }
}
