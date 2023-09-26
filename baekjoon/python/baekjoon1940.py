"""
백준 1940. 주몽

링크: https://www.acmicpc.net/problem/1940
"""

from sys import stdin

N = int(stdin.readline().strip())
M = int(stdin.readline().strip())
arr = list(map(int, stdin.readline().split()))
arr.sort()

cnt = 0
start, end = 0, N - 1
while start < end:
    if arr[start] + arr[end] == M:
        cnt += 1
        start += 1
        end -= 1
    elif arr[start] + arr[end] < M:
        start += 1
    else:
        end -= 1

print(cnt)