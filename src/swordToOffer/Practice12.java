package swordToOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 注意：浮点数和double类型的相等的判断，一般只要小于一个阈值即可认为是相等的
 * 考虑特殊情况:
 * 1.base是0
 * 2.exponent是负数
 *
 * 提升效率，可以利用  a^n = a^(n/2) * a^(n/2)        n为偶数
 *                           a^(n/2) * a^(n/2) * a    n为奇数
 */
public class Practice12 {

    //判断是否相等
    public boolean equal(double num1, double num2) {
        if((num1 - num2) < 0.000001 && (num1 - num2) > -0.000001) {
            return true;
        }else {
            return false;
        }
    }

    //O(logn)的算x^n次方
    public double PowerWithUnsignedExponent(double base, int exponent){
        //logn 的时间复杂度
        // 非零数的0次方都是1
        if(exponent == 0) {
            return 1;
        }
        //一次方就是自己
        if(exponent == 1) {
            return base;
        }
        double result = 0.0;
        result = PowerWithUnsignedExponent(base, exponent >> 1);
        result = result * result;
        //判断exponent是奇数还是偶数
        if((exponent & 1) == 1){
            //是奇数还要再乘以一个base
            result = result * base;
        }
        return result;
    }

    public double Power(double base, int exponent) {
        // 0 的 0 次方应该是多少呢？
        if(equal(base, 0.0)){
            // 0 的 0 次方设置为非法输入
            if(exponent == 0){
                throw new RuntimeException("不能求0的0次方");
            }else {
                // 0的任何非0次方都是0
                return 0;
            }
        }
        // 非零数的0次方都是1
        if(exponent == 0) {
            return 1;
        }
        //一次方就是自己
        if(exponent == 1) {
            return base;
        }
        double result = 0.0;
        // 如果exponent是负数，则先取整数，将结果取倒数即可
        if(exponent < 0) {
            exponent = -1 * exponent;
            result = 1.0/PowerWithUnsignedExponent(base, exponent);
        }else {
            //因为之前已经考虑过exponent为0的情况了，这里exponent一定是大于0
            result = PowerWithUnsignedExponent(base, exponent);
        }
        return result;
    }

    public static void main(String[] args) {
        Practice12 practice12 = new Practice12();
        System.out.println(practice12.Power(2,3));

    }
}
