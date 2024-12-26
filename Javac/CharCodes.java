import java.util.Scanner;

public class CharCodes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a character:");
        char ch = scanner.next().charAt(0);

        int ascii = (int) ch;
        int unicode = Character.codePointAt(new char[] { ch }, 0);

        System.out.println("ASCII code of '" + ch + "': " + ascii);
        System.out.println("Unicode of '" + ch + "': " + unicode);

        scanner.close();
    }
}
