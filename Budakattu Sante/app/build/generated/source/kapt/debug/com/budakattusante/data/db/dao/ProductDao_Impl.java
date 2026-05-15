package com.budakattusante.data.db.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.budakattusante.data.db.entity.Product;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ProductDao_Impl implements ProductDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Product> __insertionAdapterOfProduct;

  private final EntityDeletionOrUpdateAdapter<Product> __deletionAdapterOfProduct;

  private final EntityDeletionOrUpdateAdapter<Product> __updateAdapterOfProduct;

  private final SharedSQLiteStatement __preparedStmtOfReduceStock;

  public ProductDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProduct = new EntityInsertionAdapter<Product>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `products` (`id`,`name`,`description`,`category`,`imageRes`,`price`,`mspPrice`,`stock`,`season`,`tribalFamilyId`,`village`,`audioText`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Product entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        if (entity.getImageRes() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getImageRes());
        }
        statement.bindDouble(6, entity.getPrice());
        statement.bindDouble(7, entity.getMspPrice());
        statement.bindLong(8, entity.getStock());
        if (entity.getSeason() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getSeason());
        }
        statement.bindLong(10, entity.getTribalFamilyId());
        if (entity.getVillage() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getVillage());
        }
        if (entity.getAudioText() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getAudioText());
        }
      }
    };
    this.__deletionAdapterOfProduct = new EntityDeletionOrUpdateAdapter<Product>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `products` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Product entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfProduct = new EntityDeletionOrUpdateAdapter<Product>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `products` SET `id` = ?,`name` = ?,`description` = ?,`category` = ?,`imageRes` = ?,`price` = ?,`mspPrice` = ?,`stock` = ?,`season` = ?,`tribalFamilyId` = ?,`village` = ?,`audioText` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Product entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        if (entity.getImageRes() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getImageRes());
        }
        statement.bindDouble(6, entity.getPrice());
        statement.bindDouble(7, entity.getMspPrice());
        statement.bindLong(8, entity.getStock());
        if (entity.getSeason() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getSeason());
        }
        statement.bindLong(10, entity.getTribalFamilyId());
        if (entity.getVillage() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getVillage());
        }
        if (entity.getAudioText() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getAudioText());
        }
        statement.bindLong(13, entity.getId());
      }
    };
    this.__preparedStmtOfReduceStock = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE products SET stock = stock - ? WHERE id = ? AND stock >= ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertProduct(final Product product, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfProduct.insertAndReturnId(product);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteProduct(final Product product, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfProduct.handle(product);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateProduct(final Product product, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfProduct.handle(product);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object reduceStock(final int productId, final int quantity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfReduceStock.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, quantity);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, productId);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, quantity);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfReduceStock.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Product>> getAllProducts() {
    final String _sql = "SELECT * FROM products ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"products"}, new Callable<List<Product>>() {
      @Override
      @NonNull
      public List<Product> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfImageRes = CursorUtil.getColumnIndexOrThrow(_cursor, "imageRes");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfMspPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "mspPrice");
          final int _cursorIndexOfStock = CursorUtil.getColumnIndexOrThrow(_cursor, "stock");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfTribalFamilyId = CursorUtil.getColumnIndexOrThrow(_cursor, "tribalFamilyId");
          final int _cursorIndexOfVillage = CursorUtil.getColumnIndexOrThrow(_cursor, "village");
          final int _cursorIndexOfAudioText = CursorUtil.getColumnIndexOrThrow(_cursor, "audioText");
          final List<Product> _result = new ArrayList<Product>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Product _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpImageRes;
            if (_cursor.isNull(_cursorIndexOfImageRes)) {
              _tmpImageRes = null;
            } else {
              _tmpImageRes = _cursor.getString(_cursorIndexOfImageRes);
            }
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final double _tmpMspPrice;
            _tmpMspPrice = _cursor.getDouble(_cursorIndexOfMspPrice);
            final int _tmpStock;
            _tmpStock = _cursor.getInt(_cursorIndexOfStock);
            final String _tmpSeason;
            if (_cursor.isNull(_cursorIndexOfSeason)) {
              _tmpSeason = null;
            } else {
              _tmpSeason = _cursor.getString(_cursorIndexOfSeason);
            }
            final int _tmpTribalFamilyId;
            _tmpTribalFamilyId = _cursor.getInt(_cursorIndexOfTribalFamilyId);
            final String _tmpVillage;
            if (_cursor.isNull(_cursorIndexOfVillage)) {
              _tmpVillage = null;
            } else {
              _tmpVillage = _cursor.getString(_cursorIndexOfVillage);
            }
            final String _tmpAudioText;
            if (_cursor.isNull(_cursorIndexOfAudioText)) {
              _tmpAudioText = null;
            } else {
              _tmpAudioText = _cursor.getString(_cursorIndexOfAudioText);
            }
            _item = new Product(_tmpId,_tmpName,_tmpDescription,_tmpCategory,_tmpImageRes,_tmpPrice,_tmpMspPrice,_tmpStock,_tmpSeason,_tmpTribalFamilyId,_tmpVillage,_tmpAudioText);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getProductById(final int id, final Continuation<? super Product> $completion) {
    final String _sql = "SELECT * FROM products WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Product>() {
      @Override
      @Nullable
      public Product call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfImageRes = CursorUtil.getColumnIndexOrThrow(_cursor, "imageRes");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfMspPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "mspPrice");
          final int _cursorIndexOfStock = CursorUtil.getColumnIndexOrThrow(_cursor, "stock");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfTribalFamilyId = CursorUtil.getColumnIndexOrThrow(_cursor, "tribalFamilyId");
          final int _cursorIndexOfVillage = CursorUtil.getColumnIndexOrThrow(_cursor, "village");
          final int _cursorIndexOfAudioText = CursorUtil.getColumnIndexOrThrow(_cursor, "audioText");
          final Product _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpImageRes;
            if (_cursor.isNull(_cursorIndexOfImageRes)) {
              _tmpImageRes = null;
            } else {
              _tmpImageRes = _cursor.getString(_cursorIndexOfImageRes);
            }
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final double _tmpMspPrice;
            _tmpMspPrice = _cursor.getDouble(_cursorIndexOfMspPrice);
            final int _tmpStock;
            _tmpStock = _cursor.getInt(_cursorIndexOfStock);
            final String _tmpSeason;
            if (_cursor.isNull(_cursorIndexOfSeason)) {
              _tmpSeason = null;
            } else {
              _tmpSeason = _cursor.getString(_cursorIndexOfSeason);
            }
            final int _tmpTribalFamilyId;
            _tmpTribalFamilyId = _cursor.getInt(_cursorIndexOfTribalFamilyId);
            final String _tmpVillage;
            if (_cursor.isNull(_cursorIndexOfVillage)) {
              _tmpVillage = null;
            } else {
              _tmpVillage = _cursor.getString(_cursorIndexOfVillage);
            }
            final String _tmpAudioText;
            if (_cursor.isNull(_cursorIndexOfAudioText)) {
              _tmpAudioText = null;
            } else {
              _tmpAudioText = _cursor.getString(_cursorIndexOfAudioText);
            }
            _result = new Product(_tmpId,_tmpName,_tmpDescription,_tmpCategory,_tmpImageRes,_tmpPrice,_tmpMspPrice,_tmpStock,_tmpSeason,_tmpTribalFamilyId,_tmpVillage,_tmpAudioText);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Product>> getProductsByCategory(final String category) {
    final String _sql = "SELECT * FROM products WHERE category = ? ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"products"}, new Callable<List<Product>>() {
      @Override
      @NonNull
      public List<Product> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfImageRes = CursorUtil.getColumnIndexOrThrow(_cursor, "imageRes");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfMspPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "mspPrice");
          final int _cursorIndexOfStock = CursorUtil.getColumnIndexOrThrow(_cursor, "stock");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfTribalFamilyId = CursorUtil.getColumnIndexOrThrow(_cursor, "tribalFamilyId");
          final int _cursorIndexOfVillage = CursorUtil.getColumnIndexOrThrow(_cursor, "village");
          final int _cursorIndexOfAudioText = CursorUtil.getColumnIndexOrThrow(_cursor, "audioText");
          final List<Product> _result = new ArrayList<Product>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Product _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpImageRes;
            if (_cursor.isNull(_cursorIndexOfImageRes)) {
              _tmpImageRes = null;
            } else {
              _tmpImageRes = _cursor.getString(_cursorIndexOfImageRes);
            }
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final double _tmpMspPrice;
            _tmpMspPrice = _cursor.getDouble(_cursorIndexOfMspPrice);
            final int _tmpStock;
            _tmpStock = _cursor.getInt(_cursorIndexOfStock);
            final String _tmpSeason;
            if (_cursor.isNull(_cursorIndexOfSeason)) {
              _tmpSeason = null;
            } else {
              _tmpSeason = _cursor.getString(_cursorIndexOfSeason);
            }
            final int _tmpTribalFamilyId;
            _tmpTribalFamilyId = _cursor.getInt(_cursorIndexOfTribalFamilyId);
            final String _tmpVillage;
            if (_cursor.isNull(_cursorIndexOfVillage)) {
              _tmpVillage = null;
            } else {
              _tmpVillage = _cursor.getString(_cursorIndexOfVillage);
            }
            final String _tmpAudioText;
            if (_cursor.isNull(_cursorIndexOfAudioText)) {
              _tmpAudioText = null;
            } else {
              _tmpAudioText = _cursor.getString(_cursorIndexOfAudioText);
            }
            _item = new Product(_tmpId,_tmpName,_tmpDescription,_tmpCategory,_tmpImageRes,_tmpPrice,_tmpMspPrice,_tmpStock,_tmpSeason,_tmpTribalFamilyId,_tmpVillage,_tmpAudioText);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Product>> searchProducts(final String query) {
    final String _sql = "SELECT * FROM products WHERE name LIKE '%' || ? || '%' OR village LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"products"}, new Callable<List<Product>>() {
      @Override
      @NonNull
      public List<Product> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfImageRes = CursorUtil.getColumnIndexOrThrow(_cursor, "imageRes");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfMspPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "mspPrice");
          final int _cursorIndexOfStock = CursorUtil.getColumnIndexOrThrow(_cursor, "stock");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfTribalFamilyId = CursorUtil.getColumnIndexOrThrow(_cursor, "tribalFamilyId");
          final int _cursorIndexOfVillage = CursorUtil.getColumnIndexOrThrow(_cursor, "village");
          final int _cursorIndexOfAudioText = CursorUtil.getColumnIndexOrThrow(_cursor, "audioText");
          final List<Product> _result = new ArrayList<Product>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Product _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpImageRes;
            if (_cursor.isNull(_cursorIndexOfImageRes)) {
              _tmpImageRes = null;
            } else {
              _tmpImageRes = _cursor.getString(_cursorIndexOfImageRes);
            }
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final double _tmpMspPrice;
            _tmpMspPrice = _cursor.getDouble(_cursorIndexOfMspPrice);
            final int _tmpStock;
            _tmpStock = _cursor.getInt(_cursorIndexOfStock);
            final String _tmpSeason;
            if (_cursor.isNull(_cursorIndexOfSeason)) {
              _tmpSeason = null;
            } else {
              _tmpSeason = _cursor.getString(_cursorIndexOfSeason);
            }
            final int _tmpTribalFamilyId;
            _tmpTribalFamilyId = _cursor.getInt(_cursorIndexOfTribalFamilyId);
            final String _tmpVillage;
            if (_cursor.isNull(_cursorIndexOfVillage)) {
              _tmpVillage = null;
            } else {
              _tmpVillage = _cursor.getString(_cursorIndexOfVillage);
            }
            final String _tmpAudioText;
            if (_cursor.isNull(_cursorIndexOfAudioText)) {
              _tmpAudioText = null;
            } else {
              _tmpAudioText = _cursor.getString(_cursorIndexOfAudioText);
            }
            _item = new Product(_tmpId,_tmpName,_tmpDescription,_tmpCategory,_tmpImageRes,_tmpPrice,_tmpMspPrice,_tmpStock,_tmpSeason,_tmpTribalFamilyId,_tmpVillage,_tmpAudioText);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getProductCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM products";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Product>> getLowStockProducts() {
    final String _sql = "SELECT * FROM products WHERE stock < 10 ORDER BY stock ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"products"}, new Callable<List<Product>>() {
      @Override
      @NonNull
      public List<Product> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfImageRes = CursorUtil.getColumnIndexOrThrow(_cursor, "imageRes");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfMspPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "mspPrice");
          final int _cursorIndexOfStock = CursorUtil.getColumnIndexOrThrow(_cursor, "stock");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfTribalFamilyId = CursorUtil.getColumnIndexOrThrow(_cursor, "tribalFamilyId");
          final int _cursorIndexOfVillage = CursorUtil.getColumnIndexOrThrow(_cursor, "village");
          final int _cursorIndexOfAudioText = CursorUtil.getColumnIndexOrThrow(_cursor, "audioText");
          final List<Product> _result = new ArrayList<Product>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Product _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpImageRes;
            if (_cursor.isNull(_cursorIndexOfImageRes)) {
              _tmpImageRes = null;
            } else {
              _tmpImageRes = _cursor.getString(_cursorIndexOfImageRes);
            }
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final double _tmpMspPrice;
            _tmpMspPrice = _cursor.getDouble(_cursorIndexOfMspPrice);
            final int _tmpStock;
            _tmpStock = _cursor.getInt(_cursorIndexOfStock);
            final String _tmpSeason;
            if (_cursor.isNull(_cursorIndexOfSeason)) {
              _tmpSeason = null;
            } else {
              _tmpSeason = _cursor.getString(_cursorIndexOfSeason);
            }
            final int _tmpTribalFamilyId;
            _tmpTribalFamilyId = _cursor.getInt(_cursorIndexOfTribalFamilyId);
            final String _tmpVillage;
            if (_cursor.isNull(_cursorIndexOfVillage)) {
              _tmpVillage = null;
            } else {
              _tmpVillage = _cursor.getString(_cursorIndexOfVillage);
            }
            final String _tmpAudioText;
            if (_cursor.isNull(_cursorIndexOfAudioText)) {
              _tmpAudioText = null;
            } else {
              _tmpAudioText = _cursor.getString(_cursorIndexOfAudioText);
            }
            _item = new Product(_tmpId,_tmpName,_tmpDescription,_tmpCategory,_tmpImageRes,_tmpPrice,_tmpMspPrice,_tmpStock,_tmpSeason,_tmpTribalFamilyId,_tmpVillage,_tmpAudioText);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
