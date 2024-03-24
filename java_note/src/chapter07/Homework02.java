package chapter07;

public class Homework02 {

    /*
    2.编写类A02，定义方法find，实现查找某字符串是否在字符串数组中，并返回索引，如果找不到，返回-1.
     */

    public static void main(String[] args) {

        String findStr = "";
        String[] strArr = {"aaaa", "aabb", "aacc", "aadd", "nnmm", "xxyy"};
        Integer index;

        A02 a02 = new A02();
        index = a02.find(findStr, strArr);

        if (index != null) {
            if (index == -1 || index >= strArr.length) {
                System.out.println(findStr + " is not found...");
            } else {
                System.out.println(findStr + " is found in strArr number " + (index + 1));
            }
        } else {
            System.out.println("findStr or strArr not null ... and findStr or strArr length more than 0 ...");
        }
    }
}

class A02 {

    public Integer find(String str, String[] strArr) {

        if (str != null && str.length() > 0 && strArr != null && strArr.length > 0) {
            int index = -1;

            for (int i = 0; i < strArr.length; i++) {
                if (str.equals(strArr[i])) {
                    index = i;
                    break;
                }
            }

            return index;
        } else {
            return null;
        }
    }
}
