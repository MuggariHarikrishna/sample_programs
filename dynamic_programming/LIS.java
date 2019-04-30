import java.util.*;
public class LIS{
	 public static void main(String[] args) {
	 	Scanner scan=new Scanner(System.in);
	 	int n=scan.nextInt();
	 	int i,j,k;
	 	int a[]=new int[n];
	 	int x[]=new int[n];
	 	for(i=0;i<n;i++){
	 		x[i]=1;
	 	}
	 	for (i=0;i<n ;i++ ) {
	 		a[i]=scan.nextInt();
	 	}
	 	for(i=1;i<n;i++){
	 		int temp=a[i];
	 		for(j=i-1;j>=0 ;j--){
	 			if(a[j]<temp && x[j]>=x[i]){
	 				x[i]=x[j]+1;
	 			}
	 		}
	 	}
	 	System.out.println("Array After");
	 	for(i=0;i<n;i++)
	 		System.out.print(x[i]+"\t");
	 	System.out.println();
	 }
}