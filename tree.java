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
    public Deque<String> st= new LinkedList<String>();
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
    public void setCur(){
        current=root;
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
            cur.descriptions +="\n"+d+"\n";
        }
        public String getDesc(Node cur){
            return cur.descriptions;
        }
        public String getText(Node cur){
            return cur.options[cur.count-1].text;
        }
        public String getText2(Option op){
            return op.text;
        }
        public String getDest(Option op){
            return op.destination;
        }
        public String getDest(Node cur){
            return cur.options[cur.count-1].destination;
        }
        public void printTree(Node cur){
            if ( cur== null)
            return;
        printTree(cur.left);
        String room=" : ";
        for(int i=0;i<cur.count;i++){
            room+=cur.options[i].destination+" ";
        }
        System.out.println(cur.key+room);
        printTree(cur.right);
        }
        
        public void printOptions(Node cur){
            for(int i=0;i<cur.count;i++){
                switch(i){
                    case 0:System.out.println("a - "+cur.options[i].text); break;
                    case 1:System.out.println("b - "+cur.options[i].text); break;
                    case 2:System.out.println("c - "+cur.options[i].text); break;
                    case 3:System.out.println("d - "+cur.options[i].text); break;
                    case 4:System.out.println("e - "+cur.options[i].text); break;
                    case 5:System.out.println("f - "+cur.options[i].text); break;
                    case 6:System.out.println("g - "+cur.options[i].text); break;
                    case 7:System.out.println("h - "+cur.options[i].text); break;
                    case 8:System.out.println("i - "+cur.options[i].text); break;
                    case 9:System.out.println("j - "+cur.options[i].text); break;
                    case 10:System.out.println("k - "+cur.options[i].text); break;
                    case 11:System.out.println("l - "+cur.options[i].text); break;
                }
            }
            System.out.print("\n");
        }

}
