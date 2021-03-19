package me.mustache.location;

public class City extends Location {

    private static String pOrt;
    private boolean city;


    public City(String pOrt) {
        super(pOrt);

        city = true;

    }



    public String getInCity() {
        return pOrt;
    }

    public void setOrt(String pOrt) {
        this.pOrt = pOrt;
    }


}



