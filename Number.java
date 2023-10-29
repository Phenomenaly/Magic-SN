import static java.lang.Double.NaN;
import static java.lang.Double.parseDouble;

public class Number {
    static String DIGIT = "0123456789ABCDEF";
    static String SPECIAL = ".-_ ";

//    For the future:
//    static String SPECIAL = ".-_ ()";


    String value, BASE; int base; double dec; char[] chrArr; boolean test;

    Number(String value, int base) {
        this.value = value;
        this.base = base;
        this.chrArr = getChrArr();

        test = test();

        if (test) {
            BASE = DIGIT.substring(0, base);
            dec = toDec();
        }
        else {
            dec = NaN;
            BASE = DIGIT;
        }
    }

    char[] getChrArr() {
        value = value.replace(" ", "").replace("_", "");

        return value.toCharArray();
    }

    double toDec() {
        double tempDec = 0;
        StringBuilder intPart = new StringBuilder(), doublePart = new StringBuilder();

        // Если основание равно 10, то зачем выполнять все нижеописанное?
        if (base == 10)
            return parseDouble(value);

        // Если есть минус то удалить его из строки и в конце вычислений умножить результат на -1, в противном случае на 1
        byte sign = 1; boolean dot = false;
        if (value.contains("-")) {
            sign = -1;
            value = value.replace("-", "");
        }


        for (char c : value.toCharArray()) {
            if (c == '.') {
                dot = true;
                continue;
            }

            if (dot) doublePart.append(c);
            else intPart.append(c);
        }

        for (int i = 0; i < intPart.length(); i++) {
            char tempChr = intPart.charAt(i);

            tempDec += BASE.indexOf(tempChr) * Math.pow(base, intPart.length() - i - 1);
        }

        for (int i = 0; i < doublePart.length(); i++) {
            char tempChr = doublePart.charAt(i);

            tempDec += BASE.indexOf(tempChr) * Math.pow(base, -i - 1);
        }

        return tempDec * sign;
    }

    static String toSN(double number, int base) {
        int temp;
        StringBuilder newNumber = new StringBuilder();

        if (Double.isNaN(number))
            return "NaN";

        String sign = "";
        if (number < 0) {
            sign = "-";
            number *= -1;
        }


        int intPart = (int) number; double doublePart = number - intPart;

        while (intPart >= base) {
            temp = intPart % base;
            intPart /= base;

            newNumber.insert(0, DIGIT.charAt(temp));
        }
        newNumber.insert(0, DIGIT.charAt(intPart));

        if (doublePart != 0)
            newNumber.append(".");



        while (doublePart != 0) {
            doublePart *= base;

            temp = (int) doublePart; doublePart -= temp;

            newNumber.append(DIGIT.charAt(temp));
        }



        return sign + newNumber;
    }

    boolean test() {
        if (value.indexOf('-') != -1 && value.lastIndexOf('-') != 0) return false;

        if (value.indexOf('.') != value.lastIndexOf('.')) return false;

        if (value.indexOf('.') == 0 || value.indexOf('.') == value.length() - 1) return false;

        if (base > DIGIT.length() || base < 2) return false;

        for (char c : chrArr) {
            if (DIGIT.substring(0, base).indexOf(c) == -1 && SPECIAL.indexOf(c) == -1) return false;
        }

        return true;
    }

    /** Additions two numbers (their decimal representation) and displays the answer in the number system of the first number */
    static String Plus(Number number1, Number number2) {
        if (!number1.test || !number2.test)
            return "NaN";

        return toSN(number1.dec + number2.dec, number1.base);
    }

    /** Subtractions two numbers (their decimal representation) and displays the answer in the number system of the first number */
    static String Minus(Number number1, Number number2) {
        if (!number1.test || !number2.test)
            return "NaN";

        return toSN(number1.dec - number2.dec, number1.base);
    }

    /** Multiplications two numbers (their decimal representation) and displays the answer in the number system of the first number */
    static String Multiply(Number number1, Number number2) {
        if (!number1.test || !number2.test)
            return "NaN";

        return toSN(number1.dec * number2.dec, number1.base);
    }

    /** Division two numbers (their decimal representation) and displays the answer in the number system of the first number */
    static String Division(Number number1, Number number2) {
        if (!number1.test || !number2.test)
            return "NaN";

        return toSN(number1.dec / number2.dec, number1.base);
    }

    /** Returns true if number1 > number2 */
    static boolean isGreater(Number number1, Number number2) {
        return number1.dec > number2.dec;
    }

    /** Returns true if number1 >= number2 */
    static boolean isGreaterOrEqual(Number number1, Number number2) {
        return number1.dec >= number2.dec;
    }

    /** Returns true if number1 == number2 */
    static boolean isEqual(Number number1, Number number2) {
        return number1.dec == number2.dec;
    }

    /** Returns true if number1 <= number2 */
    static boolean isLessOrEqual(Number number1, Number number2) {
        return number1.dec <= number2.dec;
    }

    /** Returns true if number1 < number2 */
    static boolean isLess(Number number1, Number number2) {
        return number1.dec < number2.dec;
    }

    /** Returns a value without fractional part */
    static String Floor(Number number) {
        if (Double.isNaN(number.dec))
            return number.value;

        return number.value.substring(0, number.value.indexOf('.'));
    }

    /** Returns a number with the index of decimal places */
    static String Floor(Number number, int index) {
        if (Double.isNaN(number.dec))
            return number.value;

        if (index > 0 && index < number.value.length() - Floor(number).length())
            return number.value.substring(0, number.value.indexOf('.') + index + 1);

        return number.value.substring(0, number.value.indexOf('.'));
    }
}