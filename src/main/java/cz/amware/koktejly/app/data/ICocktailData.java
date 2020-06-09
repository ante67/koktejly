/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.amware.koktejly.app.data;

import cz.amware.koktejly.app.model.TCocktail;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 *
 * @author m.ambros
 */
public interface ICocktailData extends JpaRepository<TCocktail, Long> {
    
}
