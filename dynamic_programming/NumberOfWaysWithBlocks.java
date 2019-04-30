import java.util.*;
public class NumberOfWaysWithBlocks{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Row:");
		int r=scan.nextInt();
		System.out.println("Enter the Column:");
		int c=scan.nextInt();
		int n=scan.nextInt();
		int b[][]=new int[r][c];
		int i,j,k;
		while(n-->0){
			i=scan.nextInt();
			j=scan.nextInt();
			b[i][j]=-1;
		}
		for(i=0;i<r;i++){
			if(b[i][0]!=-1)
				b[i][0]=1;
			else
				break;
		}
		for(i=0;i<c;i++){
			if(b[0][i]!=-1)
				b[0][i]=1;
			else
				break;
		}
		for(i=1;i<r;i++){
			for(j=1;j<c;j++){
				if(b[i][j]!=-1 || b[i-1][j]!=-1 || b[i][j-1]!=-1){
					if(b[i][j]==-1){
						b[i][j]=-1;
					}
					else if(b[i-1][j]==-1 && b[i][j-1]==-1){
						b[i][j]=0;
					}
					else if(b[i-1][j]==-1 && b[i][j-1]!=-1){
						b[i][j]=b[i][j-1];
					}
					else{
						b[i][j]=b[i-1][j];
					}
				}
				if(b[i][j]!=-1 && b[i-1][j]!=-1 && b[i][j-1]!=-1){
					b[i][j]=b[i-1][j]+b[i][j-1];
				}
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