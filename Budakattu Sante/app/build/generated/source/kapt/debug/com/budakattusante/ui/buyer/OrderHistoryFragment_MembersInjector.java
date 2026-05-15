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
public final class OrderHistoryFragment_MembersInjector implements MembersInjector<OrderHistoryFragment> {
  private final Provider<SessionManager> sessionManagerProvider;

  public OrderHistoryFragment_MembersInjector(Provider<SessionManager> sessionManagerProvider) {
    this.sessionManagerProvider = sessionManagerProvider;
  }

  public static MembersInjector<OrderHistoryFragment> create(
      Provider<SessionManager> sessionManagerProvider) {
    return new OrderHistoryFragment_MembersInjector(sessionManagerProvider);
  }

  @Override
  public void injectMembers(OrderHistoryFragment instance) {
    injectSessionManager(instance, sessionManagerProvider.get());
  }

  @InjectedFieldSignature("com.budakattusante.ui.buyer.OrderHistoryFragment.sessionManager")
  public static void injectSessionManager(OrderHistoryFragment instance,
      SessionManager sessionManager) {
    instance.sessionManager = sessionManager;
  }
}
