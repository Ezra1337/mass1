import java.io.IOException;
import java.util.Scanner;

public class hw1 {
        public static void main(String[] args) throws IOException {
            Scanner text = new Scanner(System.in);
            System.out.print("Введите строку в консоль: ");
            String str = text.nextLine();
            System.out.print("Введите один символ: ");
            String word = text.next();
            if (word.length() == 1) {
                char ch = word.charAt(0);
                int counter = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ch) {
                        System.out.println("Символ по индексу " + i);
                        counter++;
                    }
                }
                System.out.printf("Колличество символов '%c' равно %d", ch, counter);
            }
            text.close();
        }
    }