package com.mcfoxmods.emberreloaded.platform.fabric;

import com.mcfoxmods.emberreloaded.platform.common.AbstractPlatform;
import com.mcfoxmods.emberreloaded.platform.fabric.packet.c2s.ClientToServerCommunicationsImpl;
import com.mcfoxmods.emberreloaded.platform.fabric.packet.s2c.ServerToClientCommunicationsImpl;

public class PlatformImpl extends AbstractPlatform {

    public PlatformImpl() {
        super(new ServerToClientCommunicationsImpl(), new ClientToServerCommunicationsImpl());
    }
}
