"""
백준 1744. 수 묶기

링크: https://www.acmicpc.net/problem/1744
"""

from sys import stdin
read = stdin.readline

N = int(read().strip())
plus, minus, zero, sum = list(), list(), 0, 0
for _ in range(N):
    temp = int(read().strip())
    if temp > 1: plus.append(temp)
    elif temp == 1: sum += 1
    else: minus.append(temp)
plus.sort(reverse=True)
minus.sort()

if len(plus) % 2 == 0:
    for i in range(0, len(plus), 2):
        sum += plus[i] * plus[i + 1]
else:
    for i in range(0, len(plus) - 1, 2):
        sum += plus[i] * plus[i + 1]
    sum += plus[len(plus) - 1]

if len(minus) % 2 == 0:
    for i in range(0, len(minus), 2):
        sum += minus[i] * minus[i + 1]
else:
    for i in range(0, len(minus) - 1, 2):
        sum += minus[i] * minus[i + 1]
    sum += minus[len(minus) - 1]

print(sum)