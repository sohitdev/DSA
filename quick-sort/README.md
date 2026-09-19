# Quick Sort

**LeetCode Problem:** [Quick Sort](https://www.geeksforgeeks.org/quick-sort/)

**Difficulty:** Medium

---

## Problem Description

Given an array of integers, sort the array in ascending order using the Quick Sort algorithm. Quick Sort is a divide-and-conquer algorithm. It picks an element as a pivot and partitions the given array around the picked pivot.

---

## Examples

**Example 1:**

**Input:** `arr = [4, 1, 3, 9, 7]`
**Output:** `[1, 3, 4, 7, 9]`
**Explanation:** The array is sorted in ascending order.

---

**Example 2:**

**Input:** `arr = [2, 1, 6, 10, 4, 1, 3, 9, 7]`
**Output:** `[1, 1, 2, 3, 4, 6, 7, 9, 10]`

---

## Approaches

---

### Approach 1: Optimal — Quick Sort (Active)

**Idea:**
Select the first element as the pivot. Partition the array such that all elements smaller than or equal to the pivot are on the left, and all elements greater are on the right. Recursively apply the same logic to the left and right subarrays.

**Algorithm:**
1. If `low < high`, call the `partition` function to get the partition index `p`.
2. Inside `partition`, use two pointers `i` and `j` to find elements on the wrong side of the pivot.
3. Swap `arr[i]` and `arr[j]` when an element larger than the pivot is found on the left and an element smaller is found on the right.
4. Place the pivot at its correct position `j` and return `j`.
5. Recursively sort the subarrays before and after the partition index.

**Complexity:**
- **Time:** O(n log n) average, O(n^2) worst — The partition process takes O(n). In the average case, it divides the array into two halves, taking O(log n) recursive calls. In the worst case (already sorted array), it takes O(n) recursive calls.
- **Space:** O(log n) average, O(n) worst — Space required for the recursion stack.
