"""
백준 1300. K번째 수

링크: https://www.acmicpc.net/problem/1300
"""

from sys import stdin
read = stdin.readline

N, k = int(read().strip()), int(read().strip())

start, end = 1, k
answer = 0

while start <= end:
    mid = (start + end) // 2
    cnt = 0

    for i in range(1, N + 1):
        cnt += min(mid//i, N)
    if cnt < k:
        start = mid + 1
    else:
        end = mid - 1
        answer = mid

print(answer)