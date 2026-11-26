import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    void main() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Fragrance> shelf = new ArrayList<>();
        boolean running = true;

        while (running) {
            IO.println("Welcome to ScentCast!");
            IO.println("______________________________");
            IO.println("1. Add fragrance");
            IO.println("2. View fragrances");
            IO.println("3. Quit");
            IO.println("______________________________");
            IO.println("Enter your choice: ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                IO.println("Please enter the name of the fragrance you want to add: ");
                String name = scanner.nextLine();
                IO.println("Please enter the price of the fragrance you want to add: ");
                double price = Double.parseDouble(scanner.nextLine());
                IO.println("Please enter the season(s) this fragrance works best in(\"Summer, Spring, Fall, Winter\"): ");
                String[] seasons = scanner.nextLine().split("\\s*,\\s*");
                Fragrance fragrance = new Fragrance(name, price, seasons[0]);

                for (int i = 1; i < seasons.length; i++) {
                    fragrance.addSeason(seasons[i]);
                }

                shelf.add(fragrance);

            }  else if (choice.equals("2")) {
                if (shelf.isEmpty()) {
                    IO.println("Your shelf is empty. Add some Fragrances!");
                } else {
                    for (Fragrance fragrance : shelf) {
                        IO.println(fragrance);
                    }
                }
            }   else if (choice.equals("3")) {
                running = false;
            } else {
                IO.println("Invalid choice. Please try again.");
            }

        }
    }
}