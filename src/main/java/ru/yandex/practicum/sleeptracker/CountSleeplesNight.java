package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountSleeplesNight implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        SleepingSession firstSession = sleepingSessions.get(0);
        LocalDate firstNight = firstSession.getStart().toLocalTime().isAfter(LocalTime.NOON)
                ? firstSession.getStart().toLocalDate().plusDays(1) : firstSession.getStart().toLocalDate();
        LocalDate lastNight = sleepingSessions.get(sleepingSessions.size() - 1).getStart().toLocalDate();
        long nightWithotSleeep = firstNight.datesUntil(lastNight.plusDays(1))
                .filter(localDate -> sleepingSessions.stream()
                        .noneMatch(session -> SleepInstrument.isNightSleep(session, localDate)))
                .count();

        return new SleepAnalysisResult("Колличество бессоных ночей: ", nightWithotSleeep);

    }
}
