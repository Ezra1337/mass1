public class massivBukv {
    public static void main(String[] args) {
        String str = "hello world";
        char[] charList = str.toCharArray();
        for ( int i = 0; i < charList.length; i++ ) {
            if (charList[i] == ' ') {
                charList[i] = '_';
            }
        }
        str = new String(charList);
    }
}
