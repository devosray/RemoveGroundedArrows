
package com.github.devosray.RemoveGroundedArrows;

/**
 *
 * @author Raymond
 */

import org.bukkit.plugin.java.JavaPlugin;

public class RGAMain extends JavaPlugin{
 
    private RGAListener listener = new RGAListener(this);
    
    @Override
    public void onEnable(){
        //Register listener
        getServer().getPluginManager().registerEvents(listener, this);
    }
    
}
