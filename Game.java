import java.util.Scanner;
public class Game {
    private Board board;
    private Player player;
    private Player computer;
    private Player currentPlayer;
    private Scanner scanner;
    public Game() {
        board = new Board();
        player = new Player("Player", 'X');
        computer = new Player("Computer", 'O');
        currentPlayer = player;
        scanner = new Scanner(System.in);
    }
    public void start() {
        // Game loop
        while (!board.isGameOver()) {
            board.displayBoard();
            if (currentPlayer == player) {
                System.out.println(currentPlayer.getName() + ", it's your turn.");
                System.out.print("Enter row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("Enter column (0-2): ");
                int col = scanner.nextInt();
                if (board.makeMove(row, col, currentPlayer.getSymbol())) {
                    // Switch players
                    currentPlayer = computer;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } else {
                // Computer's turn (AI logic)
                // ...
                // Make a move on the game board
                // ...
                // Switch players
                currentPlayer = player;
            }
        }
        // Game over
        board.displayBoard();
        System.out.println("Game over!");
        // ...
    }
}