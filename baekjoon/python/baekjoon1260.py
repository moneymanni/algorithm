"""
백준 1260. DFS와 BFS

링크: https://www.acmicpc.net/problem/1260
"""

from collections import deque
from sys import stdin
readline = stdin.readline

def BFS(vertex):
    que = deque()
    que.append(vertex)
    visited[vertex] = 1
    
    while que:
        vertex = que.popleft()
        print(vertex, end = " ")

        for i in range(1, N + 1):
            if visited[i] == 0 and graph[vertex][i] == 1:
                que.append(i)
                visited[i] = 1

def DFS(vertex):
    visited[vertex] = 1
    print(vertex, end = " ")
    for i in range(1, N + 1):
        if visited[i] == 0 and graph[vertex][i] == 1:
            DFS(i)

N, M, V = map(int, readline().split())
graph = [[0] * (N + 1) for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, readline().split())
    graph[a][b] = graph[b][a] = 1

visited = [0] * (N + 1)
DFS(V)
print()
visited = [0] * (N + 1)
BFS(V)