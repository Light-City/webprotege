package edu.stanford.bmir.protege.web.server.app;

import dagger.Component;
import edu.stanford.bmir.protege.web.server.access.AccessManager;
import edu.stanford.bmir.protege.web.server.dispatch.DispatchServlet;
import edu.stanford.bmir.protege.web.server.download.ProjectDownloadServlet;
import edu.stanford.bmir.protege.web.server.inject.*;
import edu.stanford.bmir.protege.web.server.inject.project.ProjectModule;
import edu.stanford.bmir.protege.web.server.upload.FileUploadServlet;
import edu.stanford.bmir.protege.web.server.user.UserDetailsManager;
import edu.stanford.bmir.protege.web.shared.inject.ApplicationSingleton;
import edu.stanford.bmir.protege.web.shared.inject.SharedApplicationModule;

import javax.inject.Singleton;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 24 Jan 2018
 */
@Component(modules = {
        ApplicationModule.class,
        SharedApplicationModule.class,
        FileSystemConfigurationModule.class,
        ConfigurationTasksModule.class,
        ActionHandlersModule.class,
        AuthenticationModule.class,
        DbModule.class,
        ServerModule.class
})
@ApplicationSingleton
public interface ServerComponent {

    ApplicationNameSupplier getApplicationNameSupplier();

    ApplicationSettingsChecker getApplicationSettingsChecker();

    UserDetailsManager getUserDetailsManager();

    AccessManager getAccessManager();

    FileUploadServlet getFileUploadServlet();

    ProjectDownloadServlet getProjectDownloadServlet();

    DispatchServlet getDispatchServlet();

    WebProtegeSessionListener getSessionListener();

    WebProtegeConfigurationChecker getWebProtegeConfigurationChecker();

    ProjectComponent getProjectComponent(ProjectModule module);


}
