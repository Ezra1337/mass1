import java.util.Scanner;

public class summaVklada {
    public static void main(String[] args) {
        double summaVklada;
        double summaR;
        double dohod;
        double procent;
        int srok;

        Scanner in = new Scanner(System.in);
        System.out.println("Сумма вклада:");
        summaVklada = in.nextDouble();
        System.out.println("Введите процент:");
        procent = in.nextDouble();
        System.out.println("ВВедите срок:");
        srok = in.nextInt();
        dohod = (procent * summaVklada / 100) * srok;
        summaR = dohod + summaVklada * srok;
        System.out.println("Накопившаяся сумма : " + summaR);
        System.out.println("Доход по вкладу: " + dohod);
    }
}