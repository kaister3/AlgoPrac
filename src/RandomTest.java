public class RandomTest {

  public static void main(String[] args) {
    int testTimes = 10000000;
    int count = 0;
//    for (int i = 0; i < testTimes; i++) {
//      if (f2() == 0) {
//        count++;
//      }
//    }
//    System.out.println((double) count / testTimes);

    int[] counts= new int[8];
    for (int i = 0; i < testTimes; i++) {
      counts[f3()]++;
    }

    for (int i = 0; i < 8; i++) {
      System.out.println(i + "appeared" + counts[i] + "times");
    }

  }

  public static int f1() {
    return (int)(Math.random()*5)+1;
  }

  public static int f2() {
    int ans = 0;
    do {
      ans = f1();
    } while (ans == 3);
    return ans < 3 ? 0 : 1;
  }

  public static int f3() {
    return (f2()<<2) + (f2()<<1) + (f2());
  }
}
