package com.budakattusante.di;

import android.content.Context;
import com.budakattusante.data.db.AppDatabase;
import com.budakattusante.data.db.dao.*;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

/**
 * Hilt module that provides Room database and DAO instances
 * throughout the entire application (SingletonComponent).
 */
@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/budakattusante/di/AppModule;", "", "()V", "provideCategoryDao", "Lcom/budakattusante/data/db/dao/CategoryDao;", "db", "Lcom/budakattusante/data/db/AppDatabase;", "provideDatabase", "context", "Landroid/content/Context;", "provideOrderDao", "Lcom/budakattusante/data/db/dao/OrderDao;", "provideProductDao", "Lcom/budakattusante/data/db/dao/ProductDao;", "provideTribalFamilyDao", "Lcom/budakattusante/data/db/dao/TribalFamilyDao;", "provideUserDao", "Lcom/budakattusante/data/db/dao/UserDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.budakattusante.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.budakattusante.data.db.AppDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.budakattusante.data.db.dao.UserDao provideUserDao(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.budakattusante.data.db.dao.ProductDao provideProductDao(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.budakattusante.data.db.dao.OrderDao provideOrderDao(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.budakattusante.data.db.dao.TribalFamilyDao provideTribalFamilyDao(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.budakattusante.data.db.dao.CategoryDao provideCategoryDao(@org.jetbrains.annotations.NotNull()
    com.budakattusante.data.db.AppDatabase db) {
        return null;
    }
}