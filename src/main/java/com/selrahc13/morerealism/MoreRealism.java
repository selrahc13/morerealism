package com.selrahc13.morerealism;

import com.selrahc13.morerealism.event.MREventHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import net.minecraftforge.common.MinecraftForge;

@Mod(modid = MoreRealism.MODID, version = MoreRealism.VERSION)
public class MoreRealism
{
    public static final String MODID = "MoreRealism";
    public static final String VERSION = "1.0";
    
    public MREventHandler eventHandler = new MREventHandler();
    
    @EventHandler
    public void preinit(FMLInitializationEvent event) {
    	FMLCommonHandler.instance().bus().register(eventHandler);
		MinecraftForge.EVENT_BUS.register(eventHandler);    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}
