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
        num5.Floor();
        Number.println(num5); // 123	123.0

        Number num6 = new Number("123.12", 10);
        num6.Floor(-1);
        Number.println(num6); // 120    120.0

        Number num7 = new Number("123.49999999", 10);
        num7.Round();
        Number.println(num7); // 123	123.0

        Number num8 = new Number("123.5", 10);
        num8.Round();
        Number.println(num8); // 124	124.0

        Number num9 = new Number("125.49", 10);
        num9.Round(1);
        Number.println(num9); // 125.5	125.5

        Number num10 = new Number("149.49", 10);
        num10.Round(-2);
        Number.println(num10); // 100	100.0

        Number num11 = new Number("2348.0", 16);
        num11.Round(-1);
        Number.println(num11); // 2340	9024.0

        Number num12 = new Number("2347.08", 15);
        num12.Round(-1);
        Number.println(num12); // 2340	7485.0

        Number num13 = new Number("149.000 001 000", 16);
        num13.Ceil();
        Number.println(num13); // 14A	330.0

        // Work in progress...
        Number num14 = new Number("149.400 001", 16);
        num14.Ceil(-1);
        Number.println(num14); // 140	320.0
    }
}