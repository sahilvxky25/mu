import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TimeDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.print("Enter the first time (HH:mm:ss): ");
        String firstTimeInput = scanner.nextLine();
        LocalTime firstTime = LocalTime.parse(firstTimeInput, formatter);

        System.out.print("Enter the second time (HH:mm:ss): ");
        String secondTimeInput = scanner.nextLine();
        LocalTime secondTime = LocalTime.parse(secondTimeInput, formatter);

        long hoursBetween = ChronoUnit.HOURS.between(firstTime, secondTime);
        long minutesBetween = ChronoUnit.MINUTES.between(firstTime, secondTime) % 60;
        long secondsBetween = ChronoUnit.SECONDS.between(firstTime, secondTime) % 60;

        System.out.println("The difference is: " + Math.abs(hoursBetween) + " hours, " 
                            + Math.abs(minutesBetween) + " minutes, and " 
                            + Math.abs(secondsBetween) + " seconds.");

        scanner.close();
    }
}
