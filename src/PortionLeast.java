public class PortionLeast {
  public int find(int[] nums) {
    if (nums == null || nums.length < 1) {
      return -1;
    }
    int N = nums.length;
    if (nums.length == 1) {
      return 0;
    }
    if (nums[0] < nums[1]) {
      return 0;
    }
    if (nums[N-2] >nums[N-1]) {
      return N-1;
    }
    int L = 0;
    int R = N-1;
    int ans = -1;
    while (L <= R) {
      int mid = (L + R) / 2;
      if (nums[mid] < nums[mid-1] && nums[mid] < nums[mid + 1]) {
        ans = mid;
        break;
      }
      if (nums[mid] > nums[mid + 1]) {
        L = mid + 1;
        continue;
      }
      if (nums[mid] > nums[mid - 1]) {
        R = mid - 1;
      }
    }
    return ans;
  }

}
