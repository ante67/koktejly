/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.koktejly.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.amware.koktejly.app.data.IIngredientData;
import cz.amware.koktejly.app.model.IngredientsFormModel;
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
    
    @GetMapping("/") /*local url  http://localhost:8080/ingredients */
    public String index(Model model){            
        model.addAttribute("ingredientsFormModel", new IngredientsFormModel());
        model.addAttribute("ingredients",ingredientData.findAll());         
        return "index";  /* vrátím html z Web Pages        */      
    }
    @PostMapping("/result") /*local url  http://localhost:8080/ingredients */
    public  String result(@ModelAttribute IngredientsFormModel formModel,Model model){
        Long[] ingredientIds = formModel.getIngredientIds(); //
        return "result";        
    }            
}
