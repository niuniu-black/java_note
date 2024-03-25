package chapter08;

public class Homework04 {

    /*
    4.通过继承实现员工工资核算打印功能
    父类:员工类
    子类:部门经理类、普通员工类
    (1)部门经理工资=1000+单日工资*天数*等级（1.2)。(2)普通员工工资=单日工资*天数*等级(1.0) ;
    (3)员工属性:姓名，单日工资，工作天数
    (4)员工方法(打印工资)
    (5)普遍员工及部门经理都是员工子类，需要重写打印工资方法。
    (5)定义并初始化普通员工对象，调用打印工资方法输入工资，定义并初始化部门经理对象，调用打印工资方法输入工资
     */

    static class Employees {

        private String name;
        private double dailyWage;
        private double workDays;
        private double grade;

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            if (grade != 0) {
                this.grade = grade;
            } else {
                this.grade = 1;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getDailyWage() {
            return dailyWage;
        }

        public void setDailyWage(double dailyWage) {
            this.dailyWage = dailyWage;
        }

        public double getWorkDays() {
            return workDays;
        }

        public void setWorkDays(double workDays) {
            this.workDays = workDays;
        }

        public Employees(String name, double dailyWage, double workDays) {
            this.setName(name);
            this.setDailyWage(dailyWage);
            this.setWorkDays(workDays);
        }

        public Employees(String name, double dailyWage, double workDays, double grade) {
            this.setName(name);
            this.setDailyWage(dailyWage);
            this.setWorkDays(workDays);
            this.setGrade(grade);
        }

        public void salayInfo() {
            System.out.println("employees " + this.getName() + " salary : " +
                    (this.getDailyWage() * this.getWorkDays() * this.getGrade()));
        }
    }

    static class Manager extends Employees {

        private double bonus;


        public Manager(String name, double dailyWage, double workDays) {
            super(name, dailyWage, workDays, 1.2);
        }

        public double getBonus() {
            return bonus;
        }

        public void setBonus(double bonus) {
            this.bonus = bonus;
        }

        @Override
        public void salayInfo() {
            System.out.println("Manager " + this.getName() + " salary : " +
                    (this.bonus + this.getDailyWage() * this.getWorkDays() * this.getGrade()));
        }
    }

    static class OrdinaryEmployees extends Employees {

        public OrdinaryEmployees(String name, double dailyWage, double workDays) {
            super(name, dailyWage, workDays, 1.0);
        }

        @Override
        public void salayInfo() {
            System.out.println("Ordinary employees " + this.getName() + " salary : " +
                    (this.getDailyWage() * this.getWorkDays() * this.getGrade()));
        }
    }

    public static void main(String[] args) {

        OrdinaryEmployees tom = new OrdinaryEmployees("tom", 200, 30);
        tom.salayInfo();

        Manager jerry = new Manager("jerry", 300, 30);
        jerry.setBonus(2000);
        jerry.salayInfo();
    }

}
