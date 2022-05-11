package bfprt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BFPRT {
  // 无序数组中求第k小
  // 1. bfprt.BFPRT algorithm
  // 后面全一样，重点在于怎么选择 pivot
  public static int BFPRT(int[] arr, int L, int R, int index) {
    if (L == R) {
      // 保证BFPRT自身调用不会循环的边界条件
      return arr[L];
    }
    int pivot = medianOfMedians(arr, L, R);
    // 荷兰国旗问题
    // range[0, 1] 记录划分值
    int[] range = partition(arr, L, R, pivot);

    if (index >= range[0] && index <= range[1]) {
      // 命中
      return arr[index];
    } else if (index < range[0]) {
      return BFPRT(arr, L, range[0] - 1, index);
    } else {
      return BFPRT(arr, range[1] + 1, R, index);
    }
  }

  // 五个数一组
  // 每组内部排序
  // 每组中位数形成 marr
  // 返回marr的中位数
  public static int medianOfMedians(int[] arr, int L, int R) {
    int size = R - L + 1;
    // 够不够一组，不够要补
    int offset = size % 5 == 0 ? 0 : 1;
    int[] mArr = new int[size / 5 + offset];
    for (int team = 0; team < mArr.length; team++) {
      int teamFirst = L + team * 5;
      mArr[team] = getMedian(arr, teamFirst, Math.min(R, teamFirst + 4));
    }
    return BFPRT(mArr, 0, mArr.length - 1, mArr.length / 2);
  }

  public static int getMedian(int[] arr, int L, int R) {
    int[] newArr = Arrays.copyOfRange(arr, L, R + 1);
    Arrays.sort(newArr);
    return newArr[newArr.length / 2];
  }

  // 2. 如果在[L..R]范围上排序，找位于index的数字
  // 用 等概率 partition sort O(N)
  public static int process2(int[] arr, int L, int R, int index) {
    if (L == R) { // L == R ==
      return arr[L];
    }
    // 不止一个数 => L + [0, R - L] 中随机选一个
    int pivot = arr[L + (int) (Math.random() * (R - L + 1))];
    // 荷兰国旗问题
    // range[0, 1] 记录划分值
    int[] range = partition(arr, L, R, pivot);

    if (index >= range[0] && index <= range[1]) {
      // 命中
      return arr[index];
    } else if (index < range[0]) {
      return process2(arr, L, range[0] - 1, index);
    } else {
      return process2(arr, range[1] + 1, R, index);
    }
  }

  public static int[] partition(int[] arr, int L, int R, int pivot) {
    int less = L - 1;
    int more = R + 1;
    int cur = L;
    while (cur < more) {
      if (arr[cur] < pivot) {
        swap(arr, ++less, cur++);
      } else if (arr[cur] > pivot) {
        swap(arr, --more, cur);
      } else {
        cur++;
      }
    }
    return new int[] {++less, --more};
  }

  public static void swap(int[] arr, int x, int y) {
    int tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;
  }

  // 3.蓄水池算法
  // maxHeap
  public static class MaxHeapComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      return o2 - o1;
    }
  }

    // 大根堆, 找index为k的数
  public static int minKth(int[] arr, int k) {
    k += 1;
    PriorityQueue<Integer> q = new PriorityQueue<>(new MaxHeapComparator());
    for (int i = 0; i < k; i++) {
      q.add(arr[i]);
    }
    for (int i = k; i < arr.length; i++) {
      if (arr[i] < q.peek()) {
        q.poll();
        q.add(arr[i]);
      }
    }
    return q.peek();
  }

  public static void main(String[] args) {
    int[] arr = {9, 6, 12, 45, 26, 5, 7, 2, 1};
    System.out.println(process2(arr, 0, arr.length - 1, 3));
    System.out.println(BFPRT(arr, 0, arr.length - 1, 3));
    System.out.println(minKth(arr, 3));
  }
}
