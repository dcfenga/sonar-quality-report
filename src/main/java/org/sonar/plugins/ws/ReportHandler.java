package org.sonar.plugins.ws;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.sonar.api.config.Configuration;
import org.sonar.api.server.ws.Request;
import org.sonar.api.server.ws.RequestHandler;
import org.sonar.api.server.ws.Response;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

public class ReportHandler implements RequestHandler {

    private static final Logger LOGGER = Logger.getLogger(ReportHandler.class.getName());

    // Sonarqube configuration
    private final Configuration config;

    /**
     * constructor
     *
     * @param config sonarqube configuration
     */
    public ReportHandler(Configuration config) {
        this.config = config;
    }

    /**
     * handle a request, write output in response stream.
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    public void handle(Request request, Response response) throws Exception {
        LOGGER.info("ReportHandler");

        // Getting stream and change headers
        Response.Stream stream = response.stream();
        stream.setMediaType("application/html");

        InputStream input =  getClass().getResourceAsStream("/templates/index.html");

        //response.setHeader("Content-Disposition", "attachment; filename=\"" + file + '"');
        IOUtils.copy(input, stream.output());
    }
}