package l337;

import java.util.Arrays;
import java.util.HashMap;

public class temp{
	
	public static void main(String[] arg){
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(0,"zero");
		map.put(1,"one");
		map.put(2,"two");
		map.put(3,"three");
		map.put(4,"four");
		map.put(5,"five");
		map.put(6,"six");
		map.put(7,"seven");
		map.put(8,"eight");
		map.put(9,"nine");
		
		int[] input ={1,2,44,66,7895,88983};
		String[] stringArray = new String[input.length];
		
		for(int i=0;i<input.length;i++){
			
			stringArray[i] = map.get(input[i]);
			if(stringArray[i]==null){
				char[] temp= (new Integer(input[i])).toString().toCharArray();
				for(int j=0;j<temp.length;j++){
					stringArray[i]+=map.get((int)temp[j]-48);
				}
			}
		}
		HashMap<String,Integer> maploc = new HashMap<String,Integer>();
		map.put(0,"zero");
		for(int i=0;i<input.length;i++){
			maploc.put(stringArray[i], input[i]);
		}
		
		Arrays.sort(stringArray);
		
		int[] output =new int[input.length];
		for(int i=0;i<input.length;i++){
			output[i]= maploc.get(stringArray[i]);
		}
         for(int i:input){
			
			System.out.print(i+" ");
		}
         System.out.println();
		for(int i:output){
			
			System.out.print(i+" ");
		}
			
		}
		
		
}
