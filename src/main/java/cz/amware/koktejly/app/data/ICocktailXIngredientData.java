/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.koktejly.app.data;

import cz.amware.koktejly.app.model.TCocktailXIngredient;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author m.ambros
 */
public interface ICocktailXIngredientData extends JpaRepository<TCocktailXIngredient, Long> {
    @Query("SELECT ci FROM TCocktailXIngredient ci WHERE ci.id.cocktailId = :cocktailId")
    public List<TCocktailXIngredient> findIngredientsByCocktailId(@Param("cocktailId") Long cocktailId);
    
}
