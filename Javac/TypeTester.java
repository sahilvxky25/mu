import java.util.*;

public class TypeTester {
    void printType(byte x) {
        System.out.println(x + " is a byte");
    }
    void printType(int x) {
        System.out.println(x + " is an int");
    }
    void printType(float x) {
        System.out.println(x + " is a float");
    }
    void printType(double x) {
        System.out.println(x + " is a double");
    }
    void printType(char x) {
        System.out.println(x + " is a char");
    }

    public static void main(String[] args) {
        TypeTester t = new TypeTester();
        byte b = 10;
        int i = 20;
        float f = 30.0f;
        double d = 40.0;
        char c = 'A';

        t.printType(b);
        t.printType(i);
        t.printType(f);
        t.printType(d);
        t.printType(c);
    }
}
