import java.util.*;
public class Combinations{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=scan.nextInt();
		System.out.println("Enter r:");
		int r=scan.nextInt();
		int a[][]=new int[n][r+1];
		int i,j,k;
		for(i=0;i<n;i++){
			a[i][0]=1;
		}
		for(i=0;i<r;i++){
			a[0][i]=1;
		}
		for(i=1;i<n;i++){
			for(j=1;j<=r;j++){
				a[i][j]=a[i-1][j-1]+a[i-1][j];
			}
		}
		System.out.println("After Matrix");
		for(i=0;i<n;i++){
			for(j=0;j<=r;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
}