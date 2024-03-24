package chapter07;

public class Homework03 {

    /*
    3.编写类Book，定义方法updatePrice，实现更改某本书的价格，具体:如果价格>150,则更改为150，如果价格>100,更改为100，否则不变
     */

    public static void main(String[] args) {

        Book secret = new Book("secret", 10);

        double newPrice = 90;
        secret.updatePrice(newPrice);

        System.out.println(secret.getName() + " price updated , now price is " + secret.getPrice());
    }
}

class Book {

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Book(double price) {
        this.price = price;
    }

    String name;
    double price;

    public void updatePrice(double newPrice) {
        if (newPrice > 150) {
            this.price = 150;
        } else if (newPrice > 100) {
            this.price = 100;
        } else {
            System.out.println("price not chenge...");
        }
    }
}
