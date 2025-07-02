public class RecommendedMovie extends Movie {
    public RecommendedMovie(String title, String genre, double rating) {
        super(title, genre, rating);
    }
    @Override
    public void displayInfo() {
        System.out.println("🎬 Recommended: " + getTitle() + " (" + getGenre() + ") - Rating: " + getRating());
    }
}
