package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountSleeplesNight implements Function<List<SleepingSession>,SleepAnalysisResult> {

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

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        Set<LocalDate> nightWithSleep = sleepingSessions.stream()
                .filter(this::isNightSleep)
                .map(this::getNightDate)
                .collect(Collectors.toSet());
        LocalDate firstNight = nightWithSleep.stream()
                .min(LocalDate::compareTo)
                .orElseThrow();
        LocalDate lastNight = nightWithSleep.stream()
                .max(LocalDate::compareTo)
                .orElseThrow();
        long nightWithotSleeep = firstNight.datesUntil(lastNight.plusDays(1))
                .filter(localDate -> !nightWithSleep.contains(localDate))
                .count();
        return new SleepAnalysisResult("Колличество бессоных ночей: ",nightWithotSleeep);
//        long countSleepsNight = sleepingSessions.stream()
//                .filter(this::isNightSleep)
//                .map(this::getNightDate)
//                .count();
//        return new SleepAnalysisResult("Количество бессоных ночей: ",countSleepsNight);
    }
}
