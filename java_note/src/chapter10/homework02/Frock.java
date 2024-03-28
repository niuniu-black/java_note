package chapter10.homework02;

public class Frock {

    private static int currentNum = 100000;
    private int serialNumber;

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public static int getNextNum() {
        return currentNum += 100;
    }
}
