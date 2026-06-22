package ru.yandex.practicum.sleeptracker;


import ru.yandex.practicum.sleeptracker.AvgDurationSession.AvgDurationSession;
import ru.yandex.practicum.sleeptracker.BadSleepAnalyzerSession.BadSleepAnalyzer;
import ru.yandex.practicum.sleeptracker.CharacterUserSession.CharacterUser;
import ru.yandex.practicum.sleeptracker.CountSleeplesNightSession.CountSleeplesNight;
import ru.yandex.practicum.sleeptracker.MaxDurationSession.MaxDurationSession;
import ru.yandex.practicum.sleeptracker.MinDurationSession.MinDurationSession;
import ru.yandex.practicum.sleeptracker.SleepAnalyzerCountSession.SleepAnalyzerCount;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
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
                    new CharacterUser());

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Не указан путь к файлу");
            return;
        }
        try {

            Scanner scanner = new Scanner(System.in);
            SleepLogReader sleepLogReader = new SleepLogReader();
            List<SleepingSession> sessions = sleepLogReader.processFilePaths(args[0]);

            analyzers.stream().map(analyzer ->
                    analyzer.apply(sessions)).forEach(sleepAnalysisResult ->
                    System.out.println(sleepAnalysisResult.getDescription() + sleepAnalysisResult.getValue()));

        } catch (IOException e) {

            System.out.println("Ошибка при чтении файла " + e.getMessage());
        }
    }
}