import java.util.HashMap;
import java.util.Map;

public class hw7 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1","_");
        map.put("2","_");
        map.put("3","_");
        map.put("4","_");
        map.put("5","_");
        map.put("6","_");
        map.put("7","_");
        map.put("8","_");
        map.put("9","_");
        map.put("0","_");
        String str = "За 3столоМ 2сидели 1мужиКи и елИ";
        String newstr = "";
        for (int i = 0; i < str.length (); i++) {
            String k = str.substring (i,i+1);
            if (map.containsKey (k)) {
                String y = map.get (k);
                newstr = newstr + y;
            } else newstr = newstr + k;
        }
        System.out.println (newstr);
        char [] ch = str.toCharArray ();
        for (int i = 0; i < ch.length; i++) {
            char str2 = ch [i];
            if (Character.isUpperCase (str2)) {
                ch [i] = Character.toLowerCase (str2);
            } else if (Character.isLowerCase (str2)) {
                ch[i] = Character.toUpperCase (str2);
            }

        }
        System.out.println (ch);
    }
}
// сделали общими силами!