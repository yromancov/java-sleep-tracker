package ru.yandex.practicum.sleeptracker;

import java.util.List;
import java.util.function.Function;

public class BadSleepAnalyzer implements Function<List<SleepingSession>,Long> {
    @Override
    public Long apply(List<SleepingSession> sleepingSessions) {
        return sleepingSessions.stream()
                .filter(sleepingSession -> sleepingSession.getQuality()==SleepQuality.BAD)
                .count();
    }
}
