"""
백준 1715. 카드 정렬하기

링크: https://www.acmicpc.net/problem/1715
"""

import heapq
from sys import stdin
read = stdin.readline

N = int(read().strip())
A = list()
for _ in range(N): heapq.heappush(A, int(read().strip()))

deck1, deck2, sum = 0, 0, 0
while len(A) != 1:
    deck1 = heapq.heappop(A)
    deck2 = heapq.heappop(A)
    sum += deck1 + deck2
    heapq.heappush(A, deck1 + deck2)

print(sum)