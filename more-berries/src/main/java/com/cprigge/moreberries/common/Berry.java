package com.cprigge.moreberries.common;

import com.cprigge.moreberries.MoreBerries;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;

public abstract class Berry extends ItemFood {
	private static final int BERRY_AMOUNT = 2;
	
	public Berry(String name) {
		super(BERRY_AMOUNT, false);
		this.setUnlocalizedName(MoreBerries.MODID + ":" + name);
		this.setRegistryName(MoreBerries.MODID + ":" + name);
		this.setCreativeTab(CreativeTabs.FOOD);
	}
	
	public Berry(String name, int amount) {
		super(amount, false);
		this.setUnlocalizedName(MoreBerries.MODID + ":" + name);
		this.setRegistryName(MoreBerries.MODID + ":" + name);
		this.setCreativeTab(CreativeTabs.FOOD);
	}
	
	public Berry(String name, int amount, PotionEffect effect) {
		super(amount, false);
		this.setUnlocalizedName(MoreBerries.MODID + ":" + name);
		this.setRegistryName(MoreBerries.MODID + ":" + name);
		this.setCreativeTab(CreativeTabs.FOOD);
		this.setPotionEffect(effect, 1);
	}
}
