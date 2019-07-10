package swordToOffer;

public class StringToInteger {
    public int StrToInt(String str) {
        //1.首字符是正负号
        //2.中间有字符不对
        //3.字符串中数字越界
        int result=0;
        if(str==null || str.length()==0){
            return result;
        }
        int i=0;
        boolean flag=true;  //是正数还是负数,默认是正数
        if(str.charAt(i)=='+'){
            flag=true;
            i++;
        }else if(str.charAt(i)=='-'){
            flag=false;
            i++;
        }
        for(;i<str.length();i++){
            //如何判断是否越界呢？
            //Integer最大值为2147483647,最小值为-2147483648
            if(str.charAt(i)<'0'||str.charAt(i)>'9'){
                return 0;
            }
            if(flag){
                int temp=result*10+(str.charAt(i)-'0');
                if(temp<result){
                    return 0;
                }
                result=temp;
            }else{
                int temp=result*10-(str.charAt(i)-'0');
                if(temp>result){
                    return 0;
                }
                result=temp;
            }
        }
        return result;
    }
}
