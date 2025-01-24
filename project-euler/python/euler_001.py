"""
Problem 001. 1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면?

### 문제
10보다 작은 자연수 중에서 3 또는 5의 배수는 3, 5, 6, 9 이고, 이것을 모두 더하면 23입니다.

1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?


### 풀이
1. 포함배제의 원리
    - 유한 집합의 합집합의 원소 개수를 세는 기법으로, 2개 또는 3개의 집합의 경우는 각각 다음과 같다.
    - |A ∪ B| = |A| + |B| - |A ∩ B|
    - |A ∪ B ∪ B| = |A| + |B| + |C| - |A ∩ B| - |A ∩ C| - |B ∩ C| + |A ∩ B ∩ C|
2. 등차급수
    - 초항이 a1이고 공차가 d인 등차수열의 초항부터 n번째 항까지의 합 Sn=a1+a2+⋯+an-1+an을 등차급수(arithmetic series)라 하고 다음 공식으로 구할 수 있다.
    - Sn = n(a1 + an) / 2 = n[2a1 + (n-1)d] / 2


### 출처
https://euler.synap.co.kr/problem=1
"""
import math

# 포함배제의 원리, 등차급수
def inclusion_exclusion(max_num: int) -> int:
    def sum_of_multiples(limit: int, divisor: int) -> int:
        n: int = (limit - 1) // divisor
        return (n * (divisor + (n * divisor))) // 2
    
    sum3: int = sum_of_multiples(max_num, 3)
    sum5: int = sum_of_multiples(max_num, 5)
    sum15: int = sum_of_multiples(max_num, 15)
    
    return sum3 + sum5 - sum15

print(inclusion_exclusion(1000))
