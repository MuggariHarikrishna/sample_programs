import java.util.*;
public class Tiles{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=scan.nextInt();
		int a[]=new int[n+1];
		a[1]=1;
		a[2]=2;
		for(int i=3;i<=n;i++){
			a[i]=a[i-1]+a[i-2];
		}
		System.out.println("Total="+a[n]);
	}
}