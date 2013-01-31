//http://leetcode.com/2010/04/rotating-array-in-place.html
public class RotateArrayInPlace {

  /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 2, 3, 4, 5, 6,7, 8 };
		int[] arr1 = { 2, 3, 6, 9, 10, 11, 12, 23 };

		print(rotateArray(arr,3));
		print(rotateArray(arr1,5));



	}

	private static void print(int[] a) {
		// TODO Auto-generated method stub
		for(int i:a) System.out.print(i+" ");
		System.out.println(" ");
	}

	private static int[] rotateArray(int[] a, int k) {
		// TODO Auto-generated method stub
		reverse(a,0,a.length-1);
		reverse(a,0,k-1);
		reverse(a,k,a.length-1);



		return a;
	}

	private static void reverse(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		while(i<j){

			a[i]=a[i]+a[j];
			a[j]=a[i]-a[j];
			a[i]=a[i]-a[j];

			i++; j--;
		}
	}

}
