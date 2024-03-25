package chapter08;

public class Homework05 {

    /*
    5.设计父类—员工类。子类:工人类(Worker),农民类(Peasant),教师类(Teacher),科学家类(Scientist),服务生类(Waiter)。
    (1)其中工人,农民,服务生只有基本工资
    (2)教师除基本工资外,还有课酬(元/天)
    (3)科学家除基本工资外,还有年终奖
    (4)编写一个测试类,将各种类型的员工的全年工资打印出来
     */

    static class Employees {

        private String name;
        private double basicSalary;
        private int salMonth = 12;

        public double allSalary() {
            return (this.getBasicSalary() * this.getSalMonth());
        }

        public void printAllSalary() {
            System.out.println(this.getName() + " all Salary is " + this.allSalary());
        }

        public int getSalMonth() {
            return salMonth;
        }

        public void setSalMonth(int salMonth) {
            this.salMonth = salMonth;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getBasicSalary() {
            return basicSalary;
        }

        public void setBasicSalary(double basicSalary) {
            this.basicSalary = basicSalary;
        }

        public Employees(String name, double basicSalary) {
            this.setName(name);
            this.setBasicSalary(basicSalary);
        }
    }

    static class Worker extends Employees {

        public Worker(String name, double basicSalary) {
            super(name, basicSalary);
        }

        @Override
        public double allSalary() {
            return super.allSalary();
        }

        @Override
        public void printAllSalary() {
            System.out.print("worker ");
            super.printAllSalary();
        }
    }

    static class Peasant extends Employees {

        public Peasant(String name, double basicSalary) {
            super(name, basicSalary);
        }

        @Override
        public double allSalary() {
            return super.allSalary();
        }

        @Override
        public void printAllSalary() {
            System.out.print("peasant ");
            super.printAllSalary();
        }
    }

    static class Waiter extends Employees {

        public Waiter(String name, double basicSalary) {
            super(name, basicSalary);
        }

        @Override
        public double allSalary() {
            return super.allSalary();
        }

        @Override
        public void printAllSalary() {
            System.out.print("waiter ");
            super.printAllSalary();
        }
    }

    static class Teacher extends Employees {

        private double teachingDaySalary;
        private double teachingDay;

        public Teacher(String name, double basicSalary, double teachingDaySalary, double teachingDay) {
            super(name, basicSalary);
            this.setTeachingDaySalary(teachingDaySalary);
            this.setTeachingDay(teachingDay);
        }

        public double getTeachingDay() {
            return teachingDay;
        }

        public void setTeachingDay(double teachingDay) {
            this.teachingDay = teachingDay;
        }

        public double getTeachingDaySalary() {
            return teachingDaySalary;
        }

        public void setTeachingDaySalary(double teachingDaySalary) {
            this.teachingDaySalary = teachingDaySalary;
        }

        @Override
        public double allSalary() {
            return (super.allSalary() + this.getTeachingDaySalary() * this.getTeachingDay());
        }

        @Override
        public void printAllSalary() {
            System.out.println("teacher " + this.getName() + " all salary is " + this.allSalary());
        }
    }

    static class Scientist extends Employees {

        private double bonus;

        public Scientist(String name, double basicSalary, double bonus) {
            super(name, basicSalary);
            this.setBonus(bonus);
        }

        public double getBonus() {
            return bonus;
        }

        public void setBonus(double bonus) {
            this.bonus = bonus;
        }

        @Override
        public double allSalary() {
            return (super.allSalary() + this.getBonus());
        }

        @Override
        public void printAllSalary() {
            System.out.println("scientist " + this.getName() + " all salary is " + this.allSalary());
        }
    }

    public static void main(String[] args) {

        Worker worker = new Worker("a", 3000);
        worker.printAllSalary();

        Peasant peasant = new Peasant("b", 2000);
        peasant.printAllSalary();

        Waiter waiter = new Waiter("c", 2500);
        waiter.printAllSalary();

        Teacher teacher = new Teacher("d", 4000, 200, 10);
        teacher.printAllSalary();

        Scientist scientist = new Scientist("e", 7000, 3000);
        scientist.printAllSalary();
    }
}
