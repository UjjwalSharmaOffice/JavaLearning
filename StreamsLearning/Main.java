package StreamsLearning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of(new String[]{"Ujjwal","Ujjwal", "Sharma", "","Adit", "anu", "aaaaaaaaaaaa"});
        printList(list);
        printUppercaseList(list);
        printStringStartsWithA(list);
        printStringWithLength(list);
        System.out.println(countString(list));
        appendMR(list);
        System.out.println("removing Empty strings");
        removeEmpty(list);
        System.out.println("Printing Length");
        printLength(list);
        System.out.println("Counting Streams with length 5");
        System.out.println(countStringwithLengthFive(list));
        System.out.println("Sorting this");
        sortString(list);
        System.out.println("Printing in reverse order");
        sortStringInReverse(list);
        System.out.println("Remove Duplicates");
        removeDuplicates(list);
        System.out.println("Sort by length");
        sortByLength(list);
        System.out.println("Printing top 3 Longest");
        top3Longest(list);

        String joined = joinStrings(list);
        System.out.println(joined);
        checkStringStartsWithS(list);
        System.out.println(lengthGreaterThan3(list));

        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are powerful"
        );



    }

    public static void printList(List<String> list){
        list.stream().forEach(System.out::println);
    }

    public static void printUppercaseList(List<String> list){
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
    }
    public static void printStringStartsWithA(List<String> list){
        list.stream().filter(str -> str.startsWith("A")).forEach(System.out::println);
    }
    public static void printStringWithLength(List<String> list){
        list.stream().filter(str ->str.length()>3).forEach(System.out::println);
    }
    public static int countString(List<String> list){
        return (int) list.stream().count();
    }
    public static void appendMR(List<String> list){
        list.stream().map(str-> "Mr."+str).forEach(System.out::println);
    }

    public static void removeEmpty(List<String> list){
        list.stream().filter(str-> !str.isEmpty()).forEach(System.out::println);
    }

    public static void printLength(List<String> list){
        list.stream().map(String::length).forEach(System.out::println);
    }
    public static int countStringwithLengthFive(List<String> list){
        long count = list.stream().filter(str -> str.length() == 5).count();
        return (int) count;
    }

    public static void sortString(List<String> list){
        list.stream().sorted().forEach(System.out::println);
    }

    public static void sortStringInReverse(List<String> list){
        list.stream().sorted((a,b) -> b.compareTo(a)).forEach(System.out::println);
    }

    public static void removeDuplicates(List<String> list){
        list.stream().distinct().forEach(System.out::println);
    }
    public static void sortByLength(List<String> list){
        list.stream().sorted((a,b) -> b.length() - a.length()).forEach(System.out::println);
    }
    public static void top3Longest(List<String> list){
        list.stream().sorted((a,b) ->b.length() - a.length()).limit(3).forEach(System.out::println);
    }

    public static String joinStrings(List<String> list){
        return list.stream().collect(Collectors.joining(","));
    }

    public static void checkStringStartsWithS(List<String> list){
       list.stream().filter(str -> str.startsWith("S")).forEach(System.out::println);

    }

    public static Boolean lengthGreaterThan3(List<String> list){
        return list.stream().allMatch(str -> str.length() > 3);
    }

    public static String firstStringWithCharA(List<String> list){
        return list.stream().filter(str -> str.contains("A")).findFirst().get();
    }
    public static void converStringToWord(List<String> list){
        list.stream().flatMap(str-> Arrays.stream(str.split(" "))).forEach(System.out::println);
    }

    public static void printWords(List<String> list){
        list.stream().flatMap(str -> Arrays.stream(str.split(" "))).forEach(System.out::println);
    }



}
