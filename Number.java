import static java.lang.Double.NaN;

public class Number {
    static String DIGIT = "0123456789ABCDEF";
    static String SPECIAL = ".-";


    String value, BASE; int base; double dec; char[] chrArr;

    Number(String value, int base) {
        this.value = value;

        this.base = base;
        BASE = DIGIT.substring(0, base);

        this.chrArr = getChrArr(value);

        dec = toDec(this);
    }

    char[] getChrArr(String number) {
        return number.toCharArray();
    }

    // Преобразование числа в его десятичное представление
    double toDec(Number number) {
        double tempDec = 0;
        StringBuilder intPart = new StringBuilder(), doublePart = new StringBuilder();

        // Если число не прошло тест, то вернуть Не Число
        if (!test()) return NaN;

        // Если есть минус то удалить его из строки и в конце вычислений умножить результат на -1, в противном случае на 1
        byte sign = 1; boolean dot = false;
        if (number.value.contains("-"))
            sign = -1;

        // Разбиение строки на две подстроки - после точки и до точки.
        for (char c : number.chrArr) {
            if (c == '.') {
                dot = true;
                continue;
            }

            if (dot) doublePart.append(c);
            else intPart.append(c);
        }

        // Вычисление целой части
        for (int i = 0; i < intPart.length(); i++) {
            char tempChr = intPart.charAt(i);

            tempDec += BASE.indexOf(tempChr) * Math.pow(number.base, intPart.length() - i - 1);
        }

        // Вычисление дробной части
        for (int i = 0; i < doublePart.length(); i++) {
            char tempChr = doublePart.charAt(i);

            tempDec += BASE.indexOf(tempChr) * Math.pow(number.base, -i - 1);
        }

        return tempDec * sign;
    }

    static String toSN(double number, int base) {
        int temp;
        StringBuilder newNumber = new StringBuilder();

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


        // Надо бы проверить на ошибки...
        while (doublePart != 0) {
            doublePart *= base;

            if (doublePart >= 1) {
                temp = (int) doublePart; doublePart -= temp;

                newNumber.append(DIGIT.charAt(temp));
            }
        }
        return sign + newNumber;
    }

    // проверяет, возможно ли число в данной системе счислия и верна ли запись
    boolean test() {

        if (value.indexOf('-') != -1 && value.lastIndexOf('-') != 0) return false;

        if (value.indexOf('.') != value.lastIndexOf('.')) return false;

        if (value.indexOf('.') == 0) return false;

        for (char c : chrArr) {
            if (BASE.indexOf(c) == -1 && SPECIAL.indexOf(c) == -1) return false;
        }

        return true;
    }

    // складывает два числа (их десятичное представление) и выводит ответ в системе счисления первого числа
    static String Plus(Number number1, Number number2) {
        return toSN(number1.dec + number2.dec, number1.base);
    }

    static String Minus(Number number1, Number number2) {
        return toSN(number1.dec - number2.dec, number1.base);
    }

    static String Multiply(Number number1, Number number2) {
        return toSN(number1.dec * number2.dec, number1.base);
    }

    static String Division(Number number1, Number number2) {
        return toSN(number1.dec / number2.dec, number1.base);
    }
}