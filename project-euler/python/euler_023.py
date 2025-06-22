"""
Problem 023. 두 과잉수의 합으로 나타낼 수 없는 모든 양의 정수의 합은?



## 문제
자신을 제외한 약수(진약수)를 모두 더하면 자기 자신이 되는 수를 완전수라고 합니다.
예를 들어 28은 1 + 2 + 4 + 7 + 14 = 28 이므로 완전수입니다.
또, 진약수의 합이 자신보다 작으면 부족수, 자신보다 클 때는 과잉수라고 합니다.

12는 1 + 2 + 3 + 4 + 6 = 16 > 12 로서 과잉수 중에서는 가장 작습니다.
따라서 과잉수 두 개의 합으로 나타낼 수 있는 수 중 가장 작은 수는 24 (= 12 + 12) 입니다.

해석학적인 방법을 사용하면, 28123을 넘는 모든 정수는 두 과잉수의 합으로 표현 가능함을 보일 수가 있습니다.
두 과잉수의 합으로 나타낼 수 없는 가장 큰 수는 실제로는 이 한계값보다 작지만, 해석학적인 방법으로는 더 이상 이 한계값을 낮출 수 없다고 합니다.

그렇다면, 과잉수 두 개의 합으로 나타낼 수 없는 모든 양의 정수의 합은 얼마입니까?



## 풀이
### 과잉수(abundant numbers)
자기 자신을 제외한 양의 약수를 모두 더했을 때 자기 자신보다 더 커지는 수이다. 
예를 들어, 20의 진약수의 합은 1+2+4+5+10=22>20으로 원래의 수 20보다 더 크기 때문에 20은 과잉수가 된다. 
과잉수는 무수히 많이 있으며 과잉수 중 가장 작은 수는 12이다. 
20161보다 큰 모든 정수는 2개의 과잉수의 합으로 표현될 수 있다. (2개의 과잉수의 합으로 표현되지 않는 자연수는 모두 1456개이다.)



## 출처
https://euler.synap.co.kr/problem=23
"""

import sys
from sys import stdin

mock_data = iter(['28124'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer


def get_divisors(limit: int) -> dict[int, list[int]]:
    divisors: dict[int, list[int]] = {}
    
    for i in range(1, limit + 1):
        for j in range(i, limit + 1, i):
            if j not in divisors:
                divisors[j] = []
            divisors[j].append(i)
    
    return divisors


def get_abundant_nums(limit: int) -> list[int]:
    divisors: dict[int, list[int]] = get_divisors(limit)
    abundant_nums: list[int] = []

    for n in divisors:
        if sum(divisors[n]) - n > n:
            abundant_nums.append(n)

    return abundant_nums


from sys import stdin

num: int = int(stdin.readline())

abundant_nums: list[int] = get_abundant_nums(num)
abundant_sums: set[int] = set()

for i in range(len(abundant_nums)):
    for j in range(i, len(abundant_nums)):
        s = abundant_nums[i] + abundant_nums[j]
        if s < num:
            abundant_sums.add(s)

result = sum(i for i in range(1, num) if i not in abundant_sums)

print(result)
