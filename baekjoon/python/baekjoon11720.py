"""
백준 11720. 숫자의 합

링크: https://www.acmicpc.net/problem/11720
"""

from sys import stdin

N = int(stdin.readline())

arr = list(map(int, stdin.readline()))

sum = 0
for num in arr:
    sum += num

print(sum)