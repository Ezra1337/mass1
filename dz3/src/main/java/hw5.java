import java.util.Scanner;

public class hw5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line = sc.nextLine();
        String[] split = line.split("[\\s:]");
        int counter = 0;
        for (String s : split) {
            if (s.length() % 2 == 0) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
