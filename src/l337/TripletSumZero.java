package l337;

//http://leetcode.com/2010/04/finding-all-unique-triplets-that-sums.html
//can replace 0 to wanted sum
import java.util.HashSet;
public class TripletSumZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={-2,-1,-1,0,1,2,3,4,6};
		
		String s=null;
		HashSet<String> S = new HashSet<String>();
		
		for(int i=0;i<arr.length;i++){
			
			int j=i+1,k=arr.length-1;
			
			while(j<k){
				
				if(arr[i]+arr[j]+arr[k]==0){
					
					s=arr[i]+"  "+arr[j]+"  "+arr[k];
					if(S.add(s))  System.out.println(s);
					
					j++;
					k--;
				}
				else if(arr[i]+arr[j]+arr[k]>0){
					k--;
				}
				else j++;
				
				
			}
			
			
			
		}
		
	}

}
