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
            IO.println("3. Remove fragrance");
            IO.println("4. Rank fragrance");
            IO.println("5. View ranked fragrances");
            IO.println("6. Quit");
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
                IO.println("Please enter the name of the fragrance you want to remove: ");
                String name = scanner.nextLine();
                boolean found = false;

                for (int i = 0; i < shelf.size(); i++) {
                    if (shelf.get(i).getName().equalsIgnoreCase(name)) {
                        shelf.remove(i);
                        found = true;
                        break;
                    }
                }

                if (found) {
                    IO.println("Removed the fragrance " + name);
                } else {
                    IO.println("Fragrance not found.");
                }
            } else if (choice.equals("4")) {
                IO.println("Please enter the name of the fragrance you want to rank: ");
                String name = scanner.nextLine();

                boolean found = false;
                for (int i = 0; i < shelf.size(); i++) {
                    if (shelf.get(i).getName().equalsIgnoreCase(name)) {
                        found = true;
                        try {

                            Fragrance selected = shelf.get(i);
                            int oldRank = selected.getRank();

                            int rankedCount = 0;
                            for (Fragrance frag : shelf) {
                                if (frag.getRank() > 0) {
                                    rankedCount++;
                                }
                            }
                            int maxRank = rankedCount;
                            if (selected.getRank() == 0) {
                                maxRank++;
                            }

                            IO.println("What would you like to rank " + name + "?");
                            int rank = Integer.parseInt(scanner.nextLine());
                            if (rank < 1 || rank > maxRank) {
                                IO.println("Invalid rank!");
                                break;
                            }

                            for (Fragrance fragrance : shelf) {
                                if (fragrance == selected) {
                                    continue;
                                }

                                int currentRank = fragrance.getRank();

                                if (oldRank == 0) {
                                    if (currentRank >= rank) {
                                        fragrance.setRank(currentRank + 1);
                                    }
                                } else if (rank < oldRank) {
                                    if (currentRank >= rank && currentRank < oldRank) {
                                        fragrance.setRank(currentRank + 1);
                                    }

                                } else if (rank > oldRank) {
                                    if (currentRank > oldRank && currentRank <= rank) {
                                        fragrance.setRank(currentRank - 1);
                                    }
                                }
                            }

                            selected.setRank(rank);
                            IO.println("Successfully ranked " + name + " at #" + rank);
                        } catch (NumberFormatException e) {
                            IO.println("Please enter a number!");
                        }
                        break;
                    }
                }
                if(!found) {
                    IO.println("Cannot find this fragrance!");
                }

            } else if (choice.equals("5")) {

            } else if (choice.equals("6")) {
                running = false;
            } else {
                IO.println("Invalid choice. Please try again.");
            }
        }
    }
}