# 189. Rotate Array

**LeetCode Problem:** [189. Rotate Array](https://leetcode.com/problems/rotate-array/)

**Difficulty:** Medium

---

## Problem Description

Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

---

## Examples

**Example 1:**

**Input:** `nums = [1,2,3,4,5,6,7], k = 3`
**Output:** `[5,6,7,1,2,3,4]`
**Explanation:**
rotate 1 steps to the right: `[7,1,2,3,4,5,6]`
rotate 2 steps to the right: `[6,7,1,2,3,4,5]`
rotate 3 steps to the right: `[5,6,7,1,2,3,4]`

---

**Example 2:**

**Input:** `nums = [-1,-100,3,99], k = 2`
**Output:** `[3,99,-1,-100]`
**Explanation:** 
rotate 1 steps to the right: `[99,-1,-100,3]`
rotate 2 steps to the right: `[3,99,-1,-100]`

---

## Approaches

---

### Approach 2: Optimal — Array Reversal (Active)

**Idea:**
When we rotate the array `k` times, the last `k` elements will move to the front, and the rest will shift to the right. We can achieve this in-place by reversing parts of the array. Specifically: 
1. Reverse the first `n-k` elements.
2. Reverse the last `k` elements.
3. Reverse the entire array.

**Algorithm:**
1. Handle cases where `k` is greater than the length of the array by using `k = k % n`.
2. Reverse the subarray from index `0` to `n - k - 1`.
3. Reverse the subarray from index `n - k` to `n - 1`.
4. Finally, reverse the entire array from `0` to `n - 1`.

**Complexity:**
- **Time:** O(n) — Each element in the array is reversed twice, resulting in a linear time complexity.
- **Space:** O(1) — The rotation is done in-place without any extra space.

---

### Approach 1: Brute Force — Extra Array

**Idea:**
Use an extra array to place each element in its new position directly. The new position for an element at index `i` is `(i + k) % n`. After filling the extra array, copy it back to the original array.

**Algorithm:**
1. Update `k = k % n` to handle cases where `k` is greater than `n`.
2. Create an extra array `temp` of size `n`.
3. Iterate through the array and assign `temp[(i + k) % n] = nums[i]`.
4. Copy the elements from `temp` back to `nums`.

**Complexity:**
- **Time:** O(n) — We iterate through the array twice.
- **Space:** O(n) — An extra array of size `n` is used.
