package ro.mariusr.java8;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by mariusrop on 25.10.2015.
 */
public class P13_NewDateApi {
    public static void main(String[] args) throws InterruptedException {
        // Instant - an instantaneous point on the time-line - an instant has nanoseconds precision - immutable!!!
        Instant instant1 = Instant.now();
        Thread.sleep(100);
        Instant instant2 = Instant.now();
        System.out.println(instant2);

        // durations
        Duration duration = Duration.between(instant1, instant2);
        System.out.println(duration.toMillis());

        // LocalDate - a date with day precision - a date without a time-zone
        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        // periods
        LocalDate dateOfBirth = LocalDate.of(1979, Month.DECEMBER, 17);
        Period period = Period.between(dateOfBirth, LocalDate.now());
        System.out.println("I was born " + period.getYears() + " years ago");
        System.out.println("I was born " + dateOfBirth.until(LocalDate.now(), ChronoUnit.DAYS) + " days ago");

        // adjusters
        LocalDate now = LocalDate.now();
        LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println("Next Sunday is on " + nextSunday);

        // LocalTime - a time without time-zone
        System.out.println(LocalTime.now());

        // time zones
        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);

        // ZonedDateTime - a date-time with a time-zone
        ZonedDateTime zdt = ZonedDateTime.of(2009, 4, 2, 2, 3, 0, 0, ZoneId.of("Europe/London"));
        System.out.println(zdt.withZoneSameInstant(ZoneId.of("Europe/Bucharest")));
    }
}
