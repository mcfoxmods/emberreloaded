package com.mcfoxmods.emberreloaded.platform.common;

import com.mcfoxmods.emberreloaded.platform.common.packet.ClientToServerCommunications;
import com.mcfoxmods.emberreloaded.platform.common.packet.ServerToClientCommunications;

public class AbstractPlatform implements Platform {

    private final ServerToClientCommunications serverToClientCommunications;
    private final ClientToServerCommunications clientToServerCommunications;

    public AbstractPlatform(ServerToClientCommunications serverToClientCommunications, ClientToServerCommunications clientToServerCommunications) {
        this.serverToClientCommunications = serverToClientCommunications;
        this.clientToServerCommunications = clientToServerCommunications;
    }


    @Override
    public ServerToClientCommunications getServerToClientCommunications() {
        return serverToClientCommunications;
    }

    @Override
    public ClientToServerCommunications getClientToServerCommunications() {
        return clientToServerCommunications;
    }
}
