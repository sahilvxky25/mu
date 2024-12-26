import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateTimeDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Date difference part
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.print("Enter the first date (yyyy-MM-dd): ");
        String firstDateInput = scanner.nextLine();
        LocalDate firstDate = LocalDate.parse(firstDateInput, dateFormatter);

        System.out.print("Enter the second date (yyyy-MM-dd): ");
        String secondDateInput = scanner.nextLine();
        LocalDate secondDate = LocalDate.parse(secondDateInput, dateFormatter);

        long daysBetween = ChronoUnit.DAYS.between(firstDate, secondDate);
        System.out.println("The difference in days between the two dates is: " + daysBetween);

        // Time difference part
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.print("Enter the first time (HH:mm:ss): ");
        String firstTimeInput = scanner.nextLine();
        LocalTime firstTime = LocalTime.parse(firstTimeInput, timeFormatter);

        System.out.print("Enter the second time (HH:mm:ss): ");
        String secondTimeInput = scanner.nextLine();
        LocalTime secondTime = LocalTime.parse(secondTimeInput, timeFormatter);

        long hoursBetween = ChronoUnit.HOURS.between(firstTime, secondTime);
        long minutesBetween = ChronoUnit.MINUTES.between(firstTime, secondTime) % 60;
        long secondsBetween = ChronoUnit.SECONDS.between(firstTime, secondTime) % 60;

        System.out.println("The difference in time between the two times is: " 
                            + Math.abs(hoursBetween) + " hours, " 
                            + Math.abs(minutesBetween) + " minutes, and " 
                            + Math.abs(secondsBetween) + " seconds.");

        scanner.close();
    }
}
