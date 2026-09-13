# 673. Number of Longest Increasing Subsequence

**LeetCode Problem:** [https://leetcode.com/problems/number-of-longest-increasing-subsequence/](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)

**Difficulty:** Medium

---

## Problem Description

Given an integer array `nums`, return the *number of longest increasing subsequences*.

Notice that the sequence has to be **strictly** increasing.

---

## Examples

**Example 1:**

**Input:** `nums = [1,3,5,4,7]`  
**Output:** `2`  
**Explanation:** The two longest increasing subsequences are `[1, 3, 4, 7]` and `[1, 3, 5, 7]`.

---

**Example 2:**

**Input:** `nums = [2,2,2,2,2]`  
**Output:** `5`  
**Explanation:** The length of the longest increasing subsequence is 1, and there are 5 subsequences of length 1, so the output is 5.

---

## Approaches

---

### Approach 1: Optimal — DP + Count Array (Active)

**Idea:**  
To keep track of the number of longest increasing subsequences (LIS), we maintain two 1D arrays:
1. `dp[i]`: the length of the LIS ending at index `i`.
2. `count_arr[i]`: the total number of LIS of length `dp[i]` ending at index `i`.

For each index `i`, we iterate through all previous indices `j` (`0 <= j < i`). If `nums[i] > nums[j]`:
- If `1 + dp[j] > dp[i]`, we found a strictly longer LIS ending at `i`. We update `dp[i] = 1 + dp[j]` and reset its count to `count_arr[i] = count_arr[j]`.
- If `1 + dp[j] == dp[i]`, we found another LIS of the same max length ending at `i`. We add to its count: `count_arr[i] += count_arr[j]`.

Finally, we find the overall maximum LIS length `max` and sum up `count_arr[i]` for all indices `i` where `dp[i] == max`.

**Algorithm:**
1. Initialize `dp` and `count_arr` arrays of size `n` filled with `1`.
2. Set `max = 1`.
3. Loop `i` from `1` to `n-1`:
   - Loop `j` from `0` to `i-1`:
     - If `nums[i] > nums[j]`:
       - If `1 + dp[j] > dp[i]`: set `dp[i] = 1 + dp[j]` and `count_arr[i] = count_arr[j]`.
       - Else if `1 + dp[j] == dp[i]`: set `count_arr[i] += count_arr[j]`.
   - Update `max = Math.max(max, dp[i])`.
4. Sum `count_arr[i]` for all indices `i` where `dp[i] == max`.
5. Return the sum `nos`.

**Complexity:**
- **Time:** O(n²) — Two nested loops of size `n`.
- **Space:** O(n) — Two 1D arrays `dp` and `count_arr` of size `n`.
