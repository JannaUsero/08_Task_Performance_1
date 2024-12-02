
import java.util.Scanner;
import java.util.InputMismatchException;

public class SurvivalMode implements GameMode {
    private Scanner scanner;

    public SurvivalMode(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void startGame() {
        System.out.println("\nYou are in the woods as you know a killer is still after you");
        System.out.println("What do you do?");
        System.out.println("1. Hide in the abandoned cursed house");
        System.out.println("2. Continue to run");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            hideHouse();
        } else if (choice == 2) {
            continueRun();
        }
    }

    private void hideHouse() {
        System.out.println("You find a gun conveniently on the desk");
        System.out.println("what is your choice?");
        System.out.println("1. Wait for the killer to fight.");
        System.out.println("2. Don't touch stuff and don't stay at the creepy house, run outside instead");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            System.out.println("you have waited and the killer comes through the door, though there is a strange surge in your arm");
            gameOver("you started to aim the gun to your head as you now feel panic, the gun is cursed that you find yourself pressing the trigger...");
        } else if (choice == 2) {
            continueRun();
        }
    }

    private void continueRun() {
        System.out.println("\nYou see a phone booth conveniently in the middle of the forest");
        System.out.println("what is your choice?:");
        System.out.println("1. Call 911 or anyone for help");
        System.out.println("2. Ignore and just run");
        System.out.print("Enter your choice: ");
        int choice = getChoice();
        
        if (choice == 1) {
            gameOver("No service, its the middle of the dang woods. The killer catches up and ends your life. The booth is now your personal casket");
        } else if (choice == 2) {
            ignoreJustRun();
        }
    }

    private void ignoreJustRun() {
        System.out.println("\nYou have run and found the street but there is no people around, he continues to chase you");
        System.out.println("what is your choice?:");
        System.out.println("1. Just run and pretty much start to scream for help");
        System.out.println("2. Try to hide in a bush");
        System.out.print("Enter your choice: ");
        int choice = getChoice();
        
        if (choice == 1) {
            runScreaming();
        } else if (choice == 2) {
            gameOver("The killer knows better since its strange that there is no footsteps, he searched around and ended up finding you in the bush");
        }
    }

    private void runScreaming() {
        System.out.println("\nYou scream and run and flail your hands, you are familiar with the street that your friend's house is close.");
        System.out.println("Though there is the police station in two blocks, so what will you do?:");
        System.out.println("1. Go bang on your friend's door and scream for help");
        System.out.println("2. Go to the Police Station instead");
        System.out.print("Enter your choice: ");
        int choice = getChoice();
        
        if (choice == 1) {
            gameOver("You keep continue on banging but no response, its either that your friend is so slow or she is out in like a party. The killer catches up to you");
        } else if (choice == 2) {
            policeStation();
        }
    }

    private void policeStation() {
        System.out.println("\nYou ran to the police station but you see a granny in the middle of the night sitting on the bench");
        System.out.println("Your night is so curse that you are sure there are supernatural things happening at this point");
        System.out.println("1. Ignore her, she's not your problem. Just go to the Poloce Station");
        System.out.println("2. Try to warn Grandma");
        System.out.print("Enter your choice: ");
        int choice = getChoice();
        
        if (choice == 1) {
            System.out.println("\nYou ran and burst through the door, the police officer's shocked and confused face is somehow comforting as you are now safe");
            System.out.println("Congratutations you survived");
        } else if (choice == 2) {
            gameOver("You try to warn Granny but she just eerily smiles, you can't move as you feel paralyzed. The killer catches up to you");
        }
    }

    private void gameOver(String message) {
        System.out.println("\n" + message);
        System.out.println("You are now dead.");
        System.out.println("Game Over.");
    }

    private int getChoice() {
        int choice = -1;
        boolean valid = false;
        
        while (!valid) {
            try {
                choice = scanner.nextInt();
                valid = choice == 1 || choice == 2;
                if (!valid) {
                    System.out.println("\nInvalid choice! Please choose 1 or 2.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("\nInvalid input. Please enter a number.");
            }
        }
        return choice;
    }
}
