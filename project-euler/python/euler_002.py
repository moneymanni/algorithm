"""
Problem 002. 피보나치 수열에서 4백만 이하이면서 짝수인 항의 합


### 문제
피보나치(Fibonacci) 수열의 각 항은 바로 앞의 항 두 개를 더한 것입니다. 1과 2로 시작하는 경우 이 수열은 아래와 같습니다.

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
4백만 이하의 짝수 값을 갖는 모든 피보나치 항을 더하면 얼마가 됩니까?


### 풀이
피보나치 수(Fibonacci numbers)
피보나치 수 Fn은 다음과 같은 초기값 및 점화식으로 정의되는 수열이다.
F0=0,F1=1,Fn=Fn−1+Fn−2(n∈{2,3,4,…})

피보나치 수의 처음 몇 항은 (0번째 항부터 시작할 경우) 다음과 같다.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, ...

피보나치 수의 일반항은 다음과 같다.
Fn = φⁿ − (1 − φ)ⁿ / √5 = 1 / √5 ((1 + √5 / 2)ⁿ − (1 − √5 / 2)ⁿ) = ( 1 + √5)ⁿ − (1 − √5)ⁿ / 2ⁿ√5

여기서 φ는 황금비이며, √5는 5의 제곱근이다.
이를 비네 공식(Binet's formula)이라고 한다.
이는 레온하르트 오일러가 1765년 처음 발표했으나 잊혔다가, 1848년 자크 비네에 의해 재발견되었다.


### 출처
https://euler.synap.co.kr/problem=2
"""


def fibonacci_numbers_top_down(num: int) -> int:
    """
    주어진 위치의 피보나치 수를 top-down 방식으로 계산
    
    :param num: 계산할 피보나치 수열의 인덱스
    :return: 주어진 인덱스의 피보나치 수
    """
    if num == 1 or num == 0:
        return 1

    return fibonacci_numbers_top_down(num - 2) + fibonacci_numbers_top_down(num - 1)


def fibonacci_numbers_bottom_up(num: int) -> int:
    """
    주어진 위치의 피보나치 수를 bottom-up 방식으로 계산한다.

    :param num: 계산할 피보나치 수열의 인덱스
    :return: 주어진 인덱스의 피보나치 수
    """
    arr: list = list()

    arr.append(1)
    arr.append(1)

    for i in range(2, num + 1):
        arr.append(arr[i - 2] + arr[i - 1])

    return arr[num]


idx: int = 1
sum: int = 0

while (True):
    num: int = fibonacci_numbers_bottom_up(idx)
    idx += 1

    if num > 4_000_000:
        break
    elif num % 2 == 0:
        sum += num

print(sum)
