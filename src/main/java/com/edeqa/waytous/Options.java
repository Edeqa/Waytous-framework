/*
 * Part of Waytous <http://waytous.net>
 * Copyright (C) Edeqa LLC <http://www.edeqa.com>
 *
 * Created 1/13/17.
 */
package com.edeqa.waytous;

import com.edeqa.helpers.Mime;
import com.edeqa.helpers.MimeType;
import com.edeqa.helpers.MimeTypes;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("HardCodedStringLiteral")
public class Options {

    private final static Logger LOGGER = Logger.getLogger(Options.class.getName());

    private JSONObject json;
    private MimeTypes mimeTypes;

    public Options(String[] args) {

        File file = new File("options.json");

        /*if(args.length != 0 && ("true".equals(args[0]) || "false".equals(args[0]))) { // onEvent from android version
            switch(args[0]) {
                case "true": // android debug mode
                    break;
                case "false": // android release mode
                    break;
            }

        } else*/ if(args.length != 0 && args[0] != null && args[0].length() != 0) {
            if("-g".equals(args[0].toLowerCase())) {
                generateSampleOptions();
                return;
            }
            file = new File(args[0]);
        }
        readWithFile(file);
    }

    public Options(File file) {
        readWithFile(file);
    }

    public Options(Reader reader) {
        try {
            readWithFileReader(reader);
        } catch (IOException e) {
            LOGGER.severe("Reader tried to read options file from corrupted or damaged source.\n");
            e.printStackTrace();
        }
    }

    private void readWithFile(File file) {
        if(!file.exists()) {
            LOGGER.severe("Options file "+file.getAbsolutePath()+" not found.\nRun with key -g for generate the sample.\n");
            return;
        }

        try(FileReader reader = new FileReader(file)) {
//            LOGGER.info("Read config from options file: " + file.getAbsoluteFile());
            readWithFileReader(reader);
        } catch (Exception e) {
            LOGGER.severe("Options file "+file.getAbsolutePath()+" is corrupted or damaged.\nRun with key -g for generate the sample.\n" + e.getMessage());
        }
    }

    private void readWithFileReader(Reader reader) throws IOException {

        int c;
        StringBuilder string = new StringBuilder();
        while((c=reader.read())!=-1){
            string.append((char)c);
        }

        Matcher m = Pattern.compile("/\\*[\\s\\S]*?\\*/").matcher(string);
        string = string.replace(0, string.length(), m.replaceAll(""));
        json = new JSONObject(string.toString());

        if(!json.has("app_name")) json.put("app_name", "Waytous");
        if(!json.has("app_link")) json.put("app_link", "http://waytous.net");
        if(!json.has("support_email")) json.put("support_email", "support@waytous.net");
        if(!json.has("gzip")) json.put("gzip", true);

        if(!json.has("http_port_masked")) json.put("http_port_masked", json.getInt("http_port"));
        if(!json.has("http_secured_port_masked")) json.put("http_secured_port_masked", json.getInt("http_secured_port"));
        if(!json.has("google_analytics_tracking_id")) json.put("google_analytics_tracking_id", "");

        if(!json.has("types")) {
            json.put("types",new JSONArray());
        }

        // normalize the path to web root directory tfor avoiding substrings like \.\
        if(json.has("web_root_directory")) {
            String path = new File(json.getString("web_root_directory")).getAbsolutePath();
            path = path.replaceAll("([\\\\/])\\.\\1", "$1").replaceAll("([\\\\/])\\.$", "");
            json.put("web_root_directory", path);
        }

        setMimeTypes(new MimeTypes().useDefault());

        JSONArray types = json.getJSONArray("types");
        for(int i = 0; i < types.length(); i++) {
            JSONObject o = types.getJSONObject(i);
            getMimeTypes().add(new MimeType(o));
        }

    }

    private void generateSampleOptions() {
        File file = new File("options.json");
//        FileWriter writer = null;

        try(FileWriter writer = new FileWriter(file)) {
            JSONObject jsonSample = new JSONObject();

            Field map = jsonSample.getClass().getDeclaredField("map");
            map.setAccessible(true);//because the field is private final...
            map.set(jsonSample, new LinkedHashMap<>());
            map.setAccessible(false);//return flag

//            jsonSample.put("firebase_web_api_key","SAMPL");
            jsonSample.put("firebase_dynamic_link_host","SAMPL");
            jsonSample.put("firebase_private_key_file","SAMPL");

            JSONObject jsonFirebaseConfig = new JSONObject();
            jsonFirebaseConfig.put("apiKey","SAMPL");
            jsonFirebaseConfig.put("authDomain","SAMPL");
            jsonFirebaseConfig.put("databaseURL","SAMPL");
            jsonFirebaseConfig.put("storageBucket","SAMPL");
            jsonFirebaseConfig.put("messagingSenderId","SAMPL");
            jsonSample.put("firebase_config",jsonFirebaseConfig);

            jsonSample.put("admin_login","admin");
            jsonSample.put("admin_password_hash","password_hash");
            jsonSample.put("server_host","localhost");
            jsonSample.put("http_port",8080);
            jsonSample.put("http_port_masked",8080);
            jsonSample.put("http_secured_port",8443);
            jsonSample.put("http_secured_port_masked",8443);
            jsonSample.put("http_admin_port",8989);
            jsonSample.put("websocket_port_dedicated",8081);
            jsonSample.put("websocket_secured_port_dedicated",8444);
            jsonSample.put("websocket_port_firebase",8082);
            jsonSample.put("websocket_secured_port_firebase",8445);
            jsonSample.put("ssl_certificate_password","SAMPL");
            jsonSample.put("keystore_filename","SAMPL");
            jsonSample.put("debug_mode",false);
            jsonSample.put("gzip",true);
            jsonSample.put("log_file","waytous.log");
            jsonSample.put("google_analytics_tracking_id","UA-XXXX-1");

            JSONArray jsonMimeTypes = new JSONArray();
            JSONObject jsonMimeType = new JSONObject();
            jsonMimeType.put("type","ogg");
            jsonMimeType.put("mime",Mime.AUDIO_OGG);
            jsonMimeTypes.put(jsonMimeType);

            jsonMimeType = new JSONObject();
            jsonMimeType.put("name","manifest.json");
            jsonMimeType.put("mime",Mime.APPLICATION_X_WEB_APP_MANIFEST_JSON);
            jsonMimeType.put("text",true);
            jsonMimeTypes.put(jsonMimeType);

            jsonSample.put("types",jsonMimeTypes);

            writer.write(jsonSample.toString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.severe(String.format("Sample options file was generated into %s.\nModify it using your custom options and run again.\n", file.getAbsolutePath()));
    }

    public String getFirebaseApiKey() {
        return getFirebaseConfig().getString("apiKey");
    }

    public String getFirebaseDynamicLinkHost() {
        return json.getString("firebase_dynamic_link_host");
    }

    public String getFirebasePrivateKeyFile() {
        return json.getString("firebase_private_key_file");
    }

    public String getFirebaseDatabaseUrl() {
        return getFirebaseConfig().getString("databaseURL");
    }

    public String getSSLCertificatePassword() {
        return json.getString("ssl_certificate_password");
    }

    public JSONObject getFirebaseConfig() {
        return json.getJSONObject("firebase_config");
    }

    public String getServerHost() {
        return json.getString("server_host");
    }

    public int getWsPortDedicated(){
        return json.getInt("websocket_port_dedicated");
    }

    public int getWssPortDedicated(){
        return json.getInt("websocket_secured_port_dedicated");
    }

    public int getWsPortFirebase(){
        return json.getInt("websocket_port_firebase");
    }

    public int getWssPortFirebase(){
        return json.getInt("websocket_secured_port_firebase");
    }

    public int getHttpPort(){
        return json.getInt("http_port");
    }

    public int getHttpsPort(){
        return json.getInt("http_secured_port");
    }

    public int getHttpPortMasked(){
        return json.getInt("http_port_masked");
    }

    public int getHttpsPortMasked(){
        return json.getInt("http_secured_port_masked");
    }

    public int getHttpsAdminPort(){
        return json.getInt("http_admin_port");
    }

    public String getWebRootDirectory() {
        return json.getString("web_root_directory");
    }

    public String getKeystoreFilename() {
        return json.getString("keystore_filename");
    }

    public boolean isDebugMode() {
        return json.getBoolean("debug_mode");
    }

    public boolean isGzip() {
        return json.getBoolean("gzip");
    }

    public String getLogFile() {
        if(json.has("log_file")) {
            return json.getString("log_file");
        } else {
            return "waytous.log";
        }
    }

    public JSONArray getTypes() {
        return json.getJSONArray("types");
    }

    public String getAppName() {
        return json.getString("app_name");
    }

    public String getAppLink() {
        return json.getString("app_link");
    }

    public String getSupportEmail() {
        return json.getString("support_email");
    }

    public String getGoogleAnalyticsTrackingId() {
        return json.getString("google_analytics_tracking_id");
    }

    public MimeTypes getMimeTypes() {
        return mimeTypes;
    }

    public void setMimeTypes(MimeTypes mimeTypes) {
        this.mimeTypes = mimeTypes;
    }
}
