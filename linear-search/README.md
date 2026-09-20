# Linear Search

**LeetCode Problem:** [Linear Search](https://www.geeksforgeeks.org/problems/who-will-win-1587115621/1)

**Difficulty:** Easy

---

## Problem Description

Given an array `arr` and an integer `x`, find if `x` is present in the given array. If it is present, return its index. Otherwise, return `-1`.

---

## Examples

**Example 1:**

**Input:** `arr = [1, 2, 3, 4], x = 3`
**Output:** `2`
**Explanation:** 3 is present at index 2.

---

**Example 2:**

**Input:** `arr = [10, 8, 30, 4, 5], x = 5`
**Output:** `4`
**Explanation:** 5 is present at index 4.

---

**Example 3:**

**Input:** `arr = [10, 8, 30], x = 6`
**Output:** `-1`
**Explanation:** 6 is not present in the array.

---

## Approaches

---

### Approach 1: Optimal — Linear Scan (Active)

**Idea:**
Iterate through the array from the first element to the last element. Compare each element with the target value `x`. If a match is found, return the current index. If the loop finishes without finding a match, return `-1`.

**Algorithm:**
1. Loop from `i = 0` to `arr.length - 1`.
2. Check if `arr[i] == x`.
3. If true, return `i`.
4. If the loop completes, return `-1`.

**Complexity:**
- **Time:** O(n) — In the worst case, we check every element in the array once.
- **Space:** O(1) — No extra space is used.
