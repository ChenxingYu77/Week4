package Learnboxandunbox;
// 了解布尔的基本类型的封装类和常用方法
public class WrapperClassForBooleanAppMain {
    public static void main(String[] args) {
        // >> TODO boolean对应的类为Boolean，布尔值因为只有两个值，所以Boolean类直接提供了这两个值的静态变量
        System.out.println("----------------静态变量-------------");
        System.out.println(Boolean.TRUE);
        System.out.println(Boolean.FALSE);

        System.out.println("----------------valueOf-------------");
        // >> TODO 只有不分大小写的true才是true，剩下的字符串都是false
        System.out.println(Boolean.valueOf("true"));
        System.out.println(Boolean.valueOf("false"));
        System.out.println(Boolean.valueOf("asdf"));
        System.out.println(Boolean.valueOf("  true  "));

    }
}
