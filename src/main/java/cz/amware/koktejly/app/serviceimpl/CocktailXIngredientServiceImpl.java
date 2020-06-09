/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.koktejly.app.serviceimpl;

import java.util.List;

import cz.amware.koktejly.app.service.ICocktailXIngredientService;
import cz.amware.koktejly.app.model.TCocktailXIngredient;
import cz.amware.koktejly.app.data.ICocktailXIngredientData;
//import cz.amware.firstjava.app.model.*;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author m.ambros
 */
@Service
public class CocktailXIngredientServiceImpl implements ICocktailXIngredientService {
    @Autowired
    ICocktailXIngredientData cocktailXIngredientData;
    
    @Override
    public List<TCocktailXIngredient> findAllCocktailsByIngredientIds(List<Long> ingredientIds){
        return cocktailXIngredientData.findAll().stream()
            .filter(record -> ingredientIds.contains(record.getIngredient().getIngredientId()))
            .distinct()
            .collect(Collectors.toList());
                    
                    
                    
                    //getIngredient().getIngredientID()))
               // .distinct().collect(Collectors.toList());
        
        //cocktailXIngredientData.
        //return null;
    }
    
    
}
