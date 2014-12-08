import static java.lang.System.*;
import java.util.*;

class Tree {

    private class Node {
        String key;
        Option[] options;
        String descriptions="";
        Node left;
        Node right;
        int count=0;

        public Node(String key){
            this.key=key;
            options=new Option[12];
        }
    }
   private class Option{
        String text;
        String destination;

        public Option(String key){
            text=key;
        }
    }
    private Node root;
    private Node current;

    public void insert(String key) {
        Node newN = new Node(key);
        if (root == null) {
            root = newN;
            current=root;
        } else {
            Node parent = null;
            Node cur = root;
            while (cur != null) {
                if (key.compareTo(cur.key) < 0) {
                    parent = cur;
                    cur = cur.left;
                } else {
                    parent = cur;
                    cur = cur.right;
                }
            }

            if (key.compareTo(parent.key) < 0){
                parent.left = newN;
                current=parent.left;
            }else{
                parent.right = newN;
                current=parent.right;
            }
        }
    }
    public void finder(String key) {
        if (root == null) {
            System.out.println("Not found");
        }
        Node cur = root;
        while (!cur.key.equals(key)) {
            if (key.compareTo(cur.key) < 0)
                cur = cur.left;
            else
                cur = cur.right;
            if (cur == null)
                System.out.println("not found");
        }
        current = cur;
    }
   
    public Node getRoot() {
        return root;
    }
    public Node getCurrent() {
        return current;
    }
    public boolean isEmpty(){
        if(root==null)
            return true;
        else
            return false;
    }
      public int getCount(Node cur){
            return cur.count;
        }
        public Option[] getOp(Node cur){
            return cur.options;
        }
       
        public void countAdd(Node cur){
            cur.count++;
        }
        public void addText(Option op, String line){
            op.text=line;
        }
        public void addDest(Node cur, String line){
            cur.options[cur.count-1].destination=line;
        }
        public Option op(String text){
            Option op = new Option(text);
            return op;
        }
        public void addDesc(Node cur,String d){
            cur.descriptions +=d +"\n";
        }
        public String getDesc(Node cur){
            return cur.descriptions;
        }
        public String getText(Node cur){
            return cur.options[cur.count-1].text;
        }
        public String getDest(Node cur){
            return cur.options[cur.count-1].destination;
        }

}
