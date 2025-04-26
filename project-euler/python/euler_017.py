"""
Problem 017. 1부터 1000까지 영어로 썼을 때 사용된 글자의 개수는?



## 문제
1부터 5까지의 수를 영어로 쓰면 one, two, three, four, five 이고,
각 단어의 길이를 더하면 3 + 3 + 5 + 4 + 4 = 19 이므로 사용된 글자는 모두 19개입니다.

1부터 1,000까지 영어로 썼을 때는 모두 몇 개의 글자를 사용해야 할까요?

참고: 빈 칸이나 하이픈('-')은 셈에서 제외하며, 단어 사이의 and 는 셈에 넣습니다.
  예를 들어 342를 영어로 쓰면 three hundred and forty-two 가 되어서 23 글자,
  115 = one hundred and fifteen 의 경우에는 20 글자가 됩니다.



## 풀이



## 출처
https://euler.synap.co.kr/problem=17
"""

import sys
from sys import stdin

mock_data = iter(['1_000'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer

num_to_word: dict[int, str] = {}

num_to_word.update({
    0: "zero",
    1: "one",
    2: "two",
    3: "three",
    4: "four",
    5: "five",
    6: "six",
    7: "seven",
    8: "eight",
    9: "nine",
    10: "ten",
    
    11: "eleven",
    12: "twelve",
    13: "thirteen",
    14: "fourteen",
    15: "fifteen",
    16: "sixteen",
    17: "seventeen",
    18: "eighteen",
    19: "nineteen",
    
    20: "twenty",
    30: "thirty",
    40: "forty",
    50: "fifty",
    60: "sixty",
    70: "seventy",
    80: "eighty",
    90: "ninety",
    
    100: "one hundred",
    200: "two hundred",
    300: "three hundred",
    400: "four hundred",
    500: "five hundred",
    600: "six hundred",
    700: "seven hundred",
    800: "eight hundred",
    900: "nine hundred",
    
    1000: "one thousand",
})

def convert_num_to_word(num: int) -> str:
    if num in num_to_word:
        return num_to_word[num]
    if num < 100:
        return num_to_word[num // 10 * 10] + ('-' + num_to_word[num % 10] if num % 10 else '')
    if num < 1000:
        return num_to_word[num // 100] + " hundred" + (' and ' + convert_num_to_word(num % 100) if num % 100 else '')
    
    return "one thousand"


from sys import stdin

print(convert_num_to_word(100))

num: int = int(stdin.readline())

result: int = 0

for i in range(1, 1001):
    word: str = convert_num_to_word(i)
    word = word.replace(' ', '').replace('-', '')  # 빈칸, 하이픈 제거
    result += len(word)

print(result)
