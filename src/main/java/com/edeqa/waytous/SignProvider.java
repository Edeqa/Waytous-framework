/*
 * Part of Waytous <http://waytous.net>
 * Copyright (C) Edeqa LLC <http://www.edeqa.com>
 *
 * Created 11/11/2017.
 */
package com.edeqa.waytous;

@SuppressWarnings("HardCodedStringLiteral")
public enum SignProvider {
    GOOGLE("google.com"), FACEBOOK("facebook.com"), TWITTER("twitter.com"), NONE("anonymous"), PASSWORD("password");
    private String id;

    SignProvider(String id) {
        this.id = id;
    }

    public String toString() {
        return id;
    }
}
