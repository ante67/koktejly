/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.koktejly.app.controller;

import cz.amware.koktejly.app.data.ICocktailData;
import cz.amware.koktejly.app.data.ICocktailXIngredientData;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.amware.koktejly.app.data.IIngredientData;
import cz.amware.koktejly.app.model.CocktailMatchModel;
import cz.amware.koktejly.app.model.IngredientsFormModel;
import cz.amware.koktejly.app.model.TCocktail;
import cz.amware.koktejly.app.model.TCocktailXIngredient;
import cz.amware.koktejly.app.service.ICocktailXIngredientService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author m.ambros
 */

@Controller
public class IngredientController {
    
   String welcome1 = "JEBAT";

    
    @Autowired
    private IIngredientData ingredientData; 
    
    @Autowired
    private ICocktailXIngredientService cocktailXIngredientService;
    
    @Autowired
    private ICocktailXIngredientData cocktailXIngredientData;
    
    @Autowired
    private ICocktailData cocktailData;

    
    private static final double MIN_PERCENTAGE_MATCH = 0.5;
    
    @GetMapping("/") /*local url  http://localhost:8080/ingredients */
    public String index(Model model){            
        model.addAttribute("ingredientsFormModel", new IngredientsFormModel());
        model.addAttribute("ingredients",ingredientData.findAll());         
        return "index";  /* vrátím html z Web Pages        */      
    }
    @PostMapping("/result") /*local url  http://localhost:8080/ingredients */
    public  String result(@ModelAttribute IngredientsFormModel formModel,Model model){
        Long[] ingredientIds = formModel.getIngredientIds(); //
        Map<Long, Integer> percentageMatch = new HashMap<>();
        List<TCocktailXIngredient> cocktailIngredientList =
                cocktailXIngredientService.findAllCocktailsByIngredientIds(
                new ArrayList<>(Arrays.asList(formModel.getIngredientIds())));
        
        for (Iterator<TCocktailXIngredient> iterator = cocktailIngredientList.iterator();
                iterator.hasNext();){
            TCocktailXIngredient cocktailXIngredient = iterator.next();
            
            List<TCocktailXIngredient> cocktailIngredientList2 =
                cocktailXIngredientData.findIngredientsByCocktailId(cocktailXIngredient.getCocktail()
                .getCocktailId());
            int listSize = cocktailIngredientList2.size();
            int matchCount = 0;
            
            for (Iterator<TCocktailXIngredient> iterator2 = cocktailIngredientList2.iterator();
                    iterator2.hasNext();){
                TCocktailXIngredient cocktailXIngredient2 = (TCocktailXIngredient) iterator2.next();
                
                for (int i=0; i<ingredientIds.length;i++){
                    if (ingredientIds[i].equals(cocktailXIngredient2.getIngredient().getIngredientId())){
                        matchCount++;
                    }
                    
                }
                
            }
            if ((((double) matchCount) / ((double) listSize )) > MIN_PERCENTAGE_MATCH){
                percentageMatch.put(cocktailXIngredient.getCocktail().getCocktailId(),
                Integer.valueOf((int) ((((double) matchCount) / ((double) listSize)) *100 )));
            }            
        }    
        Object[] percentageMatchArr = percentageMatch.entrySet().toArray();
        Arrays.sort(percentageMatchArr,(Object o1, Object o2) -> 
                ((Map.Entry<String, Integer>) o2).getValue()
                .compareTo(((Map.Entry<String, Integer>) o1).getValue()));
        
        List<CocktailMatchModel> matches = new LinkedList<>();
     
        for (int i=0; i<percentageMatchArr.length; i++){
            Map.Entry<Long, Integer> entry = (Map.Entry<Long, Integer>) percentageMatchArr[i];
            
            TCocktail cocktail = this.cocktailData.getOne(entry.getKey());
            matches.add(new CocktailMatchModel(cocktail.getName(),(entry.getValue()+" %"),cocktail.getUrl()));            
        }                
        model.addAttribute("matches", matches);
        return "result";        
    }            
}
