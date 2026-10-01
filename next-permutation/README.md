# 31. Next Permutation

**LeetCode Problem:** [31. Next Permutation](https://leetcode.com/problems/next-permutation/)

**Difficulty:** Medium

---

## Problem Description

A **permutation** of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for `arr = [1,2,3]`, the following are all the permutations of `arr`: `[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]`.

The **next permutation** of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

Given an array of integers `nums`, find the next permutation of `nums`.
The replacement must be **in place** and use only constant extra memory.

---

## Examples

**Example 1:**

**Input:** `nums = [1,2,3]`
**Output:** `[1,3,2]`

**Example 2:**

**Input:** `nums = [3,2,1]`
**Output:** `[1,2,3]`

**Example 3:**

**Input:** `nums = [1,1,5]`
**Output:** `[1,5,1]`

---

## Approaches

---

### Approach: Optimal — In-place Swap and Reverse (Active)

**Idea:**
To find the next lexicographically greater sequence, we need to find the rightmost character which is smaller than its next character. Let's call this position the "break point". 
Once we find the break point `idx`, we need to swap it with the smallest character strictly greater than it on its right side. After the swap, the sequence after `idx` will still be in descending order. To get the next *smallest* lexicographical arrangement, we just reverse the sequence from `idx + 1` to the end.

**Algorithm:**
1. **Find the break point**: Traverse from the second last element to the left. Find the first index `idx` such that `nums[idx] < nums[idx + 1]`.
2. **Handle the edge case**: If no such `idx` exists, the entire array is in descending order (last permutation). Simply reverse the entire array.
3. **Swap**: If `idx` is found, traverse from the end of the array to find the first element `nums[i]` that is strictly greater than `nums[idx]`.
4. Swap `nums[idx]` and `nums[i]`.
5. **Reverse the right half**: Reverse the sub-array starting from `idx + 1` to the end of the array to make it the smallest possible sequence.

**Complexity:**
- **Time:** O(N) — We scan the array at most three times: once to find the break point, once to find the swap candidate, and once to reverse.
- **Space:** O(1) — We modify the array in place, requiring only a few variables for indices.
