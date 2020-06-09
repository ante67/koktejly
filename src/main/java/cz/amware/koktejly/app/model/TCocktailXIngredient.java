/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.koktejly.app.model;

import cz.amware.koktejly.app.model.CocktailIngredientId;
import cz.amware.koktejly.app.model.TCocktail;
import cz.amware.koktejly.app.model.TIngredient;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author m.ambros
 */
@Entity
@Table(name="t_cocktails_x_ingredients", schema="co")
public class TCocktailXIngredient implements Serializable {
    @EmbeddedId
    private CocktailIngredientId id;

    @ManyToOne
    @MapsId("cocktailId")
    @JoinColumn(name="cocktail_id", nullable=false)
    private TCocktail cocktail;

    
    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name="ingredient_id", nullable=false)
    private TIngredient ingredient;

    public TCocktailXIngredient(CocktailIngredientId id, TCocktail cocktail, TIngredient ingredient) {
        this.id = id;
        this.cocktail = cocktail;
        this.ingredient = ingredient;
    }
    
    
    
    public TCocktailXIngredient(){
        super();
    }

    public CocktailIngredientId getId() {
        return id;
    }

    public void setId(CocktailIngredientId id) {
        this.id = id;
    }

    public TCocktail getCocktail() {
        return cocktail;
    }

    public void setCocktail(TCocktail cocktail) {
        this.cocktail = cocktail;
    }

    public TIngredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(TIngredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.cocktail);
        hash = 47 * hash + Objects.hashCode(this.ingredient);
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
        final TCocktailXIngredient other = (TCocktailXIngredient) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cocktail, other.cocktail)) {
            return false;
        }
        if (!Objects.equals(this.ingredient, other.ingredient)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TCocktailXIngredient{" + "id=" + id + ", cocktail=" + cocktail + ", ingredient=" + ingredient + '}';
    }
    
}
