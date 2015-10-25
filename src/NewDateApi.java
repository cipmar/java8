import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by mariusrop on 25.10.2015.
 */
public class NewDateApi {
    public static void main(String[] args) throws InterruptedException {
        // Instant is immutable!! an instant has nanoseconds precision
        Instant instant1 = Instant.now();
        Thread.sleep(100);
        Instant instant2 = Instant.now();
        System.out.println(instant2);

        // durations
        Duration duration = Duration.between(instant1, instant2);
        System.out.println(duration.toMillis());

        // localdate - a date with day precision
        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        // periods
        LocalDate dateOfBirth = LocalDate.of(1979, Month.DECEMBER, 17);
        Period period = Period.between(dateOfBirth, LocalDate.now());
        System.out.println("I was born " + period.getYears() + " years ago");
        System.out.println("I was born " + dateOfBirth.until(LocalDate.now(), ChronoUnit.DAYS) + " days ago");

        // ajusters
        LocalDate now = LocalDate.now();
        LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println("Next Sunday is on " + nextSunday);

        // LocalTime
        System.out.println(LocalTime.now());

        // time zones
        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
        ZonedDateTime zdt = ZonedDateTime.of(2009, 4, 2, 2, 3, 0, 0, ZoneId.of("Europe/London"));
        System.out.println(zdt.withZoneSameInstant(ZoneId.of("Europe/Bucharest")));

    }
}
