"""
Problem 004. 세자리 수를 곱해 만들 수 있는 가장 큰 대칭수


### 문제
앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수(palindrome)라고 부릅니다.

두 자리 수를 곱해 만들 수 있는 대칭수 중 가장 큰 수는 9009 (= 91 × 99) 입니다.

세 자리 수를 곱해 만들 수 있는 가장 큰 대칭수는 얼마입니까?


### 풀이
- 대칭수(palindrome)
순서대로 읽은 수와 거꾸로 읽은 수가 같은 수를 말한다. 예를 들어 34543은 대칭수이고, 34567은 대칭수가 아니다. 
대칭수는 유희 수학에서 주목받는 수이며, 일반적으로 어떤 성질을 가지는 동시에 대칭인 수를 다룬다. 
예로 0, 1, 14641, 104060401, 1004006004001, ...은 네 제곱인 대칭수이다. 회문수(回文數)라고도 한다.


### 출처
https://euler.synap.co.kr/problem=4
"""

def isPalindrome(str: str) -> bool:
    reversed_str = str[::-1]
    if reversed_str == str:
        return True
    return False


def isPalindrome(num: int) -> bool:
    str_num = str(num)
    reversed_str_num = str_num[::-1]
    
    if reversed_str_num == str_num:
        return True
    return False


max_num: int = 0

for i in range(100, 1000):
    for j in range(900, 1000):
        temp = i * j
        if (isPalindrome(temp)):
            max_num = max(max_num, temp)

print(max_num)
