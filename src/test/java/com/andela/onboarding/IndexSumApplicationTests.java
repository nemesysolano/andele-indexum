package com.andela.onboarding;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 Example 1: <br/>
   Input: nums = [2,7,11,15], target = 9 <br/>
   Output: [0,1] <br/>
Example 2: <br/>
   Input: nums = [3,2,4], target = 6 <br/>
   Output: [1,2] <br/>
Example 3: <br/>
   Input: nums = [3,3], target = 6 <br/>
   Output: [0,1] <br/>
Example 4:
   Input: nums = [3,2], target = 9 <br/>
   Output: [] <br/>
 */
class IndexSumApplicationTests {
	private static Logger LOG = LoggerFactory.getLogger(IndexSumApplicationTests.class);

	void test(List<Integer> expected, List<Integer> input, Integer target, Integer testNumber) {
		List<Integer> actual = IndexSumApplication.indexes(target, input);

		assertEquals(expected, actual);
		LOG.debug(String.format("test %d with %s and %s passed because %s == %s", testNumber, target, input, expected, actual));

	}
	
	@Test
	void test1() { // Happy Path
		List<Integer> expected = List.of(0, 1);
		List<Integer> input = List.of(2,7,11,15);
		Integer target = 9;

		test(expected, input, target, 1);
	}

	@Test
	void test2() { // Happy Path
		List<Integer> expected = List.of(1,2);
		List<Integer> input = List.of(3,2,4);
		Integer target = 6;

		test(expected, input, target, 2);
	}

	@Test
	void test3() { // Happy Path
		List<Integer> expected = List.of(0,1);
		List<Integer> input = List.of(3,3);
		Integer target = 6;

		test(expected, input, target, 3);
	}

	@Test
	void test4() { // Happy Path
		List<Integer> expected = List.of();
		List<Integer> input = List.of(3,2);
		Integer target = 9;

		test(expected, input, target, 4);
	}	

	
	@Test
	void testCounter() { // Happy Path
		List<List<Integer>> expected = List.of(List.of(0, 1), List.of(1, 2));
		List<Integer> input = List.of(2,7,11,15);
		List<Integer> target = List.of(9, 18);
		Iterator<List<Integer>> expectedIterator = expected.iterator();
		Iterator<Integer> targetIterator = target.iterator();
		int testNumber = 5;

		while(targetIterator.hasNext()) {
			test(expectedIterator.next(), input, targetIterator.next(), testNumber++);
		}
	}
}

