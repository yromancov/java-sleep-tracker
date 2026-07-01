package ru.yandex.practicum.sleeptracker.SleepAnalyzerCountSession;

import ru.yandex.practicum.sleeptracker.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.SleepingSession;

import java.util.List;
import java.util.function.Function;

public class SleepAnalyzerCount implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        long count = sleepingSessions.stream().count();
        return new SleepAnalysisResult("Количество сессий сна: ", count);
    }
}
