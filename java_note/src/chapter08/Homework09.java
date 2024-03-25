package chapter08;

public class Homework09 {

    /*
    9.设计一个Point类，其x和y坐标可以通过构造器提供。提供一个子类LabeledPoint，其构造器接受一个标签值和x, y坐标,
    比如:new LabeledPoint("BlackThursday”,1929,230.07)，写出对应的构造器即可
     */

    static class Point {
        private double xValue;
        private double yValue;

        public Point(double xValue, double yValue) {
            this.xValue = xValue;
            this.yValue = yValue;
        }

        public double getxValue() {
            return xValue;
        }

        public double getyValue() {
            return yValue;
        }
    }

    static class LabeledPoint extends Point {
        private String label;

        public LabeledPoint(String label,double xValue, double yValue) {
            super(xValue, yValue);
            this.label = label;
        }

        @Override
        public String toString() {
            return "LabeledPoint{" +
                    "xValue=" + getxValue() +
                    ", yValue=" + getyValue() +
                    ", label='" + label + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        LabeledPoint blackThursday = new LabeledPoint("BlackThursday", 1929, 230.07);
        System.out.println(blackThursday.toString());
    }
}
