public class Main {
    public static void main(String[] args) {

        Number newNum1 = new Number("10.734375", 10);
        Number newNum2 = new Number("A.B", 16);


        System.out.println(newNum1.dec); // 10.734375
        System.out.println(newNum2.dec); // 10.6875

        System.out.println(Number.Plus(newNum1, newNum2)); // 21.421875
        System.out.println(Number.Plus(newNum2, newNum1)); // 15.6C

        System.out.println(Number.Minus(newNum1, newNum2)); // 0.046875
        System.out.println(Number.Minus(newNum2, newNum1)); // -0.0C

        System.out.println(Number.Multiply(newNum1, newNum2)); // 114.7236328125
        System.out.println(Number.Multiply(newNum2, newNum1)); // 72.B94

        System.out.println(Number.Division(newNum1, newNum2)); // 1.0043859649122806043664013486704789102077484130859375
        System.out.println(Number.Division(newNum2, newNum1)); // 0.FEE1D10C4C0478



        Number num3 = new Number("FF0A", 16);
        Number num4 = new Number("1111 1111 0000 1010", 2);


        System.out.println(Number.isGreater(num3, num4)); // false
        System.out.println(Number.isGreaterOrEqual(num3, num4)); // true

        System.out.println(Number.isEqual(num3, num4)); // true

        System.out.println(Number.isLessOrEqual(num3, num4)); // true
        System.out.println(Number.isLess(num3, num4)); // false


        Number num5 = new Number("123.15", 10);

        System.out.println(Number.Floor(num5)); // 123
        System.out.println(Number.Floor(num5, 1)); // 123.1
        System.out.println(Number.Floor(num5, 2)); // 123.15
        System.out.println(Number.Floor(num5, 3)); // 123
    }
}