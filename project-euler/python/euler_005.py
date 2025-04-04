"""
Problem 005. 1 ~ 20 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수


### 문제
1 ~ 10 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수는 2520입니다.

그러면 1 ~ 20 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수는 얼마입니까?


### 풀이
- 최소공배수(least common multiple)
여러 개의 정수의 공배수는 그들 모두의 배수가 되는 정수이다. 
최소공배수(Least Common Multiple, LCM)는 양의 공배수 가운데 가장 작은 하나이다.

여러 개의 정수 n1,n2,…,nk∈Z:nk≠0
의 최소공배수 lcm{n1,n2,…,nk}
는 재귀적으로 lcm{lcm{n1,n2,…,nk−1},nk}
로 정의할 수 있다.


### 출처
https://euler.synap.co.kr/problem=5
"""

def gcd(a: int, b: int) -> int:
    while b:
        a, b = b, a % b
    return a


def lcm(a: int, b: int) -> int:
    return a * b // gcd(a, b)


result: int = 1

for i in range(2, 21):
    result = lcm(result, i)
    
print(result)
