/*
 * Part of Waytous <http://waytous.net>
 * Copyright (C) Edeqa LLC <http://www.edeqa.com>
 *
 * Created 10/14/16.
 */
package com.edeqa.waytous;

@SuppressWarnings({"HardCodedStringLiteral", "WeakerAccess"})
public class Constants {

    public static Options OPTIONS;

    public final static String BROADCAST = "com.edeqa.waytous.waytousservice";
    public final static String BROADCAST_MESSAGE = "message";

    public final static int LOCATION_UPDATES_DELAY = 1000;

// client constants
    public static final String REQUEST = "client";
    public static final String REQUEST_TIMESTAMP = "timestamp";
    public static final String REQUEST_UPDATE = "update";
    public static final String REQUEST_JOIN_GROUP = "join";
    public static final String REQUEST_NEW_GROUP = "create";
    public static final String REQUEST_CHECK_USER = "check";
    public static final String REQUEST_TOKEN = "token";
    public static final String REQUEST_HASH = "hash";
    public static final String REQUEST_PUSH = "push";
    public static final String REQUEST_ADMIN = "admin";

    public static final String REQUEST_UID = "uid";
    public static final String REQUEST_MODEL = "model";
    public static final String REQUEST_MANUFACTURER = "manufacturer";
    public static final String REQUEST_OS = "os";
    public static final String REQUEST_KEY = "key";
    public static final String REQUEST_SIGN_PROVIDER = "sign-provider";

// instances to/from server
    public static final String REQUEST_TRACKING = "tracking";
    public static final String REQUEST_MESSAGE = "message";
    public static final String REQUEST_CHANGE_NAME = "change_name";
    public static final String REQUEST_WELCOME_MESSAGE = "welcome_message";
    public static final String REQUEST_LEAVE = "leave";
    public static final String REQUEST_SAVED_LOCATION = "saved_location";
    public static final String REQUEST_DELIVERY_CONFIRMATION = "delivery";

// server constants
    public static final String RESPONSE_STATUS = "server";
    public static final String RESPONSE_STATUS_ACCEPTED = "accepted";
    public static final String RESPONSE_STATUS_UPDATED = "updated";
    public static final String RESPONSE_STATUS_CHECK = "check";
//    public static final String RESPONSE_STATUS_DISCONNECTED = "disconnected";
    public static final String RESPONSE_STATUS_ERROR = "error";
    public static final String RESPONSE_MESSAGE = "message";
    public static final String RESPONSE_TOKEN = "token";
    public static final String RESPONSE_CONTROL = "control";
    public static final String RESPONSE_NUMBER = "number";
    public static final String RESPONSE_INITIAL = "initial";
    public static final String RESPONSE_PRIVATE = "to";
    public static final String RESPONSE_SIGN = "sign";

    public static final String USER_JOINED = "joined";
    public static final String USER_DISMISSED = "dismissed";
    public static final String USER_LEFT = "left";

    public static final String USER_PROVIDER = "pr";
    public static final String USER_LATITUDE = "la";
    public static final String USER_LONGITUDE = "lo";
    public static final String USER_ALTITUDE = "al";
    public static final String USER_ACCURACY = "ac";
    public static final String USER_BEARING = "be";
    public static final String USER_TILT = "ti";
    public static final String USER_SPEED = "sp";

    public static final String USER_NUMBER = "number";
    public static final String USER_COLOR = "color";
    public static final String USER_NAME = "name";
    public static final String USER_MESSAGE = "user_message";
    public static final String USER_ADDRESS = "address";
    public static final String USER_DESCRIPTION = "description";

    public static final int LIFETIME_REQUEST_TIMEOUT = 10;
    public static final int LIFETIME_INACTIVE_GROUP = 24 * 3600;
    public final static int LIFETIME_INACTIVE_USER = 300;

}
