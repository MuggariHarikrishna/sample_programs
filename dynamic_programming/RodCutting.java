import java.util.*;
public class RodCutting{
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		// int l[]=new int[n];
		int p[]=new int[n];
		System.out.println("Enter Profit:");
		int i,j,k;
		for(i=0;i<n;i++)
			p[i]=scan.nextInt();
		int max[]=new int[n+1];
		max[0]=0;
		for(i=1;i<=n;i++){
			max[i]=-1;
			for(j=0;j<i;j++){
				max[i]=Math.max(max[i],p[j]+max[i-j-1]);
			}
		}
		for(i=0;i<=n;i++)
		System.out.println("max profit="+max[i]);
	}
}