# Tic-Tac-Toe Game Implementation

## Overview
This package contains an implementation of the classic Tic-Tac-Toe game using object-oriented design principles and several design patterns. The implementation demonstrates how to structure a simple game using proper separation of concerns and reusable components.

## Design Patterns Used

### 1. Factory Method Pattern
The Factory Method pattern is used to create different types of playing pieces (X and O):

- **PlayingPiece**: Abstract base class for all playing pieces
- **PlayingPieceX**: Concrete implementation for X pieces
- **PlayingPieceO**: Concrete implementation for O pieces

This pattern allows for easy extension if more piece types are needed in the future.

### 2. Model-View-Controller (MVC) Pattern
The implementation separates the game's data (model) from its logic (controller):

- **Model**: PlayingBoard, Player, PlayingPiece classes
- **Controller**: TicTacToeGame class
- **View**: Console output (System.out.println)

This separation makes the code more maintainable and easier to extend.

### 3. Iterator Pattern
The TicTacToeGame class uses a Deque to manage players, implementing a simple form of the Iterator pattern:

- Players are stored in a Deque
- The first player is removed for their turn
- After their turn, they are added back to the end of the queue

## Implementation Details

### Components

1. **PlayingPieces.java**: An enum defining the two types of pieces (X and O).
   ```java
   public enum PlayingPieces {
       X, O;
   }
   ```

2. **PlayingPiece.java**: Base class for playing pieces.
   ```java
   public class PlayingPiece {
       PlayingPieces piece;
   
       PlayingPiece(PlayingPieces piece) {
           this.piece = piece;
       }
   }
   ```

3. **PlayingPieceX.java**: Concrete implementation for X pieces.
   ```java
   public class PlayingPieceX extends PlayingPiece {
       PlayingPieceX() {
           super(PlayingPieces.X);
       }
   }
   ```

4. **PlayingPieceO.java**: Concrete implementation for O pieces.
   ```java
   public class PlayingPieceO extends PlayingPiece {
       PlayingPieceO() {
           super(PlayingPieces.O);
       }
   }
   ```

5. **Player.java**: Represents a player in the game.
   ```java
   public class Player {
       String name;
       PlayingPiece playingPiece;
   
       Player(String name, PlayingPiece playingPiece) {
           this.name = name;
           this.playingPiece = playingPiece;
       }
       
       // Getters and setters
   }
   ```

6. **PlayingBoard.java**: Represents the game board.
   ```java
   public class PlayingBoard {
       public PlayingPiece[][] board;
       public int size;
   
       PlayingBoard(int size) {
           this.size = size;
           board = new PlayingPiece[size][size];
       }
   
       boolean fillPosition(Integer x, Integer y, PlayingPiece piece) {
           if(board[x][y] == null) {
               board[x][y] = piece;
               return false;  // Position filled successfully
           }
           else {
               return true;   // Position already filled
           }
       }
   }
   ```

7. **TicTacToeGame.java**: Implements the game logic.
   ```java
   public class TicTacToeGame {
       private PlayingBoard board;
       private Deque<Player> players;
   
       // Game initialization and logic
       // ...
   }
   ```

## How It Works

1. The game initializes a 3x3 board and two players with X and O pieces.
2. Players take turns placing their pieces on the board.
3. After each move, the game checks if the current player has won by examining rows, columns, and diagonals.
4. If a player wins, their name is returned. If all cells are filled without a winner, "No winner" is returned.

## Known Issues

1. The players Deque in TicTacToeGame is not initialized, which would cause a NullPointerException.
2. The fillPosition method in PlayingBoard returns true for failure and false for success, which is counterintuitive.
3. There's commented-out code for checking if all cells are filled, which might lead to games that can't end in a tie.

## Benefits of This Design

1. **Extensibility**: New piece types or board sizes can be easily added.
2. **Maintainability**: The separation of concerns makes the code easier to understand and modify.
3. **Reusability**: Components like PlayingBoard and Player can be reused in other games.
4. **Testability**: The clear separation of responsibilities makes unit testing easier.

## Potential Improvements

1. Add a proper user interface instead of console input/output.
2. Implement an AI player using the Strategy pattern.
3. Add support for different board sizes.
4. Implement game state persistence using the Memento pattern.
5. Fix the known issues mentioned above.

## Comparison with Other Patterns

- **State Pattern**: Could be used to manage different game states (setup, player1's turn, player2's turn, game over).
- **Observer Pattern**: Could be used to notify UI components of game state changes.
- **Command Pattern**: Could be used to implement undo/redo functionality for moves.
- **Singleton Pattern**: Could be used to ensure only one game instance exists.
