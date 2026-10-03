# 42. Trapping Rain Water

**LeetCode Problem:** [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)

**Difficulty:** Hard

---

## Problem Description

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

---

## Examples

**Example 1:**

**Input:** `height = [0,1,0,2,1,0,1,3,2,1,2,1]`
**Output:** `6`
**Explanation:** The above elevation map (black section) is represented by array `[0,1,0,2,1,0,1,3,2,1,2,1]`. In this case, 6 units of rain water (blue section) are being trapped.

**Example 2:**

**Input:** `height = [4,2,0,3,2,5]`
**Output:** `9`

---

## Approaches

---

### Approach 1: Better (Prefix and Suffix Arrays)

**Idea:**
For each bar, the water it can trap is the minimum of the maximum height on its left and the maximum height on its right, minus its own height. We can precompute the maximum heights from the left and right into two arrays (`prefix` and `suffix`), allowing us to find trapped water in linear time.

**Complexity:**
- **Time:** O(N) — We traverse the array three times (left-to-right, right-to-left, and then combined).
- **Space:** O(N) — We use two arrays of size N.

---

### Approach 2: Optimal — Two Pointers (Active)

**Idea:**
Instead of maintaining two full arrays for `lmax` and `rmax`, we can use two pointers `l` and `r` to compute them dynamically on the fly. 
If `height[l] <= height[r]`, it means the water trapped at `l` is strictly determined by `lmax` because we know there is a bar at least as high on the right. Conversely, if `height[l] > height[r]`, the trapped water at `r` is determined by `rmax`.

**Algorithm:**
1. Initialize `l = 0` and `r = n - 1`.
2. Initialize `lmax = 0` and `rmax = 0`, along with `total = 0`.
3. While `l < r`:
   - If `height[l] <= height[r]`:
     - If `height[l] >= lmax`, update `lmax = height[l]`.
     - Else, water can be trapped. Add `lmax - height[l]` to `total`.
     - Move the left pointer `l++`.
   - Else (meaning `height[l] > height[r]`):
     - If `height[r] >= rmax`, update `rmax = height[r]`.
     - Else, water can be trapped. Add `rmax - height[r]` to `total`.
     - Move the right pointer `r--`.
4. Return `total`.

**Complexity:**
- **Time:** O(N) — We process each element at most once using two pointers.
- **Space:** O(1) — We only use a few integer variables.
