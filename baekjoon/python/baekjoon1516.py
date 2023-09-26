"""
백준 1516. 게임 개발

링크: https://www.acmicpc.net/problem/1516
"""

from sys import stdin
from collections import deque
read = stdin.readline

N = int(read().strip())
A = [[] for _ in range(N + 1)]

indegree = [0 for _ in range(N + 1)]
selfBuild = [[] for _ in range(N + 1)]
time = [0 for _ in range(N + 1)]

for i in range(1, N + 1):
    temp = list(map(int, read().strip().split()))[:-1]
    time[i] = temp[0]
    selfBuild_data = temp[1:]
    for j in selfBuild_data:
        selfBuild[j].append(i)
        indegree[i] += 1

result = [0 for _ in range(N + 1)]
que = deque()

for i in range(1, N + 1):
    if indegree[i] == 0:
        que.append(i)

while que:
    temp = que.popleft()
    result[temp] += time[temp]
    for i in selfBuild[temp]:
        indegree[i] -= 1
        result[i] = max(result[i], result[temp])
        if indegree[i] == 0:
            que.append(i)

for i in range(1, len(result)):
    print(result[i])