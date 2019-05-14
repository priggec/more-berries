package com.cprigge.moreberries.client;

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
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModColorManager {
	//private static final Minecraft minecraft = Minecraft.getMinecraft();
	
	/*
	public static void registerColourHandlers() {
		final BlockColors blockColors = minecraft.getBlockColors();
		final ItemColors itemColors = minecraft.getItemColors();

		registerBlockColourHandlers(blockColors);
		registerItemColourHandlers(blockColors, itemColors);
	}
	*/

	/**
	 * Register the {@link IBlockColor} handlers.
	 *
	 * @param blockColors The BlockColors instance
	 */
	@SubscribeEvent
	private static void regBlockColours(ColorHandlerEvent.Block event) {
		// Use the grass colour of the biome or the default grass colour
		BlockColors blockColors = event.getBlockColors();
		final IBlockColor grassColourHandler = (state, blockAccess, pos, tintIndex) -> {
			if (blockAccess != null && pos != null) {
				return BiomeColorHelper.getGrassColorAtPos(blockAccess, pos);
			}

			return ColorizerFoliage.getFoliageColor(0.5D, 1.0D);
		};

		blockColors.registerBlockColorHandler(grassColourHandler, ModBlocks.BERRYBUSH);
	}

	/**
	 * Register the {@link IItemColor} handlers
	 *
	 * @param blockColors The BlockColors instance
	 * @param itemColors  The ItemColors instance
	 */
	@SubscribeEvent
	private static void regItemColours(ColorHandlerEvent.Item event) {
		// Use the Block's colour handler for an ItemBlock
		BlockColors blockColors = event.getBlockColors();
		ItemColors itemColors = event.getItemColors();
		final IItemColor itemBlockColourHandler = (stack, tintIndex) -> {
			final IBlockState state = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
			return blockColors.colorMultiplier(state, null, null, tintIndex);
		};

		itemColors.registerItemColorHandler(itemBlockColourHandler, ModBlocks.BERRYBUSH);
	}
}
