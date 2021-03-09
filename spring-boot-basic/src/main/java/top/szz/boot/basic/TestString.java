package top.szz.boot.basic;

/**
 * @author 囧态汗
 * @date 2021/3/9
 * @description TestString
 */
public class TestString {
    public static void main(String[] args) {
        String name = "111.jpg";
        int index = name.lastIndexOf(".");
        System.out.println(index);
        System.out.println(name.substring(index));
    }
}
