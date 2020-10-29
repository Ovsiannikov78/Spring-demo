package de.ovsiannikov.springdemo;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private String[] operatingSystems;

    private LinkedHashMap<String, String> countryOptions;

    private LinkedHashMap<String, String> favoriteLanguageOptions;

    public Student() {

        // populate country options: used ISO country code
        countryOptions = new LinkedHashMap<>();

        countryOptions.put("DE", "Germany");
        countryOptions.put("AU", "Australia");
        countryOptions.put("UA", "Ukraine");
        countryOptions.put("FR", "France");
        countryOptions.put("GB", "Great Britain");

        favoriteLanguageOptions = new LinkedHashMap<>();

        favoriteLanguageOptions.put("Java", "Java");
        favoriteLanguageOptions.put("Kotlin", "Kotlin");
        favoriteLanguageOptions.put("Javascript", "Javascript");
        favoriteLanguageOptions.put("Python", "Python");

    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }


    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
        return favoriteLanguageOptions;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
