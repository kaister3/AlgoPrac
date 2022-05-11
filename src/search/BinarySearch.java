package search;

public class BinarySearch {
  static int[] nums = {1, 1, 1, 1, 2, 2, 3, 5, 6, 6, 8};

  public static int leftEndBinarySearch(int[] nums, int target) {
    if (nums == null || nums.length <= 1) {
      return -1;
    }
    int L = 0;
    int R = nums.length - 1;
    int ans = -1;
    while (L < R) {
      int mid = (L+R)/2;
      if (nums[mid] >= target) {
        ans = mid;
        R = mid - 1;
      } else {
        L = mid + 1;
      }
    }
    return ans;
  }
}
