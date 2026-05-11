package de.cobwebrecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class CobwebRecipes extends JavaPlugin {

    private NamespacedKey key;

    @Override
    public void onEnable() {
        key = new NamespacedKey(this, "cobweb");
        ShapelessRecipe recipe = new ShapelessRecipe(key, new ItemStack(Material.COBWEB, 1));
        recipe.addIngredient(4, Material.STRING);
        getServer().addRecipe(recipe, true);
    }

    @Override
    public void onDisable() {
        getServer().removeRecipe(key, true);
    }
}
