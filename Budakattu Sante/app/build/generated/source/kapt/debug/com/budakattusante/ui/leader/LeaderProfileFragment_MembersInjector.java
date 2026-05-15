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
public final class LeaderProfileFragment_MembersInjector implements MembersInjector<LeaderProfileFragment> {
  private final Provider<SessionManager> sessionManagerProvider;

  public LeaderProfileFragment_MembersInjector(Provider<SessionManager> sessionManagerProvider) {
    this.sessionManagerProvider = sessionManagerProvider;
  }

  public static MembersInjector<LeaderProfileFragment> create(
      Provider<SessionManager> sessionManagerProvider) {
    return new LeaderProfileFragment_MembersInjector(sessionManagerProvider);
  }

  @Override
  public void injectMembers(LeaderProfileFragment instance) {
    injectSessionManager(instance, sessionManagerProvider.get());
  }

  @InjectedFieldSignature("com.budakattusante.ui.leader.LeaderProfileFragment.sessionManager")
  public static void injectSessionManager(LeaderProfileFragment instance,
      SessionManager sessionManager) {
    instance.sessionManager = sessionManager;
  }
}
