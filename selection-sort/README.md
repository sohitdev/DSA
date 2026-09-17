# Selection Sort

**GFG Problem:** [https://www.geeksforgeeks.org/problems/selection-sort/1](https://www.geeksforgeeks.org/problems/selection-sort/1)

**Difficulty:** Easy

---

## Problem Description

Given an array `arr[]`, sort it using **Selection Sort**.

Selection Sort divides the array into a sorted and an unsorted region. In each pass, it finds the minimum element from the unsorted region and swaps it with the first element of the unsorted region, growing the sorted portion by one element each time.

---

## Examples

**Example 1:**

**Input:** `arr[] = [4, 1, 3, 9, 7]`
**Output:** `[1, 3, 4, 7, 9]`

---

**Example 2:**

**Input:** `arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]`
**Output:** `[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]`

---

## Approaches

---

### Approach 1: Optimal — Find Minimum and Swap (Active)

**Idea:**
For each position `i`, scan the rest of the array (`i` to `n-1`) to find the index of the minimum element (`min_idx`). Swap `arr[i]` with `arr[min_idx]`. After pass `i`, the first `i+1` elements are in their final sorted positions.

**Algorithm:**
1. Outer loop `i` from `0` to `n-1`.
2. Initialize `min_idx = i`.
3. Inner scan `j` from `i` to `n-1`: if `arr[j] < arr[min_idx]`, update `min_idx = j`.
4. Swap `arr[i]` and `arr[min_idx]`.
5. Repeat until the entire array is sorted.

**Complexity:**
- **Time:** O(n²) — Two nested loops; the inner scan runs `n-i` times for each `i`.
- **Space:** O(1) — Sorting is done in-place with only a temporary swap variable.
