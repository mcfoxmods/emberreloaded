package com.mcfoxmods.emberreloaded.platform.fabric;

import com.mcfoxmods.emberreloaded.platform.common.AbstractModInitializer;
import com.mcfoxmods.emberreloaded.platform.common.constants.ContentId;
import com.mcfoxmods.emberreloaded.platform.common.block.content.Blocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static com.mcfoxmods.emberreloaded.platform.common.utils.IdentifierUtil.createIdentifier;

public class ModInitializerImpl extends AbstractModInitializer implements ModInitializer {

    private static final Logger LOGGER = LogManager.getLogger(ModInitializerImpl.class);
//    private static final String BLOCK_TRANSLATION_CATEGORY = "block";
    private static final CreativeModeTab CREATIVE_MODE_TAB = FabricItemGroupBuilder.build(createIdentifier("general"), () -> new ItemStack(Blocks.INSTANCE.getBlock(ContentId.BASIC_BLOCK)));


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
        Blocks.INSTANCE.getBlocks().forEach((contentId, block) -> Registry.register(Registry.BLOCK, contentId.id, block));
    }

    private void registerItems() {
        Blocks.INSTANCE.getBlocks().forEach((contentId, block) -> Registry.register(Registry.ITEM, contentId.id, new BlockItem(block, createProperties())));
    }

    private static Item.Properties createProperties() {
        return new Item.Properties().tab(CREATIVE_MODE_TAB);
    }
}
