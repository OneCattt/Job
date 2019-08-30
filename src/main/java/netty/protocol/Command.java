package netty.protocol;

import io.netty.buffer.ByteBuf;

public interface Command {

    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE =2;
}
