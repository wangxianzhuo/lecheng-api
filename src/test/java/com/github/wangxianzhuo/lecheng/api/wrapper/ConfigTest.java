package com.github.wangxianzhuo.lecheng.api.wrapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    @BeforeEach
    void setUp() {
        System.setProperty("app.id", "123");
        System.setProperty("app.secret", "abc");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBaseConfig() {
    }
}