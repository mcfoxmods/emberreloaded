package com.mcfoxmods.emberreloaded.platform.common.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public final class BlockConstants {

    public static final BlockBehaviour.Properties STONE_PROPERTIES = BlockBehaviour.Properties
            .of(Material.STONE)
            .strength(0.5f, 6.0f)
            .sound(SoundType.STONE);

}
