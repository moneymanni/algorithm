"""
백준 1717. 집합의 표현

링크: https://www.acmicpc.net/problem/1717
"""

from sys import stdin
read = stdin.readline

N, M = map(int, read().split())
parent = [i for i in range(N+1)]

def find(a):
    if a == parent[a]:
        return a
    else:
        parent[a] = find(parent[a])
        return parent[a]

def checkSame(a, b):
    a, b = find(a), find(b)
    if a == b:
        return True
    else:
        return False

def union(a, b):
    a, b = find(a), find(b)
    if a != b:
        parent[b] = a


for i in range(M):
    question, a, b = map(int, read().split())
    if question == 0:
        union(a, b)
    else:
        if checkSame(a, b):
            print('YES')
        else:
            print('NO')