"""
Problem 027. 연속되는 n에 대해 가장 많은 소수를 만들어내는 이차식



## 문제
오일러는 다음과 같은 멋진 이차식을 제시했습니다.

n² + n + 41

이 식의 n에다 0부터 39 사이의 수를 넣으면, 그 결과는 모두 소수가 됩니다.
하지만 n = 40일 때의 값 40² + 40 + 41 은 40×(40 + 1) + 41 이므로 41로 나누어지고, 
n = 41일 때 역시 41² + 41 + 41 이므로 소수가 아닙니다.

컴퓨터의 발전에 힘입어 n² - 79n + 1601 이라는 엄청난 이차식이 발견되었는데, 
이것은 n이 0에서 79 사이일 때 모두 80개의 소수를 만들어냅니다. 이 식의 계수의 곱은 -79 × 1601 = -126479가 됩니다.

아래와 같은 모양의 이차식이 있다고 가정했을 때,

n² + an + b   (단 | a | < 1000, | b | < 1000)

0부터 시작하는 연속된 n에 대해 가장 많은 소수를 만들어내는 이차식을 찾아서, 그 계수 a와 b의 곱을 구하세요.



## 풀이
### 소수 생성 다항식(prime-generating polynomial)
르장드르(Legendre)는 소수만을 생성하는 유리 대수 함수가 없다는 것을 증명했다. 
또, 골드바흐(Goldbach)는 모든 정수값에서 소수를 생성하는 정수 계수의 다항식이 존재하지 않는다는 것을 증명했다. 
그러나 비록 디오판토스 방정식의 변형이기는 하지만 음이 아닌 모든 정수에서 모든 소수를 생성하는 10변수 정수 계수 다항식이나 정확히 소수를 생성하는 26변수 25차 다항식은 있다.

소수를 생성하는 다항식 중에서 가장 잘 알려진 것은 오일러의 n²+n+41으로 0~39까지의 연속된 n에서 서로 다른 소수를 생성한다. 
n 미만의 모든 자연수 k에서 다항식 k²−k+n이 소수를 생성할 때, 이 자연수 n을 "오일러의 행운수"라 한다.



## 출처
https://euler.synap.co.kr/problem=27
"""

import sys
from sys import stdin

mock_data = iter(['1_000', '1_000'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer


def is_prime(num: int) -> bool:
    if num < 2:
        return False
    
    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            return False
    
    return True

def find_sieve_of_eratosthenes(limit: int) -> list[int]:
    sieve: list[bool] = [True] * (limit + 1)
    
    sieve[0] = sieve[1] = False
    
    for i in range(2, int(limit ** 0.5) + 1):
        if sieve[i]:
            for j in range(i * i, limit + 1, i):
                sieve[j] = False
    
    return [i for i, is_p in enumerate(sieve) if is_p]


from sys import stdin

a_limit: int = int(stdin.readline())
b_limit: int = int(stdin.readline())

primes_a: list[int] = find_sieve_of_eratosthenes(a_limit)
primes_b: list[int] = find_sieve_of_eratosthenes(b_limit)

max_k: int = 0
pair: tuple[int] = (0, 0)
arr: list[int] = []

for i in primes_a:
    for j in primes_b:
        k: int = 0
        
        while (k**2 - i*k + j > 0 and is_prime(k**2 - i*k + j)):
            k += 1
        
        if k > max_k:
            max_k = k
            pair = (-i, j)

print(-pair[0] * pair[1])
print(pair)
