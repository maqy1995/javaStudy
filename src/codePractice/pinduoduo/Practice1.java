package codePractice.pinduoduo;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] listStr = new String[2];
        for(int i=0;i<2;i++){
            listStr[i] = sc.nextLine();
        }
        if(listStr[0] == null || listStr[1] == null || listStr[0].length()==0||listStr[1].length()==0){
            System.out.println("NO");
        }
        int[][] list = convertStr2List(listStr);
        int[] neighbor = findBreanNeighbor(list[0]);

        if(neighbor == null){
            System.out.println("NO");
        }else if(findAndChange(list[1],list[0],neighbor)&&isSort(list[0])){
            for(int i = 0;i<list[0].length;i++){
                System.out.print(list[0][i] + " ");
            }
        }else {
            System.out.println("NO");
        }
    }

    private static int[] findBreanNeighbor(int[] list){
        if(list == null){
            //输入不对
        }else if(list.length <= 1){
            return new int[] {0};
        }

        if(list[0] >= list[1]){
            return new int[] {0};
        }else if(list[list.length - 1] <= list[list.length - 2]){
            return new int[]{list.length - 1};
        }

        int before = list[0];
        for(int i = 1;i<=list.length-2;i++){
            if(list[i] <= before){
                return new int[] {i-1,i+1};
            }
            before = list[i];
        }
        return null;
    }
    private static boolean findAndChange(int[] list,int[] sortList,int[] neighbor){
        if(neighbor == null || list == null || list.length == 0){
            return false;
        }

        int beforeMax = Integer.MIN_VALUE;
        for(int i : list){
            if(neighbor.length == 1){
                if(neighbor[0] == 0 && i< sortList[1]){
                    if(beforeMax < i){
                        beforeMax = i;
                    }
                }else if(neighbor[0] != 0 && i > sortList[sortList.length - 2]){
                    if(beforeMax < i){
                        beforeMax = i;
                    }
                }
            }else if(i > sortList[neighbor[0]] && i < sortList[neighbor[1]]){
                if(i>beforeMax){
                    beforeMax = i;
                }
            }
        }
        if(beforeMax != Integer.MIN_VALUE){
            if(neighbor.length <= 1){
                sortList[neighbor[0]] = beforeMax;
            }else {
                sortList[neighbor[0]+1]=beforeMax;
            }
            return true;
        }else {
            return false;
        }
    }

    private static boolean isSort(int[] sortList){
        if(sortList == null || sortList.length <= 1){
            return true;
        }
        for(int i=0;i<sortList.length - 2;i++){
            if(sortList[i] >= sortList[i+1]){
                return false;
            }
        }
        return true;
    }

    private static int[][] convertStr2List(String[] listStr){
        int[][] list = new int[listStr.length][];

        for(int i= 0;i<listStr.length;i++){
            String[] items = listStr[i].trim().split(" ");
            list[i] = new int[items.length];
            for(int j = 0;j<items.length;j++){
                list[i][j] = Integer.parseInt(items[j]);
            }
        }
        return list;
    }
}
