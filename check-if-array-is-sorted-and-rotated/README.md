# 1752. Check if Array Is Sorted and Rotated

**LeetCode Problem:** [1752. Check if Array Is Sorted and Rotated](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/)

**Difficulty:** Easy

---

## Problem Description

Given an array `nums`, return `true` if the array was originally sorted in non-decreasing order, then rotated **some** number of positions (including zero). Otherwise, return `false`.

There may be **duplicates** in the original array.

Note: An array `A` rotated by `x` positions results in an array `B` of the same length such that `A[i] == B[(i+x) % A.length]`, where `%` is the modulo operation.

---

## Examples

**Example 1:**

**Input:** `nums = [3,4,5,1,2]`
**Output:** `true`
**Explanation:** `[1,2,3,4,5]` is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: `[3,4,5,1,2]`.

---

**Example 2:**

**Input:** `nums = [2,1,3,4]`
**Output:** `false`
**Explanation:** There is no sorted array once rotated that can make `nums`.

---

**Example 3:**

**Input:** `nums = [1,2,3]`
**Output:** `true`
**Explanation:** `[1,2,3]` is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make `nums`.

---

## Approaches

---

### Approach 1: Optimal — Single Pass Count Drops (Active)

**Idea:**
If an array is sorted and rotated, there will be at most one "drop" or "inversion" where an element is strictly greater than the next element. Since the array is treated as circular (the last element connects back to the first), we can iterate through the array and count how many times `nums[i] > nums[(i+1) % n]`. If this count exceeds 1, then the array is not sorted and rotated.

**Algorithm:**
1. Initialize a `count` variable to 0.
2. Iterate through the array from `i = 0` to `n - 1`.
3. Check if `nums[i] > nums[(i+1) % n]`. If so, increment `count`.
4. If `count > 1` at any point, return `false`.
5. Return `true` if the loop completes without `count` exceeding 1.

**Complexity:**
- **Time:** O(n) — We traverse the array exactly once.
- **Space:** O(1) — No extra space is used.
