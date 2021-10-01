package de.digitalfrontiers.javaswitchcase;

public enum GenericCompileSafeEnum {
  XYZ {
    @Override
    public <T> T switchCase(GenericCompileSafeEnum.EnumSwitch<T> enumSwitch) {
      return enumSwitch.xyz();
    }
  },
  FOO {
    @Override
    public <T> T switchCase(GenericCompileSafeEnum.EnumSwitch<T> enumSwitch) {
      return enumSwitch.foo();
    }
  },
  BAR {
    @Override
    public <T> T switchCase(GenericCompileSafeEnum.EnumSwitch<T> enumSwitch) {
      return enumSwitch.bar();
    }
  },
  BLA {
    @Override
    public <T> T switchCase(GenericCompileSafeEnum.EnumSwitch<T> enumSwitch) {
      return enumSwitch.bla();
    }
  };

  public abstract <T> T switchCase(GenericCompileSafeEnum.EnumSwitch<T> enumSwitch);

  public interface EnumSwitch<T> {

    T foo();

    T bar();

    T bla();

    T xyz();
  }
}