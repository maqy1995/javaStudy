package codePractice.pinduoduo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Practice3 {
    public static class Block {
        int width = 0;
        int weight = 0;
        int maxSupportWeight;

        public Block(int width) {
            this.width = width;
        }

        public void setWeight(int weight) {
            this.weight = weight;
            this.maxSupportWeight = weight * 7;
        }
    }

    public static class Height {
        int height = 0;
    }

    public static int maxHeight(Block[] blocks) {
        Arrays.sort(blocks, new Comparator<Block>() {
            @Override
            public int compare(Block o1, Block o2) {
                if (o1.width != o2.width) {
                    return o1.width - o2.width;
                } else {
                    return o1.weight - o2.weight;
                }
            }
        });
        return maxHeight(blocks, 0, new Height());
    }

    private static int maxHeight(Block[] blocks, int start, Height height) {
        if (start >= blocks.length) {
            return height.height;
        }

        int heightWhenLoad = -1;
        if (canSupport(blocks, start, 0)) {
            canSupport(blocks, start, 1);
            height.height += 1;
            heightWhenLoad = maxHeight(blocks, start + 1, height);
            canSupport(blocks, start, -1);
            height.height -= 1;
        }

        int heightWhenNotLoad = maxHeight(blocks, start + 1, height);
        canSupport(blocks, start, -1);
        height.height = -1;
        return Math.max(heightWhenLoad, heightWhenNotLoad);
    }

    private static boolean canSupport(Block[] blocks, int start, int dir) {
        int curWeight = blocks[start].weight;
        for (start = start - 1; start >= 0; start--) {
            if (curWeight <= blocks[start].maxSupportWeight) {
                blocks[start].maxSupportWeight += dir * curWeight;
                curWeight += blocks[start].weight;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Block[] blocks = new Block[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = new Block(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            blocks[i].setWeight(sc.nextInt());
        }

        System.out.println(maxHeight(blocks));
    }
}
