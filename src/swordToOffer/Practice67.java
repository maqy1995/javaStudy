package swordToOffer;

import java.util.Stack;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Practice67 {


    int num = 0;

    public int getNumSum(int x) {
        int result = 0;
        while (x != 0) {
            result = result + x % 10;
            x = x / 10;
        }
        return result;
    }

    public void visit(int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
        if (!visited[i][j]) {//如果该节点没有被访问过
            visited[i][j] = true;
            //判断是否符合题意可以访问
            if (getNumSum(i) + getNumSum(j) <= threshold) {
                this.num++;
                if (i - 1 >= 0) {
                    visit(threshold, rows, cols, i - 1, j, visited);
                }
                if (i + 1 < rows) {
                    visit(threshold, rows, cols, i + 1, j, visited);
                }
                if (j - 1 >= 0) {
                    visit(threshold, rows, cols, i, j - 1, visited);
                }
                if (j + 1 < cols) {
                    visit(threshold, rows, cols, i, j + 1, visited);
                }
            }
        }
    }

    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        //Stack<Location> stack=new Stack<>();
        visit(threshold, rows, cols, 0, 0, visited);
        return num;
    }

    public static void main(String[] args) {
        Stack<Location> stack = new Stack<>();
        Location a = new Location(1, 2);
        stack.push(a);
        Location b = new Location(1, 2);
        System.out.println(stack.contains(b));
    }
}

class Location {
    int row;
    int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Location) {
            if (((Location) obj).col == this.col && ((Location) obj).row == this.row) {
                return true;
            }
        }
        return false;
    }
}