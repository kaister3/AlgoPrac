package moris;

public class Morris {
  class Node {
    Node left;
    Node right;
    int value;
    Node (int value) {
      this.value = value;
    }
  }

  public static void morris(Node root) {
    if (root == null) {
      return;
    }
    Node cur = null;
    Node mostRight = null;
    while (cur != null) {
      // 1.判断是否有左树
      mostRight = cur;
      if (mostRight != null) {// 有左树
        // 找到cur左树上的真实（最右）前驱节点
        while (mostRight.right != null && mostRight.right != cur) {
          mostRight = mostRight.right;
        }
        if (mostRight == null) {
          // 第一次来
          mostRight.right = cur;
        }
      }
      cur = cur.right;
    }
  }
}
