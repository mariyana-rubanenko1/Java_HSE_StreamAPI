package stream_api;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ExampleStreamAPI5 {
    public static void main(String[] args) {
        testMatch();
    }

    static void testMatch() {
        List<String> projectLanguages = List.of("Java", "Fortran", "C", "C++", "Python", "Ruby", "JS");
        List<String> iKnow = List.of("Java", "Fortran", "C", "Python");
        Predicate<String> predicate = check(iKnow);
        if (projectLanguages.stream().anyMatch(predicate)) {
            System.out.println("I can implement part of the task ");
        } else {
            System.out.println("I cant help ");
        }
        if (projectLanguages.stream().allMatch(predicate)) {
            System.out.println("I can implement the whole task");
        } else {
            System.out.println("I cannot complete the whole task");
        }
    }
    public static <T> Predicate<T> check(List<T> list) {
        class CheckLanguage implements Predicate<T> {
            @Override
            public boolean test(T t) {
                for (T element : list) {
                    if (element.equals(t)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return new CheckLanguage();
    }

    static void testFind() {
        List<Integer> numbers = List.of(0, 8, 4, 6, 3, 10, 5);
        Stream<Integer> stream = numbers.stream().filter(n -> n % 2 == 1);
        Optional<Integer> result = stream.findFirst();
        System.out.println(result.get());
    }

    static void testCount() {
        List<Integer> numbers = List.of(0, 8, 4, 6, 3, 10, 5);
        Stream<Integer> stream = numbers.stream().filter(n -> n % 2 == 1);
        long odd = stream.count();
        System.out.println(odd);
    }

    static void testMaxMin() {
        ProgrammingLanguage lang1 = new ProgrammingLanguage("Haskell", DifficultyLevel.HARD);
        ProgrammingLanguage lang2 = new ProgrammingLanguage("Python", DifficultyLevel.EASY);
        ProgrammingLanguage lang3 = new ProgrammingLanguage("Java", DifficultyLevel.MEDIUM);
        ProgrammingLanguage lang4 = new ProgrammingLanguage("C++", DifficultyLevel.HARD);
        ProgrammingLanguage lang5 = new ProgrammingLanguage("JS", DifficultyLevel.EASY);
        List<ProgrammingLanguage> languages = List.of(lang1, lang2, lang3, lang4, lang5);
        Optional<ProgrammingLanguage> result = languages.stream().max(ExampleStreamAPI5::compareHard);
        System.out.println(result.get());
    }
    public static int compareHard(ProgrammingLanguage a, ProgrammingLanguage b) {
        if (a.getComplexity().ordinal() > b.getComplexity().ordinal()) {
            return 1;
        }
        if (a.getComplexity().ordinal() < b.getComplexity().ordinal()) {
            return -1;
        }
        return Integer.compare(a.getName().length(), b.getName().length());
    }
}
