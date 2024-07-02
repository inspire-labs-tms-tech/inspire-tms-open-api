package com.inspiretmstech.openapi;

import java.util.Optional;

public final class Runtime {

    public static final String SEMVER = Runtime.get("SEMVER");
    public static final String SUPABASE_CLIENT_SIDE_URL = Runtime.get("SUPABASE_CLIENT_SIDE_URL");
    public static final String SUPABASE_ANON_KEY = Runtime.get("SUPABASE_ANON_KEY");
    public static final String DB_HOST = Runtime.get("DB_HOST");
    public static final String DB_PORT = Runtime.get("DB_PORT");
    public static final String DB_USER = Runtime.get("DB_USER");
    public static final String DB_PASS = Runtime.get("DB_PASS");
    public static final String DB_NAME = Runtime.get("DB_NAME");

    private static String get(String name) {
        Optional<String> value = Optional.ofNullable(System.getenv(name));
        if(value.isEmpty() || value.get().isBlank()) throw new RuntimeException("'" + name + "' is not defined in the runtime environment");
        return value.get();
    }
}
