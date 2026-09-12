# 1048. Longest String Chain

**LeetCode Problem:** [https://leetcode.com/problems/longest-string-chain/](https://leetcode.com/problems/longest-string-chain/)

**Difficulty:** Medium

---

## Problem Description

You are given an array of `words` where each word consists of lowercase English letters.

`wordA` is a **predecessor** of `wordB` if and only if we can insert exactly one letter anywhere in `wordA` without changing the order of the other characters to make it equal to `wordB`.
- For example, `"abc"` is a predecessor of `"abac"`, while `"cba"` is not a predecessor of `"bcad"`.

A **word chain** is a sequence of words `[word1, word2, ..., wordk]` with `k >= 1`, where `word1` is a predecessor of `word2`, `word2` is a predecessor of `word3`, and so on. A single word is trivially a word chain with `k == 1`.

Return the **length of the longest possible word chain** with words chosen from the given list of `words`.

---

## Examples

**Example 1:**

**Input:** `words = ["a","b","ba","bca","bda","bdca"]`  
**Output:** `4`  
**Explanation:** One of the longest word chains is `["a","ba","bda","bdca"]`.

---

**Example 2:**

**Input:** `words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]`  
**Output:** `5`  
**Explanation:** All the words can be put in a word chain `["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"]`.

---

**Example 3:**

**Input:** `words = ["abcd","dbqca"]`  
**Output:** `1`  
**Explanation:** The trivial word chain `["abcd"]` is one of the longest word chains.

---

## Approaches

---

### Approach 1: Optimal — Sort by Length + 1D DP (Active)

**Idea:**  
First, sort the array of words based on string length in ascending order. This guarantees that any valid predecessor of `words[idx]` appears before `words[idx]`. We can then adapt the LIS 1D DP approach: `dp[idx]` stores the maximum word chain length ending at `words[idx]`. To check if `words[prev]` is a predecessor of `words[idx]`, we use a two-pointer helper function `compare(s1, s2)` which verifies that `s1.length() == s2.length() + 1` and that `s1` differs from `s2` by exactly one inserted character.

**Algorithm:**
1. Sort `words` by length in ascending order.
2. Initialize `dp` array of size `n` filled with `1`.
3. Loop `idx` from `0` to `n-1`:
   - Loop `prev` from `0` to `idx-1`:
     - If `compare(words[idx], words[prev])` is `true` and `1 + dp[prev] > dp[idx]`:
       - `dp[idx] = 1 + dp[prev]`.
   - Update `max = max(max, dp[idx])`.
4. Return `max`.

**Helper Function (`compare(s1, s2)`):**
- Returns `false` if `s1.length() != s2.length() + 1`.
- Uses two pointers `first` and `second` to traverse `s1` and `s2`.
- Advances `first` always, and `second` only when characters match.
- Returns `true` if `first == s1.length()` and `second == s2.length()`.

**Complexity:**
- **Time:** O(N log N + N² × L) — Sorting takes $O(N \log N)$ time (where $N$ is number of words). Two nested DP loops take $O(N^2)$ iterations, each doing string comparison of length at most $L$.
- **Space:** O(N) — Auxiliary DP array and hash array of size $N$.
