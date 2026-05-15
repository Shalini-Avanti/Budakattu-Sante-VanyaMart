package com.budakattusante.ui.buyer;

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
public final class ProfileFragment_MembersInjector implements MembersInjector<ProfileFragment> {
  private final Provider<SessionManager> sessionManagerProvider;

  public ProfileFragment_MembersInjector(Provider<SessionManager> sessionManagerProvider) {
    this.sessionManagerProvider = sessionManagerProvider;
  }

  public static MembersInjector<ProfileFragment> create(
      Provider<SessionManager> sessionManagerProvider) {
    return new ProfileFragment_MembersInjector(sessionManagerProvider);
  }

  @Override
  public void injectMembers(ProfileFragment instance) {
    injectSessionManager(instance, sessionManagerProvider.get());
  }

  @InjectedFieldSignature("com.budakattusante.ui.buyer.ProfileFragment.sessionManager")
  public static void injectSessionManager(ProfileFragment instance, SessionManager sessionManager) {
    instance.sessionManager = sessionManager;
  }
}
