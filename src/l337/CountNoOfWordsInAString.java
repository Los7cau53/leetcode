package l337;
//http://leetcode.com/2010/02/c-code-to-count-number-of-words-in.html
public class CountNoOfWordsInAString{
	
	public static void main(String[] arg){
		
		String abc="Hello,Android seeee when 11,in texas";
		char[] arr= abc.toCharArray();
		/*char a='H';
		System.out.println(Character.isLetterOrDigit(a));*/
		int count=1;
		boolean inword=false;
		for(int i=0;i<arr.length;i++){
			if(Character.isLetterOrDigit(arr[i])){
				inword=true;
			}
			else {
				if(inword){
					count++;
					inword=false;
					
				}
			}
			
			
		}
		System.out.println(count);
		
	}
}