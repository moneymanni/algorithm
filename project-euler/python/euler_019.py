"""
Problem 019. 20세기에서, 매월 1일이 일요일인 경우는 몇 번?



## 문제
다음은 달력에 관한 몇 가지 일반적인 정보입니다 (필요한 경우 좀 더 연구를 해 보셔도 좋습니다).

- 1900년 1월 1일은 월요일이다.
- 4월, 6월, 9월, 11월은 30일까지 있고, 1월, 3월, 5월, 7월, 8월, 10월, 12월은 31일까지 있다.
- 2월은 28일이지만, 윤년에는 29일까지 있다.
- 윤년은 연도를 4로 나누어 떨어지는 해를 말한다. 하지만 400으로 나누어 떨어지지 않는 매 100년째는 윤년이 아니며, 400으로 나누어 떨어지면 윤년이다

20세기 (1901년 1월 1일 ~ 2000년 12월 31일) 에서, 매월 1일이 일요일인 경우는 총 몇 번입니까?



## 풀이
### 태양력의 윤년(leap year)
현재 전 세계 대부분의 나라에서 쓰는 그레고리력은 4년에 반드시 하루씩 윤날(2월 29일)을 추가하는 율리우스력을 보완한 것으로, 태양년과의 편차를 줄이기 위해 율리우스력의 400년에서 3일(세 번의 윤년)을 뺐다. 즉, 400년에 97년은 윤년이 되며, 1년은 평균 365.2425일이 된다. 이는 춘분점을 기준으로 한 태양년보다 0.0003일(26초) 길기 때문에, 약 3,300년마다 1일의 편차가 난다.

그레고리력의 정확한 윤년 규칙을 알고리즘으로 표현하면 다음과 같다.
if (연수가 4로 나뉘지 않으면) then (평년임)
else if (연도가 100으로 나뉘지 않으면) then (윤년임)
else if (연도가 400으로 나뉘지 않으면) then (평년임)
else (윤년임)



## 출처
https://euler.synap.co.kr/problem=19
"""

import sys
from sys import stdin

mock_data = iter([])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer

month_to_day: dict[int, int] = {
    1: 31,
    2: 28,
    3: 31,
    4: 30,
    5: 31,
    6: 30,
    7: 31,
    8: 31,
    9: 30,
    10: 31,
    11: 30,
    12: 31,
}

day: list[str] = ['월', '화', '수', '목', '금', '토', '일']


def is_leap_year(year: int) -> bool:
    return year % 400 == 0 or (year % 4 == 0 and year % 100 != 0)


def count_sundays_on_first_20th() -> int:
    count: int = 0
    start_year: int = 1901
    end_year: int = 2000
    
    curr_day_idx: int = 1
    
    for year in range(start_year, end_year + 1):
        for month in range(1, 13):
            if curr_day_idx == 6:
                count += 1
                
            days_in_month: int = month_to_day[month]
            
            if month == 2 and is_leap_year(year):
                days_in_month += 1
            
            curr_day_idx = (curr_day_idx + days_in_month) % 7
            
    return count

print(count_sundays_on_first_20th())
