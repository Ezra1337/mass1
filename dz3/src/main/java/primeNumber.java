import java.math.BigInteger;
import java.util.Scanner;
public class primeNumber {
    public static void main(String[] args) {
        System.out.println("Введите число: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        BigInteger bigInteger = BigInteger.valueOf(a);
        boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(a));
        System.out.println(probablePrime);
    }
}
