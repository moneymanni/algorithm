"""
백준 11660. 구간 합 구하기 5

링크: https://www.acmicpc.net/problem/11660
"""

from sys import stdin

N, M = map(int, stdin.readline().split())
arr = [[0] * (N + 1)]
for i in range(N):
    arr.append([0] + list(map(int, stdin.readline().split())))

for i in range(1, N+1):
    for j in range(1, N):
        arr[i][j+1] += arr[i][j]

for i in range(1, N+1):
    for j in range(1, N):
        arr[j+1][i] += arr[j][i]

for _ in range(M):
    x1, y1, x2, y2 = map(int, stdin.readline().split())
    print(arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1])