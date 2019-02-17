package swordToOffer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */


public class Practice2 {
    /**
     * 思路：先从前往后遍历一遍，得到空格的数量，然后从后往前往后调整
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        //step 1.还是合法性判断
        if(str == null ){
            return null;
        }else {
            int num = 0;
            int i = 0;
            //通过一次遍历得到空格个数
            while(i<str.length()){
                if(str.charAt(i) == ' '){
                    ++num;
                }
                ++i;
            }
            //如果空格数为0，则直接返回
            if(num == 0){
                return str.toString();
            }
            // 每个空格，字符串长度都要+2
            int j = str.length() + num*2 - 1; //j表示新的字符串长度 - 1
            i = str.length() - 1;
            str.setLength(j + 1); //重新设置字符串长度
            while(j > i){//当i j 不重合时，都顺位后移 当第一个位置为空格时，i会为负数，而j会为0。
                if(str.charAt(i) != ' '){
                    str.setCharAt(j--,str.charAt(i));
                }else {
                    //如果判断i位置是空格，则需要在j那里插入%20
                    str.setCharAt(j--,'0');
                    str.setCharAt(j--,'2');
                    str.setCharAt(j--,'%');
                }
                --i;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer.length());
        //stringBuffer.append("   ");
        //System.out.println(stringBuffer.length());
        Practice2 practice2 = new Practice2();
        System.out.println(practice2.replaceSpace(stringBuffer));
    }
}
