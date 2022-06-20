import java.util.Scanner;

public class isEven {
    public static void main(String[] args) {
        System.out.println("Введите число: ");
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        if ((a%2) == 0) {
            System.out.println("Число\n" + a + "\nЧЕТНОЕ!");
        }
         else {
                 System.out.println("Число\n" +a+ "\nНЕЧЕТНОЕ!");
             }
        }
    }

