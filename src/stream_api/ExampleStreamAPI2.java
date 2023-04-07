package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStreamAPI2 {
    public static void main(String[] args) {
//        testFilter();
//        testDistinct();
//        testDistinctWithOverrideEquals();
//        testLimit();
//        testSkip();
//        testDropWhile();
//        testTakeWhile();
    }

    static void testFilter() {
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("UmkA", 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Kuzia", 3, "Grey");
        Cat [] cats = new Cat[] {cat1,cat2,null,cat3,cat4};
        Stream<Cat> catToName = Arrays.stream(cats)
                .filter(Objects::nonNull)
                .filter(a -> a.getWeight() > 5);
        try {
            List<Cat> result = catToName.collect(Collectors.toList());
            System.out.println(result);
        }catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    static void testDistinct() {
        List<Integer> list = List.of(0, 5, -2, 0, 3, 1, 1, -4, 7);
        list.stream().distinct().forEach(n -> System.out.println(n));
    }

    static void testDistinctWithOverrideEquals() {
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("Luska", 5, "White");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Kuzia", 3, "Grey");
        Cat[] cats = new Cat[] { cat1, cat2, cat3, cat4 };
        Stream<Cat> catToName = Arrays.stream(cats).distinct();
        catToName.forEach(n -> System.out.println(n));
    }

    static void testLimit() {
        List<Integer> list = List.of(0, 5, -2, 0, 3, 1, 1, -4, 7);
        list.stream()
                .filter(n -> n >= 0)
                .sorted()
                .limit(3)
                .forEach(n -> System.out.println(n));
    }

    static void testSkip() {
        List<Integer> list = List.of(0, 5, -2, 0, 3, 1, 1, -4, 7);
        list.stream()
                .filter(n -> n >= 0)
                .sorted()
                .skip(4)
                .forEach(n -> System.out.println(n));
    }

    static void testDropWhile() {
        List<Integer> list = List.of(0, 5, -2, 0, 3, 1, 1, -4, 7);
        list.stream()
                .dropWhile(n->n>=0)
                .forEach(n -> System.out.println(n));
    }

    static void testTakeWhile() {
        List<Integer> list = List.of(0, 5, -2, 0, 3, 1, 1, -4, 7);
        list.stream()
                .takeWhile(n->n>=0)
                .forEach(n -> System.out.println(n));
    }
}
