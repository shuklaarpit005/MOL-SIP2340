package project;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.print("Enter the first date and time (yyyy-MM-dd HH:mm): ");
        String input1 = scanner.nextLine();
        LocalDateTime dateTime1 = LocalDateTime.parse(input1, formatter);

        System.out.print("Enter the second date and time (yyyy-MM-dd HH:mm): ");
        String input2 = scanner.nextLine();
        LocalDateTime dateTime2 = LocalDateTime.parse(input2, formatter);

        // Calculate the difference between the two date-time objects
        Duration duration = Duration.between(dateTime1, dateTime2);

        // Calculate the difference in years, months, and days
        Period period = Period.between(dateTime1.toLocalDate(), dateTime2.toLocalDate());

        long years = period.getYears();
        long months = period.getMonths();
        long days = period.getDays();

        // Calculate the total minutes
//        long totalMinutes = duration.toMinutes();

        // Calculate the hours and minutes
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;

        // Output the results
        System.out.println("Years: " + years);
        System.out.println("Months: " + months);
        System.out.println("Days: " + days);
        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);

        scanner.close();
    }
}
