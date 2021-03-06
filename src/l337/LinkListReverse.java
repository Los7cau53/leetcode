package l337;

//http://leetcode.com/2010/04/reversing-linked-list-iteratively-and.html
public class LinkListReverse {

  /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List myList= new List();
		myList.insert(2);
		myList.insert(10);
		myList.insert(12);
		myList.insert(4);
		myList.insert(17);
		myList.insert(21);
		myList.insert(222);
		myList.display();
		System.out.println("------------------");
		myList.reverse();
		myList.display();
		System.out.println("------------------");
		reverse(myList);
		myList.display();
		System.out.println("------------------");

		recursivereverse1(myList);
		myList.display();
		System.out.println("------------------");
		myList.insert(252);
		myList.display();
	}

	public static void recursivereverse1(List l){
		ListNode temp=l.last;
		l.last=l.head;
		recursivereverse(l.head);
		l.head=temp;
	}

	public static void recursivereverse(ListNode head){

		if(head==null) return;
		if(head.next==null) return;
		ListNode temp=head.next;
		head.next=null;
		recursivereverse(temp);
		temp.next=head;

	}
	public  static  void reverse(List l){
		if(l.head ==null) return;
		ListNode prev=null;
		ListNode current=l.head;
		ListNode next=null;
		l.last=l.head;
		while(current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;

		}
		l.head=prev;
	} 

}


class ListNode{
	int item;
	ListNode next;

	ListNode(int i){
		this.item=i;
		this.next=null;

	}
}

class List{

	public ListNode head,last;
	List(){
		head=null;
		last=head;
	}
	public  void insert(int i){

		if(head==null){
			ListNode newNode= new ListNode(i);
			head= newNode;
			last=newNode;
		}
		else{

			ListNode newNode= new ListNode(i);
			last.next= newNode;
			last=newNode;
		}
	}

	public void display(){

		ListNode temp=head;
		while(temp!=null){
			System.out.println(temp.item);
			temp=temp.next;
		}

	}
	public   void reverse(){
		if(head==null) return;
		ListNode prev=null;
		ListNode current=head;
		ListNode next=null;
		last=head;
		while(current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;

		}
		head=prev;
	} 

}
