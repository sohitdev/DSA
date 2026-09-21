# 169. Majority Element

**LeetCode Problem:** [169. Majority Element](https://leetcode.com/problems/majority-element/)

**Difficulty:** Easy

---

## Problem Description

Given an array `nums` of size `n`, return the majority element.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

---

## Examples

**Example 1:**

**Input:** `nums = [3,2,3]`
**Output:** `3`

---

**Example 2:**

**Input:** `nums = [2,2,1,1,1,2,2]`
**Output:** `2`

---

## Approaches

---

### Approach 1: Optimal — Moore's Voting Algorithm (Active)

**Idea:**
Boyer-Moore Voting Algorithm works on the fact that if an element occurs more than `n/2` times, it will always remain as the `candidate` if we increment a `count` when we see the candidate, and decrement the `count` when we see any other element. When the count drops to 0, we simply pick the current element as the new candidate.

**Algorithm:**
1. Initialize `count = 0` and `candidate = 0`.
2. Iterate through each `num` in the array `nums`:
3. If `count == 0`, update `candidate = num`.
4. If `num == candidate`, increment `count`.
5. Else, decrement `count`.
6. At the end of the loop, `candidate` will hold the majority element.
7. Return `candidate`.

**Complexity:**
- **Time:** O(n) — We traverse the array exactly once.
- **Space:** O(1) — No extra auxiliary space is required.
