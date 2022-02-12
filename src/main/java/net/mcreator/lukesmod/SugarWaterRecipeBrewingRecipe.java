
package net.mcreator.lukesmod;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.potion.PotionUtils;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.lukesmod.potion.SugeredwaterPotion;

@LukesModModElements.ModElement.Tag
public class SugarWaterRecipeBrewingRecipe extends LukesModModElements.ModElement {
	public SugarWaterRecipeBrewingRecipe(LukesModModElements instance) {
		super(instance, 2);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}

	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == Items.POTION;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Items.SUGAR;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), SugeredwaterPotion.potionType);
			}
			return ItemStack.EMPTY;
		}
	}
}
