package Model;

public class Book {
    private String title;
    private int starRating;

    public Book(String title, int starRating) {
        this.title = title;
        this.starRating = starRating;
    }

    public String getTitle() {
        return title;
    }

    public int getStarRating() {
        return starRating;
    }
}
