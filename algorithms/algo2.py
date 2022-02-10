def solve(arr):
    s = set(arr)
    n = 1
    while(True):
        if n not in s:
            return n
        n += 1
