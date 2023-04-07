package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExampleStreamAPI3 {
    public static void main(String[] args) {
//        testMap();
//        testMapForCats();
//        testFlatMap();
//        testFlatMapToInt();
        testConcat();
    }

    static void testMap() {
        List<String> list = List.of("Java", "Python", "Fortarn", "C");
        Stream<Integer> stream = list.stream().map(n -> n.length());
        stream.forEach(n -> System.out.println(n));
    }

    static void testMapForCats() {
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("UmkA", 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Kuzia", 3, "Grey");
        Cat[] cats = new Cat[] { cat1, cat2, cat3, cat4 };
        List<String> result = Arrays.stream(cats)
                .filter(n -> n.getWeight() < 5)
                .map(n -> n.getName())
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static void testFlatMap() {
        Singer singer1 = new Singer("Freddie Mercury", new String[] { "We Are the Champions", "Somebody to Love" });
        Singer singer2 = new Singer("David Bowie",new String[] { "Space Oddity", "Let Me Sleep Beside You", "Suffragette City" });
        Singer singer3 = new Singer("James Paul McCartney", new String[] { "Can’t Buy Me Love", "Another Girl" });
        Singer[] rockStars = new Singer[] { singer1, singer2, singer3 };
        List<String> song = Arrays.stream(rockStars).flatMap(n-> Arrays.stream(n.getSongs())).collect(Collectors.toList());
        System.out.println(song);
    }

    static void testFlatMapToInt() {
        String[] array = new String[] { "C", "Java", "Fortran" };
        IntStream stream = Arrays.stream(array).flatMapToInt(n -> n.codePoints());
        stream.forEach(n -> System.out.println(n));
    }

    static void testConcat() {
        List<Integer> list1 = List.of(0, 2, 4, 6);
        List<Integer> list2 = List.of(1, 3, 5, 7);
        Stream<Integer> stream1 = list1.stream();
        Stream<Integer> stream2 = list2.stream();
        Stream<Integer> concatStream = Stream.concat(stream1, stream2);
        concatStream.forEach(n -> System.out.println(n));
    }

    static void testEmpty() {
        Stream<Integer> stream = Stream.empty();
        stream.forEach(n -> System.out.println(n));
    }

    static void testGenerate() {
        Stream<Integer> stream = Stream.generate(getRandomNumber(1, 10));
        List<Integer> list = stream.limit(10).collect(Collectors.toList());
        System.out.println(list);
    }

    public static Supplier<Integer> getRandomNumber(int start, int end) {
        class RandGen implements Supplier<Integer> {
            @Override
            public Integer get() {
                return (int) (start + Math.random() * (end - start) + 1);
            }
        }
        return new RandGen();
    }

    static void testIterate() {
        Stream<Integer> stream = Stream.iterate(1, n -> n <= 10, n -> n + 1);
        stream.forEach(n -> System.out.println(n));
    }
    static void testIterateUnlimited() {
        Stream<String> stream = Stream.iterate("A", n -> n + n);
        stream.limit(4).forEach(n -> System.out.println(n));
    }

    static void testOf() {
        Stream<String> stream = Stream.of("Hello", "World");
        List<String> list = stream.collect(Collectors.toList());
        System.out.println(list);
    }

    static void testOfNullable() {
        Stream<String> stream1 = Stream.ofNullable("Hello");
        stream1.forEach(n -> System.out.println(n));
        Stream<String> stream2 = Stream.ofNullable(null);
        stream2.forEach(n -> System.out.println(n));
    }

}
