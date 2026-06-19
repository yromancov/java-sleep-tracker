package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class AvgDurationSession implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        double duration = sleepingSessions.stream()
                .mapToLong(sleepingSession -> Duration.between(sleepingSession.getStart(), sleepingSession.getFinish()).toMinutes())
                .average()
                .orElse(0);
        return new SleepAnalysisResult("Средняя продолжительность сессии (в минутах): ", duration);

    }
}
