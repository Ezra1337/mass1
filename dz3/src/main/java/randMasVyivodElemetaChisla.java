import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class randMasVyivodElemetaChisla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random(0);
        byte[] num = new byte[rand.nextInt(21) + 20];
                for (int i =0; i < num.length; i++) {
                    num[i] = (byte)(rand.nextInt(20) +1);
                }
        System.out.println("массив: ");
        System.out.println(Arrays.toString(num));
        System.out.println("input num to search: ");
                byte num2 = scanner.nextByte();
                int index = -1;
                for ( int i = 0; i < num.length && index < 0; i++) {
                    if (num2 == num[i]) {
                        index = i;
                    }
                }
                if (index <0) {
                    System.out.println("число не найдено");
                } else

        System.out.printf("num[%d] = %d ", index,num2);
    }
}

