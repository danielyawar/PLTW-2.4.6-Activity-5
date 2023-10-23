import java.util.Scanner;
import java.util.Random;

class Game {
  String answer;
  String[] hints;
  String[] guesses;
  int hintsLeft=5;
  int guessesLeft;
  Scanner sc = new Scanner(System.in);


  public Game(String answer, String[] hints){
    this.answer = answer;
    this.hints = hints;
  }

  public int getHint(String lastGuess){
    if(!(hintsLeft>0)){
      System.out.println("You have ran out of your hints! Try guessing instead?");
    }
    while(hintsLeft>0){
    System.out.println("There are " + (hintsLeft) + " hints");
    System.out.println("Which number hint would you like to use?");
    hintsLeft--;
    int hintNum = sc.nextInt();
    if (hintNum == hints.length+1){
      if (lastGuess.substring(0,1).compareTo(this.answer.substring(0,1)) < 0) {
          System.out.println("Your last guess is alphabetically before the correct answer.");
      } else if (lastGuess.substring(0,1).compareTo(this.answer.substring(0,1)) < 0) {
          System.out.println("Your last guess is alphabetically after the correct answer.");
      }
      else{
        System.out.println("Your last guess is about alphabetically the same as the correct answer.");
      }
    }
    else{
    System.out.println(hints[hintNum-1]);}
    return 10;
    }
    return 10;
  }

  public int scoreDeduction(String guess){
    int deduction = 0;
    for(int i = 0; i < guess.length(); i++){
      if(this.answer.contains(guess.substring(i,i+1))){
        ;
      }
      else{
        deduction++;
        deduction ++;
      }
    }
    return deduction;
  }

}
