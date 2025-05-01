"""
Problem 021. 10000 이하 모든 친화수(우애수)의 합은?



## 문제
n의 약수들 중에서 자신을 제외한 것의 합을 d(n)으로 정의했을 때,
서로 다른 두 정수 a, b에 대하여 d(a) = b 이고 d(b) = a 이면
a, b는 친화쌍이라 하고 a와 b를 각각 친화수(우애수)라고 합니다.

예를 들어 220의 약수는 자신을 제외하면 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110 이므로 그 합은 d(220) = 284 입니다.
또 284의 약수는 자신을 제외하면 1, 2, 4, 71, 142 이므로 d(284) = 220 입니다.
따라서 220과 284는 친화쌍이 됩니다.

10000 이하의 친화수들을 모두 찾아서 그 합을 구하세요.



## 풀이
###친화수(amicable numbers)
두 수의 쌍이 있어, 어느 한 수의 진약수를 모두 더하면 다른 수가 되는 것을 말한다. 
220과 284의 쌍이 그 예이다. 220의 진약수는 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110로 모두 더하면 284가 된다. 반대로 284의 모든 진약수 1, 2, 4, 71, 142를 모두 더하면 220이 된다.

(220, 284) 다음에 구해진 친화수는 (17296, 18416)이다. 
이 친화수는 그 이전에도 구해져 있었지만, 피에르 드 페르마에 의해 재발견되었다. 그 후, 레온하르트 오일러에 의해 60개 정도의 친화수가 구해졌다. 1946년에는 390쌍의 알려진 쌍이 있었지만, 컴퓨터의 발달로 그 이후에 수천 쌍이 발견되었다. 
현재까지 알려진 친화수는 2017년 4월 기준으로, 12억 개 이상이다.



## 출처
https://euler.synap.co.kr/problem=21
"""

import sys
from sys import stdin

mock_data = iter(['10_000'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer

def get_divisors(limit: int) -> list[list[int]]:
    divisors: list[list[int]] = [[] for _ in range(limit + 1)]
    
    for i in range(1, limit + 1):
        for j in range(i, limit + 1, i):
            divisors[j].append(i)
    
    return divisors


def sum_proper_divisors(n: int, divisors: list[list[int]]) -> int:
    return sum(divisors[n]) - n


def is_amicable_num(a: int, b: int, divisors: list[list[int]]) -> bool:
    sum_a: int = sum(divisors[a]) - a
    sum_b: int = sum(divisors[b]) - b
    
    return sum_a == b and sum_b == a


from sys import stdin

num: int = int(stdin.readline())
divisors: list[list[int]] = get_divisors(num)

result: int = 0

for a in range(1, num + 1):
    b = sum_proper_divisors(a, divisors)
    
    if b > a and b <= num:
        if sum_proper_divisors(b, divisors) == a:
           result += a + b

print(result)
