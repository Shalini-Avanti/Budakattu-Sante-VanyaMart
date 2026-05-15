package com.budakattusante.data.repository;

import com.budakattusante.data.db.dao.ProductDao;
import com.budakattusante.data.db.dao.TribalFamilyDao;
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
public final class ProductRepository_Factory implements Factory<ProductRepository> {
  private final Provider<ProductDao> productDaoProvider;

  private final Provider<TribalFamilyDao> tribalFamilyDaoProvider;

  public ProductRepository_Factory(Provider<ProductDao> productDaoProvider,
      Provider<TribalFamilyDao> tribalFamilyDaoProvider) {
    this.productDaoProvider = productDaoProvider;
    this.tribalFamilyDaoProvider = tribalFamilyDaoProvider;
  }

  @Override
  public ProductRepository get() {
    return newInstance(productDaoProvider.get(), tribalFamilyDaoProvider.get());
  }

  public static ProductRepository_Factory create(Provider<ProductDao> productDaoProvider,
      Provider<TribalFamilyDao> tribalFamilyDaoProvider) {
    return new ProductRepository_Factory(productDaoProvider, tribalFamilyDaoProvider);
  }

  public static ProductRepository newInstance(ProductDao productDao,
      TribalFamilyDao tribalFamilyDao) {
    return new ProductRepository(productDao, tribalFamilyDao);
  }
}
