"""
백준 1874. 스택 수열 

링크: https://www.acmicpc.net/problem/1874
"""

from sys import stdin

N = int(stdin.readline().strip())
arr = [int(stdin.readline().strip()) for _ in range(N)]

cnt, flag = 1, True
stack, answer = list(), list()
for i in range(N):
    while cnt <= arr[i]:
        stack.append(cnt)
        answer.append('+')
        cnt += 1
    
    if stack[-1] == arr[i]:
        stack.pop()
        answer.append('-')
    else:
        print('NO')
        flag = False
        break

if flag:
    for i in answer: print(i)