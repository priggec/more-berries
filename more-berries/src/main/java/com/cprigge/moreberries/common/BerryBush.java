package com.cprigge.moreberries.common;

import java.util.ArrayList;
import java.util.Random;

import com.cprigge.moreberries.MoreBerries;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;

public class BerryBush extends BlockBush {
	public BerryBush() {
		super(Material.VINE);
		this.setUnlocalizedName(MoreBerries.MODID + ":berry_bush");
		this.setRegistryName(MoreBerries.MODID + ":berry_bush");
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setSoundType(SoundType.PLANT);
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random r = new Random();
		if (r.nextInt(2) == 0) {
			drops.add(new ItemStack(ModItems.CHERRY));
		}
		if (r.nextInt(5) == 0) {
			drops.add(new ItemStack(ModItems.STRAWBERRY));
		}
		if (r.nextInt(10) == 0) {
			drops.add(new ItemStack(ModItems.WILDBERRIES));
		}
	}
}
