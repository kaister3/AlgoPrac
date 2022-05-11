package sort;

public class Sort {

  public static void selectionSort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }
    int N = nums.length;
    for (int i = 0; i < N; i++) {
      int minValueIndex = i;
      for (int j = i + 1; j < N; j++) {
        minValueIndex = nums[minValueIndex] > nums[j] ? j : minValueIndex;
      }
      swap(nums, i, minValueIndex);
    }
  }

  public static void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
    return;
  }

  public static void printArray(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }

  public static void bubbleSort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }
    int N = nums.length;
    for (int end = N-1; end >= 0; end--) {
      for (int i = 1; i <= end; i++) {
        if (nums[i-1] > nums[i]) {
          swap(nums, i-1, i);
        }
      }
    }
  }

  public static void insertSort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }
    int N = nums.length;
    for (int end = 1; end < N; end++) {
      int currentNumIndex = end;
      while (currentNumIndex-1 >= 0 && nums[currentNumIndex-1] > nums[currentNumIndex]) {
        swap(nums, currentNumIndex-1, currentNumIndex);
        currentNumIndex--;
      }
    }
  }

  public static void betteIinsertSort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }
    int N = nums.length;
    for (int end = 1; end < N; end++) {
      for (int pre = end-1; pre >= 0 && nums[pre] > nums[pre] ; pre--) {
        swap(nums, pre, pre-1);
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {7, 1, 3, 5, 6, 3, 7, 9, 8, 2};
    printArray(nums);
    betteIinsertSort(nums);
    printArray(nums);
  }
}
