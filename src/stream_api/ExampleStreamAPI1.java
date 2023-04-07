package stream_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStreamAPI1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(0, 7, -2, 4, -1, 7);
        list.stream()
                .filter(a -> a > 0)
                .sorted()
                .forEach(a -> System.out.println(a));

//         test();
//        testMap();
        //testTry();
        //testException();
        testChangeObjects();

    }

    static void test() {
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("Umka", 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Luska", 3, "Grey");
        List<Cat> list = List.of(cat1, cat2, cat3, cat4);
        int age = 5;
        List<Cat> result= list.stream()
                .filter(a->a.getWeight()>=age)
                .collect(Collectors.toList());
        System.out.println(result);

    }

    static void testMap() {
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("Umka", 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Luska", 3, "Grey");
        List<Cat> list = List.of(cat1, cat2, cat3, cat4);
        int age = 5;
        Stream<String> catToName = list.stream()
                .filter(a -> a.getWeight() >= age)
                .map(a -> a.getName());
        List<String> result = catToName.collect(Collectors.toList());
        System.out.println(result);

    }

    static void testTry() {
        try {
            Optional<String> result = Files.lines(Path.of("cat name.txt")).max((a, b) -> a.length() - b.length());
            System.out.println(result.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void testException() {
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat(null, 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Luska", 3, "Grey");
        List<Cat> list = List.of(cat1, cat2, cat3, cat4);
        //Stream<Cat> catToName = list.stream().filter(a -> a.getName().length() > 5);
        Stream<Cat> catToName = list.stream().filter(a -> a.getWeight() < 5).filter(a -> a.getName().length() >
                5);
        try {
            List<Cat> result = catToName.collect(Collectors.toList());
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    static void testChangeObjects() {
        Cat cat1 = new Cat("Luska", 5, "White");
        Cat cat2 = new Cat("Umka", 7, "Black");
        Cat cat3 = new Cat("Barsic", 2, "Red");
        Cat cat4 = new Cat("Kuzia", 3, "Grey");
        List<Cat> list = List.of(cat1, cat2, cat3, cat4);
        Stream<Cat> catToName = list.stream()
                .filter(a -> a.getWeight() < 5)
                .peek(a -> a.setName("_" + a.getName()));
        catToName.forEach(a -> System.out.println(a));
        System.out.println();
        for (Cat cat : list) {
            System.out.println(cat);
        }
    }



}
