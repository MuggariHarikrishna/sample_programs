import java.util.*;
public class LCS{
	 public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter String 1:");
		String a=scan.next();
		System.out.println("Enter String 2:");
		String b=scan.next();
		int r=a.length();
		int c=b.length();
		int x[][]=new int[r+1][c+1];
		int i,j,k;
		String res="";
		for(i=0;i<=r;i++)
			x[i][0]=0;
		for(i=0;i<=c;i++)
			x[0][i]=0;
		for(i=1;i<=r;i++){
			for(j=1;j<=c;j++){
				if(a.charAt(i-1)==b.charAt(j-1)){
					x[i][j]=x[i-1][j-1]+1;
					res=res+a.charAt(i-1);
				}
				else{
					x[i][j]=Math.max(x[i-1][j],x[i][j-1]);
				}
			}
		}
		System.out.println("After Matrix:");
		for(i=0;i<=r;i++){
			for(j=0;j<=c;j++){
				System.out.print(x[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("String=="+res);
		i=r;j=c;
		while(i>0 && j>0){
			if(a.charAt(i-1)==b.charAt(j-1)){
				i--;j--;
				System.out.println(a.charAt(i));
			}
			else if(x[i-1][j]>x[i][j-1]){
				i--;
			}
			else{
				j--;
			}
		}
	}
}