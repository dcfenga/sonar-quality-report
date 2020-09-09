package org.sonar.plugins.web;

import org.sonar.api.web.page.Context;
import org.sonar.api.web.page.Page;
import org.sonar.api.web.page.PageDefinition;
import org.sonar.utils.PluginStringManager;

public class ReportPluginPageDefinition implements PageDefinition {

    /**
     * Define the web view for the plugin. Called by SonarQube.
     *
     * @param context
     */
    @Override
    public void define(Context context) {
        Page.Builder page = Page.builder(PluginStringManager.getProperty("homepage.url"));
        page.setName(PluginStringManager.getProperty("homepage.name"));
        page.setScope(Page.Scope.GLOBAL);
        context.addPage(page.build());
    }
}