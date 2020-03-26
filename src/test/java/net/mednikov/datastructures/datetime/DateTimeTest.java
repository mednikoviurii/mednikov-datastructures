package net.mednikov.datastructures.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DateTimeTest {

    @Test
    public void equalsTest(){
        LocalDateTime date1 = LocalDate.of(2013, 3, 5).atStartOfDay();
        LocalDateTime date2 = date1.plusHours(12).plusMinutes(30);
        assertThat(date1).isEqualToIgnoringHours(date2);
        assertThat(date1.plusHours(12)).isEqualToIgnoringMinutes(date2);
        assertThat(date1.plusHours(12).plusMinutes(30)).isEqualTo(date2);
        assertThat(date1).matches(d -> d.isEqual(date2.minusHours(12).minusMinutes(30)));
    }

    @Test
    public void beforeTest(){
        LocalDateTime date = LocalDate.of(1992, 2, 14).atStartOfDay();
        assertThat(date).matches(d -> d.isBefore(LocalDateTime.now()));
        assertThat(date).isBefore(LocalDateTime.now());
    }

    @Test
    public void afterTest(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime after = now.plusDays(10);
        assertThat(after).matches(d -> d.isAfter(now));
        assertThat(after).isAfter(now);
    }

}