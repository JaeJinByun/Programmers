"""
* Programmers
* https://school.programmers.co.kr/learn/courses/30/lessons/172928
* Problem: 공원 산책
* Level: 1
* Algorithm: 구현
"""


def solution(park, routes):
    answer = [0, 0]
    map = []
    for element in park:
        map.append([char for char in element])

    # S위치 찾기
    for i in range(len(map)):
        for j in range(len(map[0])):
            if map[i][j] == 'S':
                answer[0] = i
                answer[1] = j
                break
    # 이동
    for i in routes:
        col = answer[0]
        row = answer[1]
        for j in range(int(i[2])):
            if i[0] == 'N' and col != 0 and map[col - 1][row] != 'X':
                col -= 1
                if j == int(i[2]) - 1:
                    answer[0] = col
            elif i[0] == 'S' and col != len(map) - 1 and map[col + 1][row] != 'X':
                col += 1
                if j == int(i[2]) - 1:
                    answer[0] = col
            elif i[0] == 'W' and row != 0 and map[col][row - 1] != 'X':
                row -= 1
                if j == int(i[2]) - 1:
                    answer[1] = row
            elif i[0] == 'E' and row != len(map[0]) - 1 and map[col][row + 1] != 'X':
                row += 1
                if j == int(i[2]) - 1:
                    answer[1] = row

    return answer


park = ["OSO", "OOO", "OXO", "OOO"]
routes = ["E 2", "S 3", "W 1"]
print(solution(park, routes))
