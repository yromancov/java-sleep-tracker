package ru.yandex.practicum.sleeptracker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SleepLogReader {

    public List<SleepingSession> processFilePaths(String fileName) throws IOException {
        List<SleepingSession> sessionList = Files.lines(Path.of(fileName))
                .map(SleepLogReader::parseSession)
                .toList();
        return sessionList;

    }

    private static SleepingSession parseSession(String line) {
        String[] parts = line.split(";");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        LocalDateTime start = LocalDateTime.parse(parts[0], dateTimeFormatter);
        LocalDateTime finish = LocalDateTime.parse(parts[1], dateTimeFormatter);
        SleepQuality quality = SleepQuality.valueOf(parts[2]);
        return new SleepingSession(start, finish, quality);
    }
}
