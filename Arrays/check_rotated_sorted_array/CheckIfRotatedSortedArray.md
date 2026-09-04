# Check if Array Is Sorted and Rotated

**Difficulty:** Easy
**Topic:** Arrays / Circular Array

## Problem

Given an array `nums`, return `true` if it was originally sorted in non-decreasing
order and then rotated some number of positions (including zero). Otherwise,
return `false`. Duplicates may exist.

### Examples

```
Input:  [3,4,5,1,2]   → Output: true   (rotate [1,2,3,4,5] by 2)
Input:  [2,1,3,4]     → Output: false
Input:  [1,2,3]       → Output: true   (rotated by 0)
```

### Constraints

```
1 <= nums.length <= 100
1 <= nums[i] <= 100
```

## Key Idea

Think of the array as **circular** — the last element connects back to the
first. Walk through the array and count how many times an element is
**strictly greater** than the next one (a "drop" / break in the increasing
order). Wrap around from the last index back to index 0 as well.

- A normal sorted array has **0 drops**.
- A rotated sorted array has **exactly 1 drop** (the point where it was cut).
- Anything with **2 or more drops** cannot be a rotated sorted array.

```
nums = [3, 4, 5, 1, 2]
3→4 ok, 4→5 ok, 5→1 DROP (1), 1→2 ok, 2→3 (wraparound) ok
Total drops = 1 → true

nums = [2, 1, 3, 4]
2→1 DROP (1), 1→3 ok, 3→4 ok, 4→2 (wraparound) DROP (2)
Total drops = 2 → false
```

## Common Mistakes

1. **Forgetting the wraparound (circular) check** — must also compare the
   last element with the first.
2. **Using `>=` instead of `>`** — duplicates (e.g. `[1,1,1,1]`) are valid,
   so equal adjacent values should NOT count as a drop.
3. **Wrong modulo placement** — `nums[i+1] % nums.length` is WRONG because
   Java evaluates `nums[i+1]` first (array access) before applying `%`,
   which crashes with `ArrayIndexOutOfBoundsException` when `i` is the last
   index. The fix is `nums[(i+1) % nums.length]` — compute the wrapped
   index first, *then* access the array.

## What `% n` (modulo) Does

`%` gives the remainder of a division. For array indices, `% n` (where `n`
is the array length) keeps any index inside the valid range `0` to `n-1`,
wrapping it back to `0` once it reaches `n`. It behaves like a clock with
`n` numbers on it: `n % n = 0`, `(n+1) % n = 1`, and so on. This is exactly
what's needed to connect the last index back to index 0 for the circular
check.

## Final Java Solution

```java
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int breakCount = 0;

        for (int i = 0; i < n; i++) {
            // compare current element with the next one (wraps around at the end)
            if (nums[i] > nums[(i + 1) % n]) {
                breakCount++;
            }
        }

        return breakCount <= 1;
    }
}
```

**Complexity:** O(n) time, O(1) space — single pass, no extra data structures.

## Pattern

This falls under the **Circular Array** pattern — whenever a problem
mentions "rotated" or wraps values from end back to start, use
`(i + 1) % n` to connect the last element to the first instead of treating
the array as a plain straight line.
