"""
Problem 012. 500개 이상의 약수를 갖는 가장 작은 삼각수는?



## 문제
1부터 n까지의 자연수를 차례로 더하여 구해진 값을 삼각수라고 합니다.
예를 들어 7번째 삼각수는 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28이 됩니다.
이런 식으로 삼각수를 구해 나가면 다음과 같습니다.

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
이 삼각수들의 약수를 구해 봅시다.

 1: 1
 3: 1, 3
 6: 1, 2, 3, 6
10: 1, 2, 5, 10
15: 1, 3, 5, 15
21: 1, 3, 7, 21
28: 1, 2, 4, 7, 14, 28

위에서 보듯이, 5개 이상의 약수를 갖는 첫번째 삼각수는 28입니다.

그러면 500개 이상의 약수를 갖는 가장 작은 삼각수는 얼마입니까?



## 풀이
### 삼각수(triangular number)
1부터 시작하는 연속된 자연수의 합을 나타내는 수로 처음 몇 삼각수는 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120, 136, 153, 171, 190, ... 이다. 
삼각수는 다음 공식으로 구할 수 있다.

$$
1 + 2 + 3 + \cdots + n = \frac{n(n+1)}{2} = \frac{n^2 + n}{2} = \binom{n+1}{2}
$$

일화에 의하면, 카를 프리드리히 가우스는 10살 때 1부터 100까지의 자연수를 모두 더하라는 선생님의 말을 듣고, 이러한 합을 1+100, 2+99와 같이 합이 101이 되는 50쌍의 수의 합으로 전환하여 5050임을 구하였다.


### 약수 함수(Divisor function)
자연수 \( n \)의 약수의 개수, 약수의 합 등 약수의 \( x \)거듭제곱의 합을 약수 함수 \( \sigma_x(n) \)라 한다.  
즉,  
\[
\sigma_x(n) = \sum_{d \mid n} d^x
\]  
여기서 \( d \)는 \( n \)의 약수이고, \( n \)을 소인수분해한 결과가  
\[
n = \prod_{i=1}^r p_i^{a_i}
\]  
일 때, 약수 함수는 다음과 같다:

\[
\sigma_x(n) = \prod_{i=1}^r \sum_{j=0}^{a_i} p_i^{jx} = \prod_{i=1}^r (1 + p_i^x + p_i^{2x} + \cdots + p_i^{a_i x})
\]

이를 다음처럼 더 간단하게 표현할 수 있다:

\[
\sigma_x(n) = \prod_{i=1}^r \frac{p_i^{(a_i+1)x} - 1}{p_i^x - 1}
\]

이 경우는 약수의 개수를 의미하며, 보통 \( \tau(n) \) 또는 \( d(n) \)으로도 표현한다:

\[
\sigma_0(n) = \prod_{i=1}^r (a_i + 1)
\]



## 출처
https://euler.synap.co.kr/problem=12
"""


import sys
from sys import stdin

mock_data = iter(['500'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer


def get_factors(num: int) -> list[int]:
    factors: list[int] = list()
    
    if num < 2:
        return None
    
    for i in range (1, num + 1):
        if num % i == 0:
             factors.append(i)
        
    return factors


def is_triangular_num(num: int) -> bool:
    factors: list[int] = get_factors(num)
    
    sum_factors: int = sum(factors)
    
    return num == sum_factors - num


def count_divisors(num: int) -> int:
    import math
    
    count: int = 0
    sqrt_num: int = int(math.sqrt(num))
    
    for i in range(1, sqrt_num + 1):
        if num % i == 0:
            count += 2 if i != num // i else 1
    
    return count


def find_triangle_with_divisors(limit: int) -> int:
    num: int = 1
    
    while True:
        triangle: int = num * (num + 1) // 2
        
        if num % 2 == 0:
            div_count: int = count_divisors(num // 2) * count_divisors(num + 1)
        else:
            div_count: int = count_divisors(num) * count_divisors((num + 1) // 2)
        
        if div_count >= limit:
            return triangle
        
        num += 1


from sys import stdin

num: int = int(stdin.readline())

print(find_triangle_with_divisors(num))
