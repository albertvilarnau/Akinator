package javaapplication11;
import java.util.Scanner;


public class JavaApplication11 {

    public static void main(String[] args) {
        Movie[] movies = new Movie[30];

        // Action
        movies[0] = new Movie("The Matrix", "Lana Wachowski, Lilly Wachowski", "USA", "Action", 1999, false, false, false, 136);
        movies[1] = new Movie("The Dark Knight", "Christopher Nolan", "USA", "Action", 2008, false, true, false, 152);
        movies[2] = new Movie("Avengers: Infinity War", "Anthony Russo, Joe Russo", "USA", "Action", 2018, false, false, true, 149);
        movies[3] = new Movie("Spider-Man: Across the Spider-Verse", "Joaquim Dos Santos, Kemp Powers, Justin K. Thompson", "USA", "Action", 2023, true, false, false, 140);
        movies[4] = new Movie("Inception", "Christopher Nolan", "USA", "Action", 2010, false, true, false, 148);

        // Comedy
        movies[5] = new Movie("Toy Story", "John Lasseter", "USA", "Comedy", 1995, true, true, false, 81);
        movies[6] = new Movie("Shrek", "Andrew Adamson, Vicky Jenson", "USA", "Comedy", 2001, true, true, false, 90);
        movies[7] = new Movie("Campeones", "Javier Fesser", "Spain", "Comedy", 2018, false, false, false, 124);
        movies[8] = new Movie("Torrente, el brazo tonto de la ley", "Santiago Segura", "Spain", "Comedy", 1998, false, false, false, 90);
        movies[9] = new Movie("The Wolf of Wall Street", "Martin Scorsese", "USA", "Comedy", 2013, false, true, false, 180);

        // Drama
        movies[10] = new Movie("Goodfellas", "Martin Scorsese", "USA", "Drama", 1990, false, true, false, 146);
        movies[11] = new Movie("Gladiator", "Ridley Scott", "USA", "Drama", 2000, false, true, false, 155);
        movies[12] = new Movie("Coco", "Lee Unkrich, Adrian Molina", "USA", "Drama", 2017, true, true, false, 105);
        movies[13] = new Movie("La Sociedad de la Nieve", "J.A. Bayona", "Spain", "Drama", 2023, false, false, false, 136);
        movies[14] = new Movie("The Truman Show", "Peter Weir", "USA", "Drama", 1998, false, false, false, 103);

        // Horror
        movies[15] = new Movie("Cube", "Vincenzo Natali", "Canada", "Horror", 1997, false, false, false, 90);
        movies[16] = new Movie("Saw", "James Wan", "USA", "Horror", 2004, false, false, false, 103);
        movies[17] = new Movie("Coraline", "Henry Selick", "USA", "Horror", 2009, true, false, false, 100);
        movies[18] = new Movie("[REC]", "Jaume Balagueró, Paco Plaza", "Spain", "Horror", 2007, false, false, false, 78);
        movies[19] = new Movie("Smile", "Parker Finn", "USA", "Horror", 2022, false, false, false, 115);

        // Science Fiction
        movies[20] = new Movie("Interstellar", "Christopher Nolan", "USA", "Science Fiction", 2014, false, true, false, 169);
        movies[21] = new Movie("WALL•E", "Andrew Stanton", "USA", "Science Fiction", 2008, true, true, false, 98);
        movies[22] = new Movie("The End of Evangelion", "Hideaki Anno", "Japan", "Science Fiction", 1997, false, false, false, 87);
        movies[23] = new Movie("Avatar", "James Cameron", "USA", "Science Fiction", 2009, false,false, false, 162);
        movies[24] = new Movie("Dune", "Denis Villeneuve", "USA", "Science Fiction", 2021, false, false, false, 155);

        // Romance
        movies[25] = new Movie("Your Name", "Makoto Shinkai", "Japan", "Romance", 2016, true, false, false, 106);
        movies[26] = new Movie("La La Land", "Damien Chazelle", "USA", "Romance", 2016, false, true, false, 128);

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
