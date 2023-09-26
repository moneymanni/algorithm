"""
백준 1517. 버블소트

링크: https://www.acmicpc.net/problem/1517
"""

from sys import stdin

N = int(stdin.readline())
arr = list(map(int, stdin.readline().split()))
swapCnt = 0

def mergeSort(prev, next):
    global swapCnt, arr

    if prev < next:
        mid = (prev + next) // 2
        mergeSort(prev, mid)
        mergeSort(mid + 1, next)

        P, M = prev, mid + 1
        tmp = []

        while P <= mid and M <= next:
            if arr[P] <= arr[M]:
                tmp.append(arr[P])
                P += 1
            else:
                tmp.append(arr[M])
                M += 1
                swapCnt += (mid - P + 1)

        if P <= mid:
            tmp = tmp + arr[P:mid + 1]
        if M <= next:
            tmp = tmp + arr[M:next + 1]
        
        for i in range(len(tmp)):
            arr[prev + i] = tmp[i]

mergeSort(0, N - 1)
print(swapCnt)