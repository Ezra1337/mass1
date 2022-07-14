import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class hw10 {
    public static void main(String[] args) {
        System.out.println("Введите слово из которого хотите сделать ромб, на латинице: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = str.length() - 1; i > -str.length(); i--) {
            if (i > 0)
                System.out.println(str.replaceAll(String.format("\\b\\w{%d}", i), getSpaces(i)));
            else
                System.out.println(str.replaceAll(String.format("\\w{%d}\\b", Math.abs(i)), getSpaces(i)));
        }
    }

    public static String getSpaces(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(value -> " ")
                .collect(Collectors.joining());
    }
}