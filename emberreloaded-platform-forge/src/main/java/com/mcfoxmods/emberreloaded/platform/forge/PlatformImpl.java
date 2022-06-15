package com.mcfoxmods.emberreloaded.platform.forge;

import com.mcfoxmods.emberreloaded.platform.common.AbstractPlatform;
import com.mcfoxmods.emberreloaded.platform.common.packet.ClientToServerCommunications;
import com.mcfoxmods.emberreloaded.platform.common.packet.ServerToClientCommunications;
import com.mcfoxmods.emberreloaded.platform.forge.packet.NetworkManager;
import com.mcfoxmods.emberreloaded.platform.forge.packet.c2s.ClientToServerCommunicationsImpl;
import com.mcfoxmods.emberreloaded.platform.forge.packet.s2c.ServerToClientCommunicationsImpl;
import net.minecraftforge.fml.ModLoadingContext;

public class PlatformImpl extends AbstractPlatform {
    public PlatformImpl(NetworkManager networkManager) {
        super(new ServerToClientCommunicationsImpl(networkManager), new ClientToServerCommunicationsImpl(networkManager));
    }
}
