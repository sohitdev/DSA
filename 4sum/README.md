# 18. 4Sum

**LeetCode Problem:** [18. 4Sum](https://leetcode.com/problems/4sum/)

**Difficulty:** Medium

---

## Problem Description

Given an array `nums` of `n` integers, return an array of all the **unique** quadruplets `[nums[a], nums[b], nums[c], nums[d]]` such that:

* `0 <= a, b, c, d < n`
* `a, b, c`, and `d` are distinct.
* `nums[a] + nums[b] + nums[c] + nums[d] == target`

You may return the answer in any order.

---

## Examples

**Example 1:**

**Input:** `nums = [1,0,-1,0,-2,2], target = 0`
**Output:** `[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]`

**Example 2:**

**Input:** `nums = [2,2,2,2,2], target = 8`
**Output:** `[[2,2,2,2]]`

---

## Approaches

---

### Approach: Optimal — Two Pointers with Sorting (Active)

**Idea:**
Similar to 3Sum, we can fix two pointers (`i` and `j`) and use a two-pointer approach for the remaining two elements (`k` and `l`) to find the exact target sum. The array needs to be sorted first to easily manage duplicates and move pointers strategically.

**Algorithm:**
1. Sort the input array `nums`.
2. Use a `for` loop to fix the first pointer `i` from `0` to `n - 3`. Skip any duplicate elements to avoid duplicate quadruplets.
3. Use a nested `for` loop to fix the second pointer `j` from `i + 1` to `n - 2`. Again, skip duplicate elements.
4. For the remaining part of the array, set two pointers `k = j + 1` (left) and `l = n - 1` (right).
5. While `k < l`:
   - Calculate `sum = (long) nums[i] + nums[j] + nums[k] + nums[l]`. Use `long` to prevent integer overflow.
   - If `sum < target`, increment `k` to increase the sum.
   - If `sum > target`, decrement `l` to decrease the sum.
   - If `sum == target`, a quadruplet is found. Add it to the list.
     - Increment `k` and decrement `l`.
     - Skip duplicates for `k` and `l` to avoid duplicate results.

**Complexity:**
- **Time:** O(N^3) — We have two nested loops leading to N^2 iterations. Inside the inner loop, the two-pointer traversal takes O(N). Hence, O(N^3) overall.
- **Space:** O(1) or O(N) depending on the sorting algorithm, ignoring the space required for output.
