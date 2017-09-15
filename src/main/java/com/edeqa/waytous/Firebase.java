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
            SECTION_PUBLIC = "b", // public
            SECTION_PRIVATE = "p", // private
            SECTION_USERS_DATA = "u/b", // users/data-public
            USER_NAME = "name",
            USER_ACTIVE = "active",
            USER_COLOR = "color",
            USER_CREATED = "created",
            USER_CHANGED = "changed",
            SECTION_USERS_DATA_PRIVATE = "u/p", // users/data-private
            SECTION_USERS_KEYS = "u/k", // users/keys
            SECTION_USERS_ORDER = "u/n", // users/order
            SECTION_OPTIONS = "o", // options
            OPTION_PERSISTENT = "persistent",
            OPTION_TIME_TO_LIVE_IF_EMPTY = "time-to-live-if-empty",
            OPTION_DELAY_TO_DISMISS = "delay-to-dismiss",
            OPTION_DISMISS_INACTIVE = "dismiss-inactive",
            OPTION_REQUIRES_PASSWORD = "requires-password",
            OPTION_WELCOME_MESSAGE = "welcome-message",
            OPTION_DATE_CREATED = "date-created",
            OPTION_DATE_CHANGED = "date-changed",

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
            STAT_MESSAGES = "messages";
}
