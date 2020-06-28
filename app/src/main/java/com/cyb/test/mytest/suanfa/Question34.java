package com.cyb.test.mytest.suanfa;

import java.util.ArrayList;
import java.util.List;

public class Question34 {
    /**
     * 丑数：因式分解后只包含 2 3 5 的数，1 为最小的丑数
     * 输入一个数找出 1~end 中的丑数
     * 下一个丑数为之前丑数 *2 或 *3 *5 的结果
     * 从之前已获得丑数中取依序 *2 或 *3 *5 找出恰好大于当前最大丑数（最后添加丑数）的索引，下一次从记录坐标开始遍历即可
     * 丑数依序生成，最大值永远为最新加入的丑数
     *
     * @param end
     * @return
     */
    public List<Integer> getUglyNum(int end) {
        if (end < 1) {
            return new ArrayList<>();
        }
        List<Integer> uglys = new ArrayList<>();
        int u1 = 0, u2 = 0, u3 = 0; // 分别记录当前丑数集合中 *2 或 *3 *5 <= 丑数集合当前最大值索引
        uglys.add(1);
        int min = minNum(uglys.get(u1) * 2, uglys.get(u2) * 3, uglys.get(u3) * 5);
        // 当下一最小丑数超过范围，则结束循环
        while (min < end) { // 每次添加最小丑数
            uglys.add(min);
            while (u1 + 1 < uglys.size() && uglys.get(u1) * 2 <= min) { // 更新最大边界值索引
                u1++;
            }
            while (u2 + 1 < uglys.size() && uglys.get(u2) * 3 <= min) {
                u2++;
            }
            while (u3 + 1 < uglys.size() && uglys.get(u3) * 5 <= min) {
                u3++;
            }
            min = minNum(uglys.get(u1) * 2, uglys.get(u2) * 3, uglys.get(u3) * 5); // 更新最大丑数
        }
        return uglys;
    }

    private int minNum(int u1, int u2, int u3) {
        int min = u1 > u2 ? u2 : u1;
        return min > u3 ? u3 : min;
    }


    public static void main(String[] args) {
        Question34 q = new Question34();
        System.out.println(q.getUglyNum(1500));
        int[] arrays = q.getUglyNum2(1500);
        for (int a : arrays) {
            System.err.print(a + ",");
        }

    }

    /**
     * 三指针法
     *
     * @param end
     * @return
     */
    private int[] getUglyNum2(int end) {

        int[] nums = new int[end];
        nums[0] = 1;

        //分别为2，3，5因子维护一个下标,最小数min为三个下标对应的丑数乘上自己的下标的最小数
        int a = 0, b = 0, c = 0;

        for (int i = 1; i < end; i++) {
            //这里每次都要乘，因为同一轮时a和b有可能都会加1
            int n2 = nums[a] * 2, n3 = nums[b] * 3, n5 = nums[c] * 5;
            int min = Math.min(n2, Math.min(n3, n5));
            nums[i] = min;

            if (min == n2) a++;
            if (min == n3) b++;
            if (min == n5) c++;
        }

        return nums;
    }
}
