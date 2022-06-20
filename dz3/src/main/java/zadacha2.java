import java.util.Scanner;

public class zadacha2 {
    public static long pow2 (long n) {

        return 1 <<n;
    }

    public static void main(String[] args) {
        System.out.println("Введите степень: ");
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(pow2(n));
    }
    }

