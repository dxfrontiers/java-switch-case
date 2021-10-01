package de.digitalfrontiers.javaswitchcase;

import java.lang.reflect.InvocationTargetException;

/**
 * This is an over-engineered version.
 *
 * I highly recommend the abstract method with a manual implementation.
 */
public enum GenericReflectionCompileSafeEnum {
  XYZ,
  FOO,
  BAR,
  BLA;

  /**
   * This implementation uses reflection to map each enum value to its related method.
   * Because of the possible exceptions and the performance overhead
   * I highly recommend the abstract method with a manual implementation.
   *
   * @param enumSwitch
   * @param <T>
   * @return
   */
  public <T> T switchCase(GenericReflectionCompileSafeEnum.EnumSwitch<T> enumSwitch) {
    try {
      return (T)  enumSwitch.getClass().getMethod(this.name()).invoke(enumSwitch);
    } catch (NoSuchMethodException e) {
      // Happens when the interface blow doesn't match the enum. You need an unit test for that.
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      // Should only happen when called with null
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      // Ain't going to happen
      throw new RuntimeException(e);
    }
  }

  public interface EnumSwitch<T> {

    /**
     * We need exactly the same writing for the reflection to work.
     */
    T FOO();

    /**
     * We need exactly the same writing for the reflection to work.
     */
    T BAR();

    /**
     * We need exactly the same writing for the reflection to work.
     */
    T BLA();

    /**
     * We need exactly the same writing for the reflection to work.
     */
    T XYZ();
  }
}
