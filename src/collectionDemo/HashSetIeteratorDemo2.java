package collectionDemo;

import java.util.HashSet;

public class HashSetIeteratorDemo2 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet =new HashSet<Integer>();
        for(int i =20 ;i>0 ; i--){
            hashSet.add(i);
        }

        //Iterator iterator = hashSet.iterator();
        for(int i=0;i<5;i++){
            for(int t:hashSet){
                System.out.print(t+" ");
            }
            System.out.println();
        }


    }
}
