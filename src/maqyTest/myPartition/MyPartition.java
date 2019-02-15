package maqyTest.myPartition;

import java.util.ArrayList;

/**
 * 使用了单例模式，以便在Jobmanager上对MyPartition进行修改
 *
 * 注意！！！
 *  partition(Integer key, int numPartitions)中的key我需要写死，如果Reduce任务并行度超过了
 *  我统计的分段数，会导致超过的那些并不会接受到数据，所以前面的统计分段需要粒度小点，初步考虑100？
 */


public class MyPartition implements Partitioner<Integer>{

    private static final int NUM=100;

    //最终需要分成几片，可以考虑默认均分，如果有最优分配比例，则根据比例分
    public int parallism;

    //每个Channel默认应该分得 NUM/parallism 数量的数据
    public int perChannelNum;

    public ArrayList<Integer> channelSplit = null;

    private static class MyPartitionInstance{
        private static final MyPartition instance = new MyPartition();
    }

    private MyPartition(){}

    public static MyPartition getInstance(){
        return MyPartitionInstance.instance;
    }

    @Override
    public int partition(Integer key, int numPartitions) {
        //如果channelSplit为空，即不用按计算出的比例来，而是平均分配。(这里最后一个channel会有更多的数据)
        if(channelSplit == null || channelSplit.isEmpty()){
            int resultChannel = key/this.getPerChannelNum();
            if(resultChannel <= (this.getParallism()-1)){
                return resultChannel;
            }else {
                return (this.getParallism()-1);
            }
        }else {
            return 0;
        }
    }

    public int getPerChannelNum() {
        return perChannelNum;
    }

    private void setPerChannelNum() {
        if(this.getParallism() == 0){
            System.out.println("parallism是0，有错误！！！！！！！！");
        }
        this.perChannelNum = NUM/parallism;
    }

    public int getParallism() {
        return parallism;
    }

    public void setParallism(int parallism) {
        this.parallism = parallism;
        //设置并行度的同时，计算每个channel中应有的数据量
        this.setPerChannelNum();
    }

    public ArrayList<Integer> getChannelSplit() {
        return channelSplit;
    }

    public void setChannelSplit(ArrayList<Integer> channelSplit) {
        this.channelSplit = channelSplit;
    }
}
