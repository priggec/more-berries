package com.cprigge.moreberries.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Wildberries extends Berry {
	public static final String BERRY_NAME = "wildberries";
	public static final int BERRY_AMOUNT = 5;
	public static final PotionEffect EFFECT = new PotionEffect(Potion.getPotionById(9), 300);
	
	public Wildberries() {
		super(BERRY_NAME, BERRY_AMOUNT, EFFECT);
	}
}
