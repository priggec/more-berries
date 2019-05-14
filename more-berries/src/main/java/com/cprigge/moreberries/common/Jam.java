package com.cprigge.moreberries.common;

import com.cprigge.moreberries.MoreBerries;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;

public abstract class Jam extends ItemFood {
	public Jam(String name, int amount) {
		super(amount, false);
		this.setUnlocalizedName(MoreBerries.MODID + ":" + name);
		this.setRegistryName(MoreBerries.MODID + ":" + name);
		this.setCreativeTab(CreativeTabs.FOOD);
	}
}
