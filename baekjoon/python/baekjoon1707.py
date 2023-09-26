"""
백준 1707. 이분 그래프

링크: https://www.acmicpc.net/problem/1707
"""

from sys import stdin, setrecursionlimit
setrecursionlimit(1000000)
readline = stdin.readline

K = int(readline().strip())

def DFS(node, group):
    visited[node] = group
    
    for i in graph[node]:
        if not visited[i]:
            temp = DFS(i, -group)
            if not temp:
                return False
        elif visited[i] == visited[node]:
            return False
    return True

for _ in range(K):
    V, E = map(int, readline().split())
    graph = [[] for _ in range(V + 1)]
    visited = [False] * (V + 1)
    for _ in range(E):
        a, b = map(int, readline().split())
        graph[a].append(b)
        graph[b].append(a)
    
    for i in range(1, V + 1):
        if not visited[i]:
            answer = DFS(i, 1)
            if not answer:
                break
    if answer:
        print('YES')
    else:
        print('NO')