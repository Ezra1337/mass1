import java.util.Scanner;

public class zadacha4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = (32- (b + 1));
        int d = 0;
        a = (a<<c);
        a = (a>>32-b);
        d = (~a/-1);
        System.out.println(d);
    }
}
