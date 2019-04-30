import java.util.*;
public class EditDistance{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the String 1:");
		String a=scan.next();
		System.out.println("Enter the String 2:");
		String b=scan.next();
		int r=a.length();
		int c=b.length();
		int x[][]=new int[r+1][c+1];
		int i,j,k;
		for(i=0;i<=r;i++){
			x[i][0]=i;
		}
		for(i=0;i<=c;i++){
			x[0][i]=i;
		}
		for(i=1;i<=r;i++){
			for(j=1;j<=c;j++){
				if(a.charAt(i-1)==b.charAt(j-1)){
					x[i][j]=x[i-1][j-1];
				}
				else{
					x[i][j]=Math.min(x[i-1][j-1],Math.min(x[i-1][j],x[i][j-1]))+1;
				}
			}
		}
		System.out.println("After Matrix=");
		for(i=0;i<=r;i++){
			for(j=0;j<=c;j++){
				System.out.print(x[i][j]+"\t");
			}
			System.out.println();
		}
	}
}