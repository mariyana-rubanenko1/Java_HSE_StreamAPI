package stream_api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStreamAPI4 {
    public static void main(String[] args) {
//        testOrdered();
//        testOrderedSorted();
        testUnordered();
    }

    static void testOrdered() {
        List<String> list1 = List.of("A1", "A2", "A3");
        Stream<String> stream = list1.stream()
                .filter(n -> {
                    System.out.println("Filter " + n);
                    return n.length() <= 2;
                })
                .map(n -> {
                    System.out.println("Map " + n);
                    return "_" + n;
                });
        stream.forEach(n -> System.out.println("forEach " + n));
    }

    static void testOrderedSorted() {
        List<String> list1 = List.of("A1", "C1", "B1");
        Stream<String> stream = list1.stream()
                .sorted((a,b)->{
                    System.out.println("Sorted "+a+" "+b);
                    return a.compareTo(b);
                })
                .filter(n -> {
                    System.out.println("Filter " + n);
                    return n.startsWith("B");
                }).map(n -> {
                    System.out.println("Map " + n);
                    return "_" + n;
                });
        stream.forEach(n -> System.out.println("forEach " + n));
    }

    static void testUnordered() {
        List<String> list1 = List.of("A1", "B1", "C1");
        Stream<String> stream = list1.stream()
                .unordered();
        stream.forEach(n -> System.out.println(n));
    }

    static void testSorted() {
        List<Integer> list = List.of(-2, 4, 0, -5, 3, 2, 5, 1);
        List<Integer> result = list.stream()
                .sorted((a,b)-> Math.abs(a)-Math.abs(b))
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static void testSortedInteger() {
        List<Integer> list = List.of(-2, 4, 0, -5, 3, 2, 5, 1);
        List<Integer> result = list.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
