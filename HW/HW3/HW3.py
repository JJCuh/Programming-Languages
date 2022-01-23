# Problem 1
def fun(x, y):
    return x + y

# Problem 2
def report(xs):
    score = 0
    size = 0
    names = ""
    i=0
    while(i < len(xs)):
        names += str(xs[i])
        i+=1
        while(isinstance(xs[i],str) and isinstance(xs[i+1],str)):
            names += " " + str(xs[i])
            i+=1
        names += ", "
        size += 1
        if(isinstance(xs[i],str)):
            i+=1
        score += xs[i]
        i+=1
    return names + "averaged " + str(score/size) + "."

# Problem 3
    # Code:
def scope_test():
    def do_local():
        spam = "local spam"
    def do_nonlocal():
        nonlocal spam
        spam = "nonlocal spam"
    def do_global():
        global spam
        spam = "global spam"
    spam = "test spam"
    do_local()
    print("After local assignment:", spam)
    do_nonlocal()
    print("After nonlocal assignment:", spam)
    do_global()
    print("After global assignment:", spam)

    # Response:
    '''
    The output of the following program is: test spam, nonlocal spam, nonlocal spam, global spam.
    The do_local doesn't replace test spam, nonlocal does modify it, and global creates the global variable spam outside of the function.
    '''

# Problem 4 (8-Queens Problem)
def EightQueens():
    size = 8
    def illegal(col, existing_queens):
        row = len(existing_queens)+1
        for queen in existing_queens:
            r,c = queen
            if r == row: return True # Check row
            if c == col: return True # Check column
            if (col-c) == (row-r): return True # Check left diagonal
            if (col-c) == -(row-r): return True # Check right diagonal
        return False
    def solve(n):
        if n == 0: return [[]]
        rec_solutions = solve(n-1)
        solutions = []
        for sol in rec_solutions:
            for col in range(1,size+1):
                if not illegal(col, sol):
                    solutions.append(sol + [(n,col)])
        return solutions
    for answer in solve(size): print(answer)

# main tests
print(fun(1,2))
print(fun("hi","there"))
print(fun(5,2))

print(report(["Jill", "Johnson", 87, "Billy", "Ray", "Cyrus", 78, "Rita", "Yeats", 94, "Bobbie", "Sue", "Palmer", 72]))

scope_test()
print("In global scope:", spam)

EightQueens()
