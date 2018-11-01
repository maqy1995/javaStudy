package collectionDemo;

public class List {
    public static void main(String[] args) {
        Person p1 = new Person(null,1);
        Person p2 = new Person(null,2);
        if(p1.getName()==p2.getName()){
            System.out.println("yes");
        }
        //引用字段 用Objects.equals判断，否则要判断是否为null，才能调用.equals()
    }


}
