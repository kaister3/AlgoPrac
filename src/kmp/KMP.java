package kmp;

public class KMP {
   public static boolean KMP(String s, String pattern) {
     // find next array
     int[] next = getNext(pattern);
     for (int i = 0, j = 0; i < s.length(); i++) {
       while (j > 0 && s.charAt(i) != pattern.charAt(j)) {
         j = next[j-1]; // => j = next[indexOf(j)-1];
       }
       if (s.charAt(i) == pattern.charAt(j)) {
         // 循环之后匹配上了，j = j + 1, 下次从后一个位置开始匹配
         j++;
       }
       if (j == pattern.length()) {
         return true;
       }
     }
     return false;
   }

   public static int[] getNext(String s) {
     if (s.length() == 1) {
       return new int[]{-1};
     }
     // 1.initializing
     int[] next = new int[s.length()];
     next[0] = 0; // there is no prefix before index 0
     int j = 0;
     for (int i = 1; i < s.length(); i++) {
       // 2.前后缀不相同
       while (j > 0 && s.charAt(i) != s.charAt(j)) {
         j = next[j - 1];
       }     // 3.前后缀相同
       if (s.charAt(i) == s.charAt(j)) {
         j++;
       }
       next[i] = j;
     }
     return next;
   }
}
