# Tic-Tac-Toe

version 2.0.0(Unbeatable AI Player):
1. The Minimax algorithm is a decision-making algorithm widely used in turn-based games like Tic-Tac-Toe. It provides an AI player with the ability to make optimal moves by evaluating all possible future game states. The goal of the Minimax algorithm is to minimize the possible loss for a worst-case scenario. When playing as an AI, it maximizes the AI’s chances of winning while minimizing the opponent’s chances.
2. Adjusted Time Complexity with Human First
   Given that the human starts first:

   Effective Game Tree:
   
   The AI evaluates up to 4 levels deep, starting with 8 possible moves on its first turn, 6 on its second turn, 4 on its third turn, and so on.
   Branching Factor: The branching factor reduces accordingly:
   
   AI's first move: 8 possible moves  
   AI's second move: 6 possible moves  
   AI's third move: 4 possible moves  
   AI's fourth move: 2 possible moves  
   Adjusted Complexity Calculation:  
   `The practical complexity with the human starting first is: O(8×6×4×2) This simplifies to:
   O(384)`


version 1.0.0:
1. implemented hashmap to store values: key for the positions of the cells (0 to 8) and value is the char (O or X in this case)
2. time complexity for checking the result after an input is given:  ~O(n)
3. Different design patterns has been used to design. 
4. `The GameManager class uses this pattern. The Singleton pattern ensures a class has only one instance and provides a global point of access to it.`
5. `The Factory Method pattern defines an interface for creating an object but allows subclasses to alter the type of objects that will be created. The PlayerFactory, 
   HumanPlayerFactory, and AIPlayerFactory classes demonstrate this pattern.`
6. `The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Here, GameLogic serves as the interface, and GameLogicImpl 
   provides the specific implementation.`