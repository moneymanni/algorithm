"""
백준 11003. 최솟값 찾기

링크: https://www.acmicpc.net/problem/11003
"""

from collections import deque
from sys import stdin

N, L = map(int, stdin.readline().split())
arr = list(map(int, stdin.readline().split()))
window = deque()
for i in range(N):
    temp = arr[i]

    while window and window[-1] > temp: window.pop()
    window.append(temp)

    if i >= L and window[0] == arr[i - L]: window.popleft()
    print(window[0], end=' ')