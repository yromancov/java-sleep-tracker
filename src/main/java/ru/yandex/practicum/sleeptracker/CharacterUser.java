package ru.yandex.practicum.sleeptracker;


import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterUser implements Function<List<SleepingSession>, SleepAnalysisResult> {
    private Character getCharacterUser(SleepingSession session) {
        if (session.getStart().toLocalTime().isAfter(LocalTime.of(23, 0))
                && session.getFinish().toLocalTime().isAfter(LocalTime.of(9, 0))) {

            return Character.СОВА;
        } else if (session.getStart().toLocalTime().isBefore(LocalTime.of(22, 0))
                && session.getFinish().toLocalTime().isBefore(LocalTime.of(7, 0))) {
            return Character.ЖАВОРОНОК;
        } else return Character.Голубь;
    }

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        Map<Character, Long> chronoUser = sleepingSessions.stream()
                .map(this::getCharacterUser)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()));
        Character result = chronoUser.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(Character.Голубь);
        return new SleepAnalysisResult("Ваш хронотип: ", result);
    }
}
