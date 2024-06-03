# Recursion

## Visualizing Binary Search

![](image17.png)

## Analyzing Binary Search

Runs in O(log n) time.

- In the worst case scenario, low = 0, high = n-1
- At each step, divide the search region by 2
- Let k be the number of steps or levels:
- mid = (low+high)/2 = (n-1)/2𝟏
- mid = (n-1)/2𝟐
- mid = (n-1)/2𝟑
- ......
- mid = (n-1)/𝟐𝒌 ≥ 1 → (n-1) ≥ 2𝑘 → n ≥ 2𝑘 → log(n) ≥ k log(2) → log(n) ≥ k

Hence, there can be at most log n levels

