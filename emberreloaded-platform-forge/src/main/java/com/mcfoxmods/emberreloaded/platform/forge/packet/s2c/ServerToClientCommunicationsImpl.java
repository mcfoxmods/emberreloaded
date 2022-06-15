package com.mcfoxmods.emberreloaded.platform.forge.packet.s2c;

import com.mcfoxmods.emberreloaded.platform.common.packet.ServerToClientCommunications;
import com.mcfoxmods.emberreloaded.platform.forge.packet.NetworkManager;

public class ServerToClientCommunicationsImpl implements ServerToClientCommunications {
    private final NetworkManager networkManager;

    public ServerToClientCommunicationsImpl(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }
}
