package g33k;

public class SizeOfTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(2);
		head.left= new Node(3);
		head.right = new Node(1);
		head.right.right = new Node(8);
		System.out.println(size(head));

	}
	
	public static int size(Node node){
		
		if(node == null){
			return 0;
		}
		else return size(node.left) + size(node.right) +1 ;
		
	}
}
	class Node{
		
		Node left;
		Node right;
		int data;
		Node(int i){
			
			this.data = i;
			left =null;
			right =null;
		}
	}
	


