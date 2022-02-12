
package net.mcreator.lukesmod;

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