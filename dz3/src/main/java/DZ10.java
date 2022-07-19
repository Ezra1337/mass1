import java.util.Random;
import java.util.Scanner;

public class DZ10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[][] arr = null;
        do {
            System.out.println("Введите размеры массива: ");
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (n > 0 && m > 0) {
                arr = new boolean[n][m];
            }
        } while (arr == null);
        Random rand = new Random();
        for( boolean[] row : arr) {
            for (int i = 0; i < arr.length; i++) {
                row[i] = rand.nextBoolean();
            }
        }
        System.out.println("1 - занято, 0 - свободно");
        for( boolean[] row : arr) {
for (boolean y : row) {
    System.out.print((y ? "1" : "0") + " ");
}
            System.out.println();

        }
        int count = -1;
                do {
                    System.out.println("Сколько нужно мест?");
                    count = scanner.nextInt();
                }while (count < 1);

}
}