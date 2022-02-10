def solve(arr):
    if arr[0] % 2 != arr[1] % 2 and arr[1] % 2 == arr[2] % 2:
        return 1

    for i in range(1, len(arr)):
        if arr[i - 1] % 2 != arr[i] % 2:
            return i + 1

