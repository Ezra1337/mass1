import java.util.Arrays;
import java.util.Random;

public class sortirovkaMasiva {
    public static void main(String[] args) {
        byte[] num = new byte[] {9,8,7,6,5,4,3,2,1};
        System.out.println("mass: ");
        System.out.println(Arrays.toString(num));
        byte[] sorted = Arrays.copyOf(num, num.length);
        Arrays.sort(num);
        System.out.println("sotred mass: ");
        System.out.println(Arrays.toString(sorted));
        int counter = 0;

        for (int i = 1; i < num.length; i++) { // выталкивает крупные элменты массива.
            System.out.println(">> " + Arrays.toString(num));
            for (int j = 1; j < num.length - i + 1; j++) {
                if (num[j-1] > num[j]) {
                    byte tmp = num[j-1];
                    num[j-1] = num[j];
                    num[j] = tmp;
                }
                counter++;
            }
        }
        System.out.println("sotred mass: ");
        System.out.println(Arrays.toString(num));
        System.out.println("counter = " + counter);
    }
}
