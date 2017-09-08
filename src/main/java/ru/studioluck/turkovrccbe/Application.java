package ru.studioluck.turkovrccbe;

import com.google.inject.Guice;
import com.google.inject.Injector;
import ru.studioluck.turkovrccbe.bean.User;
import ru.studioluck.turkovrccbe.dao.DbModule;
import ru.studioluck.turkovrccbe.dao.UserDao;
import ru.studioluck.turkovrccbe.server.Server;
import ru.studioluck.turkovrccbe.server.ServerModule;

public class Application {

    public static void main(String[] args) {
        Injector serverModuleInjector = Guice.createInjector(new ServerModule());
        Injector dbModuleInjector = Guice.createInjector(new DbModule());

        UserDao userDao = dbModuleInjector.getInstance(UserDao.class);
        User user = new User();
        user.setEmail("test");
        userDao.save(user);

        Server server = serverModuleInjector.getInstance(Server.class);

        server.start();
    }
}
