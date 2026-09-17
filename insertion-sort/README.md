# Insertion Sort

**GFG Problem:** [https://www.geeksforgeeks.org/problems/insertion-sort/1](https://www.geeksforgeeks.org/problems/insertion-sort/1)

**Difficulty:** Easy

---

## Problem Description

Given an array `arr[]`, sort it using **Insertion Sort**.

Insertion Sort builds the sorted array one element at a time. It picks each element and places it in its correct position among the already-sorted elements to its left, shifting larger elements rightward as needed.

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

### Approach 1: Optimal — Shift and Insert (Active)

**Idea:**
For each element at index `i` (starting from `1`), walk backwards comparing `arr[j]` with `arr[j-1]`. As long as `arr[j] < arr[j-1]`, swap the two elements and continue moving left. Once the element is in its correct position (no swap needed), break early. This ensures that `arr[0..i]` is always sorted after processing index `i`.

**Algorithm:**
1. Outer loop `i` from `1` to `n-1` — picks the element to insert.
2. Inner loop `j` from `i` down to `1`:
   - If `arr[j] < arr[j-1]`, swap them and continue.
   - Otherwise `break` — the element is already in the correct position.
3. Repeat until all elements are processed.

**Complexity:**
- **Time:** O(n²) — In the worst case (reverse-sorted input), each element is compared with all elements to its left.
- **Space:** O(1) — Sorting is done in-place with only a temporary swap variable.
