import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

//    public static void main(String[] args) {
//        try {
//            Files.lines(Paths.get("unicum.txt"))
//                    .map(line -> line.split("\\s"))
//                    .distinct()
//                    .forEach(arr -> System.out.println(Arrays.toString(arr)));
//            System.out.println("----------------------");
//            Files.lines(Paths.get("unicum.txt"))
//                    .map(line -> line.split("\\s"))
//                    .map(Arrays::stream)
//                    .distinct()
//                    .forEach(System.out::println);
//            System.out.println("----------------------");
//            System.out.println(Files.lines(Paths.get("unicum.txt"))
//                    .map(line -> line.split("\\s"))
//                    .flatMap(Arrays::stream)
//                    .distinct()
//                    .collect(Collectors.joining(", ", "Уникальные слова ", ".")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
//        matchEx();
//        findAnyEx();
//        mappingEx();
//        reduceEx();
//        streamCreationEx();
//        intStreamEx();
//        streamFromFilesEx();
//        simpleStringEx();
//        doSomething(() -> System.out.println(11));
//        doSomething(() -> System.out.println(22));
//        secondEx();
        thirdEx();
    }

    private static void thirdEx() {
        System.out.println("Первый вариант: ");
        Arrays.asList(1, 2, 3, 4, 4, 3, 2, 3, 2, 1).stream().distinct().forEach(n -> System.out.println(n));

        System.out.println("Второй вариант: ");
        Arrays.asList(1, 2, 3, 4, 4, 3, 2, 3, 2, 1).stream().distinct().forEach(System.out::println);

        class Point {
            int x;

            public Point(int x) {
                this.x = x;
            }
        }

        Stream.of(1, 2, 3, 4).forEach(Point::new);
    }

    private static void secondEx() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> out = numbers.stream()
            .filter(n -> n % 2 == 0)
            .limit(2)
            .map((Function<Integer, Integer>) n -> n * n)
            .collect(Collectors.toList());

        Stream<String> stringStream = Stream.of("A", "BB", "CCCC");
        System.out.println(stringStream.map((Function<String, Integer>) s -> s.length())
                .collect(Collectors.toSet()));

        System.out.println(numbers);
        System.out.println(out);
    }

    public static void doSomething(Runnable runnable) {
        runnable.run();
    }

    private static void simpleStringEx() {
        System.out.println(Arrays.stream("A B CC B C AA A A B CC C".split("\\s")).distinct().count());
    }

    private static void streamFromFilesEx() {
        try {
            Files.lines(Paths.get("text.txt")).map(String::length).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void streamCreationEx() {
        Arrays.asList("A", "B", "C").stream().forEach(System.out::print);
        System.out.println();
        Stream.of(1, 2, 3, 4).forEach(System.out::print);
        System.out.println();
        Arrays.stream(new int[]{4, 3, 2, 1}).forEach(System.out::print);
    }

    private static void intStreamEx() {
//        IntStream myIntStream = IntStream.of(10, 20, 30, 40, 50);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().mapToInt(v -> v).sum();

//        IntStream.rangeClosed(2, 10).filter(n -> n % 2 == 0).forEach(System.out::println);
    }

    private static void reduceEx() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int sum = 0;
        for (Integer o : list) {
            sum += o;
        }

        int streamSum = list.stream().reduce(0, (a, b) -> a + b);

        System.out.println(sum + " " + streamSum);
    }

    private static void mappingEx() {
        Function<String, Integer> _strToLen = String::length;
        Function<String, Integer> strToLen = s -> s.length();

        Predicate<Integer> evenNumberFilter = n -> n % 2 == 0;
        Stream.of(1, 2, 3, 4, 5, 6).filter(evenNumberFilter).forEach(System.out::println);
        System.out.println();
        Function<Integer, Integer> cube = n -> n * n * n;
        Stream.of(1, 2, 3).map(cube).forEach(System.out::println);

//        List<String> list = Arrays.asList("A", "BB", "C", "DDD", "EE", "FFFF");
//        List<Integer> wordsLength = list.stream().map(str -> str.length().collect())
//        List<Integer> wordsLenght = list.stream().map(strToLen).collect(Collectors.toList());

//        System.out.println(list);
//        System.out.println(wordsLenght);

//        list.stream().map(strToLen).forEach(n -> System.out.println(n));
//        list.stream().map(strToLen).forEach(System.out::println);
    }


    private static void matchEx() {
//        int[] arr = {1, 2, 3, 4, 23, 1, 1, 1, 1};
//        boolean ok = true;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] >= 10) {
//                ok = false;
//                break;
//            }
//        }
//        System.out.println(ok);

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(list.stream().allMatch(n -> n < 10));
        System.out.println(list.stream().anyMatch(n -> n == 4));
        System.out.println(list.stream().noneMatch(n -> n ==2));
    }

    private static void findAnyEx() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 11));
        list.stream().filter(n -> n > 10).findAny().ifPresent(System.out::println);
//        Optional<Integer> opt = list.stream().filter(n -> n > 10).findAny();
//        if (opt.isPresent()) {
//            System.out.println(opt.get());
//        }
    }
}
