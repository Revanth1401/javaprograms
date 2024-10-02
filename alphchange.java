package Revanth;

public class alphchange {
	public static void main(String[] args) {
		String s="abc-XYZ@#$-abcdefg";
		String t="";
		int k=1;
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c>='A' && c<='Z') {
				int r=c-65;
				r=(r+k)%26;
				r=r+65;
				t=t+((char)(r));
			}
			else if(c>='a' && c<='z') {
				int l=c-97;
				l=(l+k)%26;
				l=l+97;
				t=t+((char)(l));
			}
			else {
				t=t+c;
			}
		}
		System.out.println(t);
	}
}
