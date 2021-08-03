
public class LinkedList {

	Node start;
	Node end;
	public LinkedList() {
		 start=null;
		 end=null;
		 
	}
	
	public void insertBeg(int data)
	{
		Node newnode= new Node(data);
		
		if (start ==null)
		{
			start= newnode;
			end= newnode;
			return;
		}
		start.prev = newnode;
		newnode.next= start;
		start = newnode;
		
	}
	
	
	public void insertEnd(int data)
	{
		Node newnode= new Node(data);
		
		if(start==null)
		{
			start=newnode;
			end= newnode;
			return;
		}
		end.next= newnode;
		newnode.prev= end;
		end= newnode;
	}
	
	
  public void display()
  {
	  Node temp;
	  temp =start;
	  while(temp!=null)
	  {
	 
	  System.out.print(temp.data + " ");
	  temp = temp.next;
	  }
  }
  public int length() {
	  Node temp;
	  temp = start;
	  int length = 0;
	  while(temp!=null)
	  {
		  length++;
		  temp= temp.next;
		  
	  }
	  return length;
  }
  
  public Node search (int data)
  {
	  Node temp ;
	  temp = start;
	  Node value = temp;
	
	  while (temp!=null)
	  {
		  if(temp.data==data)
		  {
			value = temp;
			  
		  }
		  temp = temp.next;
	  }
	  return value;
  }
  // insertafternode
  
  void inserAfterNode(int el_add, int el_pre)
  {
	  Node a = search(el_pre);
	  if(a == null)
	  {
		  return;
	  }
	  if(a==end)
	  {
		  insertEnd(el_add);
		  return;
	  }
	  Node b = new Node(el_add);
	  Node c = a.next;
	  a.next=b;
	  b.next=c;
  }
	
	public static void main(String[] args) {
	LinkedList ll = new LinkedList();
	ll.insertEnd(4);
	ll.insertEnd(5);
	ll.insertEnd(1);
	ll.insertEnd(9);

	 
   // System.out.println(ll.length());
    ll.display();
	
	
}}
