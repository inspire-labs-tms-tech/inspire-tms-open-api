package com.inspiretmstech.openapi.services;

import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;

import java.sql.Connection;
import java.sql.SQLException;

public class Supabase extends DefaultDSLContext {

    public Supabase() throws SQLException {
        super(Database.getConnection(), SQLDialect.POSTGRES);
    }

    public Supabase(Connection connection) {
        super(connection, SQLDialect.POSTGRES);
    }

}
