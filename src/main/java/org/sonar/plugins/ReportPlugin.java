package org.sonar.plugins;

import org.sonar.api.Plugin;
import org.sonar.plugins.web.ReportPluginPageDefinition;
import org.sonar.plugins.ws.ReportWebService;

public class ReportPlugin implements Plugin {

    @Override
    public void define(Context context) {
        context.addExtension(ReportWebService.class);
        context.addExtension(ReportPluginPageDefinition.class);
    }
}