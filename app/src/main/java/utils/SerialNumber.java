package utils;

public class SerialNumber {
  private static int serialNumber;

  public SerialNumber() {
    serialNumber = 0;
  }

  public static int createSerialNumber() {
    serialNumber += 1;
    return serialNumber;
  }
}
