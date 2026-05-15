package com.budakattusante.di;

import com.budakattusante.data.db.AppDatabase;
import com.budakattusante.data.db.dao.TribalFamilyDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideTribalFamilyDaoFactory implements Factory<TribalFamilyDao> {
  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideTribalFamilyDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public TribalFamilyDao get() {
    return provideTribalFamilyDao(dbProvider.get());
  }

  public static AppModule_ProvideTribalFamilyDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideTribalFamilyDaoFactory(dbProvider);
  }

  public static TribalFamilyDao provideTribalFamilyDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTribalFamilyDao(db));
  }
}
