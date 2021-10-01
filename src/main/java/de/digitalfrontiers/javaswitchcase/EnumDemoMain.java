package de.digitalfrontiers.javaswitchcase;

public class EnumDemoMain {

  /**
   * A variable to assign a new value with the switch case
   */
  public int normalClassField = 0;

  /**
   * Main method of enum demo.
   *
   * @param args
   */
  public static void main(String[] args) {
    EnumDemoMain demo = new EnumDemoMain();
    demo.normalEnum();
    demo.compileSafeEnumWithClassField();
    demo.compileSafeEnumWithLocalVariable();
    demo.genericCompileSafeEnum();
  }

  /**
   * Normal enum usage.
   * <p>
   * The compiler doesn't detect missing value in the switch case.
   */
  public void normalEnum() {
    System.out.println("Start: normalEnum()");
    for (NormalEnum normalEnum : NormalEnum.values()) {
      switch (normalEnum) {
        case BAR:
          System.out.println("    That is awesome");
          break;
        case BLA:
          System.out.println("    Bla, Bla, Bla");
          break;
        case FOO:
          System.out.println("    Foo, that hurts");
          break;
        default:
          System.out.println("    !!! Should not happen !!!");
          // But it happens, because the enum definition is incomplete
          break;
      }
    }
    System.out.println("End: normalEnum()");
  }

  /**
   * Usage of the FancyEnumSwitch interface.
   * <p>
   * Because of the interface the compiler detects a missing enum value.
   */
  public void compileSafeEnumWithClassField() {
    System.out.println("Start: compileSafeEnumWithClassField()");
    for (CompileSafeEnum fancyEnum : CompileSafeEnum.values()) {
      fancyEnum.switchCase(new CompileSafeEnum.EnumSwitch() {
        @Override
        public void xyz() {
          // Our outer EnumDemoMain object is effectively final,
          // so we can access and set every field as normal.
          normalClassField = 1;
        }

        @Override
        public void foo() {
          // "this" references the object of the inner class not EnumDemoMain.
          // To access EnumDemoMain object, we need to append the outer class in Java to access the outer "this".
          EnumDemoMain.this.normalClassField = 2;
        }

        @Override
        public void bar() {
          normalClassField = 3;
        }

        @Override
        public void bla() {
          normalClassField = 4;
        }
      });
      System.out.println(normalClassField);
    }
    System.out.println("End: compileSafeEnumWithClassField()");
  }

  /**
   * Same as compileSafeEnumWithClassField but this time setting a value of a
   * local variable.
   */
  public void compileSafeEnumWithLocalVariable() {
    System.out.println("Start: compileSafeEnumWithLocalVariable()");
    for (CompileSafeEnum fancyEnum : CompileSafeEnum.values()) {
      // For non class fields, we need a small workaround.
      // Local variables are not final and final variables are not changeable.

      // A final array with one element is effectively final and,
      // we can change the value.
      final int[] i = new int[1];
      fancyEnum.switchCase(
          new CompileSafeEnum.EnumSwitch() {

            @Override
            public void xyz() {
              i[0] = 1;
            }

            @Override
            public void foo() {
              i[0] = 2;
            }

            @Override
            public void bar() {
              i[0] = 3;
            }

            @Override
            public void bla() {
              i[0] = 4;
            }
          });
      System.out.println(i[0]);
    }
    System.out.println("End: compileSafeEnumWithLocalVariable()");
  }

  /**
   * We can also extend the Interface of the EnumSwitch to have a generic return value.
   */
  public void genericCompileSafeEnum() {
    System.out.println("Start: genericCompileSafeEnum()");
    for (GenericCompileSafeEnum genericEnum : GenericCompileSafeEnum.values()) {
      // We can also use Java Generics to add a return value if needed.
      int i = genericEnum.switchCase(
          new GenericCompileSafeEnum.EnumSwitch<Integer>() {

            @Override
            public Integer xyz() {
              return 1;
            }

            @Override
            public Integer foo() {
              return 2;
            }

            @Override
            public Integer bar() {
              return 3;
            }

            @Override
            public Integer bla() {
              return 4;
            }
          });
      System.out.println(i);
    }
    System.out.println("End: genericCompileSafeEnum()");
  }
}

