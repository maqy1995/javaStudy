package codePractice.Toutiao;

/**
 * 有N张卡牌堆成一摞，每张卡牌上都会有一个整数标记其分数。
 *
 * 现有两个人要交替从牌堆顶拿牌，每次至少拿一张，至多拿M张，直到牌堆被拿完。
 *
 * 每个人拿至手中的牌的分数和即为其最终得分。假设两个人都会采取最佳策略拿牌来使自己的得分最大化，请问先手拿牌的人的得分为多少？
 * 0 < N, M < 1,000,000,  每张牌的分数在-100和100之间
 *
 * 输入描述
 *输入第一行是样例个数；
 *
 * 对于每个样例，第一行是N，M，第二行有N个整数，代表牌堆顶到牌堆底N张牌的分数。
 *
 * 输出描述
 * 每个样例，输出一个整数代表先手得分。
 * 示例1
 * 输入
 * 2
 * 4 2
 * 1 1 1 1
 * 5 2
 * 3 -4 1 1 7
 * 输出
 * 2
 * 6
 * 说明
 * 第一个样例，先手拿2张1，最高得分为2。 第二个样例，先手拿3，-4，逼迫对方接下来只能拿1，1，最后自己再拿到7，所以先手最高得分为6。
 */

/**
 * 令f(i)表示从i...n的牌中，先手选的最大得分。则第一次选的时候，有m种选项，选1到m张牌。
 * 当第一个人选定x张牌之后，此时轮到第二个选，则此时转为第二个人先手，从第x+1张牌选起，为f(x+1)
 * f(i)=   max{sum[i,n]-f(i+j)},其中j∈[1,m],i+j<=n       当i<n-m+1时
 *         max{sum[i,n]-f(i+j),sum[i,n]}其中j∈[1,m],i+j<=n       当i>=n-m+1时，此时可以全选
 */
public class PlayingCard1 {

    public static int getMax(int[] input,int m){
        //m是一次可以取的个数
        int n=input.length-1; //牌的数量
        int[] sum = new int[n+1]; // 累加和
        for(int i=1;i<= n;i++){
            if(i==1){
                sum[i]=input[i];
            }else {
                sum[i]=sum[i-1]+input[i];
            }
        }
        int[] f=new int[n+1];
        f[n] = input[n];
        int i;
        for(i=n-1;i>=1;i--){
            int max = Integer.MIN_VALUE;
            for(int j=1;j<=m && i+j<=n;j++){
                max = Math.max(sum[n]-sum[i-1]-f[i+j],max);
            }
            if(i>=n-m+1){
                max = Math.max(max,sum[n]-sum[i-1]);
            }
            f[i]=max;
        }
        return f[1];
    }
    public static void main(String[] args) {
        //第0个位置不算，只是一个填充位
        int[] input = {0,3,-4,1,1,7};
        System.out.println(getMax(input,3));
    }
}
