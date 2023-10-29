import java.util.Scanner;

public class Input {
    static int newInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    static String newStr() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}