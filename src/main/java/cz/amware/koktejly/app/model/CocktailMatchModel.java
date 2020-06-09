/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.koktejly.app.model;

import java.util.Objects;

/**
 *
 * @author m.ambros
 */
public class CocktailMatchModel {
    private String cocktailName;
    private String percentageMatch;
    private String url;

    public CocktailMatchModel() {
        super();
    }

    public CocktailMatchModel(String cocktailName, String percentageMatch, String url) {
        this.cocktailName = cocktailName;
        this.percentageMatch = percentageMatch;
        this.url = url;
    }

    public String getCocktailName() {
        return cocktailName;
    }

    public void setCocktailName(String cocktailName) {
        this.cocktailName = cocktailName;
    }

    public String getPercentageMatch() {
        return percentageMatch;
    }

    public void setPercentageMatch(String percentageMatch) {
        this.percentageMatch = percentageMatch;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.cocktailName);
        hash = 37 * hash + Objects.hashCode(this.percentageMatch);
        hash = 37 * hash + Objects.hashCode(this.url);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CocktailMatchModel other = (CocktailMatchModel) obj;
        if (!Objects.equals(this.cocktailName, other.cocktailName)) {
            return false;
        }
        if (!Objects.equals(this.percentageMatch, other.percentageMatch)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CocktailMatchModel{" + "cocktailName=" + cocktailName + ", percentageMatch=" + percentageMatch + ", url=" + url + '}';
    }
    
}
