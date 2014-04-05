import java.util.Iterator;


public class Trie<Value> implements Iterable{

	/*Node definition*/
	class Node<Value>{
		Node[] array;//only 256 ASCII
		Value val;//can hold any value corresponding to given key
		Node(){
			this.array = new Node[256];
			this.val = null;
		}
	}
	
	/*Class members*/
	private Node root;
	private int size;
	
	
	/*Client methods*/	
	
	public void put(String key, Value val){
		this.size=this.size+1;
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
	
	public boolean contains(String key){
		return get(key)!=null;
	}
	
	public int size(){
		return this.size;
	}
	
	//lets write code to iterate over keys before
	//going ahead with "Iterator" implementation
	
	public void iterate(){
		iterate(this.root);
	}
	
	
	public Iterable<String> keysWithPrefix(String prefix){
		return (Iterable<String>)new TrieIterator(this.root, prefix);
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new TrieIterator(this.root,"");
	}

	/*Private methods hidden from client*/
	private Node put(Node x, String key,Value val,int index){
		
		if(x==null) x=new Node();
		//check if you have hit the end
		if(index==key.length()){
			x.val=val;
			return x;
		}
		
		//int pos=key.charAt(index)-48; // jaffa !! we are not just dealing with decimals.
		int pos=key.charAt(index);
		x.array[pos]=new Node();
		x.array[pos]=put(x.array[pos],key,val,(index+1));
		return x;
	}
	
	private Value get(Node x, String key,int index){
		if(x==null) return null;
		if(index==key.length()) return (Value)x.val;
		int pos=(key.charAt(index));
		return get(x.array[pos],key,index+1);
	}

	private void iterate(Node x){
		//if(x==null) return;
		
		for(int i=0;i<256;i++){
			if(x.array[i]!=null){
				System.out.print(Character.toString((char)i));
				iterate(x.array[i]);
				System.out.println("");
			}
			
		}
		
	}
	
	private class TrieIterator implements Iterator<String>{

		private String prefix;
		private Node localRoot;
		
		TrieIterator(Node x, String prefix){
			this.prefix=prefix;
			
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
