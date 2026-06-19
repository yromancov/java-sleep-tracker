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
                "C:\\java-sleep-tracker\\src\\main\\resources\\test_sleep_log.txt"
        );
    }

    @Test
    public void sesionsIsNull() {
        Assertions.assertNotNull(sessions);
    }
    @Test
    public void shouldBeCountAllSession(){
        SleepAnalyzerCount sleepAnalyzerCount = new SleepAnalyzerCount();
        SleepAnalysisResult analyzer = sleepAnalyzerCount.apply(sessions);
        Assertions.assertEquals(10L,analyzer.getValue());
    }
    @Test
    public void shouldBeCountAllSession2(){
        SleepAnalyzerCount sleepAnalyzerCount = new SleepAnalyzerCount();
        SleepAnalysisResult analyzer = sleepAnalyzerCount.apply(sessions);
        Assertions.assertNotEquals(0L,analyzer.getValue());
    }
    @Test
    public void shouldBeCountBadSession(){
        BadSleepAnalyzer badSleepAnalyzer = new BadSleepAnalyzer();
        SleepAnalysisResult analysisResult = badSleepAnalyzer.apply(sessions);
        Assertions.assertEquals(3L,analysisResult.getValue());
    }
    @Test
    public void shouldBeCountBadSession2(){
        BadSleepAnalyzer badSleepAnalyzer = new BadSleepAnalyzer();
        SleepAnalysisResult analysisResult = badSleepAnalyzer.apply(sessions);
        Assertions.assertNotEquals(4L,analysisResult.getValue());
    }
    @Test
    public void shouldBeFindMaxDuration(){
        MaxDurationSession maxDurationSession = new MaxDurationSession();
        SleepAnalysisResult analysisResult = maxDurationSession.apply(sessions);
        Assertions.assertEquals(620L,analysisResult.getValue());
    }
    @Test
    public void shouldBeFindMaxDuration2(){
        MaxDurationSession maxDurationSession = new MaxDurationSession();
        SleepAnalysisResult analysisResult = maxDurationSession.apply(sessions);
        Assertions.assertNotEquals(700L,analysisResult.getValue());
    }
    @Test
    public void shouldBeFindMinDuration(){
        MinDurationSession minDurationSession = new MinDurationSession();
        SleepAnalysisResult analysisResult = minDurationSession.apply(sessions);
        Assertions.assertEquals(40L,analysisResult.getValue());
    }
    @Test
    public void shouldBeFindMinDuration2(){
        MinDurationSession minDurationSession = new MinDurationSession();
        SleepAnalysisResult analysisResult = minDurationSession.apply(sessions);
        Assertions.assertNotEquals(10L,analysisResult.getValue());
    }
    @Test
    public void shouldBeFindAvgDuration(){
        AvgDurationSession avgDurationSession = new AvgDurationSession();
        SleepAnalysisResult analysisResult = avgDurationSession.apply(sessions);
        Assertions.assertEquals(397.0D,analysisResult.getValue());
    }
    @Test
    public void shouldBeFindAvgDuration2(){
        AvgDurationSession avgDurationSession = new AvgDurationSession();
        SleepAnalysisResult analysisResult = avgDurationSession.apply(sessions);
        Assertions.assertNotEquals(397.3D,analysisResult.getValue());
    }

}