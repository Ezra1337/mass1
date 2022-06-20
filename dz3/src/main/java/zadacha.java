import java.util.Scanner;

public class zadacha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.printf("Введите числа от %d до %d\n", start, end);
        for (int i = end; i <= end; i++) {
            if (i % 2 == 0) {
                System.out.printf("%d ", i);
            }

        }
    }
}