package ru.yandex.practicum.sleeptracker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        for (int i = 0; i <analyzers.size() ; i++) {
            System.out.println(analyzers.get(i).apply(sessions).getDescription()+analyzers.get(i).apply(sessions).getValue());
        }
//        for (int i = 0; i < sessions.size(); i++) {
//            System.out.println("Сессия ночная? "+sessions.get(i).getStart()+" / "+sessions.get(i).getFinish() +"---"+sleepplessNight.isNightSleep(sessions.get(i)));
//        }


        // Временный цикл для теста ВЫВОДА
//        BadSleepAnalyzer badSleepAnalyzer = new BadSleepAnalyzer();

//        System.out.println(badSleepAnalyzer.apply(sleepLogReader.processFilePaths("C:\\java-sleep-tracker\\src\\main\\resources\\sleep_log.txt")));
    }

}