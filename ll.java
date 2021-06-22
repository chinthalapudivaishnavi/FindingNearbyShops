class LinkedList
{
	public Node head=null;
	public Node tail=null;
	class Node
	{
		int data;
		Node next;
		public  Node(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	public void display()
	{
		Node current=head;
		if(head==null)
		{
			System.out.println("list is empty");
		}
		else{
			while(current!=null)
			{
				System.out.println(current.data+"");
				current=current.next;
			}
		}
	}
	public void addNode(int data)
	{
		Node newnode=new Node(data);
		if(head==null)
		{
			head=newnode;
			tail=newnode;
		
		}
		else{
			tail.next=newnode;
			tail=newnode;
		}
		
	}
	public static void main(String args[])
	{
		LinkedList slist=new LinkedList();
		slist.addNode(1);
		slist.addNode(2);
		slist.addNode(3);
		slist.addNode(4);
		slist.display();
	}
}
