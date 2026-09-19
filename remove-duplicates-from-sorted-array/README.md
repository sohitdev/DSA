# 26. Remove Duplicates from Sorted Array

**LeetCode Problem:** [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

**Difficulty:** Easy

---

## Problem Description

Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates **in-place** such that each unique element appears only **once**. The **relative order** of the elements should be kept the same. Then return the number of unique elements in `nums`.

Consider the number of unique elements of `nums` to be `k`, to get accepted, you need to do the following things:
- Change the array `nums` such that the first `k` elements of `nums` contain the unique elements in the order they were present in `nums` initially. The remaining elements of `nums` are not important as well as the size of `nums`.
- Return `k`.

---

## Examples

**Example 1:**

**Input:** `nums = [1,1,2]`
**Output:** `2, nums = [1,2,_]`
**Explanation:** Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

---

**Example 2:**

**Input:** `nums = [0,0,1,1,1,2,2,3,3,4]`
**Output:** `5, nums = [0,1,2,3,4,_,_,_,_,_]`
**Explanation:** Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

---

## Approaches

---

### Approach 2: Optimal — Two Pointers (Active)

**Idea:**
Since the array is already sorted, duplicates will be adjacent to each other. We can use two pointers: one (`i`) to track the position of the last unique element, and another (`j`) to scan through the array. When we find an element different from the element at `i`, we increment `i` and copy the new unique element there.

**Algorithm:**
1. Initialize pointer `i = 0` and pointer `j = 1`.
2. Loop while `j < nums.length`:
3. If `nums[i] != nums[j]`, increment `i` and set `nums[i] = nums[j]`.
4. Increment `j` in every iteration.
5. Return `i + 1`, which is the count of unique elements.

**Complexity:**
- **Time:** O(n) — We traverse the array exactly once with the `j` pointer.
- **Space:** O(1) — We modify the array in-place without using extra space.

---

### Approach 1: Brute Force — Using Set

**Idea:**
We can use a `TreeSet` (or any ordered set) to automatically remove duplicates and keep the elements sorted. We insert all elements into the set, and then copy them back to the original array.

**Algorithm:**
1. Create a `TreeSet` to store unique elements.
2. Iterate through the array and add each element to the set.
3. Iterate through the set and copy the elements back to the beginning of `nums`.
4. Return the size of the set.

**Complexity:**
- **Time:** O(n log n) — Inserting `n` elements into a `TreeSet` takes O(n log n) time.
- **Space:** O(n) — The set can store up to `n` unique elements.
