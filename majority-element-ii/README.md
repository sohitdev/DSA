# 229. Majority Element II

**LeetCode Problem:** [229. Majority Element II](https://leetcode.com/problems/majority-element-ii/)

**Difficulty:** Medium

---

## Problem Description

Given an integer array of size `n`, find all elements that appear more than `⌊ n/3 ⌋` times.

---

## Examples

**Example 1:**

**Input:** `nums = [3,2,3]`
**Output:** `[3]`

---

**Example 2:**

**Input:** `nums = [1]`
**Output:** `[1]`

---

**Example 3:**

**Input:** `nums = [1,2]`
**Output:** `[1,2]`

---

## Approaches

---

### Approach: Optimal — Boyer-Moore Voting Algorithm (Active)

**Idea:**
Since we need to find elements that appear more than `n/3` times, there can be at most 2 such elements. The Boyer-Moore Voting Algorithm can be extended to find these two potential candidates. 

**Algorithm:**
1. Initialize two candidates (`cand1`, `cand2`) and their counts (`count1`, `count2`) to `0`.
2. First Pass (Find candidates): Iterate through the array:
   - If the current number matches `cand1`, increment `count1`.
   - Else if it matches `cand2`, increment `count2`.
   - Else if `count1 == 0`, set `cand1` to current number and `count1 = 1`.
   - Else if `count2 == 0`, set `cand2` to current number and `count2 = 1`.
   - Else, decrement both counts.
3. Second Pass (Verification): Re-iterate through the array to count the exact occurrences of `cand1` and `cand2`.
4. If their counts are greater than `n / 3`, add them to the result list.

**Complexity:**
- **Time:** O(n) — We traverse the array twice, which is O(2n) = O(n).
- **Space:** O(1) — We only use a few variables for counting, requiring constant extra space.
