"""
* Programmers
* https://school.programmers.co.kr/learn/courses/30/lessons/176963
* Problem: 추억 점수
* Level: 1
* Algorithm: 자료구조
"""


def solution(name, yearning, photos):
    answer = []

    dictionary = dict(zip(name, yearning))

    for photo in photos:
        score = 0
        for name in photo:
            score += dictionary.get(name, 0)

        answer.append(score)
    return answer


print(solution(["may", "kein", "kain", "radi"], [5, 10, 1, 3],
               [["may", "kein", "kain", "radi"], ["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]))
