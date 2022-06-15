package com.mcfoxmods.emberreloaded.platform.forge.packet;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import static com.mcfoxmods.emberreloaded.platform.common.utils.IdentifierUtil.createIdentifier;

public class NetworkManager {

    private static final String PROTOCOL_VERSION = "1";

    private final ResourceLocation channel = createIdentifier("main_channel");
    private final SimpleChannel handler = NetworkRegistry.ChannelBuilder.named(channel)
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();

    public NetworkManager() {
//        int id = 0;
    }

    public void send(ServerPlayer player, Object message) {
        handler.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    public void send(Object message) {
        handler.sendToServer(message);
    }

}
