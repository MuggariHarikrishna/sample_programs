
public class MergeSort {
	public static void main(String[] args) {
		int arr[]=new int[] {3,4,1,2,8};
		divide(arr,0,arr.length-1);
		for(int i:arr) {System.out.print(i+"\t");}
	}
	public static void divide(int[] a,int low,int high) {
		if(low<high) {
			int mid=(low+high)/2;
			divide(a,low,mid);
			divide(a, mid+1, high);
			merge(a,low,mid,high);
		}
	}
	public static void merge(int a[],int low,int mid,int high) {
		int n1=mid-low+1;
		int n2=high-mid;
		int l[]=new int[n1];
		int r[]=new int[n2];
		int i,j,k;
		for( i=0;i<n1;i++) {
			l[i]=a[i+low];
		}
		for(j=0;j<n2;j++) {
			r[j]=a[j+mid+1];
		}
		k=low;i=0;j=0;
		while(i<n1 && j<n2) {
			if(l[i]<r[j]) {
				a[k]=l[i];i++;k++;
			}
			else{
				a[k]=r[j];j++;k++;
			}
		}
		while(i<n1) {
			a[k]=l[i];i++;k++;
		}
		while(j<n2) {
			a[k]=r[j];j++;k++;
		}
	}
}
