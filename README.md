MOVIE RECOMMENDATION SYSTEM 
 VERSION 2
Objectives: 
To develop a simple movie management and recommendation application in Java that allows users 
to: 
• Add movies with title, genre, and rating. 
• Get movie recommendations based on selected genre. 
• Interact through a graphical user interface (GUI). 
 
CONCEPTS USED: 
 
Class 
A class in Java is a blueprint or template used to create objects. It defines attributes (fields) 
and behaviors (methods) that the objects created from the class will have. 
 You have four classes—Movie, RecommendedMovie, MovieSystem, and MovieGUI. 
 
Object 
An object is an instance of a class. It represents a specific entity with values assigned to 
the fields defined in the class. 
In your code: An example is Movie m = new Movie(...), which creates a new movie object 
with given attributes. 
 
Constructor 
A constructor is a special method that is automatically called when an object is created. It 
initializes the fields of the object. The Movie class has a constructor public Movie(String 
title, String genre, double rating) that sets the initial values for title, genre, and rating. 
 
 
 
Encapsulation: 
Encapsulation is the principle of hiding internal class details (like fields) from outside 
access. This is done by declaring variables as private and accessing them via public getter 
methods. The fields title, genre, and rating in the Movie class are private and can be 
accessed through their respective getter methods (getTitle(), getGenre(), and getRating()). 
 
Inheritance: 
Inheritance allows one class (subclass/child) to acquire the properties and methods of 
another class (superclass/parent). This promotes code reusability and logical hierarchy. 
 The RecommendedMovie class inherits from the Movie class using extends, meaning it 
can use all the non-private methods and fields of Movie. 
 
Polymorphism: 
Polymorphism means "many forms." In Java, it typically refers to the ability to redefine 
methods in subclasses, so the same method name behaves differently based on the object 
calling it. The displayInfo() method is defined in both Movie and RecommendedMovie, 
but behaves differently depending on the object type. 
 
Method Overriding 
Method Overriding is a specific type of polymorphism where a subclass provides a new 
implementation for a method that is already defined in its superclass. 
 The RecommendedMovie class overrides the displayInfo() method from the Movie class 
using the @Override annotation to customize the way recommended movies are displayed. 
 
Key Classes and Their Responsibilities: 
1. Movie 
• Represents a movie with basic attributes: 
o title (String) 
o genre (String) 
o rating (double) 
• Method displayInfo() prints the movie details in a formatted style. 
2. RecommendedMovie (Inherits from Movie) 
• A specialized movie class used for recommended results. 
• Overrides displayInfo() to print a visually distinctive message with an emoji (🎬). 
3. MovieSystem 
• Core backend class to manage and store movies. 
• Uses a fixed-size array of 50 movies and tracks the current count. 
• Methods: 
o addMovie(Movie m) – Adds a movie to the system. 
o getRecommendations(String genre) – Returns movies of the same genre with a 
rating ≥ 1.0, wrapped as RecommendedMovie. 
4. MovieGUI 
• Implements the user interface using Java Swing. 
• Displays form fields for user input: 
o Movie title, genre, and rating. 
• Buttons: 
o Add Movie: Adds a movie to the system. 
o Get Recommendations: Retrieves and displays matching movies. 
• JTextArea is used to show messages and recommendations. 
 
Features Implemented: 
Feature Description 
Add Movie Users can enter a title, genre, and rating, then 
save the movie. 
Recommendation by genre Suggests movies with matching genres and 
acceptable ratings. 
GUI based interface Simple Swing interface with form fields and 
buttons for interactions. 
Custom display for recommendations Uses a subclass to change the message format 
for recommended movies. 
 
 
How the Recommendation Works: 
1. User inputs a genre. 
2. The system filters all stored movies: 
o Matching genre. 
o Rating ≥ 0 
3. Wraps those as RecommendedMovie and returns the results. 
 Here we made a code in a design that if the rating is above 4 then recommend that movie. 
But if someone rates the movie below 4 do not recommend it to the viewers. 
 
 
 
 
 
Sample Output: 
After Adding a Movie: 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
After Clicking "Get Recommendations": 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
After Clicking "Show All": 
 
 
 
 
 
 
 
 
 
 
The movie recommendation system implemented in the provided Java code uses a simple yet 
effective genre-based filtering approach. Users can input and store movies by entering their 
title, genre, and rating through a Swing-based GUI. When the "Get Recommendations" button 
is clicked, the system filters the stored movies based on the genre entered by the user and 
selects those with a rating of 1.0 or higher. These matching movies are wrapped as 
RecommendedMovie objects, which display a visually distinct output to highlight 
recommended content. The recommendations are then shown in the output text area of the 
GUI. For example, if the user adds multiple "Action" or "Sci-Fi" movies and requests 
recommendations in that genre, the system will list those high-rated movies as personalized 
suggestions, helping users quickly discover relevant films from their preferred category. 
 
What is Swing GUI in Java? 
Swing GUI refers to a Graphical User Interface framework in Java that allows developers 
to create windows, buttons, text fields, menus, and other graphical elements in desktop 
applications. 
 
 
 
 
 
Key Points About Swing: 
Feature Description 
Library Part of javax.swing package 
Platform-Independent Works across Windows, macOS, and Linux 
Lightweight 
Components 
Built mostly in Java, not dependent on native OS 
widgets 
Rich Components Supports tables, trees, tabbed panes, sliders, etc. 
Customizable Developers can customize the look and behavior of 
components 
 
Case Insensitive: 
If you are saving or adding a movie using small alphabets you can also search it through capital 
alphabets as well. This is because we make the system in such a way that it remains insensitive 
to avoid these type of troubles. 
Flow Chart Diagram: 
 
Conclusion: 
This project provides a clean, modular, and functional movie recommendation system with a GUI 
interface. It is well-structured with clear separation between data, logic, and presentation. It serves 
as a solid foundation for more advanced recommendation features in future enhancements.
