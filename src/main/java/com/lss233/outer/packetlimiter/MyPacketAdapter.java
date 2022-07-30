package com.lss233.outer.packetlimiter;

import dev.simplix.protocolize.api.Direction;
import dev.simplix.protocolize.api.listener.AbstractPacketListener;
import dev.simplix.protocolize.api.listener.PacketReceiveEvent;
import dev.simplix.protocolize.api.listener.PacketSendEvent;
import net.md_5.bungee.protocol.packet.Chat;

public class MyPacketAdapter extends AbstractPacketListener<Chat> {
    protected MyPacketAdapter() {
        super(Chat.class, Direction.DOWNSTREAM , 0);
    }

    @Override
    public void packetReceive(PacketReceiveEvent<Chat> event) {
        Chat packet = event.packet();
        if(packet.getMessage().length() > 14400) {
            packet.setMessage("{\"text\":\"消息过长\"}");
            event.packet(packet).markForRewrite();
        }
    }

    @Override
    public void packetSend(PacketSendEvent<Chat> event) {

    }
}
