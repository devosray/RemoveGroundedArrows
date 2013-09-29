
package com.github.devosray.RemoveGroundedArrows;

/**
 *
 * @author Raymond
 */

import java.util.ArrayList;
import org.bukkit.Server;
import org.bukkit.entity.Arrow;
import org.bukkit.plugin.java.JavaPlugin;

public class RGAMain extends JavaPlugin{
 
    private RGAListener listener = new RGAListener(this);
    private int repeatID;
    private ArrayList<Arrow> arrows;
    
    @Override
    public void onEnable(){
        //Register listener
        getServer().getPluginManager().registerEvents(listener, this);
        
        //init arrows
        arrows = new ArrayList<>();
        
        //Repeating task to check on fired arrows
        repeatID = getServer().getScheduler().scheduleSyncRepeatingTask(this,
                new Runnable() {

            @Override
            public void run() {
                
            }
        }, 0, 1);
    }
    
    @Override
    public void onDisable(){
        //Stop recurring task
        getServer().getScheduler().cancelTask(repeatID);
    }
    
    public void addArrow(Arrow arw){
        //Add arrow to lists of arrows to be checked
        arrows.add(arw);
    }
    
}
