/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.devosray.RemoveGroundedArrows;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

/**
 *
 * @author Raymond
 */
public class RGAListener implements Listener {
    
    private final RGAMain main;
    
    public RGAListener(RGAMain main){
        this.main = main;
    }
    
    @EventHandler
    public void onProjectileLaunchEvent(ProjectileLaunchEvent evt){
        //When an arrow is shot, add it to an array for ground/collision check
        
        //Check if it is not a player-shot arrow
        if (!(evt.getEntity().getShooter() instanceof Player) && evt.getEntity() instanceof Arrow){
            main.getLogger().info("An arrow has been shot!");
            main.addArrow((Arrow) evt.getEntity());
        }
    }
    
}
