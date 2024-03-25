package chapter08;

public class Homework06 {

    /*
    6.假定Grand .Father和Son在同一个包，问:父类和子类中通过this和super都可以调用哪些属性和方法,

    class Grand{
        String name="AA";
        private int age=100;
        public void g1() {}
    }
    class Father extends Grand{
        String id="001";
        private double score;
        public void f1(){
            //(1)方super可以访问哪些成员(属性和法)?
            // 答：
            super.name; super.g1();
            //(2)this可以访问哪些成员?
            // 答：
            this.id; this.double; this.f1(); this.name; this.g1();
        }
    }
    class Son extends Father{
        String name="BB";
        pubic void g1() {}
        private void show() {
            //(3)super可以访问哪些成员(属性和方法)?
            // 答：
            super.id; super.f1(); super.name; super.g1();
            //(4)this可以访问哪些成员?
            // 答：
            this.name; this.g1(); this.show(); this.id(); this.f1();
        }
    }
    答：
    (1): Grand -> super.name, super.g1()
    (2): Father -> this.id, this.score, this.f1(); Grand -> this.name, this.g1()
    (3): Father -> super.id, super.f1(); Grand -> super.name, super.g1()
    (4): Son -> this.name, this.g1(), this.show(); Father -> this.id, this.f1()
     */
}
