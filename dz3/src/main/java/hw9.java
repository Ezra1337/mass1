import java.util.Scanner;

public class hw9 {
    public static void main(String[] args) {
        System.out.println("Введите строку 1: ");
        Scanner sc = new Scanner(System.in);
        String str1, str2;
        str1 = sc.nextLine();
        System.out.println("Введите строку 2: ");
        str2 = sc.nextLine();
        char[] chArr1 = str1.toUpperCase().toCharArray();
        char[] chArr2 = str2.toUpperCase().toCharArray();

        for (int i = chArr1.length - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (chArr1[j] > chArr1[j + 1])
                {
                    char tmp = chArr1[j];
                    chArr1[j] = chArr1[j + 1];
                    chArr1[j + 1] = tmp;
                }
            }
        }
        for (int i = chArr2.length - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (chArr2[j] > chArr2[j + 1])
                {
                    char tmp = chArr2[j];
                    chArr2[j] = chArr2[j + 1];
                    chArr2[j + 1] = tmp;
                }
            }
        }
        String valueOfchar1 = String.valueOf(chArr1);
        String valueOfchar2 = String.valueOf(chArr2);
        valueOfchar1 = valueOfchar1.replaceAll(" ", "");
        valueOfchar2 = valueOfchar2.replaceAll(" ", "");
        System.out.println(valueOfchar1);
        System.out.println(valueOfchar2);
        System.out.println(valueOfchar1.equalsIgnoreCase(valueOfchar2));
    }
}