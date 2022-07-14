public class hw6 {
    public static void main(String[] args) {
        int count = 0;
        for ( int i =4; i <= 99994; i++) {
            String str = String.valueOf(i);
            if (str.indexOf('4') != -1) {
                count++;
            } else if (str.indexOf('1') != -1 & str.indexOf('1') + 1 == str.indexOf('3')) {
                count++;
            }
        }
        System.out.println("Нужно убрать "+count+" номеров");
    }
}
