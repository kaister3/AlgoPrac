package kmp;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class KMPTreeEqual {
  public static boolean containsTree(Node big, Node small) {
    if (small == null) {
      return true;
    }
    if (big == null) {
      return false;
    }
    ArrayList<String> b = preSerial(big);
    ArrayList<String> s = preSerial(small);
    String[] str = new String[]{};
    String[] match = new String[]{};
    toArray(b, str);
    toArray(s, match);
    return getIndexOf(str, match) != -1;
  }
  public static ArrayList<String> preSerial(Node root) {
    ArrayList<String> ans = new ArrayList<String>();
    pres(root, ans);
    return ans;
  }

  public static void pres(Node root, ArrayList<String> ans) {
    if (root == null) {
      ans.add(null);
    } else {
      ans.add(String.valueOf(root.value));
      pres(root.left, ans);
      pres(root.right, ans);
    }
  }
  public static <T> T toArray(ArrayList<T> l, T[] t) {
    for (int i = 0; i < t.length; i++) {
      t[i] = l.get(i);
    }
    return null;
  }

  public static int getIndexOf(String[] str1, String[] str2) {
    if (str1 == null || str2 == null || str1.length < 1 || str1.length < str2.length) {
      return -1;
    }
    int j = 0;
    int[] next = getNextArray(str2);
    for (int i = 0; i < str1.length; i++) {
      while (j > 0 && !str1[i].equals(str2[j])) {
        j = next[j - 1];
      }
      if (str1[i].equals(str2[j])) {
        j++;
      }
      if (j == str2.length) {
        return i - j + 1;
      }
    }
    return -1;
  }

  public static boolean isEqual(String a, String b) {
    if (a == null && b == null) {
      return true;
    } else {
      if (a == null || b == null) {
        return false;
      } else {
        return a.equals(b);
      }
    }
  }

  public static int[] getNextArray(String[] str) {
    if (str.length == 1) {
      return new int[] {0};
    }
    int[] next = new int[str.length];
    next[0] = 0;
    int j = 0;
    for (int i = 0; i < str.length; i++) {
      while (j > 0 && !isEqual(str[i], str[j])) {
        j = next[j-1];
      }
      if (isEqual(str[j], str[i])) {
        j++;
      }
      next[i] = j;
    }
    return next;
  }
}
