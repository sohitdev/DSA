# Bubble Sort

**GFG Problem:** [https://www.geeksforgeeks.org/problems/bubble-sort/1](https://www.geeksforgeeks.org/problems/bubble-sort/1)

**Difficulty:** Easy

---

## Problem Description

Given an array `arr[]`, sort it using **Bubble Sort**.

Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order. After each pass, the largest unsorted element "bubbles up" to its correct position at the end.

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

### Approach 1: Optimal — Adjacent Swap (Bubble Sort) (Active)

**Idea:**
In each pass `i`, compare every pair of adjacent elements `arr[j-1]` and `arr[j]` from index `1` up to `n-i-1`. If they are out of order, swap them. After `i` passes, the `i` largest elements are correctly placed at the end, so the inner loop shrinks by one each time.

**Algorithm:**
1. Outer loop `i` from `0` to `n-2` (controls the number of passes).
2. Inner loop `j` from `1` to `n-i-1`:
   - If `arr[j] < arr[j-1]`, swap `arr[j]` and `arr[j-1]`.
3. After all passes, `arr[]` is sorted in ascending order.

**Complexity:**
- **Time:** O(n²) — Two nested loops each of up to n iterations.
- **Space:** O(1) — Sorting is done in-place with only a temporary swap variable.
