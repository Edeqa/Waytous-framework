/*
 * Part of Waytous <http://waytous.net>
 * Copyright (C) Edeqa LLC <http://www.edeqa.com>
 *
 * Created 9/15/2017.
 */
package com.edeqa.waytous;

@SuppressWarnings({"HardCodedStringLiteral", "WeakerAccess"})
public class Firebase {
    public static final String SECTION_GROUPS = "_groups",
            USERS = "u", // users
            PUBLIC = "b", // public
            PRIVATE = "p", // private
            NAME = "name",
            ACTIVE = "active",
            COLOR = "color",
            CREATED = "created",
            CHANGED = "changed",
    
            KEYS = "k", // keys
            ORDER = "n", // users/order

            OPTIONS = "o", // options
            OPTION_PERSISTENT = "persistent",
            OPTION_TIME_TO_LIVE_IF_EMPTY = "time-to-live-if-empty",
            OPTION_DELAY_TO_DISMISS = "delay-to-dismiss",
            OPTION_DISMISS_INACTIVE = "dismiss-inactive",
            OPTION_REQUIRES_PASSWORD = "requires-password",
            OPTION_WELCOME_MESSAGE = "welcome-message",

    SECTION_STAT = "_stat",
            STAT_TOTAL = "total",
            STAT_BY_DATE = "by-date",
            STAT_GROUPS_CREATED_TEMPORARY = "gt",
            STAT_GROUPS_CREATED_PERSISTENT = "gp",
            STAT_GROUPS_REJECTED = "gr",
            STAT_GROUPS_DELETED = "gd",
            STAT_USERS_JOINED = "uj",
            STAT_USERS_RECONNECTED = "uc",
            STAT_USERS_REJECTED = "ur",
            STAT_MESSAGES = "messages",
    
    SECTION_USERS = "_users",
            HISTORY = "h";
    
    
}
