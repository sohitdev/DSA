# 368. Largest Divisible Subset

**LeetCode Problem:** [https://leetcode.com/problems/largest-divisible-subset/](https://leetcode.com/problems/largest-divisible-subset/)

**Difficulty:** Medium

---

## Problem Description

Given a set of **distinct** positive integers `nums`, return the largest subset `answer` such that every pair `(answer[i], answer[j])` of elements in this subset satisfies:
- `answer[i] % answer[j] == 0`, or
- `answer[j] % answer[i] == 0`

If there are multiple valid solutions, return any of them.

---

## Examples

**Example 1:**

**Input:** `nums = [1,2,3]`  
**Output:** `[1,2]`  
**Explanation:** `[1,3]` is also a valid answer.

---

**Example 2:**

**Input:** `nums = [1,2,4,8]`  
**Output:** `[1,2,4,8]`

---

## Approaches

---

### Approach 1: Optimal — Sort + DP with Backtracking Hash Array (Active)

**Idea:**  
If we sort the array in ascending order, whenever `nums[idx] % nums[prev] == 0`, transitivity guarantees that `nums[idx]` is divisible by every smaller element already in `nums[prev]`'s subset. This transforms the problem into finding the Longest Increasing Subsequence variant where the condition is divisibility (`nums[idx] % nums[prev] == 0`). We maintain a `hash` array to store parent pointers to reconstruct the subset.

**Algorithm:**
1. Sort `nums` in ascending order.
2. Initialize `dp` array of size `n` filled with `1` and `hash` array with `hash[i] = i`.
3. Loop `idx` from `0` to `n-1`:
   - Loop `prev` from `0` to `idx-1`:
     - If `nums[idx] % nums[prev] == 0` and `1 + dp[prev] > dp[idx]`:
       - `dp[idx] = 1 + dp[prev]`
       - `hash[idx] = prev`
   - Track maximum DP value and update `last_idx`.
4. Backtrack using `hash` array from `last_idx` until `hash[last_idx] == last_idx`.
5. Reverse the collected elements and return the subset.

**Complexity:**
- **Time:** O(n²) — O(n log n) sorting + O(n²) DP nested loops + O(n) backtracking.
- **Space:** O(n) — Auxiliary DP array, `hash` array, and output list.
