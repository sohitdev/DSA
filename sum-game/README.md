# 1927. Sum Game

**LeetCode Problem:** [https://leetcode.com/problems/sum-game/](https://leetcode.com/problems/sum-game/)

**Difficulty:** Medium

---

## Problem Description

Alice and Bob take turns playing a game, with Alice starting first.

You are given a string `num` of even length consisting of digits and `?` characters. On each turn, a player will replace one `?` with any digit from `'0'` to `'9'` until there are no more `?` characters left.

The game ends when all `?` characters are filled. Bob wins if the sum of digits in the first half of `num` equals the sum of digits in the second half. Alice wins otherwise.

Assuming both players play optimally, return `true` if Alice will win and `false` if Bob will win.

---

## Examples

**Example 1:**

**Input:** `"5023"`  
**Output:** `false`  
**Explanation:** There are no moves to be made. The sums are equal: `5 + 0 = 2 + 3`.

---

**Example 2:**

**Input:** `"25??"`  
**Output:** `true`  
**Explanation:** Alice can replace one of the `?` characters with a digit that makes the sum difference impossible to fix for Bob.

---

**Example 3:**

**Input:** `"?3295???"`  
**Output:** `false`  
**Explanation:** It can be proven that Bob always wins under optimal play.

---

## Approaches

---

### Approach 1: Optimal — Balance Half-Sum and Wildcards (Active)

**Idea:**
Compute the total known digit sum and wildcard count in each half. The outcome depends only on how much the right half must gain or lose against the left half after all `?` are assigned, and whether the number of unknowns is odd.

**Algorithm:**
1. Scan the left half and right half separately to count `?` characters and sum the fixed digits.
2. Let `qL`, `qR` be the counts of unknowns and `sumL`, `sumR` be the known sums in each half.
3. If the total number of `?` is odd, Alice makes the final move and wins.
4. Otherwise, Bob wins only when the equation `2 * (sumR - sumL) == 9 * (qL - qR)` holds; if it does not, Alice wins.

**Complexity:**
- **Time:** O(n) — one pass through the string.
- **Space:** O(1) — a fixed number of counters.
