package com.lss233.outer.packetlimiter;

import dev.simplix.protocolize.api.Protocolize;
import net.md_5.bungee.api.plugin.Plugin;

public final class PacketLimiter extends Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Protocolize.listenerProvider().registerListener(new MyPacketAdapter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
