package com.budakattusante.ui.splash;

import com.budakattusante.data.preferences.SessionManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SplashActivity_MembersInjector implements MembersInjector<SplashActivity> {
  private final Provider<SessionManager> sessionManagerProvider;

  public SplashActivity_MembersInjector(Provider<SessionManager> sessionManagerProvider) {
    this.sessionManagerProvider = sessionManagerProvider;
  }

  public static MembersInjector<SplashActivity> create(
      Provider<SessionManager> sessionManagerProvider) {
    return new SplashActivity_MembersInjector(sessionManagerProvider);
  }

  @Override
  public void injectMembers(SplashActivity instance) {
    injectSessionManager(instance, sessionManagerProvider.get());
  }

  @InjectedFieldSignature("com.budakattusante.ui.splash.SplashActivity.sessionManager")
  public static void injectSessionManager(SplashActivity instance, SessionManager sessionManager) {
    instance.sessionManager = sessionManager;
  }
}
