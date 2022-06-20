import java.util.Scanner;
public class zadacha6 {
    public static void main(String[] args) {
        System.out.println("Введите число N и i бит: ");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i = sc.nextInt();
        System.out.println(Integer.toBinaryString(N));
        System.out.println(Integer.toBinaryString(fBit(N,i)));
        System.out.println(N &((1<<i)-1));

    }
    public static int fBit (int value, int bitIndex) {
        return value ^ 1<<(bitIndex-1);
    }
}

