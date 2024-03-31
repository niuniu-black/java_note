package chapter13.homework02;

/*
2.编程题
输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则生产异常对象要求:
(1)用户名长度为2或3或4
(2)密码的长度为6，要求全是数字'123456' isDigital
(3)邮箱中包含@和.并且@在.的前面
 */
public class Homework02 {

    public static void main(String[] args) {

        SignUp tom = null;
        try {
            tom = new SignUp("tom", "123456", "123@.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("signup info:");
        System.out.println("name: " + tom.getName());
        System.out.println("password: " + tom.getPassWord());
        System.out.println("email:  " + tom.getEMail());
    }
}

class SignUp {

    private String name;
    private String passWord;
    private String eMail;

    public SignUp(String name, String passWord, String eMail) {
        this.setName(name);
        this.setPassWord(passWord);
        this.setEMail(eMail);
        // 如果信息没有抛异常，说明信息设置成功
        signSuccess();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = checkName(name);
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = checkPassWord(passWord);
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = checkEMail(eMail);
    }

    // 用户名长度为2或3或4
    public String checkName(String name) {
        if (name == null) {
            throw new RuntimeException("name not null...");
        }
        if (!(name.length() >= 2 && name.length() <= 4)) {
            throw new RuntimeException("name length error...");
        }
        return name;
    }

    // 要求密码长度为6，全是数字 '123456'
    public String checkPassWord(String passWord) {
        if (passWord == null) {
            throw new RuntimeException("password not null...");
        }
        // 先判断长度为6
        if (passWord.length() != 6) {
            throw new RuntimeException("password length error...");
        }
        // 判断全为数字
        if (!isDigital(passWord)) {
            throw new RuntimeException("password format error...");
        }

        return passWord;
    }

    // 判断是否全为数字
    public boolean isDigital(String passWord) {
//        // 再将 password string -> int ，如果无法转换成int，则说明password不全为数字
//        int passWordToInt = 0;
//        try {
//            passWordToInt = Integer.parseInt(passWord);
//        } catch (NumberFormatException e) {
//            throw new RuntimeException("password format error...");
//        }
        // password string -> char , 判断
        char[] chars = passWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!(chars[i] >= '0' && chars[i] <= '9')) {
                return false;
            }
        }
        return true;
    }

    // 邮箱中包含@和.并且@在.的前面
    public String checkEMail(String eMail) {
        if (eMail == null) {
            throw new RuntimeException("email not null...");
        }
//        char[] chars = eMail.toCharArray();
//
//        for (int i = 0; i < chars.length - 1; i++) {
//            if (chars[i] == '@' && chars[i + 1] == '.') {
//                return new String(chars);
//            }
//        }
//
//        throw new RuntimeException("email format error...");

        // 其他方法
        int i = eMail.indexOf('@');
        int j = eMail.indexOf('.');
        if (!(i > 0 && j > i)) {
            throw new RuntimeException("email format error...");
        }
        return eMail;
    }

    public void signSuccess() {
        System.out.println("sign up success...");
    }
}
