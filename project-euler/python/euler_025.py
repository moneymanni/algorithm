"""
Problem 025. 피보나치 수열에서 처음으로 1000자리가 되는 항은 몇 번째?



## 문제
피보나치 수열은 아래와 같은 점화식으로 정의됩니다.

Fn = Fn-1 + Fn-2  (단, F1 = 1, F2 = 1).
이에 따라 수열을 12번째 항까지 차례대로 계산하면 다음과 같습니다.

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
수열의 값은 F12에서 처음으로 3자리가 됩니다.

피보나치 수열에서 값이 처음으로 1000자리가 되는 것은 몇번째 항입니까?



## 풀이
### 피보나치 수(Fibonacci numbers)
피보나치 수 Fₙ은 다음과 같은 초기값 및 점화식으로 정의되는 수열이다.

$$
F_0 = 0, \quad F_1 = 1, \quad F_n = F_{n-1} + F_{n-2} \quad (n \in \{2, 3, 4, \dots\})
$$

피보나치 수의 처음 몇 항은 (0번째 항부터 시작할 경우) 다음과 같다.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, ...
피보나치 수의 일반항은 다음과 같다.

$$
F_n = \frac{\varphi^n - (1 - \varphi)^n}{\sqrt{5}} 
= \frac{1}{\sqrt{5}} \left( \left( \frac{1 + \sqrt{5}}{2} \right)^n - \left( \frac{1 - \sqrt{5}}{2} \right)^n \right)
= \frac{(1 + \sqrt{5})^n - (1 - \sqrt{5})^n}{2^n \sqrt{5}}
$$
여기서 φ는 황금비이며, √5는 5의 제곱근이다. 이를 비네 공식(Binet's formula)이라고 한다. 
이는 레온하르트 오일러가 1765년 처음 발표했으나 잊혔다가, 1848년 자크 비네에 의해 재발견되었다.



## 출처
https://euler.synap.co.kr/problem=25
"""

import sys
from sys import stdin

mock_data = iter(['1_000'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer


def get_fibonacci_arr(limit: int) -> list[int]:
    fibo: list[int] = [0] * (limit + 1)
    
    fibo[1] = fibo[2] = 1
    
    for i in range(3, limit + 1):
        fibo[i] = fibo[i - 1] + fibo[i - 2]
    
    return fibo


def index_of_first_fibo_ge_n(n: int) -> int:
    idx = 2
    a, b = 1, 1
    
    while True:
        a, b = b, a + b
        idx += 1
        if len(str(b)) >= n:
            break
    
    return idx


from sys import stdin

limit_num: int = int(stdin.readline())

print(index_of_first_fibo_ge_n(limit_num))
