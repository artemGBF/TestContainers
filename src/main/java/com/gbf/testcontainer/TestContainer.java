package com.gbf.testcontainer;

import org.testcontainers.containers.PostgreSQLContainer;

public class TestContainer extends PostgreSQLContainer<TestContainer> {
    private static final String IMAGE_VERSION = "postgres:11.1";
    private static TestContainer container;

    private TestContainer() {
        super(IMAGE_VERSION);
    }

    public static TestContainer getInstance() {
        if (container == null) {
            container = new TestContainer();
            container
                    .withDatabaseName("new")
                    .withUsername("postgres")
                    .withPassword("postgres")/*.addFixedExposedPort(5433, 32825)*/;
        }
        container.start();
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.out.println(container.getJdbcUrl());
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
