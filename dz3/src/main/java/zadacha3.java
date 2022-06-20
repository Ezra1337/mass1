import java.util.Scanner;

public class zadacha3 {
    public static void main(String[] args) {
        System.out.println("Введите число N: ");
        System.out.println("Введите i бит: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(fBit(a,b)));
        System.out.println(fBit(a,b));
    }
    public static int fBit (int value, int bitIndex) {
        return value ^ 1<<(bitIndex-1);
    }
}
