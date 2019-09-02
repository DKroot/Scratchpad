using System;
using System.Collections.Generic;

namespace LeetCodeOJ
{
    public class TwoSumSolution
    {
        /// <summary>
        /// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
        /// You may assume that each input would have exactly one solution, and you may not use the same element twice.
        /// </summary>
        /// <param name="nums"></param>
        /// <param name="target"></param>
        /// <returns></returns>
        public int[] TwoSum(int[] nums, int target)
        {
            var lookup = new Dictionary<int, int>();
            for (var index = 0; index < nums.Length; index++)
            {
                var y = nums[index];
                try
                {
                    var xIndex = lookup[target - y];
                    return new[] {xIndex, index};
                }
                catch (KeyNotFoundException)
                {
                    lookup[y] = index;
                }
            }
            throw new ArgumentException("No solution has been found.");
        }
    }
}