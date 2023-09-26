"""
백준 11724. 연결 요소의 개수

링크: https://www.acmicpc.net/problem/11724
"""

import sys
from sys import stdin, setrecursionlimit
setrecursionlimit(10000)

N, M = map(int, stdin.readline().split())
A = [[] for _ in range(N+1)]
visited = [False] * (N + 1)
cnt = 0

def DFS(v):
    visited[v] = True
    for i in A[v]:
        if not visited[i]:
            DFS(i)

for i in range(M):
    u, v = map(int, stdin.readline().split())
    A[u].append(v)
    A[v].append(u)

for i in range(1, N+1):
    if not visited[i]:
        cnt += 1
        DFS(i)

print(cnt)