package kmp;

public class Tree_Equal {

  public static boolean containsTree(Node big, Node small) {
    if (small == null) {
      return true;
    }
    if (big == null) {
      return true;
    }
    if (isSameTree(big, small)) {
      return true;
    }
    return containsTree(big.left, small) || containsTree(big.right, small);
  }

  public static boolean isSameTree(Node head1, Node head2) {
    if (head1 == null && head2 == null) {
      return true;
    }
    if ((head1 == null && head2 != null) || (head1 != null && head2 == null)) {
      return false;
    }
    if (head1.value != head2.value) {
      return false;
    }
    return isSameTree(head1.left, head2.left) && isSameTree(head1.right, head2.right);
  }
}
