package com.mcfoxmods.emberreloaded.platform.forge.packet.c2s;

import com.mcfoxmods.emberreloaded.platform.common.packet.ClientToServerCommunications;
import com.mcfoxmods.emberreloaded.platform.forge.packet.NetworkManager;

public class ClientToServerCommunicationsImpl implements ClientToServerCommunications {
    private final NetworkManager networkManager;

    public ClientToServerCommunicationsImpl(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }
}
