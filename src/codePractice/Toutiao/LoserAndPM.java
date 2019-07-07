package codePractice.Toutiao;

import java.util.*;

class Idea {
    int PMid;
    int submitTime;
    int neededTime;
    int priority;
    int endTime;

    public Idea(int PMid, int submitTime, int neededTime, int priority) {
        this.PMid = PMid;
        this.submitTime = submitTime;
        this.neededTime = neededTime;
        this.priority = priority;
    }
}

class PM {
    //PM需要两个优先队列，一个用来存按时间顺序的idea
    PriorityQueue<Idea> pq1 = new PriorityQueue<>(new Comparator<Idea>() {
        @Override
        public int compare(Idea o1, Idea o2) {
            return o1.submitTime - o2.submitTime;
        }
    });
    //PM的id可以用数组下标来代替
    //PM中需要一个PriorityQueue来存储Idea

    //根据程序员时间选择获取最想完成的Idea
    public Idea getFirstIdea(int workerTime) {
        PriorityQueue<Idea> pq2 = new PriorityQueue<>(new Comparator<Idea>() {
            // 优先级顺序为优先等级高的，所需时间最少的，最早提出的
            // 注意排序一般是递增！！！
            @Override
            public int compare(Idea o1, Idea o2) {
                if (o1.priority != o2.priority) {
                    return o2.priority - o1.priority;
                } else if (o1.neededTime != o2.neededTime) {
                    return o2.neededTime - o1.neededTime;
                } else {
                    return o2.submitTime - o1.submitTime;
                }
            }
        });
        while (!pq1.isEmpty()) {
            if (pq1.peek().submitTime <= workerTime) {
                pq2.add(pq1.poll());
            } else {
                break;
            }
        }
        //如果workerTime时间之前已经有idea，则直接返回优先度高的，否则返回时间最小的
        Idea result = pq2.isEmpty() ? pq1.poll() : pq2.poll();
        //将pq2中的idea写回pq1
        while (!pq2.isEmpty()) {
            pq1.add(pq2.poll());
        }
        return result;
    }
}

class Worker {
    //每个程序员空闲的时候就会查看每个PM尚未执行并且最想完成的一个idea,
    // 然后从中挑选出所需时间最小的一个idea独立实现，如果所需时间相同则选择PM序号最小的。
    int freeTime = 0;

    public void work(Idea idea) {
        this.freeTime += idea.neededTime;
        idea.endTime = this.freeTime; //该idea的结束时间
    }
}

public class LoserAndPM {

    public static Idea  selectIdea(PM[] pms,Worker worker){
        // 选每个PM中小于worker时间的
        PriorityQueue<Idea> pq = new PriorityQueue<>(new Comparator<Idea>() {
            @Override
            public int compare(Idea o1, Idea o2) {
                if(o1.submitTime == o2.submitTime ||(o1.submitTime<=worker.freeTime && (o2.submitTime < worker.freeTime))){
                    if(o1.neededTime!=o2.neededTime){
                        return o1.neededTime - o2.neededTime;
                    }else {
                        return o1.PMid - o2.PMid;
                    }
                }
                if(o1.submitTime <= worker.freeTime){
                    return -1;
                }
                if(o2.submitTime <= worker.freeTime){
                    return 1;
                }
                //否则谁先提出来就是队首
                return o1.submitTime - o2.submitTime;
            }
        });

        for(PM pm : pms){
            Idea idea = pm.getFirstIdea(worker.freeTime);
            if(idea!=null){
                pq.add(idea);
            }
        }
        Idea targetIdea = pq.poll();
        //将拿出来的再写回去
        while(!pq.isEmpty()){
            Idea t = pq.poll();
            pms[t.PMid-1].pq1.add(t);
        }
        return targetIdea;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numPM = scan.nextInt();
        int numWorker = scan.nextInt();
        int numIdea = scan.nextInt();
        //有n行的idea个数，PM序号、提出时间、优先等级和所需时间
        ArrayList<Idea> inputIdea = new ArrayList<>();
        PriorityQueue<Worker> workerPriorityQueue = new PriorityQueue<>(new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                return o1.freeTime - o2.freeTime; //freeTime在前的先干
            }
        });
        for (int i = 0; i < numWorker; i++) {
            workerPriorityQueue.add(new Worker());
        }
        PM[] pms = new PM[numPM];
        for (int i = 0; i < numPM; i++) {
            pms[i] = new PM();
        }
        for (int i = 0; i < numIdea; i++) {
            int PMid = scan.nextInt();
            int submitTime = scan.nextInt();
            int priority = scan.nextInt();
            int neededTime = scan.nextInt();
            Idea idea = new Idea(PMid, submitTime, neededTime, priority);
            inputIdea.add(idea);
            pms[idea.PMid - 1].pq1.add(idea);
        }

        PriorityQueue<Idea> ideasPerPM = new PriorityQueue<>(new Comparator<Idea>() {
            @Override
            public int compare(Idea o1, Idea o2) {
                return o1.neededTime - o2.neededTime;
            }
        });
        //每个Idea都要运行一次
        while(true){
            Worker worker = workerPriorityQueue.poll();
            Idea workIdea = selectIdea(pms,worker);
            if(workIdea==null){
                break;
            }
            if(workIdea.submitTime>worker.freeTime){
                worker.freeTime = workIdea.submitTime;
            }
            worker.work(workIdea);
            //写回去
            workerPriorityQueue.add(worker);
        }
        for (Idea idea : inputIdea) {
            System.out.println(idea.endTime);
        }
    }
}
