package javaapplication11;

import java.io.*;
import java.util.*;

public class JavaApplication11 {

    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        cargarPeliculasDesdeArchivo("movies.txt", movies);

        Question[] questions = new Question[7];
        questions[0] = new Question("Your movie was made in ", new Option[]{new Option("Japan"), new Option("USA"), new Option("Spain"), new Option("Canada")});
        questions[1] = new Question("Your movie genre is ", new Option[]{new Option("Action"), new Option("Comedy"), new Option("Drama"), new Option("Horror"), new Option("Science Fiction"), new Option("Romance")});
        questions[2] = new Question("Your movie was released between", new Option[]{new Option("1990 and 2000"), new Option("2001 and 2010"), new Option("2011 and 2019"), new Option("2020 and 2024")});
        questions[3] = new Question("Your movie is animated", new Option[]{new Option("Base")});
        questions[4] = new Question("Your movie has an Oscar", new Option[]{new Option("Base")});
        questions[5] = new Question("Your movie is in a Saga", new Option[]{new Option("Base")});
        questions[6] = new Question("Your movie lasts between", new Option[]{new Option("50 and 100 minutes"), new Option("Mas de 100 minutes")});

        boolean finished = false;
        Scanner scanner = new Scanner(System.in);
        boolean decision;
        int nQuestion;
        int nOption;

        do {
            nQuestion = (int) (Math.random() * 3);
            nOption = (int) (Math.random() * questions[nQuestion].getOptions().length);

            if (questions[nQuestion].getElegible() && !questions[nQuestion].getOptions()[nOption].getHasComeOut()) {
                System.out.println(questions[nQuestion].getBase_question() + questions[nQuestion].getOptions()[nOption].getText());
                decision = scanner.nextBoolean();
                questions[nQuestion].getOptions()[nOption].setHasComeOut(true);

                switch (nQuestion) {
                    case 0:
                        for (Movie movie : movies) {
                            if (Objects.equals(movie.getCountry(), questions[nQuestion].getOptions()[nOption].getText())) {
                                if (!decision) {
                                    movie.setElegible(false);
                                }
                            }
                            if (!Objects.equals(movie.getCountry(), questions[nQuestion].getOptions()[nOption].getText())) {
                                if (decision) {
                                    movie.setElegible(false);
                                }
                            }
                        }
                        questions[nQuestion].getOptions()[nOption].setHasComeOut(true);
                        break;
                    case 1:
                        for (Movie movie : movies) {
                            if (Objects.equals(movie.getGenre(), questions[nQuestion].getOptions()[nOption].getText())) {
                                if (!decision) {
                                    movie.setElegible(false);
                                }
                            }
                            if (!Objects.equals(movie.getGenre(), questions[nQuestion].getOptions()[nOption].getText())) {
                                if (decision) {
                                    movie.setElegible(false);
                                }
                            }
                        }
                        questions[nQuestion].getOptions()[nOption].setHasComeOut(true);
                        break;
                    case 2:
                        int y1 = 0;
                        int y2 = 0;
                        if (questions[nQuestion].getOptions()[nOption].getText().equals("1990 and 2000")) {
                            y1 = 1990;
                            y2 = 2000;
                        } else if (questions[nQuestion].getOptions()[nOption].getText().equals("2001 and 2010")) {
                            y1 = 2001;
                            y2 = 2010;
                        } else if (questions[nQuestion].getOptions()[nOption].getText().equals("2011 and 2019")) {
                            y1 = 2011;
                            y2 = 2019;
                        } else if (questions[nQuestion].getOptions()[nOption].getText().equals("2020 and 2024")) {
                            y1 = 2020;
                            y2 = 2024;
                        }
                        for (Movie movie : movies) {
                            if (y1 <= movie.getYear() && movie.getYear() <= y2) {
                                if (!decision) {
                                    movie.setElegible(false);
                                }
                            }
                            if (y1 > movie.getYear() || movie.getYear() > y2) {
                                if (decision) {
                                    movie.setElegible(false);
                                }
                            }
                        }
                        questions[nQuestion].getOptions()[nOption].setHasComeOut(true);
                        break;
                    case 3:
                        break;
                }

                if (decision) {
                    questions[nQuestion].setElegible(false);
                }

                int mCounter = 0;
                for (Movie movie : movies) {
                    if (movie.getElegible()) {
                        System.out.println(movie.getName());
                        mCounter++;
                    }
                }
                if (mCounter == 1) {
                    finished = true;
                    for (Movie moviee : movies) {
                        if (moviee.getElegible()) {
                            System.out.printf("Your movie is " + moviee.getName());
                        }
                    }
                }
            }
        } while (!finished);

    }

    public static void cargarPeliculasDesdeArchivo(String archivo, ArrayList<Movie> movies) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                String director = datos[1];
                String pais = datos[2];
                String genero = datos[3];
                int año = Integer.parseInt(datos[4]);
                boolean esAnimada = Boolean.parseBoolean(datos[5]);
                boolean tieneOscar = Boolean.parseBoolean(datos[6]);
                boolean esSaga = Boolean.parseBoolean(datos[7]);
                int duracion = Integer.parseInt(datos[8]);

                Movie movie = new Movie(nombre, director, pais, genero, año, esAnimada, tieneOscar, esSaga, duracion);
                movies.add(movie);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de los datos: " + e.getMessage());
        }
    }
}
