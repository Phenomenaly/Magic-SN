public class Main {
    public static void main(String[] args) {

        Number newNum1 = new Number("10", 10);
        Number newNum2 = new Number("A", 16);


        System.out.println(newNum1.dec);
        System.out.println(Number.Plus(newNum1, newNum2));
        System.out.println(Number.Minus(newNum1, newNum2));
        System.out.println(Number.Multiply(newNum1, newNum2));
        System.out.println(Number.Division(newNum1, newNum2));
    }
}