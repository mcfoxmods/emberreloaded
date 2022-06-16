package com.mcfoxmods.emberreloaded.platform.common.block.content;

import com.mcfoxmods.emberreloaded.platform.common.block.BasicBlock;
import com.mcfoxmods.emberreloaded.platform.common.block.SimpleBlock;
import com.mcfoxmods.emberreloaded.platform.common.block.ThirdBlock;
import com.mcfoxmods.emberreloaded.platform.common.constants.ContentId;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

import static com.mcfoxmods.emberreloaded.platform.common.constants.ContentId.*;

public final class Blocks {
    public static final Blocks INSTANCE = new Blocks();

    private final Map<ContentId, Block> blocks = new HashMap<>();


    private Blocks() {
        blocks.put(BASIC_BLOCK, new BasicBlock());
        blocks.put(SIMPLE_BLOCK, new SimpleBlock());
        blocks.put(THIRD_BLOCK, new ThirdBlock());
    }

    public Map<ContentId, Block> getBlocks() {
        return this.blocks;
    }

    public Block getBlock(ContentId id) {
        return this.blocks.get(id);
    }
}
