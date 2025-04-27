// The Game class operates the core logic of the program.
// Manages the game loop, user interaction, and state transitions based on user guesses.
public class Game {
    private final WordManager wordManager; // Responsible for retrieving words.
    private final Difficulty difficulty;
    private GameState gameState; // Tracks the current game state.
    private final Input inputHandler;
    private final Output outputHandler;

    // Constructs a Game instance using the specified difficulty. 
    public Game(Difficulty difficulty) {
        this.wordManager = new FileWordManager(); // Loads words from the "words.txt" file
        this.difficulty = difficulty;
        this.inputHandler = new Input();
        this.outputHandler = new Output();
        initialiseGame(); // Prepare the game environment with a word to guess.
    }

    // Initialises the game by selecting a random word from the chosen difficulty's word
    // bank, and exits the program if no word could be loaded for the selected difficulty.
    private void initialiseGame() {
        String wordToGuess = wordManager.getRandomWord(difficulty);
        if (wordToGuess == null) {
            System.err.println("Could not load words for the selected difficulty!");
            System.exit(1);
        }
        gameState = new GameState(wordToGuess, difficulty);
    }

    // Runs the main game loop - dipslays the welcome message, displays the current game 
    // state, and accepts/validates guesses.
    public void run() {
        outputHandler.displayWelcome();
        // The game loop continues until the player won or ran out of attempts.
        while (!gameState.hasSuccessfullyTerminated() && !gameState.isGameOver()) {
            outputHandler.displayGameState(gameState);
            char guess = inputHandler.getValidGuess(gameState);
            gameState.validateGuess(guess);
        }

        // Displays the final result of the game - i.e. whether the user won or now.
        outputHandler.displayResult(gameState.hasSuccessfullyTerminated(), gameState);
    }
}