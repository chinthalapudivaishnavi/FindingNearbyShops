import java.util.*;
class Node{
	int key;
	Node left,right;
	public Node(int item){
		key=item;
		left=right=null;
	}
}


	

class BinaryTree
{
	Node root;
	BinaryTree(){
		root=null;
	}
	public static void main(String args[])
	{

		Scanner sc=new Scanner(System.in);
		BinaryTree tree=new BinaryTree();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
	}
}