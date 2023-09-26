"""
백준 1043. 거짓말

링크: https://www.acmicpc.net/problem/1043
"""

from sys import stdin
read = stdin.readline

N, M = map(int, read().split())
trueP = set(read().split()[1:])
parties = list()

for _ in range(M):
    parties.append(set(read().split()[1:]))

for _ in range(M):
    for party in parties:
        if party & trueP:
            trueP = trueP.union(party)

cnt = 0
for party in parties:
    if party & trueP:
        continue
    cnt += 1

print(cnt)