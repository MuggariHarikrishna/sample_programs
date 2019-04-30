import java.util.*;
public class SumOfNaturalNumbers{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=scan.nextInt();
		int a[]=new int[n+1];
		a[0]=0;
		a[1]=1;
		int i,j,k;
		for(i=2;i<=n;i++){
			a[i]=a[i-1]+i;
		}
		System.out.println("Sum=="+a[n]);
	}
}