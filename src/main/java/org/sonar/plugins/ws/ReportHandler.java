package org.sonar.plugins.ws;

import org.apache.commons.io.FileUtils;
import org.sonar.api.config.Configuration;
import org.sonar.api.server.ws.Request;
import org.sonar.api.server.ws.RequestHandler;
import org.sonar.api.server.ws.Response;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        LOGGER.info("Requesting all project report...");

        // Getting stream and change headers
        Response.Stream stream = response.stream();
        stream.setMediaType("application/html");

        File file = File.createTempFile("qualityreport_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd")) + "_", ".html");
        Files.delete(file.toPath());

        InputStream input = getClass().getResourceAsStream("/templates/index.html");
        FileUtils.copyInputStreamToFile(input, file);
        FileUtils.copyFile(file, stream.output());

        response.setHeader("Content-Disposition", "attachment; filename=\"" + file + '"');

        LOGGER.info("Quality report generation: SUCCESS");
    }
}