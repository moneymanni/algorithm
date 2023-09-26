"""
백준 2343. 기타 레슨

링크: https://www.acmicpc.net/problem/2343
"""

from sys import stdin
read = stdin.readline

N, M = map(int, read().split())
A = list(map(int, read().split()))
left, right = max(A), sum(A)

while left <= right:
    mid = (left + right) // 2
    sum, temp = 0, 0
    for i in range(N):
        if temp + A[i] > mid:
            sum += 1
            temp = 0
        temp += A[i]
    sum += 1 if temp else 0

    if sum <= M:
        right = mid - 1
    else:
        left = mid + 1

print(left)