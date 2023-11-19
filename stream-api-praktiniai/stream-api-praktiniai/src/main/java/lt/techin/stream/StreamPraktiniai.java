package lt.techin.stream;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPraktiniai {

    public static List<Integer> returnSquareRoot(List<Integer> numbers){
        return numbers.stream()
                .map(n -> (int)Math.sqrt(n))
                .collect(Collectors.toList());
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<Integer> getAgeFromUsers(List<User> users){
        return users.stream()
                .map(u -> u.getAge())
                .collect(Collectors.toList());
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<Integer> getDistinctAges(List<User> users){
        return users.stream()
                .map(u -> u.getAge())
                .distinct()
                .collect(Collectors.toList());
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<User> getLimitedUserList(List<User> users, int limit){
        return users.stream()
                .limit(limit)
                .collect(Collectors.toList());
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static Integer countUsersOlderThen25(List<User> users){
        return (int)users.stream()
                .filter(u -> u.getAge() > 25)
                .count();
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<String> mapToUpperCase(List<String> strings){
        return strings.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static Integer sum(List<Integer> integers){
        return integers.stream()
                .reduce(0, (a, b) -> a + b);
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip){
        return integers.stream()
                .skip(toSkip)
                .collect(Collectors.toList());
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<String> getFirstNames(List<String> names){
        return names.stream()
                .map(s -> s.substring(0, s.indexOf(" ")))
                .collect(Collectors.toList());
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<String> getDistinctLetters(List<String> names){
        return names.stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .distinct()
                .collect(Collectors.toList());
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static String separateNamesByComma(List<User> users){
        return users.stream()
                .map(s -> s.getName())
                .collect(Collectors.joining(", "));
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static double getAverageAge(List<User> users){
        return users.stream()
                .mapToDouble(u -> u.getAge())
                .average()
                .getAsDouble();
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static Integer getMaxAge(List<User> users){
        return users.stream()
                .mapToInt(u -> u.getAge())
                .max()
                .orElseThrow();
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static Integer getMinAge(List<User> users) {
        return users.stream()
                .mapToInt(u -> u.getAge())
                .min()
                .orElseThrow();
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static boolean anyMatch(List<User> users, int age){
        return users.stream()
                .anyMatch(u -> u.getAge() == age);
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static boolean noneMatch(List<User> users, int age){
        return users.stream()
                .noneMatch(u -> u.getAge() == age);
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static Optional<User> findAny(List<User> users, String name){
        return users.stream()
                .filter(u -> u.getName().equals(name))
                .findAny();
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<User> sortByAge(List<User> users){
        return users.stream()
                .sorted((u01, u02) -> u01.getAge().compareTo(u02.getAge()))
                .collect(Collectors.toList());
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static Stream<Integer> getBoxedStream(IntStream stream){
        return stream.boxed();
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static List<Integer> generateFirst10PrimeNumbers(){
    return Stream.generate(() -> new Random().nextInt())
            .limit(10)
            .collect(Collectors.toList());
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2)
                .noneMatch(i -> number%i == 0);
    }

    public static List<Integer> generate10RandomNumbers(){
        return Stream.generate(() -> Integer.valueOf(new Random().nextInt()))
                .limit(10)
                .collect(Collectors.toList());
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static User findOldest(List<User> users){
        return users.stream()
                .max((u01, u02) -> u01.getAge().compareTo(u02.getAge()))
                .orElse(null);
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static int sumAge(List<User> users){
        return (int) users.stream()
                .map(n -> n.getAge())
                .reduce(0, (a, b) -> a + b);
//        throw new UnsupportedOperationException("Not implemented");
    }

    //Pvz.:
    //Java 8 Streams API: Grouping and Partitioning a Stream
    //https://www.javacodegeeks.com/2015/11/java-8-streams-api-grouping-partitioning-stream.html

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users){
        return users.stream()
                .collect(Collectors.partitioningBy(u -> u.isMale()));
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(u -> u.getAge()));
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(u -> u.isMale(), Collectors.groupingBy(u -> u.getAge())));
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static Map<Boolean, Long> countGender(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(u -> u.isMale(), Collectors.counting()));
//        throw new UnsupportedOperationException("Not implemented");
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users){
        throw new UnsupportedOperationException("Not implemented");
    }

}
