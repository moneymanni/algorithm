"""
백준 17298. 오큰수

링크: https://www.acmicpc.net/problem/17298
"""

from sys import stdin

N = int(stdin.readline().strip())
A = list(map(int, stdin.readline().split()))

stack = list()
nge = [-1 for _ in range(N)]

stack.append(0)
for i in range(1, N):
    while stack and A[stack[-1]] < A[i]:
        nge[stack.pop()] = A[i]
    stack.append(i)

print(*nge)