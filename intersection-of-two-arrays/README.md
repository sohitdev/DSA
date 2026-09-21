# Intersection of Two Sorted Arrays

**LeetCode Problem:** [Intersection of Two Arrays](https://www.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1)

**Difficulty:** Easy

---

## Problem Description

Given two sorted arrays `arr1` and `arr2`, return their intersection. The intersection of two arrays is defined as the set of elements that are common in both the arrays. The output should be a list containing the intersection of the two arrays in sorted order without duplicates.

---

## Examples

**Example 1:**

**Input:** `arr1 = [1, 2, 2, 3, 4]`, `arr2 = [2, 2, 4, 6, 7, 8]`
**Output:** `[2, 4]`
**Explanation:** 2 and 4 are the only common elements.

---

**Example 2:**

**Input:** `arr1 = [1, 2, 3]`, `arr2 = [4, 5, 6]`
**Output:** `[]`
**Explanation:** There are no common elements.

---

## Approaches

---

### Approach 2: Optimal — Two Pointers (Sorted Arrays) (Active)

**Idea:**
Since the arrays are already sorted, we can use a two-pointer approach to find the common elements efficiently. We place one pointer at the beginning of each array and increment the pointer that points to the smaller value. If both point to the same value, it's a common element; we add it to the result (ensuring no duplicates) and increment both pointers.

**Algorithm:**
1. Initialize two pointers `i = 0` for `arr1` and `j = 0` for `arr2`.
2. While `i < arr1.length` and `j < arr2.length`:
3. If `arr1[i] < arr2[j]`, increment `i`.
4. Else if `arr1[i] > arr2[j]`, increment `j`.
5. Else (they are equal):
   - Check if the element is already the last added element in the result list to avoid duplicates.
   - If not, add `arr1[i]` to the result list.
   - Increment both `i` and `j`.
6. Return the result list.

**Complexity:**
- **Time:** O(n + m) — In the worst case, we traverse both arrays completely, where `n` and `m` are their lengths.
- **Space:** O(1) — No extra auxiliary space is used (excluding the result list).

---

### Approach 1: Brute Force — Nested Loops with Set

**Idea:**
For every element in the first array, we can iterate through the second array to check if it exists. If it does, we add it to a `TreeSet` to handle duplicates and maintain sorted order. After finding all common elements, we transfer them from the set to a list.

**Algorithm:**
1. Initialize a `TreeSet` to store common elements without duplicates.
2. Iterate `i` through `arr1`.
3. For each `arr1[i]`, iterate `j` through `arr2`.
4. If `arr1[i] == arr2[j]`, add it to the set and `break` the inner loop to avoid redundant checks.
5. After the loops, copy all elements from the set to an `ArrayList`.
6. Return the list.

**Complexity:**
- **Time:** O(n * m) — For each element in `arr1`, we potentially scan all of `arr2`.
- **Space:** O(min(n, m)) — The set can store up to the number of common unique elements.
