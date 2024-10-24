package javaapplication11;
import java.util.Scanner;
import java.util.Random;

public class JavaApplication11 {

    public static void main(String[] args) {

        String[] questions = new String[]{
                "Your movie was made in USA?",
                "Your movie was made in Spain?",
                "Your movie was made in Canada?",
                "Your movie was made in Japan?",
                "Your movie was released between 1990 and 2000?",
                "Your movie was released between 2001 and 2010?",
                "Your movie was released between 2011 and 2019?",
                "Your movie was released between 2020 and 2024?",
                "Your movie is animated?",
                "Your movie is in a saga?",
                "Your movie has an Oscar?",
                "Your movie is 90 minutes or more?",
        };

        Movie[] movies = {
                // Action
                new Movie("The Matrix", "Lana Wachowski, Lilly Wachowski", "USA", "Action", 1999, false, false, false, 136),
                new Movie("The Dark Knight", "Christopher Nolan", "USA", "Action", 2008, false, true, false, 152),
                new Movie("Avengers: Infinity War", "Anthony Russo, Joe Russo", "USA", "Action", 2018, false, false, true, 149),
                new Movie("Spider-Man: Across the Spider-Verse", "Joaquim Dos Santos, Kemp Powers, Justin K. Thompson", "USA", "Action", 2023, true, false, false, 140),
                new Movie("Inception", "Christopher Nolan", "USA", "Action", 2010, false, true, false, 148),

                // Comedy
                new Movie("Toy Story", "John Lasseter", "USA", "Comedy", 1995, true, true, false, 81),
                new Movie("Shrek", "Andrew Adamson, Vicky Jenson", "USA", "Comedy", 2001, true, true, false, 90),
                new Movie("Campeones", "Javier Fesser", "Spain", "Comedy", 2018, false, false, false, 124),
                new Movie("Torrente, el brazo tonto de la ley", "Santiago Segura", "Spain", "Comedy", 1998, false, false, false, 90),
                new Movie("The Wolf of Wall Street", "Martin Scorsese", "USA", "Comedy", 2013, false, true, false, 180),

                // Drama
                new Movie("Goodfellas", "Martin Scorsese", "USA", "Drama", 1990, false, true, false, 146),
                new Movie("Gladiator", "Ridley Scott", "USA", "Drama", 2000, false, true, false, 155),
                new Movie("Coco", "Lee Unkrich, Adrian Molina", "USA", "Drama", 2017, true, true, false, 105),
                new Movie("La Sociedad de la Nieve", "J.A. Bayona", "Spain", "Drama", 2023, false, false, false, 136),
                new Movie("The Truman Show", "Peter Weir", "USA", "Drama", 1998, false, false, false, 103),

                // Horror
                new Movie("Cube", "Vincenzo Natali", "Canada", "Horror", 1997, false, false, false, 90),
                new Movie("Saw", "James Wan", "USA", "Horror", 2004, false, false, false, 103),
                new Movie("Coraline", "Henry Selick", "USA", "Horror", 2009, true, false, false, 100),
                new Movie("[REC]", "Jaume Balagueró, Paco Plaza", "Spain", "Horror", 2007, false, false, false, 78),
                new Movie("Smile", "Parker Finn", "USA", "Horror", 2022, false, false, false, 115),

                // Science Fiction
                new Movie("Interstellar", "Christopher Nolan", "USA", "Science Fiction", 2014, false, true, false, 169),
                new Movie("WALL•E", "Andrew Stanton", "USA", "Science Fiction", 2008, true, true, false, 98),
                new Movie("The End of Evangelion", "Hideaki Anno", "Japan", "Science Fiction", 1997, true, false, false, 87),
                new Movie("Avatar", "James Cameron", "USA", "Science Fiction", 2009, false,false, false, 162),
                new Movie("Dune", "Denis Villeneuve", "USA", "Science Fiction", 2021, false, false, false, 155),

                // Romance
                new Movie("Your Name", "Makoto Shinkai", "Japan", "Romance", 2016, true, false, false, 106),
                new Movie("La La Land", "Damien Chazelle", "USA", "Romance", 2016, false, true, false, 128)
        };


        Scanner scanner = new Scanner(System.in);
        boolean decision;
        System.out.println("La pelicula salio en 2015 o mas adelante?");
        decision = scanner.nextBoolean();

        for(int i = 0; i <= 26; i++){
            if(decision) {
                if (movies[i].getYear() < 2015) {
                    movies[i].setElegible(false);
                }
            } if(!decision){
                if (movies[i].getYear() >= 2015) {
                    movies[i].setElegible(false);
                }
            }
        }

        for(int i = 0; i <= 26; i++){
            if (movies[i].getElegible()) {
                System.out.println(movies[i].getName() + " " + movies[i].getYear());
            }
        }
    }
}
