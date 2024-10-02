package Revanth;
import java.util.*;
public class alphachange {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();    //s="ABCD-XYZ-abcd-xyz972&-865";
		String t="";
		int k=sc.nextInt();       //k=1;
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c>='A' && c<='Z') {
				int r=c-65;
				r=(r+k)%26;
				r=r+65;
				t=t+(char)(r);
			}
			else if(c>='a' && c<='z') {
				int r=c-97;
				r=(r+k)%26;
				r=r+97;
				t=t+(char)(r);
			}
			else {
				t=t+c;
			}
		}
		System.out.println(t);
	}
}
