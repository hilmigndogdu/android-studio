package com.hilmigndogdu.apptravel;

public class Cities {

    private String cityName;
    private String countryName;
    private String imageName;

    public Cities(String cityName, String countryName, String imageName) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.imageName = imageName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
