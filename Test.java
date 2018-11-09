import java.util.*;
class Node{
	int id;
	Node next;
	public Node(int id){
		this.id=id;
	}
	public String toString(){
		return ""+id;
	}
}
public class Test{
	public static Node head;
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int c;
		do{
			System.out.println("enter id:");
			int id=scan.nextInt();
			Node t=new Node(id);
			if(head==null){head=t;}
			else{
				Node temp=head;
				while(temp.next!=null){
					temp=temp.next;
				}
				temp.next=t;
			}
			System.out.println("To add Nodes Enter 1::");
			c=scan.nextInt();
		}while(c==1);
		display();
		/*System.out.println("Enter key Before which to be inserted:");
		int key=scan.nextInt();
		System.out.println("Enter the Value::");
		int val=scan.nextInt();
		insertbefore(key,val);
		display();
		System.out.println("Enter key After which to be inserted:");
		key=scan.nextInt();
		System.out.println("Enter the Value::");
		val=scan.nextInt();
		insertafter(key,val);
		display();*/
		/*System.out.println("Enter the Key to be delete::");
		int key=scan.nextInt();*/
		// delete(key);
		// display();
		/*llength();
		display();*/
		/*System.out.println("Enter index to getElement::");
		while(true){
			System.out.println(getNthNode(scan.nextInt()));
		}*/
		/*System.out.println("Enter index to getElement from Reverse::");
		while(true){
			System.out.println(getNthNode(llength()-scan.nextInt()));
		}*/
		// printMiddle();
		/*System.out.println("Enter the element to count occurences::");
		countElementOccurence(scan.nextInt());*/
		// reverse();
		// display();
		// checkPalindrome();
		removeDuplicatesFromSortedLL();
	}
	public static void removeDuplicatesFromSortedLL(){

	}
	public static void checkPalindrome(){
		System.out.println("in check palindrome");
		Stack<Node> s=new Stack<Node>();
		Node temp=head;
		while(temp!=null){
			s.push(temp);
			temp=temp.next;
			System.out.println("stack-->"+s);
		}
		temp=head;
		while(!s.empty() && temp!=null){
			System.out.println(s.peek()+"\t"+temp+"\tstack==>"+s);
			if(s.pop()!=temp){
				System.out.println("Not palindrome");
			}
			temp=temp.next;
		}
	}
	public static void reverse(){
		Node prev=null;
		Node curr=head;
		Node next=null;
		while(curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
	}
	public static void countElementOccurence(int element){
		Node temp=head;
		int c=0;
		while(temp.next!=null){
			if(temp.id==element){c++;}
			temp=temp.next;
		}
		if(temp!=null && temp.id==element){c++;}
		System.out.println("Element "+element+" occured "+c+" number of times");
	}
	public static void printMiddle(){
		Node temp=head;
		if(temp==null){System.out.println("null");}
		else{
			Node preptr,ptr;
			ptr=head;
			preptr=ptr;  
			while(ptr.next!=null && ptr.next.next!=null){
				preptr=preptr.next;
				ptr=ptr.next.next;
			}
			System.out.println("middle element==>"+preptr);
		}
	}
	public static Node getNthNode(int index){
		Node temp=head;
		if(temp==null){return null;}
		else if(index==0 && temp!=null){return head;}
		else{
			int i=1;
			while(temp.next!=null){
				if(i==index){return temp.next;}
				else{temp=temp.next;i++;}
			}
			if(temp!=null && i==index){return temp;}
		}
		return null;
	}
	public static int llength(){
		 Node temp=head;
		int c=0;
		if(temp!=null){c=1;}
		while(temp!=null && temp.next!=null){
			temp=temp.next;
			c++;
		}
		System.out.println("Total length==>"+c);
		return c;
	}
	public static void insertbefore(int key,int val){
		Node temp=head;
		Node t=new Node(val);
		if(temp.id==key){
			t.next=head;
			head=t;
		}
		else{
			Node preptr,ptr;
			ptr=head;
			preptr=ptr;
			while(ptr.id!=key){
				preptr=ptr;
				ptr=ptr.next;
			}
			t.next=ptr;
			preptr.next=t;
		}
		System.out.println("Node id="+val+" is inserteddd");
	}
	public static void insertafter(int key,int val){
		Node temp=head;
		Node t=new Node(val);
		if(temp.id==key){
			t.next=temp.next;
			temp.next=t;
		}
		else{
			Node preptr,ptr;
			ptr=head;
			preptr=ptr;
			while(preptr.id!=key){
				preptr=ptr;
				ptr=ptr.next;
			}
			t.next=ptr;
			preptr.next=t;
		}
		System.out.println("Node id="+val+" id inserted");
	}
	public static void delete(int key){
		Node temp=head;
		if(head.id==key){
			head=head.next;
		}
		else{
			Node preptr,ptr;
			ptr=head;
			preptr=ptr;
			while(ptr.id!=key){
				preptr=ptr;
				ptr=ptr.next;
			}
			preptr.next=ptr.next;
		}
		System.out.println("Node id="+key+" is deleted");
	}
	public static void display(){
		Node temp=head;
		while(temp!=null && temp.next!=null){
			System.out.print(temp.id+"-->");
			temp=temp.next;
		}
		System.out.println(temp);
	}
}