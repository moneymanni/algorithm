"""
Problem 020. 100! 의 자릿수를 모두 더하면?



## 문제
n! 이라는 표기법은 n × (n − 1) × ... × 3 × 2 × 1을 뜻합니다.

예를 들자면 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800 이 되는데,
여기서 10!의 각 자릿수를 더해 보면 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27 입니다.

100! 의 자릿수를 모두 더하면 얼마입니까?



## 풀이
### 계승, 팩토리얼(factorial)
계승은 그 수보다 작거나 같은 모든 양의 정수의 곱이다. 
기호는 !을 쓰며 팩토리얼이라고 읽는다. 
팩토리얼(프랑스어: factorielle 팍토리엘)이라는 이름은 프랑스의 루이 프랑수아 앙투안 아르보가(Louis François Antoine Arbogast)가 사용하였다. 느낌표 표기법은 1808년 수학자 크리스티앙 크랑(Christian Kramp)이 저서 《보편 산술 원론》에서 처음으로 사용하였다.

0!=1이고, 1이상의 자연수 n의 계승 n!은 다음과 같이 정의된다.

$$
n! = \prod_{k=1}^{n} k = n \cdot (n - 1) \cdot (n - 2) \cdot \ldots \cdot 3 \cdot 2 \cdot 1
$$


## 출처
https://euler.synap.co.kr/problem=20
"""

import sys
from sys import stdin

mock_data = iter(['100'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer


def factorial_topdown(num: int) -> int:
    if num == 1:
        return 1
    
    return num * factorial_topdown(num - 1)


def factorial_bottomup(num: int) -> int:
    dp: list[int] = [i for i in range(num + 1)]
    
    for i in range(2, num + 1):
        dp[i] = dp[i] * dp[i - 1]
    
    return dp[num]


def sum_of_digits(num: int) -> int:
    return sum(map(int, str(num)))
    

from sys import stdin

num: int = int(stdin.readline())

fac: int = factorial_bottomup(100)
result: int = sum_of_digits(fac)

print(result)
