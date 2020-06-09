/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.koktejly.app.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author m.ambros
 */
@Entity
@Table(name="t_ingredients", schema="co")
public class TIngredient implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="t_ingredients_seq")
    @SequenceGenerator(name="t_ingredients_seq", sequenceName="co.t_ingredients_ingredient_id_seq", allocationSize=1, initialValue=0)
    @Column(name="ingredient_id",nullable = false)
    private Long ingredientId;
    
    @Column(name="name",nullable = false)
    private String name;
    
    
    public TIngredient(){
        super();
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.ingredientId);
        hash = 71 * hash + Objects.hashCode(this.name);
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
        final TIngredient other = (TIngredient) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.ingredientId, other.ingredientId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TIngredient{" + "ingredientId=" + ingredientId + ", name=" + name + '}';
    }


    
}
