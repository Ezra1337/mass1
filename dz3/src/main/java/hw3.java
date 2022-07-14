import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введие строку: ");
        String str = sc.nextLine();
        sc.close();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            str = str.replace(" ", " ");
        }
        str = str.trim(); // удалим пробелы
        System.out.println("Удаляем  пробелы в начале и конце, результат - \"" + str + "\"");

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println("Слов в строке - " + (count + 1));
        System.out.println("Средняя длина слова в строке = (int) " + Math.round((float) (str.length() - count) / (float) (count + 1)));
        System.out.println("Средняя длина слова в строке = (float) " + ((float) (str.length() - count) / (float) (count + 1)));
    }
}
