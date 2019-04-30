import java.util.*;
public class GridNumberOfWays{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Row:");
		int r=scan.nextInt();
		System.out.println("Enter the Column:");
		int c=scan.nextInt();
		int b[][]=new int[r][c];
		int i,j,k;
		for(i=0;i<r;i++){
			b[i][0]=1;
		}
		for(i=0;i<c;i++){
			b[0][i]=1;
		}
		for(i=1;i<r;i++){
			for(j=1;j<c;j++){
				b[i][j]=b[i-1][j]+b[i][j-1];
			}
		}
		System.out.println("After Matrix:");
		for(i=r-1;i>=0;i--){
			for(j=0;j<c;j++){
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
	}
}