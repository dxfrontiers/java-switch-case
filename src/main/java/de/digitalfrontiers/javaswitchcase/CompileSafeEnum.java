package de.digitalfrontiers.javaswitchcase;

/**
 * Extended version of NormalEnum with an inner class interface
 * for the compile-safe switch case.
 *
 * It uses the fact, that in Java each value of an enum is a class,
 * that could override methods of the enum.
 */
public enum CompileSafeEnum {

  XYZ {
    @Override
    public void switchCase(EnumSwitch enumSwitch) {
      // Each enum value overrides this method and calls its corresponding method in the enum definition.
      enumSwitch.xyz();
    }
  },
  FOO {
    @Override
    public void switchCase(EnumSwitch enumSwitch) {
      enumSwitch.foo();
    }
  },
  BAR {
    @Override
    public void switchCase(EnumSwitch enumSwitch) {
      enumSwitch.bar();
    }
  },
  BLA {
    @Override
    public void switchCase(EnumSwitch enumSwitch) {
      enumSwitch.bla();
    }
  };

  /**
   * With this abstract method we achieve that every enum value
   * has its own routing to its inner interface method (see below).
   *
   * It's possible to use Java reflection instead of the abstract method.
   */
  public abstract void switchCase(EnumSwitch enumSwitch);

  /**
   * This interface defines a method for each enum value.
   * Each enum value calls its corresponding method in the enum definition
   *
   * An implementation of this interface with the normal switch case logic,
   * is used as a parameter in the abstract method above. See the examples in
   * the EnumDemoMain class.
   */
  public interface EnumSwitch {

    void foo();

    void bar();

    void bla();

    void xyz();
  }
}
