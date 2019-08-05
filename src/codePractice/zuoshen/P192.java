package codePractice.zuoshen;

/**
 * 机器人达到指定位置方法数
 */
public class P192 {
    /**
     * 动态递归的方法
     * f(m,k) 表示 从m位置，经过k步，到达位置p的走法数
     * 则  f(m,k) = f(m-1,k-1) + f(m+1,k-1);
     * 初始条件为，f(i,1)
     * @param n n个位置
     * @param m 开始的位置
     * @param k 经过k步
     * @param p 最终到达的位置
     * @return 走法数量
     */
    public static int getNum(int n, int m, int k, int p){
        int[][] f = new int[n+1][k+1];
        f[p][1] = 0;
        if(p-1>=1){
            f[p-1][1] = 1;
        }
        if(p+1 <= n){
            f[p+1][1] = 1;
        }
        int calculate = 0;
        for(int j = 2; j <= k; j++){
            for(int i = 1; i <= n; i++){
                //按列处理,每次处理f[i][j]
                int sum = 0;
                if(i - 1 >= 1){
                    sum += f[i-1][j-1];
                }
                if(i + 1 <= n){
                    sum += f[i+1][j-1];
                }
                f[i][j] = sum;
                calculate++;
                if(i == m && j == k){
                    System.out.println("我已经输出了！" + calculate);
                    return f[i][j];
                }
            }
        }
        return f[m][k];
    }

    /**
     * 使用递归的方法求解
     * @param n 总共有多少个位置
     * @param cur 当前的位置
     * @param rest 剩下的步数
     * @param p 目标位置
     * @return
     */

    public static int walk(int n, int cur, int rest, int p){
        if(rest == 0){
            if(cur == p){
                //说明找到了一条路径
                return 1;
            }else {
                return 0;
            }
        }
        //此时说明剩余步数rest还大于0
        if(cur == 1){
            return walk(n,2,rest-1,p);
        }
        if(cur == n){
            return walk(n,n-1,rest-1,p);
        }
        return walk(n,cur-1,rest-1,p) + walk(n,cur+1,rest-1,p);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 7, m = 4, k = 9, p = 5;
        System.out.println(getNum(n,m,k,p));
        long end = System.currentTimeMillis();
    }
}
