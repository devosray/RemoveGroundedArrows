/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.devosray.RemoveGroundedArrows;

import org.bukkit.Bukkit;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
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
        //Check orgin and compare with config
        
        //Player
        if (evt.getEntity().getShooter() instanceof Player && main.getConfig().getBoolean("remove_player_arrows")){
            main.addArrow((Arrow) evt.getEntity());
            
        } else {
        
            //Dispenser
            if (evt.getEntity().getShooter() == null && main.getConfig().getBoolean("remove_dispensed_arrows")){
                main.addArrow((Arrow) evt.getEntity());
            }

            //Mob
            if (evt.getEntity().getShooter() instanceof LivingEntity && main.getConfig().getBoolean("remove_mob_arrows")){
                main.addArrow((Arrow) evt.getEntity());
            }
        
        }       

    }
    
}
