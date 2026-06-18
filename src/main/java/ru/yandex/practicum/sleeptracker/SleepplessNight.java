package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class SleepplessNight {
    boolean isNightSleep(SleepingSession session){
        boolean nextDay = (session.getStart().toLocalDate().isBefore(session.getFinish().toLocalDate()));
                boolean inNight = session.getStart().toLocalTime().isBefore(LocalTime.of(6,0)) ;
        return nextDay || inNight;
    }
    private LocalDate getNightDate(SleepingSession session){
        if(session.getStart().toLocalTime().isBefore(LocalTime.of(6,0))){
            return session.getStart().toLocalDate().minusDays(1);
        }
        return session.getStart().toLocalDate();
    }
}
