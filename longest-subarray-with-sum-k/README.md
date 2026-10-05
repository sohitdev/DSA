# Longest Subarray with sum K

**Platform Problem:** [Longest Sub-Array with Sum K](https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1)

**Difficulty:** Medium

---

## Problem Description

Given an array containing `N` integers and an integer `K`, your task is to find the length of the longest subarray with the sum of the elements equal to the given value `K`.

---

## Examples

**Example 1:**

**Input:** `arr[] = [10, 5, 2, 7, 1, 9], k = 15`
**Output:** `4`
**Explanation:** The sub-array is `[5, 2, 7, 1]` with sum 15 and length 4.

**Example 2:**

**Input:** `arr[] = [-1, 2, 3], k = 6`
**Output:** `0`
**Explanation:** There is no such sub-array with sum 6.

---

## Approaches

---

### Approach 1: Brute Force

**Idea:**
Check the sum of every possible subarray. We can do this by fixing the starting index `i` of the subarray and then varying the ending index `j`.

**Complexity:**
- **Time:** O(N^2) — We use two nested loops to check all possible subarrays.
- **Space:** O(1) — No extra space is used.

---

### Approach 2: Optimal (Prefix Sum with HashMap) (Active)

**Idea:**
We can optimize the search by using a running `prefixSum`. As we iterate through the array, we keep track of the cumulative sum of elements.
If the cumulative sum equals `K`, it means the subarray from index `0` to `i` has sum `K`.
For other subarrays, we check if `(prefixSum - K)` exists in a HashMap. If it does, it implies there's a subarray ending at the current index `i` and starting just after the index where `prefixSum - K` was seen.
We only insert the `prefixSum` into the map if it doesn't already exist. This ensures we preserve the earliest occurrence of a prefix sum, which allows us to maximize the length of the resulting subarray.

**Algorithm:**
1. Initialize a `HashMap` to store `(prefixSum, index)`.
2. Initialize `prefixSum = 0` and `maxLen = 0`.
3. Iterate through the array:
   - Add the current element to `prefixSum`.
   - If `prefixSum == k`, update `maxLen = i + 1`.
   - Calculate `rem = prefixSum - k`.
   - If `rem` exists in the map, a valid subarray is found. Calculate its length as `i - map.get(rem)` and update `maxLen` if it's strictly greater.
   - If `prefixSum` is not already in the map, insert it.
4. Return `maxLen`.

**Complexity:**
- **Time:** O(N) — We traverse the array exactly once. Assuming hash map operations are O(1) on average. (If collisions are many, it could go up to O(N log N) or O(N^2)).
- **Space:** O(N) — We store at most N prefix sums in the HashMap.
