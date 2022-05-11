public class ReverseLinkList {

  public static Node reverse(Node head) {
    Node pre = null;
    Node next = null;
    while (head != null) {
      next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }
    return pre;
  }

  public static void main(String[] args) {
    Node h = new Node(1);
    Node p = h;
    p.next = new Node(2);
    p.next.next = new Node(3);
    p.next.next.next = new Node(4);
    printNode(h);
    Node nh = reverse(h);
    printNode(nh);

  }

  public static void printNode(Node head) {
    while (head != null) {
      System.out.print(head.value + " ");
      head = head.next;
    }
    System.out.println();
  }
}
class Node {
  int value;
  Node next;
  Node last;

  Node(int a) {
    this.value = a;
  }
}
