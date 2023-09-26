"""
백준 1541. 잃어버린 괄호

링크: https://www.acmicpc.net/problem/1541
"""

from sys import stdin
readline = stdin.readline

arr = [sum(map(int, x.split('+'))) for x in readline().split('-')]
print(arr[0] - sum(arr[1:]))