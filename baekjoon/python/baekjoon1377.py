"""
백준 1377. 버블 소트

링크: https://www.acmicpc.net/problem/1377
"""

from sys import stdin

N = int(stdin.readline().strip())

nums = []

for i in range(N):
    num = int(stdin.readline())
    nums.append((num, i))
    
sorted_nums = sorted(nums)

answer = 0
for i in range(N):
    answer = max(sorted_nums[i][1] - i + 1, answer)
    
print(answer)