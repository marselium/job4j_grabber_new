package ru.job4j;

import org.apache.log4j.Logger;
import ru.job4j.grabber.model.Post;
import ru.job4j.grabber.service.Config;
import ru.job4j.grabber.service.SchedulerManager;
import ru.job4j.grabber.service.SuperJobGrab;
import ru.job4j.grabber.stores.JdbcStore;
import ru.job4j.grabber.stores.MemStore;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final Logger log = Logger.getLogger(Config.class);

    public static void main(String[] args) {
        var config = new Config();

        config.load("application.properties");

        try (var connection = DriverManager.getConnection("application.properties");

            SchedulerManager scheduler = new SchedulerManager()) {
            var store = new JdbcStore(connection);
            var post = new Post();
            post.setTitle("Super Java Job");
            store.save(post);
            scheduler.init();
            scheduler.load(
                    Integer.parseInt(config.get("rabbit.interval")),
                    SuperJobGrab.class,
                    store);
            Thread.sleep(10000);
        } catch (SQLException | InterruptedException e) {
            log.error("When create a connection", e);
        }
    }
}
