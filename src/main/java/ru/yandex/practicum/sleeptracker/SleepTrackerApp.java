package ru.yandex.practicum.sleeptracker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SleepTrackerApp {
    List<Function<List<SleepingSession>,?>> analyzers = List.of(new BadSleepAnalyzer(), new SleepAnalyzerCount());
    public static void main(String[] args) throws IOException {
BadSleepAnalyzer badSleepAnalyzer = new BadSleepAnalyzer();
SleepLogReader sleepLogReader = new SleepLogReader();
        System.out.println(badSleepAnalyzer.apply(sleepLogReader.processFilePaths("C:\\java-sleep-tracker\\src\\main\\resources\\sleep_log.txt")));
    }

}