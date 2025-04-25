"""
Problem 016. 2¹⁰⁰⁰의 각 자릿수를 모두 더하면?



## 문제
2¹⁵ = 32768 의 각 자릿수를 더하면 3 + 2 + 7 + 6 + 8 = 26 입니다.
2¹⁰⁰⁰의 각 자릿수를 모두 더하면 얼마입니까?



## 풀이
### 숫자의 거듭제곱 계산(computing powers of a number)
x를 n번 곱한 수를 xⁿ이라 한다.  
현재의 거듭제곱 표기법은 데카르트가 만들었다.  
x가 실수, n이 정수일 때, xⁿ 계산은 재귀적으로 다음과 같이 한다:

---

1. n이 0이면, x의 값이 무엇이든 간에  
   \[
   x^0 = 1
   \]

2. n이 양수이면:
   1. n이 **짝수**일 때:  
      \[
      x^n = x^{n/2} \cdot x^{n/2}
      \]
   2. n이 **홀수**일 때:  
      \[
      x^n = x^{n-1} \cdot x
      \]

3. n이 음수이면:  
   \[
   x^n = \frac{1}{x^{-n}}
   \]




## 출처
https://euler.synap.co.kr/problem=15
"""


import sys
from sys import stdin

mock_data = iter(['1_000'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer

def digit_sum_of_power(base: int, exp: int) -> int:
    return sum(map(int, str(base ** exp)))

def compute_pow_of_num_top_down(base: int, exp: int) -> int:
    if (exp == 0):
        return 1
    
    if (exp % 2 == 0):
        half: int = compute_pow_of_num_top_down(base, exp // 2)
        return half * half
    else:
        return compute_pow_of_num_top_down(base, exp - 1) * base


def compute_pow_of_num_bottom_up(base: int, exp: int) -> int:
    result: int = 1
    
    while exp > 0:
        if exp % 2 == 1:
            result *= base
            
        base *= base
        exp //= 2
    
    return result


from sys import stdin

num: int = int(stdin.readline())

print(digit_sum_of_power(2, num))
