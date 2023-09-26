"""
백준 2018. 수들의 합 5

링크: https://www.acmicpc.net/problem/2018
"""

from sys import stdin

N = int(stdin.readline().strip())

cnt = 0
sum = 0
end = 1
for start in range(1, N+1):
    while sum < N and end < N:
        sum += end
        end += 1
    if start == end:
        sum = start
    if sum == N:
        cnt += 1
    sum -= start

print(cnt)