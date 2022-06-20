import java.util.Scanner;

public class zadacha7 {
    public static void main(String[] args) {
        primer solution = new primer();
        System.out.println("Введите число: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        number |= (number >>  1);
        number |= (number >>  2);
        number |= (number >>  4);
        number |= (number >>  8);
        return number - (number >> 1);
    }
}