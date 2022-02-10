def solve(str):
    cnt = 0
    for i in range(len(str)):
        if str[i] in ['a', 'e', 'i', 'o', 'u']:
            cnt += 1

    return cnt

