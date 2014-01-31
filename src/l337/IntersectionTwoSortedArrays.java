package l337;

//http://leetcode.com/2010/03/here-is-phone-screening-question-from.html
//O(m+n)
//if we use binary serach in b-- O(n*lg(m))
public class IntersectionTwoSortedArrays {

  /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {1,3,4,7,8,9,12,99};
		int[] b={0,1,2,4,8,12,90,100};
		int i=0,j=0;
		
		while(i<a.length&&j<b.length){
			
			if(a[i]==b[j]){
			System.out.println(a[i]);
			i++; j++;
		}
			else if(a[i]<b[j]) i++;
			else j++;
		
	}

}
}
