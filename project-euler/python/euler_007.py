"""
Problem 007. 10001번째의 소수



## 문제
소수를 크기 순으로 나열하면 2, 3, 5, 7, 11, 13, ... 과 같이 됩니다.

이 때 10,001번째의 소수를 구하세요.



## 풀이
### 에라토스테네스의 체(the sieve of Eratosthenes)
주어진 자연수 n
까지의 모든 소수를 찾는 고대의 알고리즘이다. 첫 소수인 2부터 시작해서 각 소수의 배수가 되는 합성수를 제거하는 방법을 반복하여 모든 소수를 걸러낸다. 작은 범위에서 모든 소수를 찾아내는 가장 효율적인 방법 중 하나이다.

### 알고리즘
1. 2부터 n까지의 모든 자연수의 목록을 만든다: (2, 3, 4, ..., n).
2. 초기 상태에 변수 p 값으로 최소 소수인 2를 대입한다.
3. 2p에서 n까지 모든 p의 배수를 목록에서 찾아 제거 표시한다: (2p, 3p, 4p, ...; p는 제외).
4. p보다 큰 수 중에서 제거 표시가 안 된 가장 작은 수를 찾는다. 
   그런 수가 없다면 종료하고, 있다면 그 수를 p에 대입하고 3번부터 다시 반복한다.
5. 알고리즘이 종료할 때, 목록에서 제거 표시가 되지 않고 남아 있는 수들이 n까지의 모든 소수이다.

에라토스테네스의 체는 소수의 개수를 세는 데도 사용될 수 있다.



## 출처
https://euler.synap.co.kr/problem=7
"""

import sys
from sys import stdin

mock_data = iter(['10_001'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer


def sieve_of_eratosthenes(num: int) -> list:
    sieve: list = [True for _ in range(num + 1)]
    sieve[0] = sieve[1] = False

    for i in range(2, int((num + 1) ** 0.5) + 1):  # ← +1 필요!
        if sieve[i]:
            for j in range(i * i, num + 1, i):
                sieve[j] = False

    return sieve


def get_nth_prime(num: int) -> int:
    import math

    # 상한값을 추정하는 함수
    def estimate_upper_bound(n: int) -> int:
        if n < 6:
            return 15
        return int(n * (math.log(n) + math.log(math.log(n)))) + 1

    limit: int = estimate_upper_bound(num)

    sieve: int = sieve_of_eratosthenes(limit)
    primes: list = [i for i, is_prime in enumerate(sieve) if is_prime]

    return primes[num - 1]


from sys import stdin

num: int = int(stdin.readline())

prime: int = get_nth_prime(num)
print(prime)
