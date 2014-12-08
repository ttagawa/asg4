import java.io.*;
import java.util.*;
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
            	}else{
            		System.err.println("You can't add an option before you create a room.");
            		auxlib.quit();}break;
            	case "d" : if(!tree.isEmpty()){
            		tree.addDesc(tree.getCurrent(),line);
            	}else{
            		System.err.println("ERROR: You can't add a description before you create a room.");
            		auxlib.quit();
            	}
            	break;
            	case "t" : if(tree.getOp(tree.getCurrent())[tree.getCount(tree.getCurrent())-1]!=null){
            		tree.addDest(tree.getCurrent(),line);
            	}break;
            }
            
        }
        scan.close();
        if(tree.tagCheck()==true)
        	play(tree);
        else{
        	System.err.println("ERROR: You Can't set a destination tag for a room that doesn't exist.");
        	auxlib.quit();
	}
	static void play(Tree t){
		Scanner in = new Scanner(System.in);
		System.out.println(t.getDesc(t.getRoot()));
		t.printOptions(t.getRoot());
		t.setCur();
		while(in.hasNextLine()){
			String c = in.nextLine();
			switch(c){
				case "r":System.out.println("[restart]");
				play(t);
				return;

				case "q":System.out.println("[exit]");
				auxlib.quit();
				break;

				case"y": t.printTree(t.getRoot()); break;

				case"z": try{t.finder(t.st.remove());
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NoSuchElementException e){
					System.err.println("You can't undo anymore.");
				}
				break;
				case "a":try{
				System.out.println("["+t.getText2(t.getOp(t.getCurrent())[0])+"]");
				t.st.add(t.getDest(t.getOp(t.getCurrent())[0]));
				t.finder(t.getDest(t.getOp(t.getCurrent())[0]));
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NullPointerException e){
					auxlib.warn("Invalid Command: "+c);}break;
				
				case "b":try{
				System.out.println("["+t.getText2(t.getOp(t.getCurrent())[1])+"]");
				t.st.add(t.getDest(t.getOp(t.getCurrent())[1]));
				t.finder(t.getDest(t.getOp(t.getCurrent())[1]));
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NullPointerException e){
					auxlib.warn("Invalid Command: "+c);}break;
				
				case "c":try{
				System.out.println("["+t.getText2(t.getOp(t.getCurrent())[2])+"]");
				t.st.add(t.getDest(t.getOp(t.getCurrent())[2]));
				t.finder(t.getDest(t.getOp(t.getCurrent())[2]));
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NullPointerException e){
					auxlib.warn("Invalid Command: "+c);}break;
				
				case "d":try{
				System.out.println("["+t.getText2(t.getOp(t.getCurrent())[3])+"]");
				t.st.add(t.getDest(t.getOp(t.getCurrent())[3]));
				t.finder(t.getDest(t.getOp(t.getCurrent())[3]));
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NullPointerException e){
					auxlib.warn("Invalid Command: "+c);}break;
				
				case "e":try{
				System.out.println("["+t.getText2(t.getOp(t.getCurrent())[4])+"]");
				t.st.add(t.getDest(t.getOp(t.getCurrent())[4]));
				t.finder(t.getDest(t.getOp(t.getCurrent())[4]));
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NullPointerException e){
					auxlib.warn("Invalid Command: "+c);}break;
				
				case "f":try{
				System.out.println("["+t.getText2(t.getOp(t.getCurrent())[5])+"]");
				t.st.add(t.getDest(t.getOp(t.getCurrent())[5]));
				t.finder(t.getDest(t.getOp(t.getCurrent())[5]));
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NullPointerException e){
					auxlib.warn("Invalid Command: "+c);}break;
				
				case "g":try{
				System.out.println("["+t.getText2(t.getOp(t.getCurrent())[6])+"]");
				t.st.add(t.getDest(t.getOp(t.getCurrent())[6]));
				t.finder(t.getDest(t.getOp(t.getCurrent())[6]));
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NullPointerException e){
					auxlib.warn("Invalid Command: "+c);}break;
				
				case "h":try{
				System.out.println("["+t.getText2(t.getOp(t.getCurrent())[7])+"]");
				t.st.add(t.getDest(t.getOp(t.getCurrent())[7]));
				t.finder(t.getDest(t.getOp(t.getCurrent())[7]));
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NullPointerException e){
					auxlib.warn("Invalid Command: "+c);}break;
				
				case "i":try{
				System.out.println("["+t.getText2(t.getOp(t.getCurrent())[8])+"]");
				t.st.add(t.getDest(t.getOp(t.getCurrent())[8]));
				t.finder(t.getDest(t.getOp(t.getCurrent())[8]));
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NullPointerException e){
					auxlib.warn("Invalid Command: "+c);}break;
				
				case "j":try{
				System.out.println("["+t.getText2(t.getOp(t.getCurrent())[9])+"]");
				t.st.add(t.getDest(t.getOp(t.getCurrent())[9]));
				t.finder(t.getDest(t.getOp(t.getCurrent())[9]));
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NullPointerException e){
					auxlib.warn("Invalid Command: "+c);}break;
				
				case "k":try{
				System.out.println("["+t.getText2(t.getOp(t.getCurrent())[10])+"]");
				t.st.add(t.getDest(t.getOp(t.getCurrent())[10]));
				t.finder(t.getDest(t.getOp(t.getCurrent())[10]));
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NullPointerException e){
					auxlib.warn("Invalid Command: "+c);}break;
				
				case "l":try{
				System.out.println("["+t.getText2(t.getOp(t.getCurrent())[11])+"]");
				t.st.add(t.getDest(t.getOp(t.getCurrent())[11]));
				t.finder(t.getDest(t.getOp(t.getCurrent())[11]));
				System.out.println(t.getDesc(t.getCurrent()));
				t.printOptions(t.getCurrent());}catch(NullPointerException e){
					auxlib.warn("Invalid Command: "+c);}break;

				default:auxlib.warn("Invalid Command: " +c);

			}
		}

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