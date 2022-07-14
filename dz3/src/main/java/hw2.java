import java.util.Scanner;

public class hw2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число от 1 до 1000: ");
        int N = sc.nextInt();
        String str1 = "";
        String str2 = "";

        for (int i = 1; str1.length() < 1000; i++) {
            str1 = str1 + String.valueOf(i);
        }
        for (int i = 0; i <= 999; i++) {
            str2 = str2 + String.valueOf(str1.charAt(i));
        }
        System.out.println("Позиция = " + N + " Число = " + str2.charAt(N - 1));
    }
}
