package com.mcfoxmods.emberreloaded.platform.fabric;

import com.mcfoxmods.emberreloaded.platform.common.AbstractModInitializer;
import com.mcfoxmods.emberreloaded.platform.common.block.BasicBlock;
import com.mcfoxmods.emberreloaded.platform.common.content.Blocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static com.mcfoxmods.emberreloaded.platform.common.content.ContentIds.BASIC_BLOCK;
import static com.mcfoxmods.emberreloaded.platform.common.utils.IdentifierUtil.createIdentifier;

public class ModInitializerImpl extends AbstractModInitializer implements ModInitializer {

    private static final Logger LOGGER = LogManager.getLogger(ModInitializerImpl.class);
    private static final String BLOCK_TRANSLATION_CATEGORY = "block";
    private static final CreativeModeTab CREATIVE_MODE_TAB = FabricItemGroupBuilder.build(createIdentifier("general"), () -> new ItemStack(Blocks.INSTANCE.getBasicBlock()));

    @Override
    public void onInitialize() {
        initializePlatform(new PlatformImpl());
        registerContent();

        LOGGER.info("Ember Reloaded has loaded.");
    }

    private void registerContent() {
        registerBlocks();
        registerItems();
    }

    private void registerBlocks() {
        Blocks.INSTANCE.setBasicBlock(Registry.register(Registry.BLOCK, BASIC_BLOCK, new BasicBlock()));
    }

    private void registerItems() {
        Registry.register(Registry.ITEM, BASIC_BLOCK, new BlockItem(Blocks.INSTANCE.getBasicBlock(), createProperties()));
    }

    private Item.Properties createProperties() {
        return new Item.Properties().tab(CREATIVE_MODE_TAB);
    }
}
