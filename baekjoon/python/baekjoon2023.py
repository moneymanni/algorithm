"""
백준 2023. 신기한 소수

링크: https://www.acmicpc.net/problem/2023
"""

from sys import stdin

N = int(stdin.readline().strip())

def isPrime(num):
    for i in range(2, int(num ** 0.5) + 1):
        if int(num) % i == 0:
            return False
    return True

def DFS(num):
    if len(str(num)) == N:
        print(num)
    else:
        for i in range(10):
            temp = num * 10 + i
            if isPrime(temp):
                DFS(temp)

DFS(2)
DFS(3)
DFS(5)
DFS(7)