package exercises._01;

public class Test {

    public static void main(String[] args) {
        System.out.println(sum(1, 3));
        System.out.println(sum(4, 5));
        System.out.println(sum(-1, 3));
    }

    private static int sum(int a, int b) {
        if (a < 0 || b < 0) {
            throw new ArithmeticException();
        }

        return a + b;
    }
}
