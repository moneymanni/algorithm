"""
백준 12891. DNA 비밀번호

링크: https://www.acmicpc.net/problem/12891
"""

from sys import stdin

S, P = map(int, stdin.readline().split())
DNAArr = list(map(str, stdin.readline().strip()))
subStr = list(map(int, stdin.readline().split()))
dic = {'A': subStr[0], 'C': subStr[1], 'G': subStr[2], 'T': subStr[3]}
base = {'A': 0, 'C': 0, 'G': 0, 'T': 0}

cnt = 0
for i in range(S-P+1):
    flag = True
    if i == 0:
        for j in range(P):
            base[DNAArr[j]] += 1
    else:
        base[DNAArr[i+P-1]] += 1
        base[DNAArr[i-1]] -= 1
    
    for j in ('A', 'C', 'G', 'T'):
        if base[j] < dic[j]:
            flag = False
            break

    if flag:
        cnt += 1

print(cnt)