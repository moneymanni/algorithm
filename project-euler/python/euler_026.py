"""
Problem 026. 1000 이하의 d 중에서 1/d 이 가장 긴 순환마디를 갖는 수는?



## 문제
분자가 1인 분수를 단위분수라고 합니다. 분모가 2에서 10까지의 단위분수는 아래와 같습니다.

1/2 = 0.5
1/3 = 0.333333… = 0.3̇
1/4 = 0.25
1/5 = 0.2
1/6 = 0.166666… = 0.16˙
1/7 = 0.142857142857… = 0.1˙42857˙
1/8 = 0.125
1/9 = 0.111111… = 0.1̇
1/10 = 0.1

숫자 위에 찍힌 점은 순환마디를 나타내는데, 1/6의 경우 순환마디는 "6"으로 0.166666...처럼 6이 무한히 반복됨을 뜻합니다. 
같은 식으로 1/7은 6자리의 순환마디(142857)를 가집니다.
d 를 1000 이하의 정수라고 할 때, 단위분수 1/d 의 순환마디가 가장 긴 수는 무엇입니까?



## 풀이
### 순환소수(repeating decimal)
소수점 아래의 어떤 자리에서부터 일정한 숫자의 배열이 계속해서 되풀이 되는 무한소수를 말한다. 
순환소수는 순환마디 양끝에 위치한 숫자들 위에다가 점을 찍거나, 선을 그어서 나타낸다.

1/6 = 0.166666… = 0.16˙
1/7 = 0.142857142857… = 0.1˙42857˙

순환소수는 등비수열의 무한 합으로 표현할 수 있다.

\[
\overline{0.142857} = \frac{142857}{10^6} + \frac{142857}{10^{12}} + \frac{142857}{10^{18}} + \cdots = \sum_{n=1}^{\infty} \frac{142857}{10^{6n}}
\Rightarrow \frac{a}{1 - r} = \frac{\frac{142857}{10^6}}{1 - \frac{1}{10^6}} = \frac{142857}{10^6 - 1} = \frac{142857}{999999} = \frac{1}{7}
\]


모든 유리수는 유한소수이거나 순환소수이다. 또한, 유한소수이거나 순환소수이면 모두 유리수이다.



## 출처
https://euler.synap.co.kr/problem=26
"""

import sys
from sys import stdin

mock_data = iter(['1_000'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer


def find_longest_cycle(limit: int) -> int:
    max_len: int = 0
    answer: int = 0
    
    for d in range(2, limit + 1):
        remain_map: dict = {}
        idx: int = 0
        value: int = 1
        
        while value != 0 and value not in remain_map:
            remain_map[value] = idx
            value = (value * 10) % d
            idx += 1
        
        cycle_len: int = idx - remain_map.get(value, idx)
        
        if cycle_len > max_len:
            max_len = cycle_len
            answer = d
        
    return answer


from sys import stdin

num: int = int(stdin.readline())

print(find_longest_cycle(num))

