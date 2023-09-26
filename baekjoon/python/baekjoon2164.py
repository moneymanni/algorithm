"""
백준 2164. 카드2

링크: https://www.acmicpc.net/problem/2164
"""

from collections import deque
from sys import stdin

N = int(stdin.readline().strip())
deque = deque([i for i in range(1, N+1)])

while len(deque) > 1:
    deque.popleft()
    num = deque.popleft()
    deque.append(num)

print(deque[0])