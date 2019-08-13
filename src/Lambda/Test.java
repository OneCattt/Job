package Lambda;

/**
 * @ClassName Test
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/8/7 16:21
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        MyLambdaInterface aBlockOfCode = System.out::println;
        enact(System.out::println, "Hello");
    }

    public static void enact(MyLambdaInterface myLambdaInterface, String s) {
        myLambdaInterface.doSomeShit(s);
    }


}
