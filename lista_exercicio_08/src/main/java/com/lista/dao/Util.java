package com.lista.dao;

import javax.persistence.EntityManager;

public interface Util {

    static EntityManager getEntityManager() {
        return null;
    }

    static void beginTransaction() {
    }

    static void commit() {
    }

    static void rollback() {
    }

    static void closeEntityManager() {
    }

}
