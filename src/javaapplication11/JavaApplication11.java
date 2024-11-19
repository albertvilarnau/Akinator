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
        questions[2] = new Question("Your movie was released between ", new Option[]{new Option("1990 and 2000"), new Option("2001 and 2010"), new Option("2011 and 2019"), new Option("2020 and 2024")});
        questions[3] = new Question("Your movie is animated", new Option[]{new Option("")});
        questions[4] = new Question("Your movie has an Oscar", new Option[]{new Option("")});
        questions[5] = new Question("Your movie is in a Saga", new Option[]{new Option("")});
        questions[6] = new Question("Your movie lasts between ", new Option[]{new Option("50 and 100 minutes"), new Option("more than 100 minutes")});

        boolean finished = false;
        Scanner scanner = new Scanner(System.in);
        int nQuestion;
        int nOption;
        boolean decision = false;

        do {
            nQuestion = (int) (Math.random() * 7);
            nOption = (int) (Math.random() * questions[nQuestion].getOptions().length);

            if (questions[nQuestion].getElegible() && !questions[nQuestion].getOptions()[nOption].getHasComeOut()) {
                System.out.println(questions[nQuestion].getBase_question() + questions[nQuestion].getOptions()[nOption].getText());

                String decision_auxiliar = "";
                boolean n  = true;
                while(n) {
                    decision_auxiliar = scanner.nextLine();
                    if (decision_auxiliar.equals("yes") || decision_auxiliar.equals("y") ||
                            decision_auxiliar.equals("true") || decision_auxiliar.equals("si")) {
                        decision = true;
                        n = false;
                    } else if (decision_auxiliar.equals("no") || decision_auxiliar.equals("n") ||
                            decision_auxiliar.equals("false") || decision_auxiliar.equals("nope")) {
                        decision = false;
                        n = false;
                    } else {
                        System.out.println("unrecognized entry");
                    }
                }
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
                        for (Movie movie : movies) {
                            if(decision){
                                if(!movie.isAnimated()){
                                    movie.setElegible(false);
                                }
                            }
                            if(!decision){
                                if(movie.isAnimated()){
                                    movie.setElegible(false);
                                }
                            }
                        }
                        questions[nQuestion].getOptions()[nOption].setHasComeOut(true);
                        break;
                    case 4:
                        for (Movie movie : movies) {
                            if(decision){
                                if(!movie.isHaveOscar()){
                                    movie.setElegible(false);
                                }
                            }
                            if(!decision){
                                if(movie.isHaveOscar()){
                                    movie.setElegible(false);
                                }
                            }
                        }
                        questions[nQuestion].getOptions()[nOption].setHasComeOut(true);
                        break;
                    case 5:
                        for (Movie movie : movies) {
                            if(decision){
                                if(!movie.isInSaga()){
                                    movie.setElegible(false);
                                }
                            }
                            if(!decision){
                                if(movie.isInSaga()){
                                    movie.setElegible(false);
                                }
                            }
                        }
                        questions[nQuestion].getOptions()[nOption].setHasComeOut(true);
                        break;
                    case 6:
                        int num1 = 0;
                        int num2 = 0;
                        if (nOption == 0){
                            num1 = 50;
                            num2 = 100;
                        } else if(nOption == 1){
                            num1 = 101;
                            num2 = 1000;
                        }
                        for (Movie movie : movies) {
                            if (num1 <= movie.getDurationMins() && movie.getDurationMins() <= num2) {
                                if (!decision) {
                                    movie.setElegible(false);
                                }
                            }
                            if (num1 > movie.getDurationMins() || movie.getDurationMins() > num2) {
                                if (decision) {
                                    movie.setElegible(false);
                                }
                            }
                        }
                        questions[nQuestion].getOptions()[nOption].setHasComeOut(true);
                        break;

                }

                if (decision) {
                    questions[nQuestion].setElegible(false);
                }

                int mCounter = 0;
                for (Movie movie : movies) {
                    if (movie.getElegible()) {
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
                } else if(mCounter == 0){
                    finished = true;
                    System.out.println("La pelicula no existe en nuestra base de datos");
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
