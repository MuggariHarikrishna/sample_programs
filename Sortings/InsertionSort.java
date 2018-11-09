
public class InsertionSort {
	public static void main(String[] args) {
		int arr[]=new int[] {3,4,1,2,8};
		for(int j=1;j<arr.length;j++) {
			int i=j-1;
			int key=arr[j];
			while(i>=0 && arr[i]>key) {
				arr[i+1]=arr[i];
				i--;
			}
			arr[i+1]=key;
		}
		System.out.println("After InsertionSort");
		for(int i:arr) {System.out.print(i+"\t");}
	}
}
