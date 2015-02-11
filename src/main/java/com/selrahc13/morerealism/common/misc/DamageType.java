/**
 * 
 */
package com.selrahc13.morerealism.common.misc;

import net.minecraft.util.DamageSource;

/**
 * @author selrahc13
 *
 */
public class DamageType extends DamageSource {
	public static final DamageSource wallpunch = new DamageType("wallpunch").setDamageBypassesArmor();
	
	public DamageType(String name) {
		super(name);
	}

}
