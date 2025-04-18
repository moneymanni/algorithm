"""
Problem 010. 이백만 이하 소수의 합



## 문제
10 이하의 소수를 모두 더하면 2 + 3 + 5 + 7 = 17 이 됩니다.

이백만(2,000,000) 이하 소수의 합은 얼마입니까?



## 풀이
### 소수의 합(prime sums)
처음 n
개 소수의 합은, n
이 작은 경우 에라토스테네스의 체 등으로 직접 구하는 것이 빠르고, n이 매우 클 경우는 어림할 수 밖에 없다. 
처음 몇 소수의 합은 2, 5, 10, 17, 28, 41, 58, 77, ... 이다. 
에라토스테네스의 체를 구성할 수 없을 정도로 n이 매우 큰 경우 소수의 합은 다음과 같이 어림할 수 있다. 
이백만 이하 소수의 합에 대해 아래 공식을 적용하면 대략 7.6%의 오차가 발생한다.
$$
\sum_{k=1}^{n} p_k \sim \frac{1}{2} n^2 \ln n
$$

참고로, 1737년에 오일러는 소수 역수의 합이 매우 느리지만 결국에는 무한대로 발산한다는 것을 보였다.
$$
\sum_{k=1}^{\infty} \frac{1}{p_k} = \infty
$$




## 출처
https://euler.synap.co.kr/problem=10
"""


import sys
from sys import stdin

mock_data = iter(['2_000_000'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer


def sieve_of_eratosthenes(num: int) -> list:
    import math
    
    is_prime = [True for _ in range(0, num + 1)]
    
    is_prime[0] = is_prime[1] = False
    
    for i in range(2, int(math.sqrt(num + 1))):
        if is_prime[i]:
            for j in range(i * i, num + 1, i):
                is_prime[j] = False
    
    return is_prime


def sum_primes(num: int) -> int:
    is_prime: list = sieve_of_eratosthenes(num)
    sum: int = 0
    
    for i in range(2, len(is_prime)):
        if is_prime[i]:
            sum += i
    
    return sum


def prime_sums_approx(num: int) -> int:
    import math
    
    if num < 1:
        return 0
    return 0.5 * (num ** 2) * math.log(num)


from sys import stdin

num: int = int(stdin.readline())

print(sum_primes(num))
