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
public final class BuyerHomeFragment_MembersInjector implements MembersInjector<BuyerHomeFragment> {
  private final Provider<SessionManager> sessionManagerProvider;

  public BuyerHomeFragment_MembersInjector(Provider<SessionManager> sessionManagerProvider) {
    this.sessionManagerProvider = sessionManagerProvider;
  }

  public static MembersInjector<BuyerHomeFragment> create(
      Provider<SessionManager> sessionManagerProvider) {
    return new BuyerHomeFragment_MembersInjector(sessionManagerProvider);
  }

  @Override
  public void injectMembers(BuyerHomeFragment instance) {
    injectSessionManager(instance, sessionManagerProvider.get());
  }

  @InjectedFieldSignature("com.budakattusante.ui.buyer.BuyerHomeFragment.sessionManager")
  public static void injectSessionManager(BuyerHomeFragment instance,
      SessionManager sessionManager) {
    instance.sessionManager = sessionManager;
  }
}
