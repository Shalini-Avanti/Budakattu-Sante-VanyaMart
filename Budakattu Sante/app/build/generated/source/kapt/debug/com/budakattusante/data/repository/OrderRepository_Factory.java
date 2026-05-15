package com.budakattusante.data.repository;

import com.budakattusante.data.db.dao.OrderDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class OrderRepository_Factory implements Factory<OrderRepository> {
  private final Provider<OrderDao> orderDaoProvider;

  public OrderRepository_Factory(Provider<OrderDao> orderDaoProvider) {
    this.orderDaoProvider = orderDaoProvider;
  }

  @Override
  public OrderRepository get() {
    return newInstance(orderDaoProvider.get());
  }

  public static OrderRepository_Factory create(Provider<OrderDao> orderDaoProvider) {
    return new OrderRepository_Factory(orderDaoProvider);
  }

  public static OrderRepository newInstance(OrderDao orderDao) {
    return new OrderRepository(orderDao);
  }
}
