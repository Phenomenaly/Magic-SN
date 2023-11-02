import static java.lang.Double.*;

public class Number {
    static String DIGIT = "0123456789ABCDEF";
    static String SPECIAL = ",.-_ ";

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
            this.value = "NaN";
            BASE = DIGIT;
        }
    }

    Number(int base) {
        this.base = base;

        BASE = DIGIT.substring(0, base);
    }

    char[] getChrArr() {
        value = value.replace(" ", "").replace("_", "");
        value = value.replace(",", ".");

        if (value.contains(".")) {
            for (int i = value.length() - 1; i >= value.indexOf('.'); i--) {
                if (value.charAt(i) != '0')
                    break;
                else
                    value = value.substring(0, i);
            }
        }

        if (value.charAt(value.length() - 1) == '.')
            value += "0";

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

        if (base == 10)
            return Double.toString(number);

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

        int count = 0;
        // Sometimes while cycle works long-time
        while (doublePart != 0) {
            doublePart *= base;

            temp = (int) doublePart; doublePart -= temp;

            newNumber.append(DIGIT.charAt(temp));

            count++; if (count > 100) break;
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

    /** Using function Plus as method*/
    void Plus(Number number) {
        value = Plus(this, number);
        dec = toDec();
    }
    /** Subtractions two numbers (their decimal representation) and displays the answer in the number system of the first number */
    static String Minus(Number number1, Number number2) {
        if (!number1.test || !number2.test)
            return "NaN";

        return toSN(number1.dec - number2.dec, number1.base);
    }

    /** Using function Minus as method*/
    void Minus(Number number) {
        value = Minus(this, number);
        dec = toDec();
    }

    /** Multiplications two numbers (their decimal representation) and displays the answer in the number system of the first number */
    static String Multiply(Number number1, Number number2) {
        if (!number1.test || !number2.test)
            return "NaN";

        return toSN(number1.dec * number2.dec, number1.base);
    }

    /** Using function Multiply as method*/
    void Multiply(Number number) {
        value = Multiply(this, number);
        dec = toDec();
    }

    /** Division two numbers (their decimal representation) and displays the answer in the number system of the first number */
    static String Division(Number number1, Number number2) {
        if (!number1.test || !number2.test)
            return "NaN";

        return toSN(number1.dec / number2.dec, number1.base);
    }

    /** Using function Division as method*/
    void Division(Number number) {
        value = Division(this, number);
        dec = toDec();
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


    /** Round down to the integer part*/
    void Floor() {
        if (!Double.isNaN(dec) && value.contains("."))
            value = value.substring(0, value.indexOf('.'));

        dec = toDec();
    }

    /** Round down to the index*/
    void Floor(int index) {
        if (!Double.isNaN(dec) && value.contains(".")) {
            if (value.indexOf('.') + index > 0 && value.length() - value.indexOf('.') > index) {
                value = value.substring(0, value.indexOf('.') + index + (index > 0 ? 1 : 0));

                if (index < 0)
                    value += "0".repeat(Math.abs(index));
            }
            else if (value.indexOf('.') + index <= 0)
                value = "0";

            dec = toDec();
        }

    }

    /** Mathematical rounding of a number to the integer part*/
    void Round() {
        this.Plus(new Number("0.5", 10));

        this.Floor();
    }

    /** Mathematical rounding of a number to the index*/
    void Round(int index) {
        if (index >= value.length() - value.indexOf('.') || value.indexOf('.') + index < 0) {}

        else if (index >= 0 && index < value.length() - value.indexOf('.'))
            this.Plus(new Number("0." + "0".repeat(index) + BASE.charAt(base / 2 + (base % 2 == 0 ? 0 : 1)), base));

        else {
            if (BASE.indexOf(value.charAt(value.indexOf('.') + index)) >= base / 2 + (base % 2 == 0 ? 0 : 1)) {
                this.Plus(new Number("1" + "0".repeat(Math.abs(index)), base));
                value += ".0";
            }
        }

        this.Floor(index);
    }

    /** Round up to the integer part*/
    void Ceil() {
        if (!Double.isNaN(dec) && value.contains(".")) {
            if (value.charAt(value.length() - 1) != '0')
                this.Plus(new Number("1", base));
        }

        this.Floor();
    }

    /** Round up to the index*/
    void Ceil(int index) {
        if (!Double.isNaN(dec) && value.contains(".")) {
            for (int i = value.indexOf('.') + index + (index >= 0 ? 1 : 0); i < value.length(); i++) {
                if (value.charAt(i) != '0') {
                    if (index <= 0)
                        this.Plus(new Number("1" + "0".repeat(Math.abs(index)), base));

                    else
                        this.Plus(new Number("0." + "0".repeat(index - 1) + "1", base));

                    break;
                }
            }
        }

        this.Floor(index);
    }

    /** Return absolute value of number*/
    static Number abs(Number number) {
        number.dec = Math.abs(number.dec);
        number.value = toSN(number.dec, number.base);

        return number;
    }

    /** Print main info of number (value & dec)*/
    static void print(Number number) {
        System.out.print(number.value + "\t" + number.dec);
    }

    /** Print main info of number (value & dec) and move the cursor to rhe next line*/
    static void println(Number number) {
        System.out.println(number.value + "\t" + number.dec);
    }
}