package org.maslov.check17java.interviewquestions;

public class InitializationOrder {
  // Prints message and returns given object
  static <T> T init(String name, T object) {
    System.out.printf("Initializing '%s' to '%s'%n",
      name, object);
    return object;
  }

  public static class Base {
    {
      i = init("Base block i", 4);
    }
    private int i = init("Base instance i", 5);

    private static int x = init("Base static x", 1);

    private static int w;
    static {
      w = init("Baze.w static block ", 10);
    }

    private int ctorI;

    public Base() {
      ctorI = init("Base ctorI", 7);
    }

    private static int y = init("Base static y", 2);

    { // instance initialization block:
      j = init("Base instance block j", 6);
    }

    private static int z;
    static { // static initialization block:
      z = init("Base.z static block", 3);
    }

    private int j;
  }

  public static class Subclass extends Base {

    public Subclass() {
      ctorB = init("Subclass ctorB", 9);
    }

    int ctorB;

    int a = init("Subclass instance a", 8);

    static int foo = init("Subclass static foo", 4);
  }
}
