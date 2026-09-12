# Printing Longest Increasing Subsequence

**GFG Problem:** [https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1](https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1)

**Difficulty:** Medium

---

## Problem Description

Given an integer array `arr[]`, return the **longest strictly increasing subsequence** as an array list of integers. If there are multiple valid subsequences of the maximum length, return any one of them.

---

## Examples

**Example 1:**

**Input:** `arr[] = [10, 9, 2, 5, 3, 7, 101, 18]`  
**Output:** `[2, 3, 7, 101]`  
**Explanation:** The longest increasing subsequence is `[2, 3, 7, 101]` with length 4.

---

**Example 2:**

**Input:** `arr[] = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]`  
**Output:** `[0, 2, 6, 9, 11, 15]`  
**Explanation:** One valid longest increasing subsequence is `[0, 2, 6, 9, 11, 15]`.

---

## Approaches

---

### Approach 1: Optimal — Tabulation DP with Backtracking Hash Array (Active)

**Idea:**  
In addition to computing the dynamic programming table `dp[i]` (where `dp[i]` stores the length of LIS ending at index `i`), maintain a `hash[i]` array. `hash[i]` stores the index of the previous element in the LIS that precedes `arr[i]`. Track `last_idx`, the index where the maximum LIS ends. After filling `dp` and `hash`, backtrack from `last_idx` using `hash[last_idx]` to reconstruct the LIS in reverse, and finally reverse the list.

**Algorithm:**
1. Initialize `dp` array of size `n` with all elements set to `1`.
2. Initialize `hash` array of size `n` where `hash[i] = i` for all `i`.
3. Track `max = 1` and `last_idx = 0`.
4. Loop `idx` from `0` to `n-1`:
   - Loop `prev` from `0` to `idx-1`:
     - If `arr[idx] > arr[prev]` and `1 + dp[prev] > dp[idx]`:
       - Update `dp[idx] = 1 + dp[prev]`.
       - Set `hash[idx] = prev`.
   - If `dp[idx] > max`, update `max = dp[idx]` and `last_idx = idx`.
5. Backtrack through `hash`: start from `last_idx`, append `arr[last_idx]` to result list, and update `last_idx = hash[last_idx]` until `hash[last_idx] == last_idx`.
6. Append the last remaining element `arr[last_idx]`, reverse the list using `Collections.reverse()`, and return it.

**Complexity:**
- **Time:** O(n²) — Two nested loops for computing DP and parent pointers + O(n) for backtracking.
- **Space:** O(n) — `dp` array, `hash` array, and output list.
