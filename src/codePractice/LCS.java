package codePractice;

public class LCS {

    public static void Lcs(char str1[], char str2[]) {
        int dp[][] = new int[str1.length][str2.length];
        //对dp矩阵的第一列赋值
        for (int i = 0; i < str1.length; i++) {
            if (str2[0] == str1[i]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        //对dp矩阵的第一行赋值
        for (int j = 0; j < str2.length; j++) {
            if (str1[0] == str2[j]) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int max = dp[0][0];
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }

    public static void Lcs2(char[] chars1, char[] chars2){
        int rows = chars2.length - 1;
        int cols = chars1.length - 1;
        int max = 0;
        for(int i = 0; i <= cols; i++){
            // 每次处理的是[0][i]这一斜线上的
            int tmp = 0;//存储的是前一次比较
            int row_now = 0;
            int col_now = i;
            while(row_now <= rows && col_now <= cols){
                if(chars1[col_now] == chars2[row_now]){
                    tmp++;
                    if(tmp > max){
                        max = tmp;
                    }
                }else {
                    tmp = 0;
                }
                row_now++;
                col_now++;
            }
        }
        for(int i = 1; i <= rows; i++){
            // 每次处理的是[i][0]这一斜线上的
            int tmp = 0;//存储的是前一次比较
            int row_now = i;
            int col_now = 0;
            while(row_now <= rows && col_now <= cols){
                if(chars1[col_now] == chars2[row_now]){
                    tmp++;
                    if(tmp > max){
                        max = tmp;
                    }
                }else {
                    tmp = 0;
                }
                row_now++;
                col_now++;
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) {
        char[] c1 = {'a','b','c'};
        char[] c2 = {'c','a','b','a'};
        Lcs2(c1,c2);
    }
}
