/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Observable;
import java.util.Observer;


public class Model extends Observable{
 

  
 
    @Override
    public void addObserver(Observer o)
    {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
    
    
    
}
