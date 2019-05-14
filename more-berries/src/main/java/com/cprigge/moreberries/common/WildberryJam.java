package com.cprigge.moreberries.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class WildberryJam extends Jam {
	public static final String JAM_NAME = "wildberry_jam";
	public static final int JAM_AMOUNT = 5;
	
	public WildberryJam() {
		super(JAM_NAME, JAM_AMOUNT);
		this.setAlwaysEdible();
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
        if (!worldIn.isRemote){
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 150, 0));
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 150, 0));
        }
    }
}
