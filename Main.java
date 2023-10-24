public class Main {
    public static void main(String[] args) {

        Number newNum1 = new Number("10.734375", 10);
        Number newNum2 = new Number("A.B", 16);



        System.out.println(newNum1.dec); // 10.734375
        System.out.println(newNum2.dec); // 10.6875

        System.out.println(Number.Plus(newNum1, newNum2)); // 21.421875
        System.out.println(Number.Plus(newNum2, newNum1)); // 15.6C

        System.out.println(Number.Minus(newNum1, newNum2)); // 0.46875
        System.out.println(Number.Minus(newNum2, newNum1)); // -0.0C

        System.out.println(Number.Multiply(newNum1, newNum2)); // 114.7236328125
        System.out.println(Number.Multiply(newNum2, newNum1)); // 72.B94

        System.out.println(Number.Division(newNum1, newNum2)); // 1.0043859649122806043664013486704789102077484130859375
        System.out.println(Number.Division(newNum2, newNum1)); // 0.FEE1D10C4C0478
        
        // Number newNum1 = new Number("10.A", 10);
        // Number newNum2 = new Number("A.B", 16);
        
        // System.out.println(newNum1.dec); // NaN (double)
        // System.out.println(newNum2.dec); // NaN (String)

        // System.out.println(Number.Plus(newNum1, newNum2)); // NaN (double)
        // System.out.println(Number.Plus(newNum2, newNum1)); // NaN (String)

        // System.out.println(Number.Minus(newNum1, newNum2)); // NaN (double)
        // System.out.println(Number.Minus(newNum2, newNum1)); // NaN (String)

        // System.out.println(Number.Multiply(newNum1, newNum2)); // NaN (double)
        // System.out.println(Number.Multiply(newNum2, newNum1)); // NaN (String)

        // System.out.println(Number.Division(newNum1, newNum2)); // NaN (double)
        // System.out.println(Number.Division(newNum2, newNum1)); // NaN (String)           
    }
}
