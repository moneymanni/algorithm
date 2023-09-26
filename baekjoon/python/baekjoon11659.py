"""
백준 11659. 구간 합 구하기 4

링크: https://www.acmicpc.net/problem/11659
"""

from sys import stdin

N, M = map(int, stdin.readline().split())
arr = list(map(int, stdin.readline().split()))

sum = 0
sum_arr = list()
for i in range(N):
    sum += arr[i]
    sum_arr.append(sum)

for i in range(M):
    start, end = map(int, stdin.readline().split())
    if start == 1:
        result = sum_arr[end-1]
    else:
        result = sum_arr[end-1] - sum_arr[start-2]
    print(result)