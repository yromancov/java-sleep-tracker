package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class SleepTrackerAppTest {

    List<SleepingSession> sessions;

    @BeforeEach
    public void beforeEach() throws IOException {
        SleepLogReader sleepLogReader = new SleepLogReader();

        sessions = sleepLogReader.processFilePaths(
                "src/main/resources/test_sleep_log.txt"
        );
    }

    @Test
    public void sesionsIsNull() {
        Assertions.assertNotNull(sessions);
    }

    @Test
    public void shouldBeCountAllSession() {
        SleepAnalyzerCount sleepAnalyzerCount = new SleepAnalyzerCount();
        SleepAnalysisResult analyzer = sleepAnalyzerCount.apply(sessions);
        Assertions.assertEquals(10L, analyzer.getValue());
    }

    @Test
    public void shouldBeCountNotNull() {
        SleepAnalyzerCount sleepAnalyzerCount = new SleepAnalyzerCount();
        SleepAnalysisResult analyzer = sleepAnalyzerCount.apply(sessions);
        Assertions.assertTrue(analyzer.getValue() != null);
    }

    @Test
    public void shouldBeCountBadSession() {
        BadSleepAnalyzer badSleepAnalyzer = new BadSleepAnalyzer();
        SleepAnalysisResult analysisResult = badSleepAnalyzer.apply(sessions);
        Assertions.assertEquals(3L, analysisResult.getValue());
    }

    @Test
    public void shouldBeCountBadSessionNotNull() {
        BadSleepAnalyzer badSleepAnalyzer = new BadSleepAnalyzer();
        SleepAnalysisResult analysisResult = badSleepAnalyzer.apply(sessions);
        Assertions.assertTrue(analysisResult.getValue() != null);
    }

    @Test
    public void shouldBeFindMaxDuration() {
        MaxDurationSession maxDurationSession = new MaxDurationSession();
        SleepAnalysisResult analysisResult = maxDurationSession.apply(sessions);
        Assertions.assertEquals(620L, analysisResult.getValue());
    }

    @Test
    public void shouldBeFindMaxDurationNotNull() {
        MaxDurationSession maxDurationSession = new MaxDurationSession();
        SleepAnalysisResult analysisResult = maxDurationSession.apply(sessions);
        Assertions.assertTrue(analysisResult.getValue() != null);
    }

    @Test
    public void shouldBeFindMinDuration() {
        MinDurationSession minDurationSession = new MinDurationSession();
        SleepAnalysisResult analysisResult = minDurationSession.apply(sessions);
        Assertions.assertEquals(40L, analysisResult.getValue());
    }

    @Test
    public void shouldBeFindMinDurationNotNull() {
        MinDurationSession minDurationSession = new MinDurationSession();
        SleepAnalysisResult analysisResult = minDurationSession.apply(sessions);
        Assertions.assertTrue(analysisResult.getValue() != null);
    }

    @Test
    public void shouldBeFindAvgDuration() {
        AvgDurationSession avgDurationSession = new AvgDurationSession();
        SleepAnalysisResult analysisResult = avgDurationSession.apply(sessions);
        Assertions.assertEquals(397.0D, analysisResult.getValue());
    }

    @Test
    public void shouldBeFindAvgDurationNotNull() {
        AvgDurationSession avgDurationSession = new AvgDurationSession();
        SleepAnalysisResult analysisResult = avgDurationSession.apply(sessions);
        Assertions.assertTrue(analysisResult.getValue() != null);
    }

}