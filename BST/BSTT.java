import java.util.*;
class Node{
	public Node left;
	public Node right;
	public int data;
	Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
class BSTT{
	public static Node root;
	public static void insert(int n){
		Node obj=new Node(n);
		if(root==null){	
			root=obj;
		}
		else{
			Node current=root;
			Node parent=current;
			Node child=parent;
			while(current!=null){
				parent=current;
				if(obj.data<current.data){
					current=current.left;
				}
				else if(obj.data>current.data){
					current=current.right;
				}
			}
			if(obj.data<parent.data ){
				parent.left=obj;
						// System.out.println(n+" is inserted in left");
			}
			else{
				parent.right=obj;
		// System.out.println(n+" is inserted in right");
			}
		}
	}
	/*public static void preOrder(Node current){
		if(current!=null){
			System.out.print(current.data+"\t");
			preOrder(current.left);
			preOrder(current.right);
		}
	}*/
	public static void inOrder(Node current){
		if(current!=null){
			inOrder(current.left);
			System.out.print(current.data+"\t");
			inOrder(current.right);
		}
	}
	public static void preOrder(Node current){
		Stack<Node> obj=new Stack<Node>();
		while(true){
			while(current!=null){
				obj.push(current);
				// System.out.println("stack size="+obj.size()+"\ttop="+obj.peek().data);
				current=current.left;
			}
			if(!obj.empty()){
			current=obj.pop();
							System.out.print(current.data+"\t");
			// System.out.println("popped emenet="+current.data);
			current=current.right;
			}
			else{
				break;
			}
		}
	}
	public static void levelOrder(Node current){
		Queue<Node> obj=new LinkedList<>();
		int top=-1;
			if(current!=null){
				obj.add(current);
			}
			while(obj.size()!=0){
				if(current.left!=null){
					obj.add(current.left);
				}
				if(current.right!=null){
					obj.add(current.right);
				}
				if(obj.size()==0){
					break;
				}
					Node item=obj.remove();
					System.out.print(item.data+"\t");
			}
	}
	public static Node findMax(Node root){
		Node current=root;
		while(current.right!=null){
			current=current.right;
		}
		return current;
		// System.out.println("Max Element="+current.data);
	}
	public static void findMin(){
		Node current=root;
		while(current.left!=null){
			current=current.left;
		}
		System.out.println("Min Element="+current.data);
	}
	public static void find(int key){
		Node current=root;
		while(current!=null){
			if(current.data==key){
				System.out.println(key+" key found");
				return;
			}
			else if(key<current.data){
				current=current.left;
			}
			else if(key>current.data){
				current=current.right;
			}
		}
		System.out.println(key+" Not Found");
	}
	public static void delete(int key){
		Node current=root;
		Node parent=current;
		Node child=parent;
		if(current.data==key){
			parent=null;
			child=current;
			if(current.left==null && current.right==null){
				System.out.println("Root 0 children");
				current=null;
			}
			else if(current.left==null ||current.right==null){
				System.out.println("Root 1 children");
				if(current.left==null){
					root=current.right;
				}
				else{
					root=current.left;
				}
			}
			else{
				System.out.println("Root 2 children");
				Node mmax=findMax(root.left);
				System.out.println("max in rooot left=="+mmax.data);
				delete(mmax.data);
				mmax.left=root.left;
				mmax.right=root.right;
				root=mmax;
				System.out.println("Root deleted");
				return;
			}
		}
		else{
			while(child.data!=key){
				parent=child;
				if(key<child.data){
					child=child.left;
				}
				else
					child=child.right;
			}
			System.out.println(key+" =key parent="+parent.data);
		}
		if(child.left==null && child.right==null){
			System.out.println("0 children");
			if(parent.left==child){
				parent.left=null;
			}
			if(parent.right==child){
				parent.right=null;
			}
			System.out.println(child.data+" is Deleted");
		}
		else if(child.left==null || child.right==null){
			System.out.println("1 children");
			if(child.left==null){
				if(parent.left==child){
					parent.left=child.right;
				}
				else if(parent.right==child){
					parent.right=child.right;
				}
			}
			else if(child.right==null){
				if(parent.left==child){
					parent.left=child.left;
				}
				else if(parent.right==child){
					parent.right=child.left;
				}
			}
		}
		else{
				System.out.println("2 children");
				 Node max=findMax(child.left);
				 System.out.println("max ="+max.data);
				 delete(max.data);
				 max.left=child.left;
				 max.right=child.right;
				 if(parent.left==child){
				 	parent.left=max;
				 }
				 else if(parent.right==child){
				 	parent.right=max;
				 }
			}
	}
	public static boolean check(Node current){
		if(current==null){
			// System.out.println("true");
			return true;
		}
		else{
				Node llmax=findMax(root.left);
				int lmax=llmax.data;	
				Node rrmax=findMax(root.right);
				int rmax=rrmax.data;	
			if(current.left!=null && current.left.data>current.data ){
				// System.out.println("false");
				System.out.println("no left");
				return false;
			}
			if(current.right!=null && current.right.data<current.data){
				// System.out.println("false");
				System.out.println("no right");
				return false;
			}
			if(lmax>current.data || rmax<current.data ){
				System.out.println(" L R max");
				return false;
			}
			if(!check(current.left) || !check(current.right) ){
				System.out.println("current.data="+current.data);
				System.out.println("Recursion");
				return false;
			}
			return true;
		}
	}
	public static int halfNodeCount(Node current){
		if(current==null){
			return 0;
		}
		else{
			if(current.left==null && current.right==null){
				return 0;
			}
			else if(current.left==null || current.right==null){
				if(current.left!=null){
					System.out.println("half Node="+current.data);
					return 1+halfNodeCount(current.left);
				}
				else{
					System.out.println("half Node="+current.data);
					return 1+halfNodeCount(current.right);
				}
			}
			else{
				return halfNodeCount(current.left)+halfNodeCount(current.right);
			}
		}
	}
	public static int fullNodeCount(Node current){
		if(current==null){
			return 0;
		}
		else{
			if(current.left==null && current.right==null){
				return 0;
			}
			else if(current.left==null || current.right==null){
				if(current.left!=null){
					return fullNodeCount(current.left);
				}
				else{
					return fullNodeCount(current.right);
				}
			}
			else{
				System.out.println("full Node="+current.data);
				return 1+fullNodeCount(current.left)+fullNodeCount(current.right);
			}
		}
	}
	public static int leafNodeCount(Node current){
		if(current==null){
			return 0;
		}
		else{
			if(current.left==null && current.right==null){
				System.out.println("leaf node="+current.data);
				return 1;
			}
			else if(current.left==null || current.right==null){
				if(current.left!=null){
					return leafNodeCount(current.left);
				}
				else{
					return leafNodeCount(current.right);
				}
			}
			else{
				return leafNodeCount(current.left)+leafNodeCount(current.right);
			}
		}
	}
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		// for(int i=0;i<5;i++){
		// 	System.out.println("Enter Item to insert:");
		// 	int n=scan.nextInt();
		// 	insert(n);
		// 	}
			insert(8);insert(3);insert(10);insert(1);insert(5);insert(14);insert(4);insert(7);insert(13);insert(6);insert(18);insert(15);
			System.out.println("Elements are:");
			System.out.println();inOrder(root);
			System.out.println("half Nodes count="+halfNodeCount(root));
			System.out.println("full Nodes count="+fullNodeCount(root));
			System.out.println("leaf Nodes count="+leafNodeCount(root));
			// findMax();findMin();
			/*System.out.println("levelOrder Traversal");
			levelOrder(root);*/
			/*find(6);
			find(7);
			find(13);
			find(12);
			find(10);
			find(1);*/
			// System.out.println("Enter Item to delete:");
			// int nn=scan.nextInt();
			// delete(nn);
			// delete(14);
			// System.out.println("After Deleting");
			// delete(8);
			// delete(7);
			// delete(13);
			// delete(10);
			// delete(18);
			// delete(6);
			// inOrder(root);
			// System.out.println(check(root));
		// }
		//preOrder(root);
	}
}