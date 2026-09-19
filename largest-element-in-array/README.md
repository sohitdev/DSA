# Largest Element in Array

**LeetCode Problem:** [Largest Element in Array](https://www.geeksforgeeks.org/problems/largest-element-in-array2439/1)

**Difficulty:** Easy

---

## Problem Description

Given an array `arr`, the task is to find the largest element in the given array.

---

## Examples

**Example 1:**

**Input:** `arr = [1, 8, 7, 56, 90]`
**Output:** `90`
**Explanation:** The largest element of given array is 90.

---

**Example 2:**

**Input:** `arr = [1, 2, 0, 3, 2, 4, 5]`
**Output:** `5`
**Explanation:** The largest element of given array is 5.

---

## Approaches

---

### Approach 1: Optimal — Single Pass (Active)

**Idea:**
Initialize a variable to store the maximum value found so far. Iterate through the array and update the maximum variable whenever a larger element is encountered.

**Algorithm:**
1. Initialize a variable `maxi` to 0.
2. Traverse through each element `num` in the array.
3. For each element, update `maxi = Math.max(maxi, num)`.
4. Return `maxi` after the loop ends.

**Complexity:**
- **Time:** O(n) — We traverse the array exactly once.
- **Space:** O(1) — No extra space is used apart from a single variable.
