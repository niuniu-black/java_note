package chapter08;

public class Homework08 {

    /*
    8.扩展如下的BankAccount类

    class BankAccount {
        private double balance;  // 余额

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }
        // 存款
        public void deposit(double amount) {
            balance += amount;
        }
        // 取款
        public withdraw(double amount) {
            balance -= amount;
        }

        // set 和getBalance方法
    }

    要求:
    (1)在上面类的基础上扩展新类CheckingAccount对每次存款和取款都收取1美元的手续费
    (2)扩展前一个练习的BankAccount类，新类SavingsAccount每个月都有利息产生(earnMonthlylnterest方法被调用)，
       并且有每月三次免手续费的存款或取款。在earnMonthlylnterest方法中重置交易计数
    (3)体会重写的好处
     */

    static class BankAccount {
        private double balance;  // 余额

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        // 存款
        public void deposit(double amount) {
            balance += amount;
        }

        // 取款
        public void withdraw(double amount) {
            balance -= amount;
        }

        // set 和getBalance方法
        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
    }

    static class CheckingAccount extends BankAccount {
        private double commission = 1;

        @Override
        public void deposit(double amount) {
            super.deposit(amount);
            setBalance(getBalance() - commission);  // 收取手续费
        }

        @Override
        public void withdraw(double amount) {
            super.withdraw(amount);
            setBalance(getBalance() - commission);  // 收取手续费
        }

        public CheckingAccount(double initialBalance) {
            super(initialBalance);
        }

        public double getCommission() {
            return commission;
        }

        public void setCommission(double commission) {
            this.commission = commission;
        }
    }

    static class SavingsAccount extends BankAccount {

        private double rate = 0.03;  // 利率
        private int freeCount = 3;  // 免手续费存款或取款次数
        private double commission = 1;  // 手续费

        // 每月产生利息
        public void earnMonthlyInterest() {
            if (true) {  // 到达每个月1号时，计算利息
                setBalance(getBalance() * (1 + getRate()));
                setFreeCount(3);  // 到达每个月1号时，重置当月免收手续费的次数
            }
        }

        @Override
        public void deposit(double amount) {
            if (getFreeCount() > 0) {
                super.deposit(amount);
                setFreeCount(getFreeCount() - 1);  // 存款一次，减少一次免收手续费的次数
            } else if (getFreeCount() == 0) {  // 如果免手续费次数用完，则调用收手续费方法
                super.deposit(amount);
                setBalance(getBalance() - commission);  // 收取手续费
            }
        }

        @Override
        public void withdraw(double amount) {
            if (getFreeCount() > 0) {
                super.withdraw(amount);
                setFreeCount(getFreeCount() - 1);  // 取款一次，减少一次免收手续费的次数
            } else if (getFreeCount() == 0) {  // 如果免手续费次数用完，则调用收手续费方法
                super.withdraw(amount);
                setBalance(getBalance() - commission);  // 收取手续费
            }
        }

        public SavingsAccount(double initialBalance) {
            super(initialBalance);
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }

        public int getFreeCount() {
            return freeCount;
        }

        public void setFreeCount(int freeCount) {
            this.freeCount = freeCount;
        }
    }

    public static void main(String[] args) {

        CheckingAccount checkingAccount = new CheckingAccount(1000);
        checkingAccount.deposit(100);  // 存100
        System.out.println(checkingAccount.getBalance());
        checkingAccount.withdraw(50);  // 取50
        System.out.println(checkingAccount.getBalance());

        System.out.println("========");
        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.deposit(100);  // 免手续费
        savingsAccount.deposit(100);  // 免手续费
        savingsAccount.deposit(100);  // 免手续费
        System.out.println(savingsAccount.getBalance());
        savingsAccount.deposit(100);  // 扣手续费
        System.out.println(savingsAccount.getBalance());
        savingsAccount.withdraw(50);  // 扣手续费
        System.out.println(savingsAccount.getBalance());
        System.out.println("时间来到下月1号...");
        savingsAccount.earnMonthlyInterest();  // 计算利息，和重置免手续费次数
        System.out.println(savingsAccount.getBalance());
        savingsAccount.deposit(100);  // 免手续费
        savingsAccount.deposit(100);  // 免手续费
        savingsAccount.deposit(100);  // 免手续费
        System.out.println(savingsAccount.getBalance());
        savingsAccount.withdraw(50);  // 扣手续费
        System.out.println(savingsAccount.getBalance());

    }

}
