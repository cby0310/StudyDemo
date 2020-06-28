package com.cyb.test.mytest.suanfa;

import java.util.Arrays;

public class Sort {

    int count = 0;

    /**
     * 1.冒泡排序，最差、平均：O(n^2) 最好：O(n),稳定
     * 鸡尾酒排序：奇数轮从左到右、偶数轮从右向左的冒泡排序
     *
     * @param nums
     */
    private void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isChanged = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                count++;
                if (nums[j + 1] < nums[j]) {
                    isChanged = true;
                    swap(nums, j, j + 1);
                }
            }
            if (!isChanged) {
                break;
            }
        }
        System.err.println("count = " + count);
    }


    /**
     * 2.选择排序,最差、平均：O(n^2),不稳定
     *
     * @param nums
     */
    private void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(nums, minIndex, i);
            }
        }
    }


    /**
     * 3.插入排序,最差、平均：O(n^2) 最好：O(n) , 稳定
     */
    private void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j, temp = nums[i];
            for (j = i; j > 0 && nums[j - 1] > temp; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
    }


    /**
     * 以第一个数为基准，将nums下标从left到right的部分按大小两边分列
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {//从右侧找到第一个比基准小的数,相等时继续移动
                right--;
            }
            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot) {//从左侧找到第一个比基准大的数
                left++;
            }
            nums[right] = nums[left];
        }

        nums[left] = pivot;//将基准数字复位
        return left;
    }

    /**
     * 4.快排实现，平均：O(nlogn) 最坏：O(n^2)，不稳定
     * 快排的迭代实现？？？？？
     *
     * @param nums
     * @param left
     * @param right
     */
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = partition(nums, left, right);
//        System.err.println("middle = " + middle);
        quickSort(nums, left, middle - 1);
        quickSort(nums, middle + 1, right);
    }


    /**
     * 5.希尔排序，对直接插入排序的优化
     * 平均：O(n log n)，依赖步长所以其他时间复杂度不好推导,不稳定
     *
     * @param nums
     */
    private void shellSort(int[] nums) {
        for (int gap = nums.length / 2; gap > 0; gap = gap / 2) {//步长逐步减小

            for (int i = gap; i < nums.length; i++) {//每一个步长内处理
                int temp = nums[i], j;
                for (j = i; j >= gap && nums[j - gap] > temp; j = j - gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = temp;
            }

        }
    }

    /**
     * 6.归并排序  最差、平均、最好：O(n log n) ，稳定
     * 将数组分为一各个小块，对每一块进行排序再合并
     *
     * @param nums
     */
    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + ((end - start) >>> 1);
        mergeSort(nums, start, middle); //左半部分排序
        mergeSort(nums, middle + 1, end);//右半部分排序

        //这俩部分已经有序，此时不需要再次合并
        if (nums[middle] <= nums[middle + 1]) {
            return;
        }

        merge(nums, start, middle, end); //合并两个有序的部分
    }


    /**
     * 合并两个有序数组
     */
    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];//申请临时数组进行合并，这个数组可以全局共用
        int i = 0;
        int p1 = start;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= end) {
            temp[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }

        while (p2 <= end) {
            temp[i++] = nums[p2++];
        }

        // 把最终的排序的结果复制给原数组
        for (int j = 0; j < temp.length; j++) {
            nums[start + j] = temp[j];
        }
    }


    /**
     * 堆排序，最差、平均、最好：O(nlogn)，不稳定
     *
     * @param nums
     */
    private void heapSort(int[] nums) {

    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 4};
//        sort.quickSort(nums, 0, nums.length - 1);
//        sort.shellSort(nums);
        sort.mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
