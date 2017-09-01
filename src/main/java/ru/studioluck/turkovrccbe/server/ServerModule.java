package ru.studioluck.turkovrccbe.server;

import com.google.inject.AbstractModule;
import ru.studioluck.turkovrccbe.server.listener.SocketListener;
import ru.studioluck.turkovrccbe.server.listener.impl.SocketListenerImpl;
import ru.studioluck.turkovrccbe.server.processor.factory.impl.SocketProcessorFactoryImpl;
import ru.studioluck.turkovrccbe.server.impl.TCPServerImpl;
import ru.studioluck.turkovrccbe.server.processor.factory.SocketProcessorFactory;

public class ServerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Server.class).to(TCPServerImpl.class);
        bind(SocketListener.class).to(SocketListenerImpl.class);
        bind(SocketProcessorFactory.class).to(SocketProcessorFactoryImpl.class);
    }
}
