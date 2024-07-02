package com.inspiretmstech.openapi.controllers;

import com.inspiretmstech.openapi.responses.Response;
import com.inspiretmstech.openapi.services.Supabase;

import java.sql.Connection;
import java.sql.DriverManager;


public abstract class Controller {

    protected  <T> Response<T> handle(Executor<T> executor) {
        try {
            Supabase supabase = new Supabase();
            return Response.success(executor.execute(supabase));
        } catch (Exception e) {
            return Response.error(e);
        }
    }

    @FunctionalInterface
    protected interface Executor<T> {
        public T execute(Supabase supabase) throws Exception;
    }

}
