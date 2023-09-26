"""
백준 1931. 회의실 배정

링크: https://www.acmicpc.net/problem/1931
"""

from sys import stdin
read = stdin.readline

N = int(read().strip())
A = list()
for _ in range(N):
    A.append(list(map(int, read().split())))

A.sort(key= lambda x: (x[1], x[0]))

cnt, end = 0, -1
for i in range(N):
    if A[i][0] >= end:
        end = A[i][1]
        cnt += 1

print(cnt)