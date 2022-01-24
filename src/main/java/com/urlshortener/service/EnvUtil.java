package com.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class EnvUtil {
    @Autowired
    Environment environment;

    private String port;
    private String hostname;

    public String getPort() {
        if (port == null) port = environment.getProperty("local.server.port");
        return port;
    }

    public String getHostname() throws UnknownHostException {
        // TODO ... would this cache cause issue, when network env change ???
        if (hostname == null) hostname = InetAddress.getLocalHost().getHostAddress();
        return hostname;
    }

    public String getServerUrlPrefix() throws UnknownHostException {
        String port = getPort();
        return "http://" + getHostname() + (port.equals("80") ? "/" : ":" + getPort() + "/");
    }
}