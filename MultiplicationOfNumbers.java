//http://leetcode.com/2010/04/multiplication-of-numbers.html
public class MultiplicationOfNumbers {

  /**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a={1,2,3,4};
		int[] b= new int[a.length];

		b=multiply(a,b,a.length);
		for(int i:b) System.out.println(i);
	}

	private static int[] multiply(int[] a,int[] b,int n) {
		int left=1,right=1;
		for(int i=0;i<n;i++) b[i] =1;
		for(int i=0;i<n;i++){
			b[i]*=left;
			b[n-i-1]*=right;
			left*=a[i];
			right*=a[n-i-1];

		}


		return b;
	}

}
