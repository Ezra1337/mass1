import java.util.Scanner;

public class zadacha8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число у которого определим значение бита: ");
        int N = sc.nextInt();
        System.out.printf("%3d ->  %32s\n", N, Integer.toBinaryString(N));
        System.out.println("Введите i бит: ");
        int i = sc.nextInt();
        int result = N & (1<<i);
        String binResult = Integer.toBinaryString(result);
        System.out.printf("%3d -> %32s\n", result, binResult);
    }
}
