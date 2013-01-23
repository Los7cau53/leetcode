


class Node{
  int item;
	Node leftChild;
	Node rightChild;
	Node nextRight;
	public void displayNode()
	{
		System.out.print("[");
		System.out.print(item);
		System.out.print("]");
	}

}
class StackNode
{
	public Node item;
	public StackNode next;
	public StackNode(Node val)
	{
		item = val;
	}

}
class LinkedListStack
{
	private StackNode first;
	public LinkedListStack()
	{
		first = null;
	}
	public boolean isEmpty()
	{
		return (first==null);
	}
	public void insert(Node key)//inserts at beginning of list
	{
		StackNode newLLNode = new StackNode(key);
		newLLNode.next = first;
		first = newLLNode;
	}
	public Node delete()//deletes at beginning of list
	{
		StackNode temp = first;
		first = first.next;
		return temp.item;
	}
}
class Stack
{
	private LinkedListStack listObj;
	public Stack()
	{
		listObj = new LinkedListStack();
	}
	public void push(Node num)
	{
		listObj.insert(num);
	}
	public Node pop()
	{
		return listObj.delete();
	}
	public boolean isEmpty()
	{
		return listObj.isEmpty();
	}
}



class Tree
{
	public Node root;
	public Tree()
	{ root = null; }
	public Node returnRoot()
	{
		return root;
	}
	public void insert(int id)
	{
		Node newNode = new Node();
		newNode.item = id;
		if(root==null)
			root = newNode;
		else
		{
			Node current = root;
			Node parent;
			while(true)
			{
				parent = current;
				if(id < current.item)
				{
					current = current.leftChild;
					if(current == null)
					{
						parent.leftChild = newNode;
						return;
					}
				}
				else
				{
					current = current.rightChild;
					if(current == null)
					{
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);	
		int emptyLeaf = 32;
		boolean isRowEmpty = false;
		System.out.println("****......................................................****");
		while(isRowEmpty==false)
		{

			Stack localStack = new Stack();
			isRowEmpty = true;
			for(int j=0; j<emptyLeaf; j++)
				System.out.print(' ');
			while(globalStack.isEmpty()==false)
			{
				Node temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.item);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if(temp.leftChild != null ||temp.rightChild != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<emptyLeaf*2-2; j++)
					System.out.print(' ');
			}
			System.out.println();
			emptyLeaf /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		}
		System.out.println("****......................................................****");
	}

}


public class BinaryTreeNextRightChild {


	public static void main(String[] args) 
	{
		int value;
		Tree theTree = new Tree();
		theTree.insert(42);
		theTree.insert(25);
		theTree.insert(65);
		theTree.insert(12);
		theTree.insert(37);
		theTree.insert(13);
		theTree.insert(30);
		theTree.insert(43);
		theTree.insert(87);
		theTree.insert(99);
		theTree.insert(9);

		System.out.println("Displaying the tree");
		theTree.displayTree();
		fixNextLink(theTree.root);
		System.out.println(theTree.root.nextRight);

	}
		public static void fixNextLink(Node root) {
			if(root == null) return;
			// The right most child for root
			Node rightmostChild = (root.rightChild != null) ? root.rightChild : root.leftChild;
			// Return, if there are no childs
			if(rightmostChild == null) return;
			// Continue to identify the sibling for root.rightmost (The right most child for root)
			Node temp = root.nextRight;
			Node leftmostSibling=null;
			while(temp != null && leftmostSibling == null){
				// Left most sibling to the right in the current level from the right most node of the current node
				Node leftmostSiblingInChain = (temp.leftChild != null) ? temp.leftChild : temp.rightChild;
				if(leftmostSiblingInChain != null) {
					rightmostChild.nextRight = leftmostSiblingInChain;
				}
				temp = temp.nextRight;
			}
			// Finally if the left and right child exists, connect left to right
			if (rightmostChild != root.leftChild) {
				root.leftChild.nextRight = root.rightChild;
			}
			// Go down the tree to fix other links
			fixNextLink(root.leftChild);
			fixNextLink(root.rightChild);
		}
	}
