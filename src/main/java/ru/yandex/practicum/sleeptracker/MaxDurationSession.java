package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class MaxDurationSession implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        long duration = sleepingSessions.stream()
                .mapToLong(sleepingSession ->Duration.between(sleepingSession.getStart(), sleepingSession.getFinish()).toMinutes())
                .max()
                .orElse(0);
        return new SleepAnalysisResult("Максимальная продолжительность сессии (в минутах): ",duration);

    }
}
