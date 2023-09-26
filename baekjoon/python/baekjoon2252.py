"""
백준 2252. 줄 세우기

링크: https://www.acmicpc.net/problem/2252
"""

from sys import stdin
from collections import deque
read = stdin.readline

N, M = map(int, read().split())
A = [[] for _ in range(N + 1)]
indegree = [0 for _ in range(N + 1)]
que = deque()
answer = list()

for i in range(M):
    a, b = map(int, read().split())
    A[a].append(b)
    indegree[b] += 1

for i in range(1, N + 1):
    if indegree[i] == 0:
        que.append(i)

while que:
    temp = que.popleft()
    answer.append(temp)
    for i in A[temp]:
        indegree[i] -= 1
        if indegree[i] == 0:
            que.append(i)

print(*answer)