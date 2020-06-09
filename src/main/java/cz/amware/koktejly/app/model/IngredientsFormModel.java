/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.koktejly.app.model;

import java.util.Arrays;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 ***
 * @author m.ambros
 */
public class IngredientsFormModel {
    
    private Long[] ingredientIds;

    public IngredientsFormModel() {
        super();
    }

    public Long[] getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(Long[] ingredientIds) {
        this.ingredientIds = ingredientIds;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Arrays.deepHashCode(this.ingredientIds);
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
        final IngredientsFormModel other = (IngredientsFormModel) obj;
        if (!Arrays.deepEquals(this.ingredientIds, other.ingredientIds)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IngredienstFormModel{" + "ingredientIds=" + ingredientIds + '}';
    }
    
    
    
}
