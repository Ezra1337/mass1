import java.util.Scanner;

class Circle {
    public static void main(String[] args) {
        double R;
        double pi = 3.14, S;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите R круга: ");
        R = sc.nextDouble();
        S = pi * R * R;
        System.out.println("S circle = " + S);
        sc.close();


    }
}
