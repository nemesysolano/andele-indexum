package com.andela.onboarding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.*;
import java.util.stream.Collectors;

/**
<p>
Given an array of integers nums and an integer target, returns indices of the two numbers
such that they add up to target.
</p>

<p>
You may assume that each input would have exactly one solution, and you may not use the
same element twice.
</p>

<p>
You can return the answer in any order:
</p>

<p>
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
</p>
*/
public class IndexSumApplication implements CommandLineRunner {
    private static Logger LOG = LoggerFactory.getLogger(IndexSumApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(IndexSumApplication.class, args);
	}

	/**
	 * CLI Interface.	 * 
	 */
	@Override
    public void run(String... args) { 
		/* Converts args to a list of integers */
		List<Integer> list = Arrays
			.asList(args).
			stream()
			.map(arg -> Integer.parseInt(arg)).collect(Collectors.toList());
		Integer target = list.remove(0);

		indexes(target, list);
    }

	/**
	 * @param target Target element
	 * @param input List of integers to be analyzed
	 * @return The two indexes of the two elements whose sum is equals to target.
	 */
	public static List<Integer> indexes(Integer target, List<Integer> input) {
		Integer array[] = input.toArray( new Integer[0]); // the remaining argument are the number whose sums we will compare to target.
		
		/**
		 * Simplistic O(N²) search
		 */
		for(int index0 = 0; index0 < array.length -1; index0++) {
			for(int index1 = index0+1; index1 < array.length; index1++) {
				if(array[index0] + array[index1] == target) {
					return List.of(index0, index1);
				}
			}
		}

		return List.of();
	}
}
