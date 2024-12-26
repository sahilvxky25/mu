import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        System.out.println("Hello User");
        System.out.println("Put The Real Coefficient of the Quadratic Equation in its General Form");
        Scanner scan = new Scanner(System.in);
        double a,b,c,d,e,f;
        System.out.println("Put the Value of Quadratic Coefficient");
        a= scan.nextDouble();
        System.out.println("Put the Value of Linear Coefficient");
        b= scan.nextDouble();
        System.out.println("Put the Value of Coefficient");
        c= scan.nextDouble();
        d= (b*b)-(4*a*c);
        System.out.println("The value of d is " +d);
        if(d>=0){
            d= Math. pow(d,0.5);
            b= (-1)*b;
            e= (b+d)/2*a;
            System.out.println("The First Solution of the Equation " +e);
            f=(b-d)/2*a;
            System.out.println("The Second Solution of the Equation " +f);
        }else{
            System.out.println("There exist no real Roots to the equation");
        }
    }
}