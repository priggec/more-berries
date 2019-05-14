package com.cprigge.moreberries.proxy;

import com.cprigge.moreberries.common.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy implements IProxy {
	public void initializeLeafRenderers() {
		BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
		ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
		
		// Block Color
		final IBlockColor grassColourHandler = (state, blockAccess, pos, tintIndex) -> {
			if (blockAccess != null && pos != null) {
				return BiomeColorHelper.getGrassColorAtPos(blockAccess, pos);
			}

			return ColorizerGrass.getGrassColor(0.5D, 1.0D);
		};
		blockColors.registerBlockColorHandler(grassColourHandler, ModBlocks.BERRYBUSH);
		
		// Item Color
		final IItemColor itemBlockColourHandler = (stack, tintIndex) -> {
			final IBlockState state = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
			return blockColors.colorMultiplier(state, null, null, tintIndex);
		};
		itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.BERRYBUSH);
	}
}
