"""
Problem 006. 1부터 100까지 "제곱의 합"과 "합의 제곱"의 차는?


### 문제
1부터 10까지 자연수를 각각 제곱해 더하면 다음과 같습니다 (제곱의 합).

1² + 2² + ... + 10² = 385
1부터 10을 먼저 더한 다음에 그 결과를 제곱하면 다음과 같습니다 (합의 제곱).

(1 + 2 + ... + 10)² = 55² = 3025
따라서 1부터 10까지 자연수에 대해 "합의 제곱"과 "제곱의 합" 의 차이는 3025 - 385 = 2640 이 됩니다.

그러면 1부터 100까지 자연수에 대해 "합의 제곱"과 "제곱의 합"의 차이는 얼마입니까?


### 풀이


### 출처
https://euler.synap.co.kr/problem=6
"""

import sys
from sys import stdin

mock_data = iter(['100'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer

from sys import stdin

def get_sum_of_squares(end: int) -> int:
    num: int = 0
    
    for i in range(1, end + 1):
        num += i * i
    
    return num


def get_square_of_sum(end: int) -> int:
    num: int = 0
    
    for i in range(1, end + 1):
        num += i
    
    return num * num


num: int = int(stdin.readline())

print(get_square_of_sum(num) - get_sum_of_squares(num))
