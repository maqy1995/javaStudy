package designPatterns.proxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建学生 张三
        Person zs = new Student("张三");

        //生成代理对象，将张三传给他
        StudentProxy studentProxy = new StudentProxy(zs);

        //代理代替交班费
        studentProxy.giveMoney();
    }
}
