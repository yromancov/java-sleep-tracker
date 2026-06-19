package ru.yandex.practicum.sleeptracker;


import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class SleepTrackerApp {
    public static List<Function<List<SleepingSession>, SleepAnalysisResult>> analyzers =
            List.of(
                    new BadSleepAnalyzer(),
                    new SleepAnalyzerCount(),
                    new MaxDurationSession(),
                    new MinDurationSession(),
                    new AvgDurationSession(),
                    new CountSleeplesNight(),
                    new CharacterUser()
            );

    public static void main(String[] args) throws IOException {

        SleepLogReader sleepLogReader = new SleepLogReader();
        List<SleepingSession> sessions = sleepLogReader.processFilePaths(
                "C:\\java-sleep-tracker\\src\\main\\resources\\sleep_log.txt"
        );

        analyzers.stream()
                .map(analyzer -> analyzer.apply(sessions))
                .forEach(sleepAnalysisResult -> System.out.println(sleepAnalysisResult.getDescription() + sleepAnalysisResult.getValue()));


    }

}