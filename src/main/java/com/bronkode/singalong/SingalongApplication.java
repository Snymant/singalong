package com.bronkode.singalong;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SingalongApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SingalongApplication.class, args);
        String port = ctx.getEnvironment().getProperty("local.server.port");
        //openBrowser(port);
    }

    public static void openBrowser(String port) {
        try {
            String[] cmd = new String[4];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "start";
            cmd[3] = "http://127.0.0.1:" + port;
            Process p = Runtime.getRuntime().exec(cmd);
        } catch (IOException ex) {
            Logger.getLogger(SingalongApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
