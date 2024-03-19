// 包的快速入门
package com.use;

import com.xiaoming.Dog;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);

        com.xiaoxiang.Dog dog1 = new com.xiaoxiang.Dog();
        System.out.println(dog1);
    }
}
