package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SleepInstrument {
    public static  boolean isNightSleep(SleepingSession session, LocalDate night){
//        boolean nextDay = (session.getStart().toLocalDate().isBefore(session.getFinish().toLocalDate()));
//        boolean inNight = session.getStart().toLocalTime().isBefore(LocalTime.of(6,0)) ;
//        return nextDay || inNight;
        LocalDateTime nightStart = night.atStartOfDay();
        LocalDateTime nightEnd = night.atTime(6,0);
        return session.getStart().isBefore(nightEnd) && session.getFinish().isAfter(nightStart);
    }
//    public  static LocalDate getNightDate(SleepingSession session){
//        if(session.getStart().toLocalTime().isBefore(LocalTime.of(6,0))){
//            return session.getStart().toLocalDate().minusDays(1);
//        }
//        return session.getStart().toLocalDate();
//    }
}
