# Merge Sort

**GFG Problem:** [https://www.geeksforgeeks.org/problems/merge-sort/1](https://www.geeksforgeeks.org/problems/merge-sort/1)

**Difficulty:** Medium

---

## Problem Description

Given an array `arr[]`, sort it using the **Merge Sort** algorithm.

Merge Sort is a divide-and-conquer algorithm that divides the array into two halves, recursively sorts each half, and then merges the two sorted halves back into a single sorted array.

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

### Approach 1: Optimal — Divide and Conquer (Merge Sort) (Active)

**Idea:**
Recursively split the array into two halves until each sub-array has one element (base case). Then merge the two sorted halves by comparing elements one by one and placing the smaller one into a temporary array, before copying it back into the original array.

**Algorithm:**
1. Base case: if `l >= r`, return (single element is already sorted).
2. Compute `mid = l + (r - l) / 2`.
3. Recursively call `mergeSort(arr, l, mid)` and `mergeSort(arr, mid+1, r)`.
4. Call `merge(arr, l, mid, r)` to merge the two sorted halves:
   - Create a temporary array `temp[]` of size `high - low + 1`.
   - Use two pointers `left = low` and `right = mid + 1`.
   - Compare `arr[left]` and `arr[right]`; place the smaller into `temp[]` and advance the corresponding pointer.
   - Copy any remaining elements from the left or right half into `temp[]`.
   - Copy `temp[]` back into `arr[low..high]`.

**Complexity:**
- **Time:** O(n log n) — The array is divided `log n` times and merging at each level takes O(n).
- **Space:** O(n) — Temporary array of size `n` used during merging.
