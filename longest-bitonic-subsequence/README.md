# Longest Bitonic Subsequence

**GFG Problem:** [https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1](https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1)

**Difficulty:** Medium

---

## Problem Description

Given an array `nums[]` of positive integers, return the length of the **longest bitonic subsequence**.

A subsequence of `nums[]` is called **bitonic** if it is first strictly increasing and then strictly decreasing. 

---

## Examples

**Example 1:**

**Input:** `n = 5`, `nums[] = [1, 2, 5, 3, 2]`  
**Output:** `5`  
**Explanation:** The sequence `[1, 2, 5, 3, 2]` is bitonic.

---

**Example 2:**

**Input:** `n = 8`, `nums[] = [1, 11, 2, 10, 4, 5, 2, 1]`  
**Output:** `6`  
**Explanation:** The longest bitonic subsequence is `[1, 2, 4, 5, 2, 1]` of length 6.

---

## Approaches

---

### Approach 1: Optimal — DP (LIS Left + LIS Right) (Active)

**Idea:**  
A bitonic subsequence centered at peak element `nums[i]` consists of an increasing subsequence of elements to its left and a decreasing subsequence to its right. 
- Compute `dp1[i]`: the length of the Longest Increasing Subsequence ending at index `i` (sweeping left to right).
- Compute `dp2[i]`: the length of the Longest Increasing Subsequence starting at index `i` (sweeping right to left).
- For every peak candidate `i` where both increasing (`dp1[i] > 1`) and decreasing (`dp2[i] > 1`) phases exist, the combined length is `dp1[i] + dp2[i] - 1` (subtracting 1 since `nums[i]` is counted twice).

**Algorithm:**
1. Create `dp1` array of size `n` initialized to `1`.
2. Compute `dp1`: Loop `i` from `1` to `n-1`, loop `prev` from `0` to `i-1`: if `nums[i] > nums[prev]`, `dp1[i] = max(dp1[i], 1 + dp1[prev])`.
3. Create `dp2` array of size `n` initialized to `1`.
4. Compute `dp2`: Loop `i` from `n-2` down to `0`, loop `prev` from `n-1` down to `i+1`: if `nums[i] > nums[prev]`, `dp2[i] = max(dp2[i], 1 + dp2[prev])`.
5. Loop `i` from `0` to `n-1`: if `dp1[i] > 1 && dp2[i] > 1`, update `max = max(max, dp1[i] + dp2[i] - 1)`.
6. Return `max`.

**Complexity:**
- **Time:** O(n²) — Two $O(n^2)$ passes to compute `dp1` and `dp2`.
- **Space:** O(n) — Two 1D arrays `dp1` and `dp2` of size `n`.
