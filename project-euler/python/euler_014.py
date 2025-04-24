"""
Problem 014. 백만 이하로 시작하는 우박수 중 가장 긴 과정을 거치는 것은?



## 문제
양의 정수 n에 대하여, 다음과 같은 계산 과정을 반복하기로 합니다.

n → n / 2 (n이 짝수일 때)
n → 3 n + 1 (n이 홀수일 때)

13에 대하여 위의 규칙을 적용해보면 아래처럼 10번의 과정을 통해 1이 됩니다.

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
아직 증명은 되지 않았지만, 이런 과정을 거치면 어떤 수로 시작해도 마지막에는 1로 끝나리라 생각됩니다.
(역주: 이것은 콜라츠 추측 Collatz Conjecture이라고 하며, 이런 수들을 우박수 hailstone sequence라 부르기도 합니다)

그러면, 백만(1,000,000) 이하의 수로 시작했을 때 1까지 도달하는데 가장 긴 과정을 거치는 수는 얼마입니까?

참고: 계산 과정에는 백만을 넘어가는 수가 나와도 괜찮습니다.



## 풀이
### 콜라츠 추측(Collatz conjecture)
1937년에 처음으로 이 추측을 제기한 로타르 콜라츠의 이름을 딴 것으로 3n+1 추측, 울람 추측, 혹은 헤일스톤(우박) 수열 등 여러 이름으로 불린다. 
콜라츠 추측은 임의의 자연수가 다음 조작을 거쳐 항상 1이 된다는 추측이다.

짝수라면 2로 나눈다.
홀수라면 3을 곱하고 1을 더한다.
1이면 조작을 멈추고, 1이 아니면 첫 번째 단계로 돌아간다.
예를 들어, 6 에서 시작한다면, 차례로 6, 3, 10, 5, 16, 8, 4, 2, 1 이 된다. 
또, 27에서 시작하면 무려 111번을 거쳐야 1이 된다. 
77번째에 이르면 9232를 정점으로 도달하다가 급격히 감소하여 34단계를 더 지나면 1이 된다.

이 추측은 컴퓨터로 268까지 모두 성립함이 확인되었다. 
그러나, 아직 모든 자연수에 대한 증명은 발견되지 않고 있다. 
이 문제의 해결에 500달러의 현상금을 걸었던 에르되시 팔은 "수학은 아직 이런 문제를 다룰 준비가 되어 있지 않다."는 말을 남겼다.



## 출처
https://euler.synap.co.kr/problem=14
"""


import sys
from sys import stdin

mock_data = iter(['1_000_000'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer


def collatz_conjecture(num: int, cnt: int) -> int:
    if num == 1:
        return cnt
    elif num % 2 == 0:
        return collatz_conjecture(num // 2, cnt + 1)
    else:
        return collatz_conjecture(3 * num + 1, cnt + 1)


def collatz_conjecture_2(num: int) -> int:
    cnt: int = 0
    
    while num != 1:
        if num % 2 == 0:
            num = num // 2
        else:
            num = 3 * num + 1
        cnt += 1
    
    return cnt


def collatz_conjecture_dict(num: int) -> dict[int, int]:
    arr: dict[int, int] = {1: 1}
    
    def recursion(n: int) -> int:
        if n not in arr:
            if n % 2 == 0:
                arr[n] = recursion(n // 2) + 1
            else:
                arr[n] = recursion(3 * n + 1) + 1
        return arr[n]
    
    max_len: int = 0
    max_idx: int = -1
    
    for i in range(1, num + 1):
        len: int = recursion(i)
        
        if len > max_len:
            max_idx = i
            max_len = len
    
    # print(f"iter: {max_idx}, at: {max_len}")
    
    return arr


from sys import stdin
from functools import reduce

num: int = int(stdin.readline())

dp: dict[int, int] = collatz_conjecture_dict(num)
result: int = reduce(lambda x, y: x if dp[x] > dp[y] else y, dp)

print(result)
