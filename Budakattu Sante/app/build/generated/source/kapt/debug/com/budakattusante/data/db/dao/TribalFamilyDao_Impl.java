package com.budakattusante.data.db.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.budakattusante.data.db.entity.TribalFamily;
import java.lang.Class;
import java.lang.Exception;
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
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TribalFamilyDao_Impl implements TribalFamilyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TribalFamily> __insertionAdapterOfTribalFamily;

  public TribalFamilyDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTribalFamily = new EntityInsertionAdapter<TribalFamily>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `tribal_families` (`id`,`familyName`,`leaderName`,`village`,`tribe`,`contactPhone`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TribalFamily entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getFamilyName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getFamilyName());
        }
        if (entity.getLeaderName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getLeaderName());
        }
        if (entity.getVillage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getVillage());
        }
        if (entity.getTribe() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTribe());
        }
        if (entity.getContactPhone() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getContactPhone());
        }
      }
    };
  }

  @Override
  public Object insertTribalFamily(final TribalFamily family,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfTribalFamily.insertAndReturnId(family);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllFamilies(final Continuation<? super List<TribalFamily>> $completion) {
    final String _sql = "SELECT * FROM tribal_families";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TribalFamily>>() {
      @Override
      @NonNull
      public List<TribalFamily> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFamilyName = CursorUtil.getColumnIndexOrThrow(_cursor, "familyName");
          final int _cursorIndexOfLeaderName = CursorUtil.getColumnIndexOrThrow(_cursor, "leaderName");
          final int _cursorIndexOfVillage = CursorUtil.getColumnIndexOrThrow(_cursor, "village");
          final int _cursorIndexOfTribe = CursorUtil.getColumnIndexOrThrow(_cursor, "tribe");
          final int _cursorIndexOfContactPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPhone");
          final List<TribalFamily> _result = new ArrayList<TribalFamily>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TribalFamily _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpFamilyName;
            if (_cursor.isNull(_cursorIndexOfFamilyName)) {
              _tmpFamilyName = null;
            } else {
              _tmpFamilyName = _cursor.getString(_cursorIndexOfFamilyName);
            }
            final String _tmpLeaderName;
            if (_cursor.isNull(_cursorIndexOfLeaderName)) {
              _tmpLeaderName = null;
            } else {
              _tmpLeaderName = _cursor.getString(_cursorIndexOfLeaderName);
            }
            final String _tmpVillage;
            if (_cursor.isNull(_cursorIndexOfVillage)) {
              _tmpVillage = null;
            } else {
              _tmpVillage = _cursor.getString(_cursorIndexOfVillage);
            }
            final String _tmpTribe;
            if (_cursor.isNull(_cursorIndexOfTribe)) {
              _tmpTribe = null;
            } else {
              _tmpTribe = _cursor.getString(_cursorIndexOfTribe);
            }
            final String _tmpContactPhone;
            if (_cursor.isNull(_cursorIndexOfContactPhone)) {
              _tmpContactPhone = null;
            } else {
              _tmpContactPhone = _cursor.getString(_cursorIndexOfContactPhone);
            }
            _item = new TribalFamily(_tmpId,_tmpFamilyName,_tmpLeaderName,_tmpVillage,_tmpTribe,_tmpContactPhone);
            _result.add(_item);
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
  public Object getFamilyById(final int id, final Continuation<? super TribalFamily> $completion) {
    final String _sql = "SELECT * FROM tribal_families WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<TribalFamily>() {
      @Override
      @Nullable
      public TribalFamily call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFamilyName = CursorUtil.getColumnIndexOrThrow(_cursor, "familyName");
          final int _cursorIndexOfLeaderName = CursorUtil.getColumnIndexOrThrow(_cursor, "leaderName");
          final int _cursorIndexOfVillage = CursorUtil.getColumnIndexOrThrow(_cursor, "village");
          final int _cursorIndexOfTribe = CursorUtil.getColumnIndexOrThrow(_cursor, "tribe");
          final int _cursorIndexOfContactPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPhone");
          final TribalFamily _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpFamilyName;
            if (_cursor.isNull(_cursorIndexOfFamilyName)) {
              _tmpFamilyName = null;
            } else {
              _tmpFamilyName = _cursor.getString(_cursorIndexOfFamilyName);
            }
            final String _tmpLeaderName;
            if (_cursor.isNull(_cursorIndexOfLeaderName)) {
              _tmpLeaderName = null;
            } else {
              _tmpLeaderName = _cursor.getString(_cursorIndexOfLeaderName);
            }
            final String _tmpVillage;
            if (_cursor.isNull(_cursorIndexOfVillage)) {
              _tmpVillage = null;
            } else {
              _tmpVillage = _cursor.getString(_cursorIndexOfVillage);
            }
            final String _tmpTribe;
            if (_cursor.isNull(_cursorIndexOfTribe)) {
              _tmpTribe = null;
            } else {
              _tmpTribe = _cursor.getString(_cursorIndexOfTribe);
            }
            final String _tmpContactPhone;
            if (_cursor.isNull(_cursorIndexOfContactPhone)) {
              _tmpContactPhone = null;
            } else {
              _tmpContactPhone = _cursor.getString(_cursorIndexOfContactPhone);
            }
            _result = new TribalFamily(_tmpId,_tmpFamilyName,_tmpLeaderName,_tmpVillage,_tmpTribe,_tmpContactPhone);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
