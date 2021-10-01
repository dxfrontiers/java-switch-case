package de.digitalfrontiers.javaswitchcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * To test that our switchCase method is correct we just need this simple test.
 */
class CompileSafeEnumTest {

  @Test
  void switchCase() {
    for (CompileSafeEnum safeEnum: CompileSafeEnum.values()) {
      final String[] s = new String[1];
      safeEnum.switchCase(new CompileSafeEnum.EnumSwitch() {
        @Override
        public void foo() {
          s[0] = CompileSafeEnum.FOO.name();
        }

        @Override
        public void bar() {
          s[0] = CompileSafeEnum.BAR.name();
        }

        @Override
        public void bla() {
          s[0] = CompileSafeEnum.BLA.name();
        }

        @Override
        public void xyz() {
          s[0] = CompileSafeEnum.XYZ.name();
        }
      });
      assertSame(safeEnum.name(), s[0]);
    }
  }
}