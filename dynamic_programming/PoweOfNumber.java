import java.util.*;
public class PoweOfNumber{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Base:");
		int x=scan.nextInt();
		System.out.println("Enter the Power:");
		int n=scan.nextInt();
		int a[]=new int[n+1];
		a[0]=1;
		a[1]=x;
		int i,j,k;
		for(i=2;i<=n;i++){
			a[i]=a[i-1]*x;
		}
		System.out.println("Power=="+a[n]);
	}
}