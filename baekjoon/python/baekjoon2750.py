"""
백준 2750. 수 정렬하기

링크: https://www.acmicpc.net/problem/2750
"""

from sys import stdin

N = int(stdin.readline().strip())
M = [int(stdin.readline().strip()) for _ in range(N)]

for i in range(len(M)):
    for j in range(len(M)):
        if M[i] < M[j]:
            M[i], M[j] = M[j], M[i]

for i in M:
    print(i)