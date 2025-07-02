public class MovieSystem {
    private Movie[] movies = new Movie[50];
    private int count = 0;
    public void addMovie(Movie m) {
        if (count < movies.length) {
            movies[count++] = m;
        }
    }
    public Movie[] getRecommendations(String genre) {
        Movie[] matches = new Movie[count];
        int matchCount = 0;
        for (int i = 0; i < count; i++) {
            if (movies[i].getGenre().equalsIgnoreCase(genre) && movies[i].getRating() >= 1.0) {
                matches[matchCount++] = new RecommendedMovie(
                        movies[i].getTitle(),
                        movies[i].getGenre(),
                        movies[i].getRating()
                );
            }
        }
        Movie[] result = new Movie[matchCount];
        for (int i = 0; i < matchCount; i++) {
            result[i] = matches[i];
        }
        return result;
    }
    public Movie[] getAllMovies() {
        Movie[] all = new Movie[count];
        for (int i = 0; i < count; i++) {
            all[i] = movies[i];
        }
        return all;
    }
}
