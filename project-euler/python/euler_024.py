"""
Problem 024. 0, 1, 2, 3, 4, 5, 6, 7, 8, 9로 만들 수 있는 1,000,000번째 사전식 순열은?



## 문제
어떤 대상을 순서에 따라 배열한 것을 순열이라고 합니다. 
예를 들어 3124는 숫자 1, 2, 3, 4로 만들 수 있는 순열 중 하나입니다.

이렇게 만들 수 있는 모든 순열을 숫자나 문자 순으로 늘어놓은 것을 사전식(lexicographic) 순서라고 합니다.
0, 1, 2로 만들 수 있는 사전식 순열은 다음과 같습니다.

012   021   102   120   201   210

0, 1, 2, 3, 4, 5, 6, 7, 8, 9로 만들 수 있는 사전식 순열에서 1,000,000번째는 무엇입니까?



## 풀이



## 출처
https://euler.synap.co.kr/problem=24
"""

import sys
from sys import stdin

mock_data = iter(['1_000_000', '0 1 2 3 4 5 6 7 8 9'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer


def get_lexicographic(nums: list[int]) -> list[str]:
    """깊이 우선 탐색을 이용하여 주어진 숫자 리스트로 만들 수 있는 모든 사전식 순열을 구한다.

    Args:
        nums (list[int]): 순열을 만들 숫자들의 리스트

    Returns:
        list[str]: 사전식(사전 순)으로 정렬된 모든 순열을 문자열 형태로 담은 리스트 반환
    """
    nums.sort()
    
    size: int = len(nums)
    lexicographic: list[str] = [0]
    arr: list[int] = [0] * size
    visited: list[bool] = [False] * size
    
    def dfs(depth: int):
        if depth == size:
            string: str = ''.join(map(str, arr))
            lexicographic.append(string)
            return
        
        for i in range(size):
            if not visited[i]:
                visited[i] = True
                arr[depth] = nums[i]
                dfs(depth + 1)
                visited[i] = False
    
    dfs(0)
    
    return lexicographic


def get_nth_lexicographic_permutation(digits: list[int], n: int) -> str:
    """주어진 숫자들로 만들 수 있는 순열 중에서 n번째 사전식 순열을 구한다.

    Args:
        digits (list[int]): 순열을 만들 숫자들의 리스트
        n (int): 찾고자 하는 순열의 번호

    Returns:
        str: 사전식으로 정렬했을 때 n번째에 해당하는 순열을 문자열 형태로 반환
    """
    import math
    
    n -= 1
    result: list[int] = []
    available: list[int] = sorted(digits)
    
    for i in range(len(digits) - 1, -1, -1):
        fact: int =  math.factorial(i)
        idx: int = n // fact
        n %= fact
        
        result.append(available.pop(idx))
    
    return ''.join(map(str, result))


from sys import stdin

num: int = int(stdin.readline())
digits: list[int] = list(map(int, stdin.readline().split()))

# lexicographic: list[int] = get_lexicographic(digits)
# print(lexicographic[num])

result: int = get_nth_lexicographic_permutation(digits, num)
print(result)
