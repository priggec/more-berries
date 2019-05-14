package com.cprigge.moreberries.common;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		for (int x = chunkX * 16; x < chunkX * 16 + 16; x++) {
			for (int z = chunkZ * 16; z < chunkZ * 16 + 16; z++) {
				for (int y = 256; y > 0; y--) {
					if (world.getBlockState(new BlockPos(x, y, z)) != Blocks.AIR.getDefaultState()) {
						if (world.getBlockState(new BlockPos(x, y, z)) == Blocks.GRASS.getDefaultState()) {
							if (random.nextInt(32) == 0) {
								world.setBlockState(new BlockPos(x, y+1, z), ModBlocks.BERRYBUSH.getDefaultState());
							}
						}
						break;
					}
				}
			}
		}
	}
}
