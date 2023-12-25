# Tic-Tac-Toe

version 1.0.0:
1. implemented hashmap to store values: key for the positions of the cells (0 to 8) and value is the char (O or X in this case)
2. time complexity for checking the result after an input is given:  ~O(n)
3. computer's turn is determined by using: `Collections.shuffle`. First, it shuffles the list consisted of available positions and then always chooses the first index. So, we 
   never face out of bound issue.