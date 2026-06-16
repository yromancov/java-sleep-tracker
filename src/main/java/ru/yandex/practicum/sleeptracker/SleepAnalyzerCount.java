package ru.yandex.practicum.sleeptracker;

import java.util.List;
import java.util.function.Function;

public class SleepAnalyzerCount implements Function<List<SleepingSession>,SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        long count =  sleepingSessions.stream().count();
        return new SleepAnalysisResult("Количество сессий сна: ", count);
    }
}
