"""
* Programmers
* https://school.programmers.co.kr/learn/courses/30/lessons/178871
* Problem: 달리기 경주
* Level: 2
* Algorithm: 자료구조
"""
#JAVA였으면 HashSet..

def solution(players, callings):
    idx = 0
    rank = {}
    for name in players:
        rank[name] = idx
        idx = idx + 1

    for name in callings:
        # Swap
        front = players[rank[name] - 1]
        front_idx = rank[front]
        tmp = players[front_idx]
        players[front_idx] = players[rank[name]]
        players[rank[name]] = tmp
        # Dictionary 갱신
        rank[name] = rank[name] - 1
        rank[front] = rank[front] + 1

    return players


print(*solution(["mumu", "soe", "poe", "kai", "mine"], ["kai", "kai", "mine", "mine"]))
