package replacemine.minereplacer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class MineReplacer extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("MineReplacer has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MineReplacer has been disabled!");
    }

    @EventHandler
    public void mineReplace(BlockBreakEvent event) {
        Block theBlock = event.getBlock();
        Random random = new Random();
        Location loc = theBlock.getLocation();
        while (true) {
            Material block = Material.values()[random.nextInt(Material.values().length)];
            if (block.isBlock()) {
                Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> loc.getBlock().setType(block));
                break;
            }
        }
    }
}
