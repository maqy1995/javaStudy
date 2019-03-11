package swordToOffer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Practice31 {
    public String PrintMinNumber(int [] numbers) {
        StringBuilder sb = new StringBuilder();
        if(numbers == null || numbers.length == 0){
            return sb.toString();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0 ;i < numbers.length; i++){
            arrayList.add(String.valueOf(numbers[i]));
        }
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                int lim = Math.min(len1, len2);
                char v1[] = o1.toCharArray();
                char v2[] = o2.toCharArray();

                int k = 0;
                char c1 = v1[k];
                char c2 = v2[k];
                while (k < lim) {
                    c1 = v1[k];
                    c2 = v2[k];
                    if (c1 != c2) {
                        return c1 - c2;
                    }
                    k++;
                }
                if(lim == len1){
                    while (k < len2){
                        c2 = v2[k];
                        if (c1 != c2) {
                            return c1 - c2;
                        }
                        k++;
                    }
                }else {
                    while (k < len1){
                        c1 = v1[k];
                        if (c1 != c2) {
                            return c1 - c2;
                        }
                        k++;
                    }
                }
                return 0;
            }
        });
        for(String s : arrayList){
            sb.append(s);
            System.out.println(s+" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Practice31 practice31 = new Practice31();
        int[] ints = {3,32,321};
        practice31.PrintMinNumber(ints);
    }
}
