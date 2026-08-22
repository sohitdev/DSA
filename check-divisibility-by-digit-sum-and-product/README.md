# 3622. Check Divisibility by Digit Sum and Product

**LeetCode Problem:** [https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/](https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/)

**Difficulty:** Easy

---

## Problem Description

Given a positive integer `n`, return `true` if `n` is divisible by the sum of its **digit sum** and **digit product**, otherwise return `false`.

- **Digit Sum:** Sum of all digits of `n`.
- **Digit Product:** Product of all digits of `n`.
- **Condition:** Return `true` if `n % (digitSum + digitProduct) == 0`.

---

## Examples

**Example 1:**

**Input:** `n = 99`  
**Output:** `true`  
**Explanation:** Digit sum = 9 + 9 = 18. Digit product = 9 × 9 = 81. div = 18 + 81 = 99. 99 % 99 == 0 → true.

---

**Example 2:**

**Input:** `n = 23`  
**Output:** `false`  
**Explanation:** Digit sum = 2 + 3 = 5. Digit product = 2 × 3 = 6. div = 5 + 6 = 11. 23 % 11 ≠ 0 → false.

---

## Approaches

---

### Approach 1: Inline Single-Pass (Active)

**Idea:**  
Extract each digit using `n % 10` and accumulate the sum and product simultaneously in a single loop. After the loop, compute `div = sum + prod` and check `n % div == 0`. A guard `div != 0` handles the edge case where a digit is `0`, making the product (and thus `div`) zero.

**Algorithm:**
1. Copy `n` into `temp`, initialize `sum = 0`, `prod = 1`.
2. While `temp > 0`:
   - Extract `digit = temp % 10`.
   - Add `digit` to `sum`; multiply `digit` into `prod`.
   - Advance: `temp /= 10`.
3. Compute `div = sum + prod`.
4. Return `div != 0 && n % div == 0`.

**Complexity:**
- **Time:** O(d) — where d is the number of digits in n.
- **Space:** O(1) — constant auxiliary space.

---

### Approach 2: Helper Method — Separate Helper for Digit Sum + Product

**Idea:**  
Same logic as Approach 1, but delegates digit extraction to a private helper method `getSumAndProd(n)` that returns the combined divisor. This improves readability and separates concerns.

**Algorithm:**
1. Call `getSumAndProd(n)` to obtain `div`.
2. Inside `getSumAndProd`: iterate digits of `n` using `% 10` and `/ 10`, accumulating `sum` and `prod`.
3. Return `sum + prod`.
4. In the main method, return `n % div == 0`.

**Complexity:**
- **Time:** O(d) — where d is the number of digits in n.
- **Space:** O(1) — constant auxiliary space.
