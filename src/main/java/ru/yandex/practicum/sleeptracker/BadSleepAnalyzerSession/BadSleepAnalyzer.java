package ru.yandex.practicum.sleeptracker.BadSleepAnalyzerSession;

import ru.yandex.practicum.sleeptracker.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.SleepQuality;
import ru.yandex.practicum.sleeptracker.SleepingSession;

import java.util.List;
import java.util.function.Function;

public class BadSleepAnalyzer implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        long count = sleepingSessions.stream()
                .filter(sleepingSession -> sleepingSession.getQuality() == SleepQuality.BAD)
                .count();
        return new SleepAnalysisResult("Количесво сессий плохого сна: ", count);
    }
}
