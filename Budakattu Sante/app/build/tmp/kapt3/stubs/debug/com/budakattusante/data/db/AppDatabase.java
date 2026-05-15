package com.budakattusante.data.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.budakattusante.data.db.dao.*;
import com.budakattusante.data.db.entity.*;
import kotlinx.coroutines.Dispatchers;

/**
 * Main Room database for Budakattu Sante.
 * Seeds default data (categories, tribal families, products, admin user)
 * on first app launch.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/budakattusante/data/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "categoryDao", "Lcom/budakattusante/data/db/dao/CategoryDao;", "orderDao", "Lcom/budakattusante/data/db/dao/OrderDao;", "productDao", "Lcom/budakattusante/data/db/dao/ProductDao;", "tribalFamilyDao", "Lcom/budakattusante/data/db/dao/TribalFamilyDao;", "userDao", "Lcom/budakattusante/data/db/dao/UserDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.budakattusante.data.db.entity.User.class, com.budakattusante.data.db.entity.Product.class, com.budakattusante.data.db.entity.Order.class, com.budakattusante.data.db.entity.TribalFamily.class, com.budakattusante.data.db.entity.Category.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.budakattusante.data.db.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.budakattusante.data.db.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.budakattusante.data.db.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.budakattusante.data.db.dao.ProductDao productDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.budakattusante.data.db.dao.OrderDao orderDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.budakattusante.data.db.dao.TribalFamilyDao tribalFamilyDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.budakattusante.data.db.dao.CategoryDao categoryDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0082@\u00a2\u0006\u0002\u0010\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/budakattusante/data/db/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/budakattusante/data/db/AppDatabase;", "getDatabase", "context", "Landroid/content/Context;", "seedDatabase", "", "database", "(Lcom/budakattusante/data/db/AppDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.budakattusante.data.db.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final java.lang.Object seedDatabase(com.budakattusante.data.db.AppDatabase database, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}