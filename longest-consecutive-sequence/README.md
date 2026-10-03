# 128. Longest Consecutive Sequence

**LeetCode Problem:** [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)

**Difficulty:** Medium

---

## Problem Description

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in `O(n)` time.

---

## Examples

**Example 1:**

**Input:** `nums = [100,4,200,1,3,2]`
**Output:** `4`
**Explanation:** The longest consecutive elements sequence is `[1, 2, 3, 4]`. Therefore its length is `4`.

**Example 2:**

**Input:** `nums = [0,3,7,2,5,8,4,6,0,1]`
**Output:** `9`

---

## Approaches

---

### Approach 1: Better (Sorting)

**Idea:**
If we sort the array, consecutive elements will be adjacent to each other. We can then iterate through the sorted array, keeping track of the current consecutive sequence length. We also need to handle duplicate elements by simply ignoring them.

**Algorithm:**
1. Sort the input array.
2. Initialize `currLen = 0`, `maxLen = 0`, and `last = Integer.MIN_VALUE`.
3. Iterate over the array:
   - If `nums[i] == last + 1`, it's the next consecutive element. Increment `currLen`.
   - If `nums[i] == last`, it's a duplicate. Do nothing.
   - Otherwise, it's the start of a new sequence. Reset `currLen = 1`.
   - In all valid cases, update `last = nums[i]` and `maxLen = Math.max(maxLen, currLen)`.
4. Return `maxLen`.

**Complexity:**
- **Time:** O(N log N) — Due to the sorting step.
- **Space:** O(1) or O(N) depending on the sorting algorithm implementation.

---

### Approach 2: Optimal (HashSet) (Active)

**Idea:**
To achieve the `O(N)` time complexity, we can use a `HashSet`. We first add all elements to the set. Then, for each number, we check if it is the **start** of a consecutive sequence. A number is the start of a sequence if its previous number (`num - 1`) is *not* in the set. If it is the start, we continually check for the next consecutive numbers (`num + 1`, `num + 2`, etc.) in the set, counting the length of the sequence.

**Algorithm:**
1. Check for the base case: if the array is empty, return `0`.
2. Insert all elements into a `HashSet`. This gives us O(1) lookups.
3. Iterate through each element in the set:
   - If `set.contains(num - 1)` is `false`, it means `num` is the first element of a sequence.
   - Start a `while` loop to check if `set.contains(last + 1)` and increment the length `currLen` as long as consecutive elements exist.
   - Update `maxLen` with the maximum length found so far.
4. Return `maxLen`.

**Complexity:**
- **Time:** O(N) — Inserting elements into the set takes O(N). The subsequent loop also takes O(N) because each element is visited at most twice (once to check if it's the start of a sequence, and once during the while loop for consecutive elements).
- **Space:** O(N) — We use a HashSet to store all the elements of the array.
