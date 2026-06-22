package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.CountSleeplesNightSession.CountSleeplesNight;

import java.io.IOException;
import java.util.List;

public class CountSleeplesNightTest {
    List<SleepingSession> sessions;


    @Test
    public void shouldBeReturnZeroNight() throws IOException {
        SleepLogReader sleepLogReader = new SleepLogReader();
        CountSleeplesNight countSleeplesNight = new CountSleeplesNight();
        sessions = sleepLogReader.processFilePaths(
                "src/main/resources/ZeroSleeplesNight_log.txt"
        );

        SleepAnalysisResult analysisResult = countSleeplesNight.apply(sessions);
        Assertions.assertEquals(0L, analysisResult.getValue());
    }

    @Test
    public void shouldBeReturnOneNight() throws IOException {
        SleepLogReader sleepLogReader = new SleepLogReader();
        CountSleeplesNight countSleeplesNight = new CountSleeplesNight();
        sessions = sleepLogReader.processFilePaths("src/main/resources/OneSleeplesNight_log.txt");
        SleepAnalysisResult analysisResult = countSleeplesNight.apply(sessions);
        Assertions.assertEquals(1L, analysisResult.getValue());

    }

    @Test
    public void shouldBeReturnThreeNight() throws IOException {
        SleepLogReader sleepLogReader = new SleepLogReader();
        CountSleeplesNight countSleeplesNight = new CountSleeplesNight();
        sessions = sleepLogReader.processFilePaths("src/main/resources/OnlyDaySession_log.txt");
        SleepAnalysisResult analysisResult = countSleeplesNight.apply(sessions);
        Assertions.assertEquals(3L, analysisResult.getValue());

    }

    @Test
    public void shouldBeReturnZeroNightNextMonth() throws IOException {
        SleepLogReader sleepLogReader = new SleepLogReader();
        CountSleeplesNight countSleeplesNight = new CountSleeplesNight();
        sessions = sleepLogReader.processFilePaths("src/main/resources/SwitchMonth_log.txt");
        SleepAnalysisResult analysisResult = countSleeplesNight.apply(sessions);
        Assertions.assertEquals(0L, analysisResult.getValue());

    }
}
