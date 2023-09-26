"""
백준 10989. 수 정렬하기 3

링크: https://www.acmicpc.net/problem/10989
"""

from sys import stdin

N = int(stdin.readline())
arr = [0] * 10001

for _ in range(N):
    arr[int(stdin.readline())] += 1

for i in range(10001):
    if arr[i] != 0:
        for j in range(arr[i]):
            print(i)