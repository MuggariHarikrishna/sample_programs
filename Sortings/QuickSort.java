
public class QuickSort {
	public static void main(String[] args) {
		int arr[]=new int[] {3,4,1,2,8};
		quick(arr,0,arr.length-1);
		for(int i:arr) {System.out.print(i+"\t");}
	}
	public static void quick(int a[],int low,int high) {
		if(low<high) {
			int mid=divide(a,low,high);
			quick(a,low,mid-1);
			quick(a,mid+1,high);
		}
	}
	public static int divide(int a[],int low,int high) {
		int pivot=a[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			if(a[j]<pivot) {
				i++;
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		int temp=a[i+1];
		a[i+1]=pivot;
		a[high]=temp;
		return i+1;
	}
}
