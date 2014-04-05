
public class Trie<Value> {

	/*Node definition*/
	class Node<Value>{
		Node[] array= new Node[256];//only 256 ASCII
		Value val;//can hold any value corresponding to given key
	}
	
	/*Class members*/
	private Node root;
	private int size;
	
	
	/*Client methods*/
	
	
	
	
	public void put(String key, Value val){
		this.root=put(this.root,key,val,0);
	}
	
	public Value get(String key){
		Value ret=null;
		ret=get(root,key,0);
		return ret;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	/*public boolean contains(String key){
		
	}*/
	
	
	private Node put(Node x, String key,Value val,int index){
		//check if you have hit the end
		if(x==null) x=new Node();
		if(index==(key.length()-1)){
			x.val=val;
			return x;
		}
		
		int pos=key.charAt(index)-48;
		x.array[pos]=new Node();
		x.array[pos]=put(x.array[pos],key,val,(index+1));
		return x;
	}
	
	private Value get(Node x, String key,int index){
		if(x==null) return null;
		if(index==(key.length()-1)) return (Value)x.val;
		int pos=(key.charAt(index)-48);
		return get(x.array[pos],key,index+1);
	}
}
