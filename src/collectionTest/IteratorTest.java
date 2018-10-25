package collectionTest;

public class IteratorTest {
    public static void main(String[] args) {
        ReadOnlyList<String> list = new ReadOnlyList<>("abc","def","hjk");
        for(String s : list){
            System.out.println(s);
        }
    }
}
