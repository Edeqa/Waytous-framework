package com.edeqa.waytous;

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

import static com.edeqa.waytous.Constants.SENSITIVE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created 9/21/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SensitiveDataTest {

    String fileName = "WaytousServer/conf/developer/options_developer.json";

    @Before
    public void setUp() throws Exception {
        SENSITIVE = new SensitiveData(new String[]{fileName});
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
        new SensitiveData(file);

        // test for correct file
        new SensitiveData(new String[]{"-g"});
        try (FileInputStream fis = new FileInputStream(file)) {
            Reader reader = new InputStreamReader(fis);
            new SensitiveData(reader);
        }
        new SensitiveData(file);

        // test for non existing file
        file = new File("options.json-fake");
        new SensitiveData(file);

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
        new SensitiveData(reader);

    }

    @Test
    public void getFirebaseApiKey() throws Exception {
        assertTrue(SENSITIVE.getFirebaseApiKey().length()>0);
    }

    @Test
    public void getFirebaseDynamicLinkHost() throws Exception {
        assertTrue(SENSITIVE.getFirebaseDynamicLinkHost().contains("app.goo.gl"));
    }

    @Test
    public void getFirebasePrivateKeyFile() throws Exception {
        assertTrue(SENSITIVE.getFirebasePrivateKeyFile().contains("firebase-adminsdk"));
    }

    @Test
    public void getFirebaseDatabaseUrl() throws Exception {
        assertTrue(SENSITIVE.getFirebaseDatabaseUrl().contains("firebaseio.com"));
    }

    @Test
    public void getSSLCertificatePassword() throws Exception {
        assertTrue(SENSITIVE.getSSLCertificatePassword().length()>0);
    }

    @Test
    public void getFirebaseConfig() throws Exception {
        assertTrue(SENSITIVE.getFirebaseConfig().toString().contains("storageBucket"));
        assertTrue(SENSITIVE.getFirebaseConfig().toString().contains("apiKey"));
        assertTrue(SENSITIVE.getFirebaseConfig().toString().contains("messagingSenderId"));
        assertTrue(SENSITIVE.getFirebaseConfig().toString().contains("projectId"));
        assertTrue(SENSITIVE.getFirebaseConfig().toString().contains("databaseURL"));
        assertTrue(SENSITIVE.getFirebaseConfig().toString().contains("authDomain"));
    }

    @Test
    public void getLogin() throws Exception {
        assertTrue(SENSITIVE.getLogin().length()>0);
    }

    @Test
    public void getPassword() throws Exception {
        assertTrue(SENSITIVE.getPassword() != null);
    }

    @Test
    public void getServerHost() throws Exception {
        assertTrue(SENSITIVE.getServerHost().length() > 5);
    }

    @Test
    public void getWsPortDedicated() throws Exception {
        assertEquals(8100, SENSITIVE.getWsPortDedicated());
    }

    @Test
    public void getWssPortDedicated() throws Exception {
        assertEquals(8101, SENSITIVE.getWssPortDedicated());
    }

    @Test
    public void getWsPortFirebase() throws Exception {
        assertEquals(8200, SENSITIVE.getWsPortFirebase());
    }

    @Test
    public void getWssPortFirebase() throws Exception {
        assertEquals(8201, SENSITIVE.getWssPortFirebase());
    }

    @Test
    public void getHttpPort() throws Exception {
        assertEquals(8080, SENSITIVE.getHttpPort());
    }

    @Test
    public void getHttpsPort() throws Exception {
        assertEquals(8443, SENSITIVE.getHttpsPort());
    }

    @Test
    public void getHttpPortMasked() throws Exception {
        assertEquals(8080, SENSITIVE.getHttpPortMasked());
    }

    @Test
    public void getHttpsPortMasked() throws Exception {
        assertEquals(8443, SENSITIVE.getHttpsPortMasked());
    }

    @Test
    public void getHttpsAdminPort() throws Exception {
        assertTrue(SENSITIVE.getHttpsAdminPort() > 8980);
    }

    @Test
    public void getWebRootDirectory() throws Exception {
        assertTrue(SENSITIVE.getWebRootDirectory().contains("Waytous"));
    }

    @Test
    public void getKeystoreFilename() throws Exception {
        assertTrue(SENSITIVE.getKeystoreFilename().contains(".jks"));
    }

    @Test
    public void isDebugMode() throws Exception {
        assertEquals(true, SENSITIVE.isDebugMode());
    }

    @Test
    public void isGzip() throws Exception {
        assertTrue(SENSITIVE.isGzip());
    }

    @Test
    public void getLogFile() throws Exception {
        assertTrue(SENSITIVE.getLogFile().contains(".log"));
    }

    @Test
    public void getTypes() throws Exception {
        assertTrue(SENSITIVE.getTypes().toString().contains("mime"));
    }

    @Test
    public void getAppName() throws Exception {
        assertEquals("Waytous", SENSITIVE.getAppName());
    }

    @Test
    public void getAppLink() throws Exception {
        assertEquals("http://waytous.net", SENSITIVE.getAppLink());
    }

    @Test
    public void getSupportEmail() throws Exception {
        assertEquals("support@waytous.net", SENSITIVE.getSupportEmail());
    }

}