import java.util.*;
public class TowerOfHonoi{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter no of disks:");
		int n=scan.nextInt();
		String s="S";
		String d="D";
		String e="E";
		Tower(s,d,e,n);
	}
	public static void Tower(String s,String d,String e,int n){
		if(n>0){
			Tower(s,e,d,n-1);
			System.out.println("Move "+n+" th disk from "+s+" to "+d);
			Tower(e,d,s,n-1);
		}
	}
}