"""
백준 11047. 

링크: https://www.acmicpc.net/problem/11047
"""

from sys import stdin
read = stdin.readline

N, K = map(int, read().split())
A = [int(read().strip()) for _ in range(N)]

cnt = 0
for i in reversed(range(N)):
    if A[i] <= K:
        cnt += K // A[i]
        K = K % A[i]
