package codePractice;

import java.net.Inet4Address;
import java.util.ArrayList;

/**
 * 辗转相除法，可以求公约数
 * 还可以求无限循环小数
 */
public class EuclideanAlgorithm {
    //需要保证 a > b
    public int getMaxNum(int a,int b){
        int r = a % b;
        if(r == 0){
            return b;
        }else {
            return getMaxNum(b,r);
        }
    }

    //存储出现过的数
    ArrayList<Integer> arr = new ArrayList<>();
    ArrayList<Integer> aux = new ArrayList<>();
    int index = -1;
    //求出a除以b的得数，可能是小数
    //保证a>b
    public void test(int a,int b){
        int t = a/b;
        int r = a%b;//余数
        arr.add(t);
        if(aux.contains(r)){
            index = aux.indexOf(r);
            return;
        }
        aux.add(r);
        if(r == 0){
            return;
        }
        //没有包含
        test(r*10,b);
    }

    public static void main(String[] args) {
        EuclideanAlgorithm euclideanAlgorithm = new EuclideanAlgorithm();
        //System.out.println(euclideanAlgorithm.getMaxNum(123456,7890));
        euclideanAlgorithm.test(558898-55,999900);
        StringBuilder sb = new StringBuilder();
        sb.append(euclideanAlgorithm.arr.get(0)+".");
        if(euclideanAlgorithm.index!=-1){
            for(int i=1;i<=euclideanAlgorithm.index;i++){
                sb.append(euclideanAlgorithm.arr.get(i)+"");
            }
            sb.append("(");
            for(int i=euclideanAlgorithm.index+1;i<euclideanAlgorithm.arr.size();i++){
                sb.append(euclideanAlgorithm.arr.get(i)+"");
            }
            sb.append(")");
        }
        System.out.println(sb.toString());
//        for(int x : euclideanAlgorithm.arr){
//            System.out.println(x);
//        }
//        System.out.println("index:"+euclideanAlgorithm.index);
    }
}
