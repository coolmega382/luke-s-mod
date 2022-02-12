
package net.mcreator.lukesmod.item;

import net.minecraft.entity.ai.attributes.Attributes;

@LukesModModElements.ModElement.Tag
public class RubyItem extends LukesModModElements.ModElement {

	@ObjectHolder("lukes_mod:ruby")
	public static final Item block = null;

	public RubyItem(LukesModModElements instance) {
		super(instance, 3);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("ruby");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Armour"));
		}

	}

}
