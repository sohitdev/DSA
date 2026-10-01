# 15. 3Sum

**LeetCode Problem:** [15. 3Sum](https://leetcode.com/problems/3sum/)

**Difficulty:** Medium

---

## Problem Description

Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

---

## Examples

**Example 1:**

**Input:** `nums = [-1,0,1,2,-1,-4]`
**Output:** `[[-1,-1,2],[-1,0,1]]`
**Explanation:** 
`nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0`.
`nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0`.
`nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0`.
The distinct triplets are `[-1,0,1]` and `[-1,-1,2]`.

**Example 2:**

**Input:** `nums = [0,1,1]`
**Output:** `[]`
**Explanation:** The only possible triplet does not sum up to 0.

**Example 3:**

**Input:** `nums = [0,0,0]`
**Output:** `[[0,0,0]]`
**Explanation:** The only possible triplet sums up to 0.

---

## Approaches

---

### Approach: Optimal — Two Pointers (Active)

**Idea:**
To avoid duplicates easily and use two pointers, we first **sort** the array. Then, we iterate through the array, fixing the first element `nums[i]`. For the remaining part of the array to its right, we use two pointers `j` (starting from `i+1`) and `k` (starting from `n-1`) to find pairs that sum up to `-nums[i]`. We also need to skip duplicate elements to ensure we don't include duplicate triplets in our result.

**Algorithm:**
1. Sort the array.
2. Loop through the array from `i = 0` to `n-1`:
   - If `i > 0` and `nums[i] == nums[i-1]`, `continue` (skip duplicates for the first element).
   - Set two pointers: `j = i + 1` and `k = n - 1`.
   - While `j < k`:
     - Calculate `sum = nums[i] + nums[j] + nums[k]`.
     - If `sum < 0`, we need a larger value, so `j++`.
     - If `sum > 0`, we need a smaller value, so `k--`.
     - If `sum == 0`, we found a triplet! Add it to the answer.
       - Increment `j` and decrement `k`.
       - Skip duplicates for the second element: `while (j < k && nums[j] == nums[j-1]) j++;`
       - Skip duplicates for the third element: `while (j < k && nums[k] == nums[k+1]) k--;`
3. Return the list of triplets.

**Complexity:**
- **Time:** O(N^2) — Sorting takes O(N log N). The outer loop runs N times, and the inner two-pointer loop takes O(N) time for each iteration. Overall time is O(N log N + N^2) = O(N^2).
- **Space:** O(1) or O(N) depending on the sorting algorithm implementation.
