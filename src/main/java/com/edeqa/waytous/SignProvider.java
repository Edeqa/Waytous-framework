/*
 * Part of Waytous <http://waytous.net>
 * Copyright (C) Edeqa LLC <http://www.edeqa.com>
 *
 * Created 11/11/2017.
 */
package com.edeqa.waytous;

@SuppressWarnings("HardCodedStringLiteral")
public enum SignProvider {
    GOOGLE("google.com"), FACEBOOK("facebook.com"), TWITTER("twitter.com"), NONE("anonymous"), PASSWORD("password"), ADMIN("admin");
    private final String id;

    SignProvider(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    public static SignProvider parse(String signProvider) {
            if(signProvider != null) {
                switch(signProvider) {
                    case "google.com":
                        return GOOGLE;
                    case "facebook.com":
                        return FACEBOOK;
                    case "twitter.com":
                        return TWITTER;
                    case "password":
                        return PASSWORD;
                    case "admin":
                        return ADMIN;
                    default:
                        return NONE;
                }
            } else {
                return NONE;
            }

    }

}
