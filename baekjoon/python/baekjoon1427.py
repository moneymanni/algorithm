"""
백준 1427. 소트인사이드

링크: https://www.acmicpc.net/problem/1427
"""

from sys import stdin

print(''.join(sorted(stdin.readline(), reverse=True)))