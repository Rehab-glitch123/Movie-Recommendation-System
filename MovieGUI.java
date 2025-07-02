import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MovieGUI {
    MovieSystem system = new MovieSystem();
    public MovieGUI() {
        JFrame frame = new JFrame("🍿 Movie Recommendation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 520);
        frame.setLocationRelativeTo(null); // Center on screen

        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        // Output area declared early for use in all listeners
        JTextArea outputArea = new JTextArea(7, 40);
        outputArea.setFont(font);
        outputArea.setEditable(false);
        outputArea.setBackground(Color.WHITE);
        outputArea.setForeground(new Color(139, 0, 0)); // Dark Red
        outputArea.setBorder(BorderFactory.createLineBorder(new Color(178, 34, 34)));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 30));
        inputPanel.setBackground(new Color(255, 240, 245)); // Light Cream
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel titleLabel = new JLabel(" Movie Title:");
        JTextField titleField = new JTextField();

        JLabel genreLabel = new JLabel(" Genre:");
        JTextField genreField = new JTextField();

        JLabel ratingLabel = new JLabel(" Rating (0 - 5):");
        JTextField ratingField = new JTextField();

        Component[] labels = {titleLabel, genreLabel, ratingLabel};
        for (Component label : labels) {
            label.setFont(font);
            label.setForeground(new Color(178, 34, 34));
        }

        inputPanel.add(titleLabel);
        inputPanel.add(titleField);
        inputPanel.add(genreLabel);
        inputPanel.add(genreField);
        inputPanel.add(ratingLabel);
        inputPanel.add(ratingField);


        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(new Color(255, 240, 245));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));

        // Create smaller buttons with reduced fixed size
        Dimension buttonSize = new Dimension(130, 40);

        JButton addBtn = new JButton(" Add");
        addBtn.setPreferredSize(buttonSize);

        JButton recommendBtn = new JButton(" Recommend");
        recommendBtn.setPreferredSize(buttonSize);

        JButton showAllBtn = new JButton(" Show All");
        showAllBtn.setPreferredSize(buttonSize);

        // Apply consistent font and style
        JButton[] buttons = {addBtn, recommendBtn, showAllBtn};
        for (JButton b : buttons) {
            b.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            b.setForeground(Color.WHITE);
        }

        addBtn.setBackground(new Color(178, 34, 34));
        recommendBtn.setBackground(new Color(255, 99, 71));
        showAllBtn.setBackground(new Color(255, 102, 102));

        // Add to panel
        buttonPanel.add(addBtn);
        buttonPanel.add(recommendBtn);
        buttonPanel.add(showAllBtn);


        // Output Panel
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(178, 34, 34)),
                "📋 Recommendations"
        ));
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setPreferredSize(new Dimension(460, 160));

        // Button Actions
        addBtn.addActionListener(e -> {
            try {
                String title = titleField.getText().trim();
                String genre = genreField.getText().trim();
                double rating = Double.parseDouble(ratingField.getText());

                if (title.isEmpty() || genre.isEmpty()) {
                    outputArea.setText(" Title and Genre must not be empty.");
                } else if (rating < 0 || rating > 5) {
                    outputArea.setText(" Please enter a rating between 0 and 5.");
                } else {
                    Movie movie = new Movie(title, genre, rating);
                    system.addMovie(movie);
                    outputArea.setText(" Movie added: " + title + " (" + genre + ")");
                    titleField.setText("");
                    genreField.setText("");
                    ratingField.setText("");
                }
            } catch (NumberFormatException ex) {
                outputArea.setText(" Please enter a valid numeric rating.");
            }
        });

        recommendBtn.addActionListener(e -> {
            String genre = genreField.getText().trim();
            Movie[] recs = system.getRecommendations(genre);
            if (recs.length == 0) {
                outputArea.setText(" No recommendations found for genre: " + genre);
            } else {
                StringBuilder sb = new StringBuilder(" Recommended Movies:\n");
                for (Movie m : recs) {
                    sb.append("🎬 ").append(m.getTitle())
                            .append(" - ⭐ ").append(m.getRating()).append("\n");
                }
                outputArea.setText(sb.toString());
            }
        });

        showAllBtn.addActionListener(e -> {
            Movie[] all = system.getAllMovies();
            if (all.length == 0) {
                outputArea.setText(" No movies added yet.");
            } else {
                StringBuilder sb = new StringBuilder("🎞️ All Movies:\n");
                for (Movie m : all) {
                    sb.append("🎬 ").append(m.getTitle())
                            .append(" (").append(m.getGenre())
                            .append(") - ⭐ ").append(m.getRating()).append("\n");
                }
                outputArea.setText(sb.toString());
            }
        });
        // Main Layout Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(255, 228, 196)); // Main cream background
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new MovieGUI();
    }
}






