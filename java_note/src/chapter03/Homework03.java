package chapter03;

public class Homework03 {

    /*
    保存两本书名，用 + 拼接，
    保存两个性别，用 + 拼接，
    保存两本书价格，用 + 拼接
     */

    public static void main(String[] args) {

        Book book1 = new Book();
        Book book2 = new Book();

        book1.name = "java";
        book1.gender = '男';
        book1.price = 100;

        book2.name = "spring";
        book2.gender = '女';
        book2.price = 20;

        // 保存两本书名，用 + 拼接 -> string + string = string
        System.out.println(book1.name + book2.name);
        // 保存两个性别，用 + 拼接 -> char + char = int(对应编码值)
        System.out.println(book1.gender + book2.gender);
        // 保存两本书价格，用 + 拼接 -> float + float = float
        System.out.println(book1.price + book2.price);

        System.out.println(
                "书名：" + book1.name +
                        "\n性别：" + book1.gender +
                        "\n价格：" + book1.price +
                        "\n书名：" + book2.name +
                        "\n性别：" + book2.gender +
                        "\n价格：" + book2.price
        );
    }
}

class Book {

    String name;
    char gender;
    float price;

}
