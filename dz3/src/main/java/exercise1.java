import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {
        int a;
        Scanner input = new Scanner (System.in);
        System.out.println("Введите порядковый номер дня недели: ");
        a = input.nextInt();
        switch (a) {
            case 0:
                System.out.println("Такого дня нет :) Введите другой!");
                break;
            case 1:
                System.out.println("Понедельник");
                break;

                case 2:
                    System.out.println("Вторник");
                    break;

                    case 3:
                        System.out.println("Среда");
                        break;
            case 4:
                System.out.println("Четверг");
                break;
                case 5:
                    System.out.println("Пятница");
                    break;
                    case 6:
                        System.out.println("Суббота");
                        break;
            case 7:
                System.out.println("Вокресенье");
                break;
        }
    }
}

