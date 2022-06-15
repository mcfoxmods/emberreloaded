package com.mcfoxmods.emberreloaded.platform.forge;

import com.mcfoxmods.emberreloaded.platform.common.AbstractPlatform;
import com.mcfoxmods.emberreloaded.platform.forge.packet.NetworkManager;
import com.mcfoxmods.emberreloaded.platform.forge.packet.c2s.ClientToServerCommunicationsImpl;
import com.mcfoxmods.emberreloaded.platform.forge.packet.s2c.ServerToClientCommunicationsImpl;

public class PlatformImpl extends AbstractPlatform {
    public PlatformImpl(NetworkManager networkManager) {
        super(new ServerToClientCommunicationsImpl(networkManager), new ClientToServerCommunicationsImpl(networkManager));
    }
}
