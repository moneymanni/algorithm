"""
백준 11004. K번째 수

링크: https://www.acmicpc.net/problem/11004
"""

from sys import stdin
import copy

N, K = map(int, stdin.readline().rstrip().split())
arr = list(map(int, stdin.readline().rstrip().split()))

def Solution(K, arr) :
    arr.sort()
    return print(arr[K-1])

Solution(copy.copy(K), copy.copy(arr))