package g33k;

public class CompareTreeEqual {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Node head1 = new Node(5);
		 Node head2 = new Node(5);
		 
		 head1.left = new Node(4);
		 head2.left = new Node(4);
		 
		 head1.right = new Node(8);
		 head2.right = new Node(8);
		 // head2.right.right = new Node(8);
		 
		 System.out.println(equalTree(head1,head2));
		 
		

	}
	
	
	public static boolean equalTree(Node a,Node b){
		if(a==null&&b==null){
			
			return true;
		}
		if(a!=null&&b!=null){
			 return (a.data==b.data)&&(equalTree(a.left,b.left))&&(equalTree(a.right,b.right));
		}
			
		
			
			
		
		
		
		return false;
	}

}
