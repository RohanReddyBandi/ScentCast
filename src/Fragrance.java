import java.util.ArrayList;

public class Fragrance {
    private String name;
    private double price;
    private int rank;
    private ArrayList<String> seasons;

    public Fragrance(String name, double price, String season) {
        this.name = name;
        this.price = price;
        this.seasons = new ArrayList<>();
        this.seasons.add(season.toLowerCase());
        this.rank = 0;
    }

    public void removeSeason(String season) {
        seasons.remove(season.toLowerCase());
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getRank() {
        return rank;
    }
    public ArrayList<String> getSeasons() {
        return new ArrayList<>(seasons);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setRank(int rank) {
        if (rank >= 0) {
            this.rank = rank;
        }
    }

    public void addSeason(String season) {
        if (!seasons.contains(season.toLowerCase())) {
            seasons.add(season.toLowerCase());
        }
    }

    @Override
    public String toString() {
        String rankText = String.valueOf(rank);

        if (rank == 0) {
            rankText = "Unranked";
        }

        return String.format("Name: %s | Price: $%.2f | Rank: %s | Seasons: %s",
                name, price, rankText, String.join(", ", seasons));
    }

}
