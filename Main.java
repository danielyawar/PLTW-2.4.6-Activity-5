import java.util.Scanner;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    
    int score = 35;
    
    System.out.println("Welcome to our guessing game! The theme is farm animals! You will be given 5 hints towards which   animal is the correct one and you can make 3 incorrect guesses before you lose.");


    String[] cowhints = {"Produces a liquid that is largely used by humans", "Generally have a white body and black spots", "On average, they weigh around 1200 lbs", "Are Herbivores"};
    String[] pighints = {"Are usually Pink", "Unclean due to rolling in mud", "Weigh around 650 lbs as a male adult", "Are Omnivores"};
    String[] chickenhints = {"Have the ability to fly", "Generally have a white body, with a yellow mouth area", "On average, they weigh around 5.7 lbs", "Can live up to 10 years"};
    
    Game cow = new Game("cow", cowhints);
    Game pig = new Game("pig", pighints);
    Game chicken = new Game("chicken", chickenhints);

    String lastGuess = "lol";
    Game[] animals = {cow, pig, chicken};
    
    // Create a random object
    Random random = new Random();

    // Generate a random index within the range of the array
    int randomIndex = random.nextInt(animals.length);

    // Get the random element from the array
    Game animal = animals[randomIndex];

    boolean gameStatus = false;
    while (score>0){
      System.out.println("___________________________________________________________________");
      System.out.println("Please guess the animal or ask for a hint");
      Scanner sc = new Scanner(System.in);
      String guess = sc.nextLine().toLowerCase();
      if (guess.equals(animal.answer)){
        System.out.println("Correct! The animal was a " + animal.answer);
        gameStatus = true;
        break;
        
    }
        else if (guess.equals("hint")){
          score -= animal.getHint(lastGuess);
          System.out.println("You have " + score + " points left");
          }
        
      else{
    score -= animal.scoreDeduction(guess);
    System.out.println("Incorrect! You have " + score + " points left");
    lastGuess = guess;
    }
      
    }

    

    if(score<=0 && animal.hintsLeft > 0){
      System.out.println("You ran out of score! Your hints times 10 will now be converted to score.");
      score = animal.hintsLeft*10;
      System.out.println("You have " + score + " points left");
      gameStatus = false;
      while (score>0){
        System.out.println("___________________________________________________________________");
        System.out.println("Please guess the animal or ask for a hint");
        Scanner sc = new Scanner(System.in);
        String guess = sc.nextLine().toLowerCase();
        if (guess.equals(animal.answer)){
          System.out.println("Correct! The animal was a " + animal.answer);
          gameStatus = true;
          break;

      }
          else if (guess.equals("hint")){
            score -= animal.getHint(lastGuess);
            System.out.println("You have " + score + " points left");
            }

        else{
      score -= animal.scoreDeduction(guess);
      System.out.println("Incorrect! You have " + score + " points left");
      lastGuess = guess;
          gameStatus = false;
      }

      }}

      if(gameStatus == false){
        System.out.println("YOU LOSE! The animal was a " + animal.answer);
      System.out.println(
        "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
        "███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀\n" +
         "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼█┼┼┼██┼██┼┼┼\n" +
         "██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀\n" +
         "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼\n" +
         "███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄\n" +
         "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
         "███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼\n" +
         "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼\n" +
         "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼\n" +
         "██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼\n" +
         "███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄");

      }
    else if (gameStatus == true) {
  System.out.println("____    ____  ______    __    __     ____    __    ____  __  .__   __.  __  ");
  System.out.println("\\   \\  /   / /  __  \\  |  |  |  |    \\   \\  /  \\  /   / |  | |  \\ |  | |  | ");
  System.out.println(" \\   \\/   / |  |  |  | |  |  |  |     \\   \\/    \\/   /  |  | |   \\|  | |  | ");
  System.out.println("  \\_    _/  |  |  |  | |  |  |  |      \\            /   |  | |  . `  | |  | ");
  System.out.println("    |  |    |  `--'  | |  `--'  |       \\    /\\    /    |  | |  |\\   | |__| ");
  System.out.println("    |__|     \\______/   \\______/         \\__/  \\__/     |__| |__| \\__| (__) ");
  System.out.println("                                                                                       ");
}
  }
}
