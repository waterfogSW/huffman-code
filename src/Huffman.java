import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.PriorityQueue;

public class Huffman {
    public static void main(String[] args) throws Exception {
        String text;

        Scanner sc = new Scanner(System.in);
        System.out.print("Input Text : ");
        text = sc.nextLine();
        sc.close();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            if(c == ' ') continue;
            Integer val = map.get(c);
            if(val != null) {
                map.put(c,val + 1);
            }
            else {
                map.put(c,1);
            }
        }
        Character[] key_arr = map.keySet().toArray(new Character[map.size()]);
        Integer[] value_arr = map.values().toArray(new Integer[map.size()]);
        System.out.println("Char : " + Arrays.toString(key_arr));
        System.out.println("Freq : " + Arrays.toString(value_arr));

        int numOfchar = key_arr.length;
        PriorityQueue<Node> q
            = new PriorityQueue<Node>(numOfchar, new MyComparator());

        for(int i = 0; i < key_arr.length; i++) {
            Node hn = new Node();
            hn.ch = key_arr[i];
            hn.weight = value_arr[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        Node root = null;

        while(q.size() > 1) {
            Node x = q.peek();
            q.poll();

            Node y = q.peek();
            q.poll();

            Node f = new Node();
            f.weight = x.weight + y.weight;
            f.ch = null;
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }

        printCode(root, "");
    }

    public static void printCode(Node root, String s) {
        if(root.left == null && root.right == null && Character.isLetter(root.ch)) {
            System.out.println(root.ch + ":" + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
}
