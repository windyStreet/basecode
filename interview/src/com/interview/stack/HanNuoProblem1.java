package com.interview.stack;

public class HanNuoProblem1 {
    public int hanoiProblem1(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    public int process(int num, String left, String mid, String right,
                       String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        //将需要移动的对象移动到相邻的位置 需要保证的 【来源是中间 或者 到达目标是中间】 即可
        if (from.equals(mid) || to.equals(mid)) {
            //移动到相邻位置
            String another = (from.equals(left) || to.equals(left)) ? right : left; // 需要借助的对象
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            //移动到间隔位置
            int part1 = process(num - 1, left, mid, right, from, to); // 移动整体内容 左到右
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from); // 移动整体内容 右到左
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, right, from, to); // 移动整体内容 左到右
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    public static void main(String[] args) {
        HanNuoProblem1 hnp = new HanNuoProblem1();
//        hnp.hanoiProblem1(1,"A","B","C");
//        hnp.hanoiProblem1(2,"A","B","C");
//        hnp.hanoiProblem1(3,"A","B","C");
        int counter = hnp.hanoiProblem1(4, "A", "B", "C");
        System.out.println("It will move " + counter + " steps.");
    }
}


