board = [[0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0,0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0, 0, 0]]

def open(r, c, board)
  for i in 0..8
    if board[r][i]==1
      return False
    end
  end

  for i in 0..8
    if (board[i][c]==1)
      return False
    end
  end

  i=r-1
  j=c-1
  while i>=0 and j>=0
    if board[i][j]==1
      return False
    end
    i=i-1
    j=j-1
  end

  i=r+1
  j=c-1
  while i<8 and j>=0
    if board[i][j]==1
      return False
    end
    i=i+1
    j=j-1
  end

  i=r-1
  j=c+1
  while i>=0 and j<8
    if board[i][j]==1
      return False
    end
    i=i-1
    j=j+1
  end

  i=r+1
  j=c+1
  while i<8 and j<8
    if board[i][j]==1
      return False
    end
    i=i+1
    j=j+1
  end

  return True
end

def place(r, board)
  if r==8
    return True
  end
  for i in 0..8
    if open(r, i, board)
      board[r][i] = 1
      success = place(r+1, board)
      if success
        return True
      else
        board[r][i] = 0
      end
    end
  end
  return False
end

place(0, board)
for i in 0..8
  puts(board[i])
end
