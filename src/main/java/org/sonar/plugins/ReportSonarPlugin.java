package org.sonar.plugins;

import org.sonar.api.Plugin;
import org.sonar.plugins.web.ReportPluginPageDefinition;
import org.sonar.plugins.ws.ReportWS;

public class ReportSonarPlugin implements Plugin {

    @Override
    public void define(Context context) {
        context.addExtension(ReportWS.class);
        context.addExtension(ReportPluginPageDefinition.class)
    }
}
