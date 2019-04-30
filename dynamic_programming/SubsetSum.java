import java.util.*;
public class SubsetSum{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of elements:");
		int n=scan.nextInt();
		int a[]=new int[n];
		System.out.println("Enter elements:");
		int i,j,k,temp;
		for(i=0;i<n;i++)
			a[i]=scan.nextInt();
		System.out.println("Enter sum:");
		int s=scan.nextInt();
		int x[][]=new int[n][s+1];
		for(i=1;i<n;i++){
			x[i][0]=1;
		}
		for(i=0;i<=s;i++){
			x[0][i]=0;
		}
		System.out.println("BEfore Matrix:");
		for(i=0;i<n;i++){
			for(j=0;j<=s;j++){
				System.out.print(x[i][j]+"\t");
			}
			System.out.println();
		}
		for(i=1;i<n;i++){
			for(j=1;j<=s;j++){
				x[i][j]=x[i-1][j];
				
			}
		}
	}
}