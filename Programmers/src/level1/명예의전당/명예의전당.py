"""
* Programmers
* https://school.programmers.co.kr/learn/courses/30/lessons/138477
* Problem: 명예의 전당
* Level: 1
* Algorithm: 구현
"""


def solution(k, score):
    answer = []
    temp = []

    for i in score:
        if len(temp) < k:
            temp.append(i)
        else:
            if min(temp) < i:
                temp.remove(min(temp))
                temp.append(i)
        answer.append(min(temp))

    return answer


k = 3
score = [10, 100, 20, 150, 1, 100, 200]
print(solution(k, score))
