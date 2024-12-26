import java.math.BigDecimal;
import java.math.RoundingMode;

public class ScientificRounding {
    public static void main(String[] args) {
        double number = 123.456789;

        // Rounding to 2 decimal places
        BigDecimal bd = new BigDecimal(Double.toString(number));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Rounded to 2 decimal places: " + bd);

        // Rounding to 4 decimal places
        bd = new BigDecimal(Double.toString(number));
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        System.out.println("Rounded to 4 decimal places: " + bd);
    }
}
