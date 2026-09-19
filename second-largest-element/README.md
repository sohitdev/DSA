# Second Largest Element

**LeetCode Problem:** [Second Largest](https://www.geeksforgeeks.org/problems/second-largest3735/1)

**Difficulty:** Easy

---

## Problem Description

Given an array `arr`, return the second largest distinct element from an array. If the second largest element doesn't exist then return `-1`.

---

## Examples

**Example 1:**

**Input:** `arr = [12, 35, 1, 10, 34, 1]`
**Output:** `34`
**Explanation:** The largest element of the array is 35 and the second largest element is 34.

---

**Example 2:**

**Input:** `arr = [10, 5, 10]`
**Output:** `5`
**Explanation:** The largest element of the array is 10 and the second largest element is 5.

---

**Example 3:**

**Input:** `arr = [10, 10, 10]`
**Output:** `-1`
**Explanation:** The largest element of the array is 10 and there is no second largest element.

---

## Approaches

---

### Approach 1: Optimal — Single Pass (Active)

**Idea:**
Initialize two variables, `l` (largest) and `sl` (second largest), to `-1`. Traverse the array and keep updating these variables. If the current element is greater than `l`, update `sl` to `l` and `l` to the current element. If it's less than `l` but greater than `sl`, update `sl` to the current element.

**Algorithm:**
1. Initialize `l` and `sl` to `-1`.
2. Iterate over each `num` in the array `arr`.
3. If `num > l`, set `sl = l` and `l = num`.
4. Else if `num > sl` and `num != l`, set `sl = num`.
5. Return `sl` at the end of the loop.

**Complexity:**
- **Time:** O(n) — We traverse the array exactly once.
- **Space:** O(1) — No extra space is used apart from a few variables.
