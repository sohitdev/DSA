# 283. Move Zeroes

**LeetCode Problem:** [283. Move Zeroes](https://leetcode.com/problems/move-zeroes/)

**Difficulty:** Easy

---

## Problem Description

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

**Note** that you must do this in-place without making a copy of the array.

---

## Examples

**Example 1:**

**Input:** `nums = [0,1,0,3,12]`
**Output:** `[1,3,12,0,0]`

---

**Example 2:**

**Input:** `nums = [0]`
**Output:** `[0]`

---

## Approaches

---

### Approach 1: Optimal — Two Pointers (Swap) (Active)

**Idea:**
Use a two-pointer approach where one pointer (`j`) keeps track of the position where the next non-zero element should be placed, and the other pointer (`i`) iterates through the array. Whenever a non-zero element is found at `i`, swap it with the element at `j`, and then increment `j`.

**Algorithm:**
1. Initialize a pointer `j = 0`.
2. Iterate through the array using pointer `i` from `0` to `n - 1`.
3. If `nums[i] != 0`, swap `nums[i]` with `nums[j]`.
4. Increment `j` after the swap.
5. All the non-zero elements are moved to the front and the remaining elements automatically become zeroes.

**Complexity:**
- **Time:** O(n) — We traverse the array exactly once.
- **Space:** O(1) — The modifications are done in-place without any extra space.
