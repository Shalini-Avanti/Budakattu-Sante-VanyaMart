package com.budakattusante.ui.viewmodel;

import com.budakattusante.data.repository.OrderRepository;
import com.budakattusante.data.repository.ProductRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class OrderViewModel_Factory implements Factory<OrderViewModel> {
  private final Provider<OrderRepository> orderRepositoryProvider;

  private final Provider<ProductRepository> productRepositoryProvider;

  public OrderViewModel_Factory(Provider<OrderRepository> orderRepositoryProvider,
      Provider<ProductRepository> productRepositoryProvider) {
    this.orderRepositoryProvider = orderRepositoryProvider;
    this.productRepositoryProvider = productRepositoryProvider;
  }

  @Override
  public OrderViewModel get() {
    return newInstance(orderRepositoryProvider.get(), productRepositoryProvider.get());
  }

  public static OrderViewModel_Factory create(Provider<OrderRepository> orderRepositoryProvider,
      Provider<ProductRepository> productRepositoryProvider) {
    return new OrderViewModel_Factory(orderRepositoryProvider, productRepositoryProvider);
  }

  public static OrderViewModel newInstance(OrderRepository orderRepository,
      ProductRepository productRepository) {
    return new OrderViewModel(orderRepository, productRepository);
  }
}
