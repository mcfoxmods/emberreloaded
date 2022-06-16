package com.mcfoxmods.emberreloaded.platform.common.constants;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import static com.mcfoxmods.emberreloaded.platform.common.utils.IdentifierUtil.createIdentifier;

public enum ContentId {
    BASIC_BLOCK("basic_block"),
    SIMPLE_BLOCK("simple_block"),
    THIRD_BLOCK("third_block");

    public final ResourceLocation id;

    private ContentId(String name) {
        this.id = createIdentifier(name);
    }
}
