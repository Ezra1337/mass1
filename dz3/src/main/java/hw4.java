import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class hw4 {

    public static final Set<Character> GLASNYIE = new HashSet<>(Arrays.asList(new Character[] {'a', 'i', 'o', 'u', 'y', 'e'}));
    public static Predicate<char[]> PREDICATE = chars -> isGLASNYIE(chars[0]) && !isGLASNYIE(chars[chars.length - 1]);

    public static void main(String[] args) {
        System.out.println("Введите слова в строку: ");
        Scanner sc = new Scanner(System.in);
        List<String> result = Arrays.stream(sc.nextLine().split(" ")).filter(s -> PREDICATE.test(s.toCharArray())).collect(Collectors.toList());
        System.out.println(result);
    }

    public static boolean isGLASNYIE(char c) {
        return GLASNYIE.contains(Character.toLowerCase(c));
    }
}