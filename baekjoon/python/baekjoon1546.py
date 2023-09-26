"""
백준 1546. 평균

링크: https://www.acmicpc.net/problem/1546
"""

from sys import stdin

N = int(stdin.readline())
arr = list(map(int, stdin.readline().split()))

M = 0
isNotZero = False
for num in arr :
    if (num < 0 or N > 100) :
        exit()
    if (num != 0) :
        isNotZero = True
    if (M < num) :
        M = num
        
if not isNotZero :
    exit()

for num in range(0,N) :
    arr[num] = arr[num]/M*100

average = 0
for num in arr :
    average += num
average = average/N

print(average)