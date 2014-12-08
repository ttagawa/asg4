import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;
class cyoa{
	static void processFile(String filename) throws IOException {
        Scanner scan = new Scanner (new File(filename));
        Tree tree = new Tree();
        while(scan.hasNextLine()) {
            String read = scan.nextLine();
            if(read.length()==0)
            	continue;
            String c = read.substring(0,1);
            String line = read.substring(2, read.length());
            switch(c){
            	case "r": tree.insert(line); break;
            	case "o" : if(!tree.isEmpty()){
            		int num =tree.getCount(tree.getCurrent());
            		tree.getOp(tree.getCurrent())[num]=tree.op(line);
            		tree.countAdd(tree.getCurrent());
            	}break;
            	case "d" : if(!tree.isEmpty()){
            		tree.addDesc(tree.getCurrent(),line);
            	}break;
            	case "t" : if(tree.getOp(tree.getCurrent())[tree.getCount(tree.getCurrent())-1]!=null){
            		tree.addDest(tree.getCurrent(),line);
            	}break;
            }
            
        }
        scan.close();
        System.out.println(tree.getRoot());
        System.out.println(tree.getDesc(tree.getCurrent()));
        System.out.println(tree.getText(tree.getCurrent()));
        System.out.println(tree.getDest(tree.getCurrent()));
        System.out.println(tree.getCurrent());
        
	}
	
	public static void main(String[] args){
		String file = args[0];
		try {
                processFile(file);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

	}

}