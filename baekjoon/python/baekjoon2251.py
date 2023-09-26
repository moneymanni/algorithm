"""
백준 2251. 물통

링크: https://www.acmicpc.net/problem/2251
"""

from collections import deque
from sys import stdin
readline = stdin.readline

def pour(x, y):
    if not visited[x][y]:
        visited[x][y] = True
        que.append((x, y))

def BFS():
    while que:
        x, y = que.popleft()
        z = C - x - y

        if x == 0:
            answer.append(z)

        water = min(x, B - y)
        pour(x - water, y + water)
        water = min(x, C - z)
        pour(x - water, y)
        water = min(y, A - x)
        pour(x + water, y - water)
        water = min(y, C - z)
        pour(x, y - water)
        water = min(z, A - x)
        pour(x + water, y)
        water = min(z, B - y)
        pour(x, y + water)

A, B, C = map(int, readline().split())

que = deque()
que.append((0, 0))

visited = [[False] * (B + 1) for _ in range(A + 1)]
visited[0][0] = True

answer = []

BFS()

answer.sort()
for temp in answer:
    print(temp, end = ' ')