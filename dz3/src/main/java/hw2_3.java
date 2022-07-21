import java.util.Random;
import java.util.Scanner;

public class hw2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер массива NxM: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        Random r = new Random();
        for ( int i = 0; i < arr.length; i++ ) {
            for ( int j = 0; j < arr[i].length; j++)
                arr[i][j] = r.nextInt(-10, 10);
        }
        getArr(arr);
    }
    public static void getArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                System.out.println();
            }
        }
    }
}