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
   // @RequestMapping("/ingredients")
        
    public String index(Model model){            
        //model.addAttribute("welcome1", welcome1);
        //model.addAttribute("message", "kunda");
        //model.
        model.addAttribute("ingredients",ingredientData.findAll());         
        return "index";  /* vrátím html z Web Pages        */      
    }
    
    
}
