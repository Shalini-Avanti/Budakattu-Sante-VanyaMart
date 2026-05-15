package com.budakattusante.ui.leader;

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
public final class LeaderDashboardFragment_MembersInjector implements MembersInjector<LeaderDashboardFragment> {
  private final Provider<SessionManager> sessionManagerProvider;

  public LeaderDashboardFragment_MembersInjector(Provider<SessionManager> sessionManagerProvider) {
    this.sessionManagerProvider = sessionManagerProvider;
  }

  public static MembersInjector<LeaderDashboardFragment> create(
      Provider<SessionManager> sessionManagerProvider) {
    return new LeaderDashboardFragment_MembersInjector(sessionManagerProvider);
  }

  @Override
  public void injectMembers(LeaderDashboardFragment instance) {
    injectSessionManager(instance, sessionManagerProvider.get());
  }

  @InjectedFieldSignature("com.budakattusante.ui.leader.LeaderDashboardFragment.sessionManager")
  public static void injectSessionManager(LeaderDashboardFragment instance,
      SessionManager sessionManager) {
    instance.sessionManager = sessionManager;
  }
}
