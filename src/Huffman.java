import java.util.Scanner;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.io.File;
import java.io.FileNotFoundException;

public class Huffman {
    public static void main(String[] args) throws Exception {

        Scanner sc_file = new Scanner(System.in);
        System.out.print("Input file name : ");
        String path = sc_file.nextLine();
        String text = "";
        try{
            File file = new File(path);
            String abs_path = file.getAbsolutePath();
            System.out.println(abs_path);
            file = new File(abs_path);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                text += scan.nextLine();
            }
            scan.close();
        }catch (FileNotFoundException e) {
            System.out.println("Error : no such file or directory" + path);
            sc_file.close();
            return;
        }

        sc_file.close();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
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

        System.out.print("Char : ");
        for (int i = 0; i < key_arr.length; i++) {
            System.out.print(String.format("%s ", key_arr[i]));
        }
        System.out.println();

        System.out.print("Freq : ");
        for (int i = 0; i < value_arr.length; i++) {
            System.out.print(String.format("%s ", value_arr[i]));
        }
        System.out.println();

        PriorityQueue<Node> q
            = new PriorityQueue<Node>(key_arr.length, new MyComparator());

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
            f.ch = '-';
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }

        printCode(root, "");
    }

    public static void printCode(Node root, String s) {
        if(root.left == null && root.right == null) {
            if(Character.isLetter(root.ch) || root.ch == ' '){
                System.out.println(root.ch + " : " + s);
                return;
            }
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
}
