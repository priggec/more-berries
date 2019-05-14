package com.cprigge.moreberries;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import org.apache.logging.log4j.Logger;

import com.cprigge.moreberries.common.BlockRegister;
import com.cprigge.moreberries.common.ItemRegister;
import com.cprigge.moreberries.common.ModGen;
import com.cprigge.moreberries.proxy.IProxy;

@Mod(modid = MoreBerries.MODID, name = MoreBerries.NAME, version = MoreBerries.VERSION)
public class MoreBerries
{
    public static final String MODID = "moreberries";
    public static final String NAME = "More Berries";
    public static final String VERSION = "0.2";
    
    public static final String SERVER_PROXY_CLASS = "com.cprigge.moreberries.proxy.ServerProxy";
    public static final String CLIENT_PROXY_CLASS = "com.cprigge.moreberries.proxy.ClientProxy";

    private static Logger logger;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    public static IProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        // Register our item handler used to add all of our items to the game
     	MinecraftForge.EVENT_BUS.register(new ItemRegister());
     	MinecraftForge.EVENT_BUS.register(new BlockRegister());
     	GameRegistry.registerWorldGenerator(new ModGen(), 1);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Mod initialized");
     	proxy.initializeLeafRenderers();
    }
}
