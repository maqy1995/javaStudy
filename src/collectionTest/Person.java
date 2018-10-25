package collectionTest;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    @Override
    public int hashCode() {
        //在name和age相同时返回相同的hashCode
        return Objects.hash(this.name,this.age);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this){
            return true;
        }
        if(obj instanceof Person){
            Person p = (Person) obj;
            //引用类型需要先判断是否为null，不是null再用equals方法判断是否相等，所以可以用Objects.equals()方法
            if(Objects.equals(this,p)&& p.age==this.age){
                return true;
            }
        }
        return false;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
