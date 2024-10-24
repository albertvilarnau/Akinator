package javaapplication11;

public class Movie {
    private String name;
    private String director;
    private String country;
    private String genre;
    private int year;
    private boolean isAnimated;
    private boolean haveOscar;
    private boolean inSaga;
    private int durationMins;
    private boolean elegible;

    public Movie(String name, String director, String country, String genre, int year,
                 boolean isAnimated, boolean haveOscar, boolean inSaga, int durationMins) {
        this.name = name;
        this.director = director;
        this.country = country;
        this.genre = genre;
        this.year = year;
        this.isAnimated = isAnimated;
        this.haveOscar = haveOscar;
        this.inSaga = inSaga;
        this.durationMins = durationMins;
        this.elegible = true;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public String getCountry() {
        return country;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public boolean isAnimated() {
        return isAnimated;
    }

    public boolean isHaveOscar() {
        return haveOscar;
    }

    public boolean isInSaga() {
        return inSaga;
    }

    public int getDurationMins() {
        return durationMins;
    }

    public void setElegible(boolean elegible){
        this.elegible = elegible;
    }

    public boolean getElegible(){
        return elegible;
    }

    // Métodos set
    public void setName(String name) {
        this.name = name;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAnimated(boolean isAnimated) {
        this.isAnimated = isAnimated;
    }

    public void setHaveOscar(boolean haveOscar) {
        this.haveOscar = haveOscar;
    }

    public void setInSaga(boolean inSaga) {
        this.inSaga = inSaga;
    }

    public void setDurationMins(int durationMins) {
        this.durationMins = durationMins;
    }
}
