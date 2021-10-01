package de.digitalfrontiers.javaswitchcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * To test that our switchCase method is correct we just need this simple test.
 */
class GenericCompileSafeEnumTest {

  @Test
  void switchCase() {
    for (GenericCompileSafeEnum safeEnum: GenericCompileSafeEnum.values()) {
      assertSame(safeEnum, safeEnum.switchCase(new GenericCompileSafeEnum.EnumSwitch<>() {

        @Override
        public GenericCompileSafeEnum foo() {
          return GenericCompileSafeEnum.FOO;
        }

        @Override
        public GenericCompileSafeEnum bar() {
          return GenericCompileSafeEnum.BAR;
        }

        @Override
        public GenericCompileSafeEnum bla() {
          return GenericCompileSafeEnum.BLA;
        }

        @Override
        public GenericCompileSafeEnum xyz() {
          return GenericCompileSafeEnum.XYZ;
        }
      }));
    }
  }
}