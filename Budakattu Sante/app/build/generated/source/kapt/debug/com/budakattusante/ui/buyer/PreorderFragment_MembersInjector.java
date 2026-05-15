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
public final class PreorderFragment_MembersInjector implements MembersInjector<PreorderFragment> {
  private final Provider<SessionManager> sessionManagerProvider;

  public PreorderFragment_MembersInjector(Provider<SessionManager> sessionManagerProvider) {
    this.sessionManagerProvider = sessionManagerProvider;
  }

  public static MembersInjector<PreorderFragment> create(
      Provider<SessionManager> sessionManagerProvider) {
    return new PreorderFragment_MembersInjector(sessionManagerProvider);
  }

  @Override
  public void injectMembers(PreorderFragment instance) {
    injectSessionManager(instance, sessionManagerProvider.get());
  }

  @InjectedFieldSignature("com.budakattusante.ui.buyer.PreorderFragment.sessionManager")
  public static void injectSessionManager(PreorderFragment instance,
      SessionManager sessionManager) {
    instance.sessionManager = sessionManager;
  }
}
