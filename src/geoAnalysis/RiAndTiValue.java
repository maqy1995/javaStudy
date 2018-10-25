package geoAnalysis;

public class RiAndTiValue implements Comparable<RiAndTiValue>{
    double r1;
    double r2;
    double r3;
    double t1u;
    double t2u;
    double t3u;
    double t1d;
    double t2d;
    double t3d;
    double maxValue;

    public RiAndTiValue(double r1, double r2, double r3, double t1u, double t2u, double t3u, double t1d, double t2d, double t3d, double maxValue) {
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.t1u = t1u;
        this.t2u = t2u;
        this.t3u = t3u;
        this.t1d = t1d;
        this.t2d = t2d;
        this.t3d = t3d;
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return "r1:"+r1 +" \n"+"r2:"+r2 +"  \n"+"r3:"+r3 +"  \n"+"t1u:"+t1u+"\n"+"t2u:"+t2u+"\n"+"t3u:"+t3u+"\n"+"t1d:"+t1d+"\n"+"t2d:"+t2d+"\n"+"t3d:"+t3d+"\n"+"maxvalue:"+maxValue;
    }


    @Override
    public int compareTo(RiAndTiValue o) {
        double result = this.maxValue-o.maxValue;
        if(result>0){
            return 1;
        }else if(result==0){
            return 0;
        }else {
            return -1;
        }
    }
}
