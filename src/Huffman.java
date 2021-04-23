import java.util.Scanner;
import java.util.TreeMap;

public class Huffman {
    public static void main(String[] args) throws Exception {
        String text;

        Scanner sc = new Scanner(System.in);
        System.out.print("Input Text : ");
        text = sc.next();

        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            Integer val = map.get(c);
            if(val != null) {
                map.put(c,val + 1);
            }
            else {
                map.put(c,1);
            }
        }

        for (Character name: map.keySet()) {
            String key = name.toString();
            String value = map.get(name).toString();
            System.out.println(key + " : " + value);
        }

        System.out.println("Output Text : " + text);
        sc.close();
    }
}
