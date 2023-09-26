"""
백준 11286. 절댓값 힙 

링크: https://www.acmicpc.net/problem/11286
"""

import heapq
from sys import stdin

N = int(stdin.readline().strip())
heap = []

for _ in range(N):
    temp = int(stdin.readline().strip())
    if temp != 0:
        heapq.heappush(heap, (abs(temp), temp))
    else:
        if not heap:
            print(0)
        else:
            print(heapq.heappop(heap)[1])