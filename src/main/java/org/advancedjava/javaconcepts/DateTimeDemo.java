package org.advancedjava.javaconcepts;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/*
LocalDate: Represents a date without time or timezone (e.g., 2025-03-26).
LocalDateTime: Represents a date and time without timezone (e.g., 2025-03-26T10:15:30).
Both are part of the java.time package, which is immutable, thread-safe, and preferred
over legacy classes like Date and Calendar.

Why use them?
Cleaner, more intuitive API compared to java.util.Date.
No timezone ambiguity (unlike Date, which includes timezone internally).
Immutable, avoiding side effects in multi-threaded applications.
 */
public class DateTimeDemo {
    public static void main(String[] args) {
        // LocalDate and LocalDateTime are immutable—every manipulation returns a new instance.
        waysToInitiate();
        // Adding/Subtracting Time - Use plusXXX() or minusXXX() methods (e.g., plusDays(), minusMonths()).
        additionSubtractionOfDateTime();
        // Modifying Specific Fields - Use withXXX() methods to change a specific part (e.g., withYear(), withDayOfMonth()).
        modifyingDateTime();
        // Calculating Differences - Use Period for LocalDate and Duration for LocalDateTime.
        calculatingDifferences();
        // Formatting and Parsing - Use DateTimeFormatter for custom formatting.
        formattingAndParsing();

        /*
            "How do you find the number of days between two dates?"
            Use Period.between() or ChronoUnit.DAYS.between()
         */
        LocalDate start = LocalDate.of(2025, 1, 1);
        LocalDate end = LocalDate.of(2025, 3, 26);
        long days = ChronoUnit.DAYS.between(start, end); // 84 days
        System.out.println("Difference between startDate " + start + " and endDate " + end + " : " + days);

        // "How do you check if a year is a leap year?"
        LocalDate date1 = LocalDate.of(2024, 1, 1);
        boolean isLeap = date1.isLeapYear(); // true

        /*
            "How do you handle invalid dates?"
            Show exception handling
         */
        try {
            LocalDate invalid = LocalDate.of(2025, 2, 30); // February 30 doesn’t exist
        } catch (DateTimeException e) {
            System.out.println("Invalid date: " + e.getMessage());
        }

        // "Write a method to check if a given date is within 30 days from today."
        LocalDate date2 = LocalDate.of(2025, 4, 10); // Today is 2025-03-26
        System.out.println(isWithin30Days(date2)); // true (15 days difference)

        /*
            Comparing LocalDate and LocalDateTime:
            Both classes implement the Comparable interface, so you can compare instances of the same type
            directly using methods like isBefore(), isAfter(), isEqual(), or the compareTo() method.
         */


        // "Check if an event is in the future"
        LocalDateTime futureEvent = LocalDateTime.of(2025, 4, 1, 10, 0);
        System.out.println(isFutureEvent(futureEvent)); // true (today is 2025-03-26)

        // "Check if two date ranges overlap"
        LocalDate range1Start = LocalDate.of(2025, 3, 26);
        LocalDate range1End = LocalDate.of(2025, 4, 1);
        LocalDate range2Start = LocalDate.of(2025, 3, 30);
        LocalDate range2End = LocalDate.of(2025, 4, 5);
        System.out.println(doDateRangesOverlap(range1Start, range1End, range2Start, range2End)); // true



    }

    //Common ways to instantiate
    public static void waysToInitiate() {
        // Current date and time
        LocalDate today = LocalDate.now();          // e.g., 2025-03-26 (yyyy-mm-dd)
        LocalDateTime now = LocalDateTime.now();    // e.g., 2025-03-26T14:30:45 (yyyy-mm-dd)

        // Specific date/time
        LocalDate date = LocalDate.of(2025, 3, 26);         // 2025-03-26
        LocalDateTime dateTime = LocalDateTime.of(2025, 3, 26, 14, 30); // 2025-03-26T14:30:00

        // Parsing from string
        LocalDate parsedDate = LocalDate.parse("2025-03-26");               // 2025-03-26
        LocalDateTime parsedDateTime = LocalDateTime.parse("2025-03-26T14:30:00"); // 2025-03-26T14:30:00
    }

    public static void additionSubtractionOfDateTime() {
        LocalDate today = LocalDate.now();          // 2025-03-26
        LocalDate nextWeek = today.plusDays(7);  // 2025-04-02
        LocalDate lastMonth = today.minusMonths(1); // 2025-02-26
        LocalDate nextYear = today.plusYears(1); // 2026-03-26

        LocalDateTime now = LocalDateTime.now();    // 2025-03-26T14:30:45
        LocalDateTime inTwoHours = now.plusHours(2); // 2025-03-26T16:30:45
        LocalDateTime inThreeMinutes = now.plusMinutes(3);
        LocalDateTime minusedSeconds = now.minusSeconds(41);
    }

    public static void modifyingDateTime() {
        LocalDate date = LocalDate.of(2025, 3, 26);
        LocalDate newYear = date.withYear(2026);    // 2026-03-26
        LocalDate firstOfMonth = date.withDayOfMonth(1); // 2025-03-01

        LocalDateTime dateTime = LocalDateTime.of(2025, 3, 26, 14, 30);
        LocalDateTime newTime = dateTime.withHour(10); // 2025-03-26T10:30:00
    }

    public static void calculatingDifferences() {
        /*
            Period is for date-based differences (years, months, days),
            while Duration is for time-based differences (hours, minutes, seconds).
         */
        // Between two LocalDates
        LocalDate start = LocalDate.of(2025, 1, 1); //2025-01-01
        LocalDate end = LocalDate.of(2025, 3, 26); //2025-03-26
        Period period = Period.between(start, end); // P2M25D (2 months, 25 days)
        System.out.println(period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days");

        // Between two LocalDateTimes
        LocalDateTime startTime = LocalDateTime.of(2025, 3, 26, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 3, 26, 14, 30);
        Duration duration = Duration.between(startTime, endTime); // PT4H30M (4 hours, 30 minutes)
        System.out.println(duration.toHours() + " hours");
    }

    public static void formattingAndParsing() {
        LocalDate date = LocalDate.of(2025, 3, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatted = date.format(formatter); // "26/03/2025"

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");
        String formattedTime = dateTime.format(timeFormatter); // e.g., "26-Mar-2025 14:30"

        //Parsing back
        LocalDate parsed = LocalDate.parse("26/03/2025", formatter); // 2025-03-26
    }

    public static boolean isWithin30Days(LocalDate date) {
        LocalDate today = LocalDate.now();
        long daysBetween = Math.abs(ChronoUnit.DAYS.between(today, date));
        return daysBetween <= 30;
    }

    public static void compareLocalDates() {
        LocalDate date1 = LocalDate.of(2025, 3, 26);
        LocalDate date2 = LocalDate.of(2025, 4, 1);

        // Using isBefore(), isAfter(), isEqual()
        boolean isBefore = date1.isBefore(date2);   // true (2025-03-26 < 2025-04-01)
        boolean isAfter = date1.isAfter(date2);     // false
        boolean isEqual = date1.isEqual(date2);     // false

        // Using compareTo() (returns -1, 0, or 1)
        int comparison = date1.compareTo(date2);    // -1 (date1 < date2)
    }

    public static void compareLocalDateTimes() {
        LocalDateTime dt1 = LocalDateTime.of(2025, 3, 26, 10, 0); // 2025-03-26T10:00
        LocalDateTime dt2 = LocalDateTime.of(2025, 3, 26, 14, 30); // 2025-03-26T14:30

        boolean isBefore = dt1.isBefore(dt2);   // true (10:00 < 14:30)
        boolean isAfter = dt1.isAfter(dt2);     // false
        boolean isEqual = dt1.isEqual(dt2);     // false

        int comparison = dt1.compareTo(dt2);    // -1 (dt1 < dt2)
    }

    public static boolean isFutureEvent(LocalDateTime eventDateTime) {
        LocalDateTime now = LocalDateTime.now();
        return eventDateTime.isAfter(now);
    }

    public static boolean doDateRangesOverlap(
            LocalDate start1, LocalDate end1,
            LocalDate start2, LocalDate end2) {
        return !start1.isAfter(end2) && !start2.isAfter(end1);
    }

    // "Filter events within a time window"
    public List<LocalDateTime> filterEventsInWindow(
            List<LocalDateTime> events,
            LocalDateTime windowStart,
            LocalDateTime windowEnd) {
        return events.stream()
                .filter(event -> !event.isBefore(windowStart) && !event.isAfter(windowEnd))
                .collect(Collectors.toList());
    }
}
