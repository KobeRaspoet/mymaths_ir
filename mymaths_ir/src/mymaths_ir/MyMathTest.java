package mymaths_ir;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	@Test
	void sqrtTest() {
		int c2 = 21;
		int c = MyMath.sqrt(c2);
		assert c == 4;
		MyMath.sqrt(2);
	}
	@Test
	void binarySearchTest() {
		int[] xs =  {10,20,30,40};
		assertEquals(1, MyMath.binarySearch(xs,15));
		assertEquals(2, MyMath.binarySearch(xs,30));
	}
	@Test
	void InsertionTestCases() {
		int[] xs = {1,6,4,2,10,5,1};
		MyMath.insertionSort(xs);
		assertArrayEquals(xs, new int[] {1,1,2,4,5,6,10});
		int[] test = {0};
		MyMath.insertionSort(test);
		assertArrayEquals( test , new int[] {0});
		int[] test2 = {1,2,3,4,6,7};
		MyMath.insert(test2, 3, 20);
		assertArrayEquals(test2, new int[] {1, 2, 3, 20, 6, 7});
 	}
	
	

}
