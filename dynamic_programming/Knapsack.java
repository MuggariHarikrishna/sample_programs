import java.util.*;
public class Knapsack{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int wt[]=new int[]{2,3,4,5};
        int v[]=new int[]{3,7,2,9};
        int c=5;
        int n=4;
        int i,j,k;
        int a[][]=new int[n+1][c+1];
        for(i=0;i<=n;i++)
        	a[i][0]=0;
        for(i=0;i<=c;i++)
        	a[0][i]=0;
        for(i=1;i<=n;i++){
        	for(j=1;j<=c;j++){
        		if(wt[i-1]<=j){
        			a[i][j]=Math.max(a[i-1][j],v[i-1]+a[i-1][j-wt[i-1]]);
        		}
        		else{
        			a[i][j]=a[i-1][j];
        		}
        	}
        }
        System.out.println("Matrix=");
        for(i=0;i<=n;i++){
        	for(j=0;j<=c;j++){
        		System.out.print(a[i][j]+"\t");
        	}
        	System.out.println();
        }
    }
}