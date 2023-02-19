package mymaths_ir;

import java.util.stream.IntStream;

public class MyMath {
	
	/**
	 * Returns the square root (rounded down) of the given nonnegative number.
	 * 
	 * @pre Number is nonnegative.
	 *    | 0 <= x
	 * 
	 * @post result is greatest nonnegative number whose square is not greater than given number.
	 * 	   | 0 <= result && result * result<= x && x < (result+1) * (result+1)
	 */
	 static int sqrt(int x) {
		int r=0;
		while((r+1)*(r+1)<=x)
			r++;
		return r;
	}
	 
	 /**
	  * Return index where given value belongs in the given sorted array (first occurence).
	  * 
	  * @pre `haystack` is not null.
	  *    | haystack != null
	  * @pre `haystack`is sorted.
	  *    | IntStream.range(1,haystack.length).allMatch(i -> haystack[i - 1] <= haystack[i])
	  * @post result is nonnegative
	  * | 0 <= result
	  * @post | result <= haystack.length
	  * @post | IntStream.range(0,result).allMatch(i -> haystack[i] < needle)
	  * @post | IntStream.range(result,haystack.length).allMatch(i -> haystack[i] >= needle)
	  * 
	  */
	 static int binarySearch(int[] haystack, int needle) {
			int lo = 0;
			int hi = haystack.length;
			while(lo<hi) {
				int middle = lo + (hi-lo)/2;
				if (needle<=haystack[middle])
					hi = middle;
				else
					lo = middle + 1;
			}
			return lo;
		}
	 /**
	  * 
	  * @pre | xs!=null
	  * @pre | 0<=n && n<=xs.length
	  * @post | result == IntStream.range(0,n).filter(i -> xs[i] == v).count()
	  */
	 static long count(int[] xs, int n, int v) {
		 return IntStream.range(0,n).filter(i -> xs[i] == v).count();
	 }
	 
	 /**
	  * 
	  * @pre | xs != null
	  * @pre | 0 <= n
	  * @pre | n < xs.length
	  * @pre | IntStream.range(1,n).allMatch(i -> xs[i-1] <= xs[i])
	  * 
	  * @post | IntStream.range(1,n).allMatch(i -> xs[i-1] <= xs[i])
	  * @post | IntStream.range(0,n+1).allMatch(i ->
	  * 	  | 	count(xs, n+1,xs[i]) == count(old(xs.clone()),n,xs[i]) +
	  *       |	    (xs[i] == v ? 1 : 0)
	  *       |)
	  * 
	  */
	 static void insert(int[] xs, int n, int v) {
		 //Implementeer en schrijf een testsuite
		 int index = 0;
		  for (int i=0;i<n;i++){
		    if (xs[i]<=v)
		      index = i+1;
		  }
		  if (index==n)
			  xs[n] = v;
		  else {
		  for (int x=n;x>index;x--) {
		    xs[x] = xs[x-1];
		  }
		  xs[index] = v;
		  }
		  
	 }
	 
	 /**
	  * TODO: Documenteer informeel en formeel
	  * @pre `xs` is not null
	  * | xs != null
	  * 
	  * 
	  * @post All numbers in `xs` are sorted after the algorithm.
	  * | IntStream.range(1,xs.length).allMatch(i -> xs[i - 1] <= xs[i])
	  * @post The frequency of numbers in `xs` is the same as before the algorithm.
	  * | IntStream.range(0,xs.length).allMatch(i ->
	  * 	  | 	count(xs, xs.length,xs[i]) == count(old(xs.clone()),xs.length,xs[i])   
	  *       |)
	  */
	 static void insertionSort(int[] xs) {
		 //Implementeer en schrijf testuite
		 for (int key=1;key<xs.length;key++)
			    insert(xs,key,xs[key]);
	 }
	 
	 
	 /**
	  * Two sorted arrays get combined into one sorted array.
	  * @pre |array1 != null
	  * @pre |array2 != null
	  *
	  */
	 static int[] merge(int[] array1, int[] array2) {
		 int i = 0;
		 int j= 0;
		 int k = 0;
		 int size = array1.length + array2.length;
		 int[] merged = new int[size];
		 while (i<array1.length && j < array2.length) {
			 if (array1[i]<array2[j]) {
				 merged[k] = array1[i];
				 i++;
			 }
			 else {
				 merged[k] = array2[j];
				 j++;
			 }
			 k++;
		 }
		 if (i<array1.length) {
			 for (int p=i;p<array1.length;p++) {
				 merged[k] = array1[p];
				 k++;
			 }
		 }
		 else {
			 for (int p=j;p<array2.length;p++) {
				 merged[k] = array2[p];
				 k++;
			 }
		 }
		 return merged;
	}
	 /**
	  * returns subarray of array from indices a (inclusive) till b (exclusive).
	  */
	static int[] subarray(int[] xs,int a,int b) {
		int size = b-a;
		int[] sub = new int[size];
		for (int i=0;i<size;i++) {
			sub[i] = xs[a+i]; 
		}
		return sub;
	}
	 
	static int[] mergeSort(int[] array) {
		if (array.length > 1) {
			int[] left = mergeSort(subarray(array,0,array.length/2));
			int[] right = mergeSort(subarray(array,array.length/2,array.length));
			return merge(left, right);
		}
		else
			return array;
	}
	
	static void printMessage(String word) {
		System.out.print(word);
	}
	

}