
package net.mcreator.lukesmod.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@LukesModModElements.ModElement.Tag
public class DeadDirtBlock extends LukesModModElements.ModElement {

	@ObjectHolder("lukes_mod:dead_dirt")
	public static final Block block = null;

	public DeadDirtBlock(LukesModModElements instance) {
		super(instance, 5);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).harvestLevel(0)
					.harvestTool(ToolType.SHOVEL).setRequiresTool());

			setRegistryName("dead_dirt");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}