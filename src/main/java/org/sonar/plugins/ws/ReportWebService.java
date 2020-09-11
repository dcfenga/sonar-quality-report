package org.sonar.plugins.ws;

import org.sonar.api.config.Configuration;
import org.sonar.api.server.ws.WebService;
import org.sonar.utils.PluginStringManager;

import java.util.logging.Logger;

public class ReportWebService implements WebService {

    private static final Logger LOGGER = Logger.getLogger(ReportWebService.class.getName());

    // SonarQube configuration
    private final Configuration config;

    /**
     * public constructor, called by SoanrQube
     */
    public ReportWebService(Configuration config) {
        this.config = config;
    }

    /**
     * Define plugin, called at SoanrQube startup
     *
     * @param context
     */
    @Override
    public void define(Context context) {
        LOGGER.info("Start to generate report:define" + PluginStringManager.getProperty("api.url"));

        final NewController controller = context.createController(PluginStringManager.getProperty("api.url"));
        controller.setSince(PluginStringManager.getProperty("plugin.since"));
        controller.setDescription(PluginStringManager.getProperty("api.description"));
        reportAction(controller);
        controller.done();
    }

    /**
     * Define action executed when we called the webservicew
     *
     * @param controller
     */
    private void reportAction(final WebService.NewController controller) {
        LOGGER.info("Start to generate report:reportAction");

        // Create API entry point
        final WebService.NewAction report = controller.createAction(PluginStringManager.getProperty("api.report.actionKey"));
        report.setDescription(PluginStringManager.getProperty("api.description"));
        report.setSince(PluginStringManager.getProperty("plugin.since"));

        // Bind webservice to export task
        report.setHandler(new ReportHandler(config));
    }
}