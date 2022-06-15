package com.mcfoxmods.emberreloaded.platform.forge;

import com.mcfoxmods.emberreloaded.platform.common.AbstractModInitializer;
import com.mcfoxmods.emberreloaded.platform.common.block.BasicBlock;
import com.mcfoxmods.emberreloaded.platform.common.content.Blocks;
import com.mcfoxmods.emberreloaded.platform.common.utils.IdentifierUtil;
import com.mcfoxmods.emberreloaded.platform.forge.packet.NetworkManager;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.GenericEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLanguageProvider;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.mcfoxmods.emberreloaded.platform.forge.content.ContentIds.*;

@Mod(IdentifierUtil.MOD_ID)
public class ModInitializer extends AbstractModInitializer {
    private static String BLOCK_TRANSLATION_CATEGORY = "block";

    private static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab(IdentifierUtil.MOD_ID + ".general") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.INSTANCE.getBasicBlock());
        }
    };

    public ModInitializer() {
        initializePlatform(new PlatformImpl(new NetworkManager()));

        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, this::registerBlocks);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, this::registerItems);
    }

    private void registerBlocks(RegistryEvent.Register<Block> event) {
        BasicBlock basicBlock = new BasicBlock();
        basicBlock.setRegistryName(BASIC_BLOCK);
        Blocks.INSTANCE.setBasicBlock(basicBlock);
        event.getRegistry().register(basicBlock);
    }

    private void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(Blocks.INSTANCE.getBasicBlock(), createProperties()).setRegistryName(BASIC_BLOCK));
    }

    private Item.Properties createProperties() {
        return new Item.Properties().tab(CREATIVE_MODE_TAB);
    }

}
