package geoAnalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetBestRi {
    public static void main(String[] args) {
        double r1=0;
        double r2=0;
        double r3=1;

        double tu1=0;
        double tu2=0;
        double tu3=0;

        double td1=0;
        double td2=0;
        double td3=0;

        double max=0;
        double maxt=0;

        double s1=260;
        double s2=100;
        double s3=60;
        double s=s1+s2+s3;

        double u1=1;
        double u2=10;
        double u3=10;

        double d1=10;
        double d2=10;
        double d3=10;

        List<RiAndTiValue> listFinal=new ArrayList();
        for(double gap1=0.05;r1<=1;r1=r1+gap1){
            for(double gap2=0.05;r2<=1;r2=gap2+r2){
                if((r1+r2)<=1){

                    List<Double> list=new ArrayList();
                    r3=1-(r1+r2);

                    tu1=s1*(1-r1)/u1;
                    tu2=s2*(1-r2)/u2;
                    tu3=s3*(1-r3)/u3;

                    td1=(s-s1)*r1/d1;
                    td2=(s-s2)*r2/d2;
                    td3=(s-s3)*r3/d3;

                    list.add(tu1);
                    list.add(tu2);
                    list.add(tu3);
                    list.add(td1);
                    list.add(td2);
                    list.add(td3);


                    RiAndTiValue riAndTiValue=new RiAndTiValue(r1,r2,1-(r1+r2),tu1,tu2,tu3,td1,td2,td3,list.get(0));
                    Collections.sort(list);
                    Collections.reverse(list);
//                    for(double d:list){
//                        System.out.print(String.format("%.3f ", d));
//                    }
//                    System.out.println();

                    riAndTiValue.maxValue=list.get(0);
                    listFinal.add(riAndTiValue);
                }
            }
            r2=0;
        }


        Collections.sort(listFinal);
//        for(RiAndTiValue t:listFinal){
//            System.out.println(t);
//        }
        for(int i=0;i<5;i++){
            System.out.println("i:"+i);
            System.out.println(listFinal.get(i)+"\n");
        }
    }
}
