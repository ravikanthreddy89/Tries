
import java.util.Scanner;


public class TrieTest {

	public static void main(String []args){
		Trie<Integer> trie= new Trie<Integer>();
		
		Scanner input= new Scanner(System.in);
		System.out.println("List of commands ");
		System.out.println("Please use <Integer,String> Key-value pairs.");
		System.out.println("=====================================================================================");
		System.out.println("insert <key> <Value>  : insert into tree a key-value pair");
		System.out.println("get <key> : get the value associated with key");
		System.out.println("del <key> : del a node with given key");
		System.out.println("quit : quits the execution");
		System.out.println("=====================================================================================");
		
		while(true){
			String[] cmds= input.nextLine().split(" ");
			
			if(cmds[0].equals("quit"))break;
			
			else if(cmds[0].equals("insert")) {
				if(cmds.length!=3){
					System.out.println("Usage : insert <key> <value>");
					continue;
				}
				trie.put(cmds[1],Integer.parseInt(cmds[2]));
			}
			
			else if(cmds[0].equals("get")){
				if(cmds.length !=2) {
					System.out.println("Usage : get <Key>");
					continue;
				}
				if(trie.get(cmds[1])==null) System.out.println("No such key");
				else System.out.println(trie.get(cmds[1]));
			}
				
		}
		
	}
}

