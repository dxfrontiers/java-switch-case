package de.digitalfrontiers.javaswitchcase;

import java.lang.reflect.InvocationTargetException;

public enum GenericReflectionCompileSafeEnum {
  XYZ,
  FOO,
  BAR,
  BLA;

  /**
   * That implementation uses reflection to map each enum value to its related method.
   * Because of the possible exceptions I recommend the abstract method with a manual implementation
   * with a simple unit test.
   *
   * @param enumSwitch
   * @param <T>
   * @return
   */
  public <T> T switchCase(GenericReflectionCompileSafeEnum.EnumSwitch<T> enumSwitch) {
    try {
      return (T)  enumSwitch.getClass().getMethod(this.name()).invoke(enumSwitch);
    } catch (NoSuchMethodException e) {
      // Only happens when the interface blow doesn't match the enum.
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      // Should only happend when called with null
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      // Ain't gonna happen
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
