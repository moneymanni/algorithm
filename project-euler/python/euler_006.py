"""
Problem 006. 1부터 100까지 "제곱의 합"과 "합의 제곱"의 차는?



## 문제
1부터 10까지 자연수를 각각 제곱해 더하면 다음과 같습니다 (제곱의 합).

1² + 2² + ... + 10² = 385
1부터 10을 먼저 더한 다음에 그 결과를 제곱하면 다음과 같습니다 (합의 제곱).

(1 + 2 + ... + 10)² = 55² = 3025
따라서 1부터 10까지 자연수에 대해 "합의 제곱"과 "제곱의 합" 의 차이는 3025 - 385 = 2640 이 됩니다.

그러면 1부터 100까지 자연수에 대해 "합의 제곱"과 "제곱의 합"의 차이는 얼마입니까?



## 풀이
처음 n개 자연수의 p거듭제곱의 합은 (p+1)차 다항식으로 표현될 수 있다.
$$
\sum_{k=1}^{n} k^p = 1^p + 2^p + 3^p + \cdots + n^p = \frac{n^{p+1}}{p+1} + \frac{1}{2}n^p + \sum_{k=2}^{p} \frac{B_k}{k!}p_k n^{p-k+1}
$$

처음 몇 가지 예는 아래와 같다:

- $1 + 2 + 3 + \cdots + n = \frac{n(n + 1)}{2} = \frac{n^2 + n}{2}$
- $1^2 + 2^2 + 3^2 + \cdots + n^2 = \frac{n(n + 1)(2n + 1)}{6} = \frac{2n^3 + 3n^2 + n}{6}$
- $1^3 + 2^3 + 3^3 + \cdots + n^3 = \left[ \frac{n(n + 1)}{2} \right]^2 = \frac{n^4 + 2n^3 + n^2}{4}$  
...

이 공식을 독일 수학자 파울하버(Johann Faulhaber)의 이름을 따서 파울하버 공식 또는 스위스 수학자 베르누이(Jacob Bernoulli)의 이름을 따서 베르누이 공식이라고도 부른다.



## 출처
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
