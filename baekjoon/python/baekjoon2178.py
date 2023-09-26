"""
백준 2178. 미로 탐색

링크: https://www.acmicpc.net/problem/2178
"""

from collections import deque
from sys import stdin
readline = stdin.readline

dx = [-1, 1, 0, 0] 
dy = [0, 0, -1, 1]

def BFS(x, y):
  que = deque()
  que.append((x, y))

  while que:
    x, y = que.popleft()
    
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1:
        graph[nx][ny] = graph[x][y] + 1
        que.append((nx, ny))
    
  return graph[N-1][M-1]

N, M = map(int, readline().split())
graph = list()
for _ in range(N):
  graph.append(list(map(int, readline().rstrip())))

print(BFS(0, 0))