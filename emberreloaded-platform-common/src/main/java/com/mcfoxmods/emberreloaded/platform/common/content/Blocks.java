package com.mcfoxmods.emberreloaded.platform.common.content;

import com.mcfoxmods.emberreloaded.platform.common.block.BasicBlock;

public final class Blocks {
    public static final Blocks INSTANCE = new Blocks();

    private BasicBlock basicBlock;

    private Blocks() {}

    public BasicBlock getBasicBlock() {
        return basicBlock;
    }
    public void setBasicBlock(BasicBlock basicBlock) {
        this.basicBlock = basicBlock;
    }
}
