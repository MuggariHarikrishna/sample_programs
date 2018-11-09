
public class SelectionSort {
	public static void main(String[] args) {
		int arr[]=new int[] {3,4,1,2,8};
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			int index=i;
			for(int j=i+1;j<n;j++) {
				if(arr[index]>arr[j]) {
					index=j;
				}
			}
			if(i!=index) {
				int temp=arr[index];;
				arr[index]=arr[i];
				arr[i]=temp;
			}
		}
		System.out.println("After SelectionSort");
		for(int i:arr) {System.out.print(i+"\t");}
	}
}
