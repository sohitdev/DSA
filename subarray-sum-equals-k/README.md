# 560. Subarray Sum Equals K

**LeetCode Problem:** [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

**Difficulty:** Medium

---

## Problem Description

Given an array of integers `nums` and an integer `k`, return the total number of continuous subarrays whose sum equals to `k`.

---

## Examples

**Example 1:**

**Input:** `nums = [1,1,1], k = 2`
**Output:** `2`

**Example 2:**

**Input:** `nums = [1,2,3], k = 3`
**Output:** `2`

---

## Approaches

---

### Approach 1: Brute Force

**Idea:**
We can find all possible continuous subarrays and compute their sum. For every starting index `i`, we iterate through all possible ending indices `j` (`j >= i`) and keep a running sum. If the running sum is equal to `k`, we increment our count.

**Complexity:**
- **Time:** O(N^2) — Two nested loops iterate over the array to check all subarrays.
- **Space:** O(1) — No extra space is required.

---

### Approach 2: Optimal (Prefix Sum with HashMap) (Active)

**Idea:**
To optimize the solution to O(N), we can use the concept of prefix sums. As we traverse the array, we calculate the cumulative sum (prefix sum). 
If the cumulative sum equals `k`, we have found a valid subarray starting from index 0. 
Furthermore, if `(current_sum - k)` exists as a previous prefix sum, it means there are continuous subarrays ending at the current index that sum to `k`. The number of such valid subarrays is equal to the frequency of `(current_sum - k)` seen so far, which we store in a HashMap.

**Algorithm:**
1. Initialize a `HashMap` to store the frequency of each prefix sum: `<PrefixSum, Frequency>`.
2. Initialize `sum = 0` (current prefix sum) and `count = 0` (total valid subarrays).
3. Loop through the array:
   - Add `nums[i]` to `sum`.
   - If `sum == k`, increment `count` by 1.
   - Calculate the remaining sum we need: `rem = sum - k`.
   - If `rem` exists in the map, add its frequency to `count`.
   - Insert the current `sum` into the map or update its frequency.
4. Return the `count`.

**Complexity:**
- **Time:** O(N) — We traverse the array exactly once and perform O(1) operations for HashMap lookup/insertion.
- **Space:** O(N) — We store the prefix sums and their frequencies in a HashMap, which takes O(N) space in the worst case.
