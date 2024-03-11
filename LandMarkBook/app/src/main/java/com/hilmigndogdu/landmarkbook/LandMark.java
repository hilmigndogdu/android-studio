package com.hilmigndogdu.landmarkbook;

import java.io.Serializable;

public class LandMark implements Serializable {

    String name;
    String country;
    int image;

    public LandMark(String name, String country, int image) {
        this.name = name;
        this.country = country;
        this.image = image;
    }

}
