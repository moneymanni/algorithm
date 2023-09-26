"""
백준 1976. 여행 가자

링크: https://www.acmicpc.net/problem/1976
"""

from sys import stdin
read = stdin.readline

def find(a):
    if a == parent[a]: return a
    else:
        parent[a] = find(parent[a])
        return parent[a]

def union(a, b):
    a, b = find(a), find(b)
    if a < b: parent[b] = a
    else: parent[a] = b

N, M = int(read().strip()), int(read().strip())
parent = [i for i in range(N)]
for i in range(N):
    temp = list(map(int, read().strip().split()))
    for j in range(N):
        if temp[j] == 1:
            union(i, j)

parent = [-1] + parent
route = list(map(int, read().strip().split()))
start = parent[route[0]]
for i in range(1, M):
    if parent[route[i]] != start:
        print('NO')
        break
else: print('YES')