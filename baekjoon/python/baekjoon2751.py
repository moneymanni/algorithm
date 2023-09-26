"""
백준 2751. 수 정렬하기 2

링크: https://www.acmicpc.net/problem/2751
"""

from sys import stdin

N = int(stdin.readline().strip())
arr = [int(stdin.readline().strip()) for _ in range(N)]

def merge(left, right):
    i, j = 0, 0
    temp = []
    while i < len(left) and j < len(right):
        if left[i] > right[j]:
            temp.append(right[j])
            j += 1
        else:
            temp.append(left[i])
            i += 1
    
    if i == len(left):
        temp.extend(right[j:])
    else:
        temp.extend(left[i:])
    return temp

def merge_sort(list):
    if len(list) <= 1:
        return list
    else:
        mid = len(list) // 2
        left = merge_sort(list[:mid])
        right = merge_sort(list[mid:])
        return merge(left, right)

arr = merge_sort(arr)
for i in arr: print(i)