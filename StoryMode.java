import java.util.Scanner;
import java.util.InputMismatchException;

public class StoryMode implements GameMode {
    private Scanner scanner;

    public StoryMode(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void startGame() {
        System.out.println("\nBullets and explosions are heard as usual as german soldiers passes through and killing remaining russian troops");
        System.out.println("Pretending to be dead with the corpses of your comrades have helped you survive this far, What will you do now Private?");
        System.out.println("1. Wait when there is silence.");
        System.out.println("2. Start to slowly crawl to the destroyed building.");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            waitSilence();
        } else if (choice == 2) {
            slowlyCrawl();
        }
    }

    private void waitSilence() {
        System.out.println("\nYou still hear the gunshots continue and boots marching on the wet pavement, screaming of commands continue to get closer");
        System.out.println("Gunshots starts firing towards the corpses of russian soldiers. Making sure that they are good as dead...");
        System.out.println("1. Pray and hope that they stop shooting. Stay still and wait");
        System.out.println("2. Knowing that the enemy is closing in with no escape, get your pistol and shoot your enemies 'til the end");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            gameOver("Bullets keeps on shooting as they are thorough, a bullet rang as your life quickly pass. You join the rest of your comrades in an endless sleep in the muddy trench.");
        } else if (choice == 2) {
            System.out.println("You say your goodbyes silently that you know you will never go back home, you get up as blood and mud cover your person.");
            gameOver("With anger and acceptance...you raised your pistols at your enemies to bring them down with you, fought until your last breath fades within the godforsaken battlefield.");
        }
    }

    private void slowlyCrawl() {
        System.out.println("\nYou find yourself crawling within the broken building, a bar. Memories of people chatting and filled with laughter...now a ghost of what it was once");
        System.out.println("Do you:");
        System.out.println("1. Raise your head to see where the enemies are and if it is safe");
        System.out.println("2. Keep moving within and don't stop moving");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            System.out.println("You raised your head as you look through the window, you take a breather as you feel a semblance of safety again. But there is a singular shot rang...");
            gameOver("You do not know where it has come from. Though you felt your body fall to the floor and mind blank. Perhaps there was a sniper hidded within a building that have seen you");
        } else if (choice == 2) {
            escapeThroughWindow();
        }
    }

    private void escapeThroughWindow() {
        System.out.println("\nYou continue to move through the building, screaming of both different languages and exlposions continues to fill the battlefield outside");
        System.out.println("There you have seen the other friendly troops, finally a chance of breathing another day. You just need to go across the hallway");
        System.out.println("1. Try to sneak and slow down movement to go there.");
        System.out.println("2. Have your pistol ready in your hand and RUN.");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        
        if (choice == 1) {
            System.out.println("You try to pass by as you duck through the window, but you are not looking at the hallway. A wounded german soldier had the time raise their Luger and take a shot a final time");
            gameOver("Shot rang as you are fatally shot through the lung, your body falls back to the cold floor as you then bleed to death");
        } else if (choice == 2) {
            System.out.println("You ran as you are covered in mud and blood, you have seen a wounded german soldier leaning on a crate as he wheeze and cough. Your hand automatically raises the gun");
            System.out.println("You pulled the trigger as he is now finally dead, you keep on running and barge through the door. You seen your comrades");
            System.out.println("You are safe for now as they welcome you back with a smile of surprise and a pat on the back");
        }
    }

    private void gameOver(String message) {
        System.out.println("\n" + message);
        System.out.println("You have died.");
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
