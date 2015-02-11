/**
 * 
 */
package com.selrahc13.morerealism.event;

import com.selrahc13.morerealism.common.misc.DamageType;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

import net.minecraftforge.event.world.BlockEvent;

/**
 * @author selrahc13
 *
 */
public class MREventHandler {
	public MREventHandler() {}
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		Block theBlock = event.block;
		EntityPlayer thePlayer = event.getPlayer();
		ItemStack heldItemStack = thePlayer.getHeldItem();
		
		if (event.world.isRemote) return;

		if (thePlayer != null && theBlock != null && !breakableByHand(theBlock) && !thePlayer.capabilities.isCreativeMode) {
			if (heldItemStack == null) {
				event.setCanceled(true);
				thePlayer.attackEntityFrom(DamageType.wallpunch, 2);
				thePlayer.addChatMessage(new ChatComponentText("OUCH! Try using tools next time!"));
			}
		}
			
	}
	
	public boolean breakableByHand(Block block) {
		if (block.getHarvestLevel(0) > 0) {
			return false;
		}
		Material mat = block.getMaterial();
		if (mat == Material.carpet ||
				mat == Material.cake ||
				mat == Material.carpet ||
				mat == Material.clay ||
				mat == Material.cloth ||
				mat == Material.grass || 
				mat == Material.ground ||
				mat == Material.glass ||
				mat == Material.leaves ||
				mat == Material.plants ||
				mat == Material.sand || 
				mat == Material.snow) {
			return true;
			
		}
		return false;
	}
}
