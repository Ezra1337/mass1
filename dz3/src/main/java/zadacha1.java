public class zadacha1 {
    public static void main(String[] args) {
        int chislo = 0b11001111;
        int chislo2 = 0b00000001;
        System.out.println(Integer.toBinaryString(chislo) + " - исходное число");
        System.out.println("0000000" + Integer.toBinaryString(chislo2) + " - изменённое число");
        System.out.println(" ");
        chislo = chislo ^ chislo2;
        System.out.println(Integer.toBinaryString(chislo));
    }
}
