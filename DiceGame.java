
// Importing the Random class
import java.util.Random;
// Scanner for user input
import java.util.Scanner;

/**
 * Program that generates a random number,
 * and then asks the user to guess it.
 * The program will keep asking until the user gets it right.
 *
 * @author Atri Sarker
 * @version 1.0
 * @since 2025-09-25
 */
public final class DiceGame {

  /**
   * Constant for the minimum roll of the dice.
   */
  public static final int MIN_NUM = 1;
  /**
   * Constant for the maximum roll of the dice.
   */
  public static final int MAX_NUM = 6;

  /**
   * Private constructor to satisfy style checker.
   *
   * @exception IllegalStateException for the utility class.
   * @see IllegalStateException
   */
  private DiceGame() {
    // Prevents illegal states.
    throw new IllegalStateException("Utility class.");
  }

  /**
   * Entrypoint of the program.
   *
   * @param args UNUSED.
   */
  public static void main(final String[] args) {
    // Create instance of Random class
    // It's for generating random numbers
    Random rand = new Random();
    // Generate a random integer between MIN_NUM and MAX_NUM
    int correctNum = rand.nextInt(1 + MAX_NUM - MIN_NUM) + MIN_NUM;
    // Initialize Scanner for user input.
    final Scanner scanner = new Scanner(System.in);
    // DO WHILE LOOP
    do {
      // RESET COLOR
      System.out.print("\033[0m");
      // Prompt for user's guess
      System.out.printf("Enter a guess [%d-%d]: ", MIN_NUM, MAX_NUM);
      // Get user's input for the guess
      String userInput = scanner.nextLine();
      try {
        // Convert user's input to an integer
        final int guess = Integer.parseInt(userInput);
        if (guess < MIN_NUM || guess > MAX_NUM) {
          // Error if the user's guess is outside the valid range. [IN RED]
          System.out.println("\033[0;31mERROR: GUESS CAN'T BE OUTSIDE RANGE");
        } else if (guess > correctNum) {
          // Message if the user's guess is too high
          System.out.println("\033[0;34mYour guess is too high!");
        } else if (guess < correctNum) {
          // Message if the user's guess is too low
          System.out.println("\033[0;34mYour guess is too low!");
        } else {
          // If the guess is not higher than the correct number
          // and if it is not lower than the correct number,
          // then it must be the correct number
          // Congratulate the user
          System.out.println("\033[0;32mYou got the number right!");
          // BREAK OUT OF THE LOOP
          break;
        }
      } catch (NumberFormatException error) {
        // Error message for non-numeric guess. [IN RED]
        System.out.println("\033[0;31mERROR: GUESS MUST BE AN INTEGER");
      }
    } while (true);
    // Close scanner
    scanner.close();
  }
}
