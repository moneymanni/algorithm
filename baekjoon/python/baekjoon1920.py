"""
백준 1920. 수 찾기

링크: https://www.acmicpc.net/problem/1920
"""

from sys import stdin
readline = stdin.readline

N = int(readline())
A = sorted(list(map(int, readline().split())))
M = int(readline())
search = list(map(int, readline().split()))

def binary(target):
    start = 0
    end = N - 1

    while start <= end:
        mid = (start + end) // 2

        if A[mid] == target:
            return True
        
        if target < A[mid]:
            end = mid - 1
        elif target > A[mid]:
            start = mid + 1

for i in range(M):
    if binary(search[i]):
        print(1)
    else:
        print(0)