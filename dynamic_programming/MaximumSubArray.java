import java.util.*;
public class MaximumSubArray{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=scan.nextInt();
		int a[]=new int[n];
		int i,j;
		for(i=0;i<n;i++){
			a[i]=scan.nextInt();
		}
		int sum_so_for=0;
		int max_sum=0;
		int start=0,end=0;
		for(i=0;i<n;i++){
			sum_so_for=sum_so_for+a[i];
			if(sum_so_for<0){
				sum_so_for=0;
				if(i+1<n)
				start=i+1;
			}
			if(sum_so_for>max_sum){
				max_sum=sum_so_for;
				end=i;
			}
		}
		System.out.println("max_sum="+max_sum);
		System.out.println("Start="+start);
		System.out.println("End="+end);
	}
}