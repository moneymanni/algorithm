"""
Problem 009. a + b + c = 1000 이 되는 피타고라스 수



## 문제
세 자연수 a, b, c 가 피타고라스 정리 a2 + b2 = c2 를 만족하면 피타고라스 수라고 부릅니다 (여기서 a < b < c ).
예를 들면 32 + 42 = 9 + 16 = 25 = 52이므로 3, 4, 5는 피타고라스 수입니다.

a + b + c = 1000 인 피타고라스 수 a, b, c는 한 가지 뿐입니다. 이 때, a × b × c 는 얼마입니까?



## 풀이
### 피타고라스 트리플(Pythagorean triple)
피타고라스 정리 a2+b2=c2을 만족시키는 세 양의 정수의 튜플 (a,b,c)이다. 
즉, 유클리드 기하학의 직각 삼각형의 세 변을 이루는 세 양의 정수의 튜플이다. 
예를 들어, (3,4,5)는 피타고라스 트리플이다. 
원시(primitive) 피타고라스 트리플은 피타고라스 트리플을 이루는 세 수가 서로소인 경우이다.

피타고라스 트리플은 항상(m2−n2,2mn,m2+n2)(m>n>0) 꼴이다. 
이러한 꼴이 원시 피타고라스 트리플일 필요 충분 조건은 m,n이 짝수를 포함하는 서로소 정수인 것이다. 
특히, (m2−1,2m,m2+1)은 항상 피타고라스 트리플이다. 
여기서 a=m2−n2,b=2mn,c=m2+n2 관계는 피타고라스 트리플을 구하는 프로그래밍에서 매우 유용하게 사용된다.

원시 피타고라스 트리플은 (3,4,5)로부터 시작하여 아래 세 행렬을 곱하여 얻어낼 수도 있다.



## 출처
https://euler.synap.co.kr/problem=9
"""


import sys
from sys import stdin

mock_data = iter(['1_000'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer


def is_pythagorean_triple(a: int, b: int, c: int) -> bool:
    arr: list = [a, b, c]
    
    arr.sort()
    
    if arr[0]**2 + arr[1]**2 == arr[2]**2:
        return True
    
    return False


def find_pythagorean_triple(num: int) -> tuple:
    m: int = 0
    
    while m < num:
        m += 1
        
        for n in range(1, m):
            a: int = m**2 - n**2
            b: int = 2 * m * n
            c: int = m**2 + n**2
            
            if a + b + c == num:
                return (a, b, c)
    
    return None


from sys import stdin

num: int = int(stdin.readline())

triple: tuple = find_pythagorean_triple(num)
result: int = triple[0] * triple[1] * triple[2]

print(result)
