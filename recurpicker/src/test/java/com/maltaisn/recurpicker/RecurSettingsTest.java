package com.maltaisn.recurpicker;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RecurSettingsTest {

    @Test
    public void recur_weekly_all_days_freq1() {
        Recurrence r = new Recurrence(System.currentTimeMillis(), Recurrence.WEEKLY)
                .setFrequency(1)
                .setWeeklySetting(Recurrence.EVERY_DAY_OF_WEEK);
        assertEquals(r.getPeriod(), Recurrence.DAILY);
        assertEquals(r.getDaySetting(), 0);
    }

    @Test
    public void recur_weekly_all_days_freq2() {
        Recurrence r = new Recurrence(System.currentTimeMillis(), Recurrence.WEEKLY)
                .setFrequency(2)
                .setWeeklySetting(Recurrence.EVERY_DAY_OF_WEEK);
        assertEquals(r.getPeriod(), Recurrence.WEEKLY);
        assertEquals(r.getDaySetting(), Recurrence.EVERY_DAY_OF_WEEK);
    }

    @Test
    public void recur_monthly_last_day_change_start() {
        long startDate = new GregorianCalendar(2018, Calendar.JANUARY, 31).getTimeInMillis();
        Recurrence r = new Recurrence(startDate, Recurrence.MONTHLY)
                .setMonthlySetting(Recurrence.LAST_DAY_OF_MONTH);

        assertEquals(r.getDaySetting(), Recurrence.LAST_DAY_OF_MONTH);

        long newDate = new GregorianCalendar(2018, Calendar.JANUARY, 1).getTimeInMillis();
        r.setStartDate(newDate);

        assertEquals(r.getDaySetting(), Recurrence.SAME_DAY_OF_MONTH);
    }

    @Test
    public void recur_monthly_last_day_wrong_start() {
        long startDate = new GregorianCalendar(2018, Calendar.JANUARY, 1).getTimeInMillis();
        Recurrence r = new Recurrence(startDate, Recurrence.MONTHLY)
                .setMonthlySetting(Recurrence.LAST_DAY_OF_MONTH);

        assertEquals(r.getDaySetting(), Recurrence.SAME_DAY_OF_MONTH);

        long newDate = new GregorianCalendar(2018, Calendar.JANUARY, 31).getTimeInMillis();
        r.setStartDate(newDate).setMonthlySetting(Recurrence.LAST_DAY_OF_MONTH);

        assertEquals(r.getDaySetting(), Recurrence.LAST_DAY_OF_MONTH);
    }

}
