import java.time.YearMonth;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class MonthCalendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take year and month input
        System.out.print("Enter year: ");
        int year = input.nextInt();

        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();

        // Create a YearMonth object
        YearMonth yearMonth = YearMonth.of(year, month);

        // Get month name and number of days
        String monthName = yearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int daysInMonth = yearMonth.lengthOfMonth();

        System.out.println("\n    " + monthName + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        // Find out what day the month starts on
        LocalDate firstDay = yearMonth.atDay(1);
        int startDay = firstDay.getDayOfWeek().getValue(); // Monday = 1, Sunday = 7

        // Adjust for Sunday to be 0
        if (startDay == 7) {
            startDay = 0;
        }

        // Print spaces before first date
        for (int i = 0; i < startDay; i++) {
            System.out.print("   ");
        }

        // Print all dates of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);
            if ((day + startDay) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }
}