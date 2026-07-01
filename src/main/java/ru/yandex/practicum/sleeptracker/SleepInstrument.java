package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class SleepInstrument {
    public static boolean isNightSleep(SleepingSession session, LocalDate night) {

        LocalDateTime nightStart = night.atStartOfDay();
        LocalDateTime nightEnd = night.atTime(6, 0);
        return session.getStart().isBefore(nightEnd) && session.getFinish().isAfter(nightStart);
    }

}
