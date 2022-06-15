package com.mcfoxmods.emberreloaded.platform.common;

import com.mcfoxmods.emberreloaded.platform.common.packet.ClientToServerCommunications;
import com.mcfoxmods.emberreloaded.platform.common.packet.ServerToClientCommunications;

public class PlatformProxy implements Platform {
    private Platform platform;

    public void setPlatform(Platform platform) {
        if (this.platform != null) throw new IllegalStateException("Platform already set");
        this.platform = platform;
    }

    @Override
    public ServerToClientCommunications getServerToClientCommunications() {
        return null;
    }

    @Override
    public ClientToServerCommunications getClientToServerCommunications() {
        return null;
    }
}
