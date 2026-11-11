package com.fedi.users.security;

public interface SecParams {
    public static final long EXP_TIME = 10 * 24 * 60 * 60 * 1000; // 10 jours
    public static final String SECRET = "fedi@equipe.com";         // Cle secrete de signature JWT
    public static final String PREFIX = "Bearer ";
}

