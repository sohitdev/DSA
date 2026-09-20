# 268. Missing Number

**LeetCode Problem:** [268. Missing Number](https://leetcode.com/problems/missing-number/)

**Difficulty:** Easy

---

## Problem Description

Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return *the only number in the range that is missing from the array.*

---

## Examples

**Example 1:**

**Input:** `nums = [3,0,1]`
**Output:** `2`
**Explanation:** `n = 3` since there are 3 numbers, so all numbers are in the range `[0,3]`. 2 is the missing number in the range since it does not appear in `nums`.

---

**Example 2:**

**Input:** `nums = [0,1]`
**Output:** `2`
**Explanation:** `n = 2` since there are 2 numbers, so all numbers are in the range `[0,2]`. 2 is the missing number in the range since it does not appear in `nums`.

---

**Example 3:**

**Input:** `nums = [9,6,4,2,3,5,7,0,1]`
**Output:** `8`
**Explanation:** `n = 9` since there are 9 numbers, so all numbers are in the range `[0,9]`. 8 is the missing number in the range since it does not appear in `nums`.

---

## Approaches

---

### Approach 2: Optimal — Math (Sum Formula) (Active)

**Idea:**
The sum of the first `n` natural numbers is given by the formula `n * (n + 1) / 2`. By calculating the expected sum of the numbers in the range `[0, n]` and subtracting the actual sum of the elements in the given array, the difference will be the missing number.

**Algorithm:**
1. Calculate the expected sum using `n * (n + 1) / 2` where `n` is the length of the array.
2. Initialize `actual_sum` to `0`.
3. Iterate through the array and add each element to `actual_sum`.
4. Return `expected_sum - actual_sum`.

**Complexity:**
- **Time:** O(n) — We traverse the array exactly once to calculate the sum.
- **Space:** O(1) — Only a few variables are used, taking constant extra space.

---

### Approach 1: Brute Force — Using Set

**Idea:**
Use a `TreeSet` (or any set) to store all the numbers present in the array. Then, check for the missing number by iterating from `0` to `n`. The first number not found in sequence is the missing one.

**Algorithm:**
1. Initialize a `TreeSet` and insert all elements from `nums` into it.
2. Maintain a counter `k` starting from `0`.
3. Iterate through the set. If the current element `i` is not equal to `k`, then `k` is the missing number.
4. If all numbers up to `n-1` are present, then `n` is the missing number.

**Complexity:**
- **Time:** O(n log n) — Inserting `n` elements into a `TreeSet` takes O(n log n) time. Iterating takes O(n). Overall O(n log n).
- **Space:** O(n) — The set stores `n` elements.
