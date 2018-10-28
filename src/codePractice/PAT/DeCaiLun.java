package codePractice.PAT;

import java.util.*;

/**
 * 输入描述:
 * 输入第1行给出3个正整数，分别为：N（<=105），即考生总数；L（>=60），为录取最低分数线，即德分和才分均不低于L的考生才有资格
 * 被考虑录取；H（<100），为优先录取线——德分和才分均不低于此线的被定义为“才德全尽”，此类考生按德才总分从高到低排序；才分不到
 * 但德分到线的一类考生属于“德胜才”，也按总分排序，但排在第一类考生之后；德才分均低于H，但是德分不低于才分的考生属于“才德兼
 * 亡”但尚有“德胜才”者，按总分排序，但排在第二类考生之后；其他达到最低线L的考生也按总分排序，但排在第三类考生之后。
 *
 * 随后N行，每行给出一位考生的信息，包括：准考证号、德分、才分，其中准考证号为8位整数，德才分为区间[0, 100]内的整数。数字间以空格分隔。
 *
 *
 * 输出描述:
 * 输出第1行首先给出达到最低分数线的考生人数M，随后M行，每行按照输入格式输出一位考生的信息，考生按输入中说明的规则从高到低排序。当某类考生中有多人
 * 总分相同时，按其德分降序排列；若德分也并列，则按准考证号的升序输出。
 *
 * 输入例子:
 * 14 60 80
 * 10000001 64 90
 * 10000002 90 60
 * 10000011 85 80
 * 10000003 85 80
 * 10000004 80 85
 * 10000005 82 77
 * 10000006 83 76
 * 10000007 90 78
 * 10000008 75 79
 * 10000009 59 90
 * 10000010 88 45
 * 10000012 80 100
 * 10000013 90 99
 * 10000014 66 60
 *
 * 输出例子:
 * 12
 * 10000013 90 99
 * 10000012 80 100
 * 10000003 85 80
 * 10000011 85 80
 * 10000004 80 85
 * 10000007 90 78
 * 10000006 83 76
 * 10000005 82 77
 * 10000002 90 60
 * 10000014 66 60
 * 10000008 75 79
 * 10000001 64 90
 *
 *
 * 用到了Collections的排序
 */
class Student{
    int ID;
    int DScore;
    int CScore;
    public Student(int id,int dScore,int cScore){
        this.ID=id;
        this.DScore=dScore;
        this.CScore=cScore;
    }
    //

    @Override
    public String toString() {
        return ID+" "+DScore+" "+CScore;
    }
}
class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        if((s1.DScore+s1.CScore) == (s2.DScore+s2.CScore)){
            //先返回值是反的完成降序排序
            if(s1.DScore==s2.DScore){
                //总分相同时，按其德分降序排列；若德分也并列，则按准考证号的升序输出。
                return s1.ID>s2.ID? 1:-1;
            }else {
                //总分相同，德分不同
                return s1.DScore>s2.DScore? -1:1;
            }
        }else {
            return  (s1.DScore+s1.CScore) > (s2.DScore+s2.CScore) ? -1:1;
        }
    }
}
public class DeCaiLun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=0,L=0,H=0;
        N=scanner.nextInt();//考生总数,
        L=scanner.nextInt();//录取最低分数线
        H=scanner.nextInt();//优先录取线
        int id=0;
        int dScore=0;
        int cScore=0;
        List<Student> caiDeQuanJin=new ArrayList<>();  //才得全尽的考生
        List<Student> deShengCai=new ArrayList<>();   //德胜才
        List<Student> third=new ArrayList<>();
        List<Student> fourth=new ArrayList<>();
        for(int i=0;i<N;i++){
            //对于每个考生
            id =scanner.nextInt();
            dScore=scanner.nextInt();
            cScore=scanner.nextInt();
            Student s=new Student(id,dScore,cScore);
            if(dScore>=L&&cScore>=L){
                if(dScore>=H&&cScore>=H){
                    caiDeQuanJin.add(s);
                }else if(dScore>=H){
                    deShengCai.add(s);
                }else if(dScore>=cScore){
                    third.add(s);
                }else {
                    fourth.add(s);
                }
            }
        }
        //已经得到了各个类型的考生，接下来需要排序
        int M=caiDeQuanJin.size()+deShengCai.size()+third.size()+fourth.size();//总人数.
        System.out.println(M);

        Iterator iterator;
        Student tmp;
        Collections.sort(caiDeQuanJin,new  StudentComparator());
        for(iterator=caiDeQuanJin.iterator();iterator.hasNext();){
            tmp = (Student) iterator.next();
            System.out.println(tmp);
        }
        Collections.sort(deShengCai,new StudentComparator());
        for(iterator=deShengCai.iterator();iterator.hasNext();){
            tmp = (Student) iterator.next();
            System.out.println(tmp);
        }
        Collections.sort(third,new StudentComparator());
        for(iterator=third.iterator();iterator.hasNext();){
            tmp = (Student) iterator.next();
            System.out.println(tmp);
        }
        Collections.sort(fourth,new StudentComparator());
        for(iterator=fourth.iterator();iterator.hasNext();){
            tmp = (Student) iterator.next();
            System.out.println(tmp);
        }
    }
}
