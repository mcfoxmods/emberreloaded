package com.mcfoxmods.emberreloaded.platform.common;

public abstract class AbstractModInitializer {

    protected void initializePlatform(Platform platform) {
        ((PlatformProxy) Platform.INSTANCE).setPlatform(platform);
    }

}
