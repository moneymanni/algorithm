"""
백준 1167. 트리의 지름

링크: https://www.acmicpc.net/problem/1167
"""

from collections import deque
from sys import stdin
readline = stdin.readline

def BFS(vertex):
    visited = [-1] * (V + 1)
    que = deque()
    que.append(vertex)
    visited[vertex] = 0
    maximum = [0, 0]

    while que:
        temp = que.popleft()
        for i, j in graph[temp]:
            if visited[i] == -1:
                visited[i] = visited[temp] + j
                que.append(i)
                if maximum[0] < visited[i]:
                    maximum = visited[i], i

    return maximum

V = int(readline())
graph = [[] for _ in range(V + 1)]
for _ in range(V):
    temp = list(map(int, readline().split()))
    for i in range(1, len(temp) - 2, 2):
        graph[temp[0]].append((temp[i], temp[i + 1]))

dis, node = BFS(1)
dis, node = BFS(node)
print(dis)