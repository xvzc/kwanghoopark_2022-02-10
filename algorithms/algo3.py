def solve(arr):
    score = 0

    for i in range(len(arr)):
        if arr[i][0] > arr[i][2]:
            score += 3
        elif arr[i][0] == arr[i][2]:
            score += 1

    return score
