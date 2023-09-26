"""
백준 1253. 좋다

링크: https://www.acmicpc.net/problem/1253
"""

from sys import stdin

N = int(stdin.readline().strip())
arr = list(map(int, stdin.readline().split()))
arr.sort()

cnt = 0
for i in range(N):
    temp = arr[:i] + arr[i+1:]
    start, end = 0, len(temp) - 1
    while start < end:
        t  = temp[start] + temp[end]
        if t == arr[i]:
            cnt += 1
            break
        if t < arr[i]: start += 1
        else: end -= 1

print(cnt)