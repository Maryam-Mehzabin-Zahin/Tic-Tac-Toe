# Tic-Tac-Toe

version 1.0.0:
1. implemented hashmap to store values: key for the positions of the cells (0 to 8) and value is the char (O or X in this case)
2. time complexity for checking the result after an input is given:  ~O(n)
3. Different design patterns has been used to design. 
4. `The GameManager class uses this pattern. The Singleton pattern ensures a class has only one instance and provides a global point of access to it.`
5. `The Factory Method pattern defines an interface for creating an object but allows subclasses to alter the type of objects that will be created. The PlayerFactory, 
   HumanPlayerFactory, and AIPlayerFactory classes demonstrate this pattern.`
6. `The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Here, GameLogic serves as the interface, and GameLogicImpl 
   provides the specific implementation.`