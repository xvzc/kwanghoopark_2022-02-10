def solve(arr):
    friends = []
    for i in range(len(arr)):
        if len(arr[i]) == 4:
            friends.append(arr[i])

    return friends
