package com.mcfoxmods.emberreloaded.platform.forge;

import com.mcfoxmods.emberreloaded.platform.common.AbstractModInitializer;
import com.mcfoxmods.emberreloaded.platform.common.constants.ContentId;
import com.mcfoxmods.emberreloaded.platform.common.block.content.Blocks;
import com.mcfoxmods.emberreloaded.platform.common.utils.IdentifierUtil;
import com.mcfoxmods.emberreloaded.platform.forge.packet.NetworkManager;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(IdentifierUtil.MOD_ID)
public class ModInitializer extends AbstractModInitializer {
//    private static String BLOCK_TRANSLATION_CATEGORY = "block";

    private static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab(IdentifierUtil.MOD_ID + ".general") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.INSTANCE.getBlock(ContentId.BASIC_BLOCK));
        }
    };

    public ModInitializer() {
        initializePlatform(new PlatformImpl(new NetworkManager()));

        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, this::registerBlocks);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, this::registerItems);
    }

    private void registerBlocks(RegistryEvent.Register<Block> event) {
        Blocks.INSTANCE.getBlocks().forEach((contentId, block) -> event.getRegistry().register(block.setRegistryName(contentId.id)));
    }

    private void registerItems(RegistryEvent.Register<Item> event) {
        Blocks.INSTANCE.getBlocks().forEach((contentId, block) -> event.getRegistry().register(new BlockItem(block, createProperties()).setRegistryName(contentId.id)));
    }

    private static Item.Properties createProperties() {
        return new Item.Properties().tab(CREATIVE_MODE_TAB);
    }

}
