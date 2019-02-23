package swordToOffer;

/**
 * 输入数字n，按顺序打印出从1到最大的n位十进制数，比如输入3，则打印出1、2、3到999。
 * 陷阱：大数问题
 */
public class Page94 {
    public void printN(int n) {
        //先判断n是否合法
        if (n <= 0) {
            throw new RuntimeException("请输入大于0的数字!");
        }
        //利用字符数组来解决大数问题
        char[] bigNumber = new char[n];
        //初始化数组都为 '0'
        for (int i = 0; i < n; i++) {
            bigNumber[i] = '0';
        }
        while (!increment(bigNumber)) {
            printBigNum(bigNumber);
            System.out.println();
        }
    }

    public boolean increment(char[] bigNumber) {
        //如何判断已经达到 9999 了呢？，可以通过第0位是否进位了来判断
        boolean isOverflow = false;

        int nSum = 0; //用于记录是否到了10，到了10则进位的
        int nTakeOver = 0;
        //int t = 0;

        for (int i = bigNumber.length - 1; i >= 0; i--) {
            nSum = bigNumber[i] - '0' + nTakeOver; //得到第 i 位上的数字
            if (i == (bigNumber.length - 1)) {
                nSum++;
            }

            if (nSum >= 10) {
                //判断是否已经到9999了
                if (i == 0) {
                    isOverflow = true;
                    break;
                }
                //重置第 i 位上的数字， 并且进位加1
                //nSum = nSum - 10;
                bigNumber[i] = '0';
                nTakeOver = 1;
            } else {
                //说明第i位数字没有越界，则直接赋值跳出循环即可
                bigNumber[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    public void printBigNum(char[] bigNum) {
        boolean isBegin = true;
        boolean isPrintLine = false;
        for (int i = 0; i < bigNum.length; i++) {
            if (isBegin && bigNum[i] != '0') {
                isBegin = false;
            }
            if (!isBegin) {
                if (isPrintLine == false) {
                    isPrintLine = true;
                }
                System.out.print(bigNum[i]);
            }
        }
        if(isPrintLine){
            System.out.println();
        }
    }

    //使用递归的方式来打印，即把数字的每一位从0-9排列一遍
    public void printToMaxDigits(int n){
        if(n <= 0) {
            throw new RuntimeException("请输入大于0的数字");
        }
        char[] bigNumber = new char[n];
        // 可以不用初始化
//        for(int i = 0; i < bigNumber.length; i ++) {
//            bigNumber[i] = '0';
//        }

        printToMaxDigitsRecursively(bigNumber,0);

    }
    public void printToMaxDigitsRecursively(char[] bigNumber, int index){
        //到了最后一位
        if(index == (bigNumber.length - 1)) {
            for(int i = 0; i < 10; i++){
                bigNumber[index] = (char)('0' + i);
                printBigNum(bigNumber);
                //System.out.println();
            }
        }else {
            for(int i = 0; i < 10; i++) {
                bigNumber[index] = (char)('0' + i);
                printToMaxDigitsRecursively(bigNumber, index + 1);
            }
        }

    }

    public static void main(String[] args) {
        Page94 page94 = new Page94();
        //page94.printN(2);
        page94.printToMaxDigits(1);
    }
}
