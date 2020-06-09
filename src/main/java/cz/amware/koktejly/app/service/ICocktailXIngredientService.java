/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.koktejly.app.service;

import cz.amware.koktejly.app.model.TCocktailXIngredient;
import java.util.List;

/**
 *
 * @author m.ambros
 */
public interface ICocktailXIngredientService {
    
    public List<TCocktailXIngredient> findAllCocktailsByIngredientIds(List<Long> ingredientIds);
    
}
