"""
Problem 015. 20×20 격자의 좌상단에서 우하단으로 가는 경로의 수



## 문제
아래와 같은 2 × 2 격자의 왼쪽 위 모서리에서 출발하여 오른쪽 아래 모서리까지 도달하는 길은 모두 6가지가 있습니다 (거슬러 가지는 않기로 합니다).

그러면 20 × 20 격자에는 모두 몇 개의 경로가 있습니까?



## 풀이
### 중복집합 순열 (permutations of multisets)

중복집합 \( M \)의 각 원소의 개수가 \( m_1, m_2, \dots, m_l \)이고  
그 합이 \( n \)일 때 순열의 개수는 다음과 같다:

\[
\binom{n}{m_1, m_2, \dots, m_l} = \frac{n!}{m_1! \cdot m_2! \cdot \dots \cdot m_l!} = \frac{\left( \sum_{i=1}^{l} m_i \right)!}{\prod_{i=1}^{l} m_i!}
\]

예를 들어, 영어 단어 **MISSISSIPPI**의 모든 문자를 사용한 순열의 수는 다음과 같다:

\[
\frac{11!}{1! \cdot 4! \cdot 4! \cdot 2!} = 34650
\]



## 출처
https://euler.synap.co.kr/problem=15
"""


import sys
from sys import stdin

mock_data = iter(['20'])
readline = lambda: next(mock_data)
sys.stdin.readline = readline
stdin.readline = readline


# ---------- Divider ----------
# Answer


def find_num_of_paths(num: int) -> int:
    size: int = num * 2
    dp: list[list[int]] = [[0] * (size + 1) for _ in range(size + 1)]
    
    for i in range(size + 1):
        dp[i][0] = 1
        dp[i][i] = 1
        if i >= 1:
            dp[i][1] = i
    
    for i in range(2, size + 1):
        for j in range(1, i):
            dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]
    
    return dp[num * 2][num]


from sys import stdin

num: int = int(stdin.readline())

print(find_num_of_paths(num))
