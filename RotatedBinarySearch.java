//http://leetcode.com/2010/04/searching-element-in-rotated-array.html

public class RotatedBinarySearch {

  /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 5, 6, 7, 0, 1, 2, 3, 4 };
		int[] arr1 = { 4, 5, 6, 7, 0, 1, 2, 3 };

		int x = rotatedBinarySearch(arr, 0, 6);
		if (x != -1)
			System.out.println(x);
		int y = rotatedBinarySearch(arr1, 0, 6);
		if (y != -1)
			System.out.println(y);
		int z = findPivot(arr);
		System.out.println(z);
		int k = findPivot(arr1);
		System.out.println(k);

	}

	public static int rotatedBinarySearch(int[] a, int i, int k) {

		int j = a.length - 1;

		while (i <= j) {
			int m = (i + j) / 2;

			if (a[m] == k)
				return m;

			if (a[i] <= a[m]) {

				if (k < a[m] && k >= a[i]) {
					j = m - 1;
				} else
					i = m + 1;

			} else if (k > a[m] && k <= a[j]) {
				i = m + 1;
			} else
				j = m - 1;

		}

		return -1;

	}

	public static int findPivot(int[] a) {

		int j = a.length - 1, i = 0;
		while (a[i] > a[j]) {

			int m = (i + j) / 2;

			if (a[m] > a[j]) {
				i = m + 1;
			} else
				j = m;

		}
		return i;

	}
}
