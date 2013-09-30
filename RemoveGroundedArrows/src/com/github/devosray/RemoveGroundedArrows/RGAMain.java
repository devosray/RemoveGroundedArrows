
package com.github.devosray.RemoveGroundedArrows;

/**
 *
 * @author Raymond
 */

import java.util.ArrayList;
import java.util.Iterator;
import org.bukkit.entity.Arrow;
import org.bukkit.plugin.java.JavaPlugin;

public class RGAMain extends JavaPlugin{
 
    private RGAListener listener = new RGAListener(this);
    private int repeatID;
    private ArrayList<Arrow> arrows;
    
    @Override
    public void onEnable(){
        
        getLogger().info("Starting to remove arrows!");
        
        //Register listener
        getServer().getPluginManager().registerEvents(listener, this);
        
        //init arrows
        arrows = new ArrayList<>();
        
        //Repeating task to check on fired arrows
        repeatID = getServer().getScheduler().scheduleSyncRepeatingTask(this,
                new Runnable() {

            @Override
            public void run() {
              
                for (Arrow arw : arrows){
                    //Check if collision with ground
                    if (arw.isOnGround() || !arw.isValid()){
                        arw.remove();
                    }
                }
                
            }
        }, 0, 5); //Just check arrows every 5 ticks
    }
    
    @Override
    public void onDisable(){
        //Stop recurring task
        getServer().getScheduler().cancelTask(repeatID);
        getLogger().info("Time to remove myself...");
        
    }
    
    public void addArrow(Arrow arw){
        //Add arrow to lists of arrows to be checked
        arrows.add(arw);
        
        
    }
    
}
