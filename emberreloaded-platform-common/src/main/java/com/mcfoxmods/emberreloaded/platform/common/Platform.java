package com.mcfoxmods.emberreloaded.platform.common;

import com.mcfoxmods.emberreloaded.platform.common.packet.ClientToServerCommunications;
import com.mcfoxmods.emberreloaded.platform.common.packet.ServerToClientCommunications;

public interface Platform {
    Platform INSTANCE = new PlatformProxy();

    ServerToClientCommunications getServerToClientCommunications();

    ClientToServerCommunications getClientToServerCommunications();

}
