package collectionDemo;

import java.util.*;

public class CollectionsTest  {
    Collection c;
    AbstractCollection abstractCollection;

    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList();
        res.add(1);

        int[] a={1,2,3,4,5};
        Integer[] b = new Integer[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=a[i];
        }
        String s1="55";
        String s2="556";
        s1.length();
        StringBuffer sb = new StringBuffer();
        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        System.out.println(s1.compareTo(s2));
    }

}
