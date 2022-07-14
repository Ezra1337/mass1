import java.util.Random;

public class chisloVSimvol {
    public static void main(String[] args) {
        char[] charList = new char[20];
        Random rand = new Random();
        for (int i = 0; i < charList.length; i++) {
            int start = (int) 'A';
            int end = (int) 'Z';
            int code = rand.nextInt(start, end + 1);
            char ch = (char)code;
            charList[i] = ch;
        }
        String str = new String(charList);
        System.out.println(str);
    }
}
