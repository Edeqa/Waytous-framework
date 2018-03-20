package com.edeqa.waytous;

import com.edeqa.helpers.MimeTypes;

import org.json.JSONArray;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static com.edeqa.waytous.Constants.OPTIONS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created 9/21/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OptionsTest {

    String fileName = "../conf/developer/options_developer.json";

    @Before
    public void setUp() throws Exception {
        OPTIONS = new Options(new String[]{fileName});
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void constructor() throws Exception {
        File file = new File("options.json");

        // test for corrupted file
        try(FileWriter writer = new FileWriter(file)) {
            writer.write("-");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Options(file);

        // test for correct file
        new Options(new String[]{"-g"});
        try (FileInputStream fis = new FileInputStream(file)) {
            Reader reader = new InputStreamReader(fis);
            new Options(reader);
        }
        new Options(file);

        // test for non existing file
        file = new File("options.json-fake");
        new Options(file);

        // test for wrong reader
        Reader reader = new Reader() {
            @Override
            public int read(char[] chars, int i, int i1) throws IOException {
                throw new IOException("Not found");
            }
            @Override
            public void close() throws IOException {

            }
        };
        new Options(reader);

    }

    @Test
    public void getFirebaseApiKey() throws Exception {
        assertTrue(OPTIONS.getFirebaseApiKey().length()>0);
    }

    @Test
    public void getFirebaseDynamicLinkHost() throws Exception {
        assertTrue(OPTIONS.getFirebaseDynamicLinkHost().contains("app.goo.gl"));
    }

    @Test
    public void getFirebasePrivateKeyFile() throws Exception {
        assertTrue(OPTIONS.getFirebasePrivateKeyFile().contains("firebase-adminsdk"));
    }

    @Test
    public void getFirebaseDatabaseUrl() throws Exception {
        assertTrue(OPTIONS.getFirebaseDatabaseUrl().contains("firebaseio.com"));
    }

    @Test
    public void getSSLCertificatePassword() throws Exception {
        assertTrue(OPTIONS.getSSLCertificatePassword().length()>0);
    }

    @Test
    public void getFirebaseConfig() throws Exception {
        assertTrue(OPTIONS.getFirebaseConfig().toString().contains("storageBucket"));
        assertTrue(OPTIONS.getFirebaseConfig().toString().contains("apiKey"));
        assertTrue(OPTIONS.getFirebaseConfig().toString().contains("messagingSenderId"));
        assertTrue(OPTIONS.getFirebaseConfig().toString().contains("projectId"));
        assertTrue(OPTIONS.getFirebaseConfig().toString().contains("databaseURL"));
        assertTrue(OPTIONS.getFirebaseConfig().toString().contains("authDomain"));
    }

    @Test
    public void getLogin() throws Exception {
        assertTrue(OPTIONS.getLogin().length()>0);
    }

    @Test
    public void getPassword() throws Exception {
        assertTrue(OPTIONS.getPassword() != null);
    }

    @Test
    public void getServerHost() throws Exception {
        assertTrue(OPTIONS.getServerHost().length() > 5);
    }

    @Test
    public void getWsPortDedicated() throws Exception {
        assertEquals(8100, OPTIONS.getWsPortDedicated());
    }

    @Test
    public void getWssPortDedicated() throws Exception {
        assertEquals(8101, OPTIONS.getWssPortDedicated());
    }

    @Test
    public void getWsPortFirebase() throws Exception {
        assertEquals(8200, OPTIONS.getWsPortFirebase());
    }

    @Test
    public void getWssPortFirebase() throws Exception {
        assertEquals(8201, OPTIONS.getWssPortFirebase());
    }

    @Test
    public void getHttpPort() throws Exception {
        assertEquals(8080, OPTIONS.getHttpPort());
    }

    @Test
    public void getHttpsPort() throws Exception {
        assertEquals(8443, OPTIONS.getHttpsPort());
    }

    @Test
    public void getHttpPortMasked() throws Exception {
        assertEquals(8080, OPTIONS.getHttpPortMasked());
    }

    @Test
    public void getHttpsPortMasked() throws Exception {
        assertEquals(8443, OPTIONS.getHttpsPortMasked());
    }

    @Test
    public void getHttpsAdminPort() throws Exception {
        assertTrue(OPTIONS.getHttpsAdminPort() > 8980);
    }

    @Test
    public void getWebRootDirectory() throws Exception {
        assertTrue(OPTIONS.getWebRootDirectory().contains("Waytous"));
    }

    @Test
    public void getKeystoreFilename() throws Exception {
        assertTrue(OPTIONS.getKeystoreFilename().contains(".jks"));
    }

    @Test
    public void isDebugMode() throws Exception {
        assertEquals(true, OPTIONS.isDebugMode());
    }

    @Test
    public void isGzip() throws Exception {
        assertTrue(OPTIONS.isGzip());
    }

    @Test
    public void getLogFile() throws Exception {
        assertTrue(OPTIONS.getLogFile().contains(".log"));
    }

    @Test
    public void getTypes() throws Exception {
        assertEquals(true, OPTIONS.getTypes() instanceof JSONArray);
    }

    @Test
    public void getAppName() throws Exception {
        assertEquals("Waytous", OPTIONS.getAppName());
    }

    @Test
    public void getAppLink() throws Exception {
        assertTrue(OPTIONS.getAppLink().startsWith("http://"));
    }

    @Test
    public void getSupportEmail() throws Exception {
        assertEquals("support@waytous.net", OPTIONS.getSupportEmail());
    }

    @Test
    public void getGoogleAnalyticsTrackingId() {
        assertEquals(true, OPTIONS.getGoogleAnalyticsTrackingId().startsWith("UA-"));

    }

    @Test
    public void getMimeTypes() {
        assertEquals(true, OPTIONS.getMimeTypes() instanceof MimeTypes);
    }

    @Test
    public void setMimeTypes() {
        MimeTypes mimeTypes = new MimeTypes();
        OPTIONS.setMimeTypes(mimeTypes);

    }
}