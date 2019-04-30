import java.util.*;
public class MinCostPath{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Row:");
		int r=scan.nextInt();
		System.out.println("Enter the Column:");
		int c=scan.nextInt();
		int a[][]=new int[r][c];
		int b[][]=new int[r][c];
		System.out.println("Enter Matrix:");
		int i,j,k;
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				a[i][j]=scan.nextInt();
			}
		}
		System.out.println("Before Matrix:");
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		 b[0][0]=a[0][0];
		for(i=1;i<r;i++){
			b[i][0]=b[i-1][0]+a[i][0];
		}
		for(i=1;i<c;i++){
			b[0][i]=b[0][i-1]+a[0][i];
		}
		for(i=1;i<r;i++){
			for(j=1;j<c;j++){
				b[i][j]=Math.min(b[i-1][j],b[i][j-1])+a[i][j];
			}
		}
		System.out.println("After Matrix:");
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
	}
}