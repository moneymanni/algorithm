"""
백준 13023. ABCDE

링크: https://www.acmicpc.net/problem/13023
"""

from sys import stdin

N, M = map(int, stdin.readline().split())
graph = [[] for _ in range(N)]
visited = [False] * N

def DFS(v, depth):
    if depth == 4:
        print(1)
        exit()

    for j in graph[v]:
        if not visited[j]:
            visited[j] = True
            DFS(j, depth + 1)
            visited[j] = False


for _ in range(M):
    a, b = map(int, stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)


for i in range(N):
    visited[i] = True
    DFS(i, 0)
    visited[i] = False

print(0)