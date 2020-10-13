package com.example.uts_pbp.Database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.uts_pbp.Model.Customer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CustomerDAO_Impl implements CustomerDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Customer> __insertionAdapterOfCustomer;

  private final EntityDeletionOrUpdateAdapter<Customer> __updateAdapterOfCustomer;

  public CustomerDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCustomer = new EntityInsertionAdapter<Customer>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Customer` (`id`,`nama`,`alamat`,`nomortelepon`,`nomorktp`,`motor`,`sewa`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Customer value) {
        stmt.bindLong(1, value.id);
        if (value.nama == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.nama);
        }
        if (value.alamat == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.alamat);
        }
        stmt.bindLong(4, value.nomortelepon);
        stmt.bindLong(5, value.nomorktp);
        if (value.motor == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.motor);
        }
        stmt.bindLong(7, value.sewa);
      }
    };
    this.__updateAdapterOfCustomer = new EntityDeletionOrUpdateAdapter<Customer>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Customer` SET `id` = ?,`nama` = ?,`alamat` = ?,`nomortelepon` = ?,`nomorktp` = ?,`motor` = ?,`sewa` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Customer value) {
        stmt.bindLong(1, value.id);
        if (value.nama == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.nama);
        }
        if (value.alamat == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.alamat);
        }
        stmt.bindLong(4, value.nomortelepon);
        stmt.bindLong(5, value.nomorktp);
        if (value.motor == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.motor);
        }
        stmt.bindLong(7, value.sewa);
        stmt.bindLong(8, value.id);
      }
    };
  }

  @Override
  public void insert(final Customer customer) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCustomer.insert(customer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Customer customer) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCustomer.handle(customer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Customer> getAll() {
    final String _sql = "SELECT * FROM customer";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNama = CursorUtil.getColumnIndexOrThrow(_cursor, "nama");
      final int _cursorIndexOfAlamat = CursorUtil.getColumnIndexOrThrow(_cursor, "alamat");
      final int _cursorIndexOfNomortelepon = CursorUtil.getColumnIndexOrThrow(_cursor, "nomortelepon");
      final int _cursorIndexOfNomorktp = CursorUtil.getColumnIndexOrThrow(_cursor, "nomorktp");
      final int _cursorIndexOfMotor = CursorUtil.getColumnIndexOrThrow(_cursor, "motor");
      final int _cursorIndexOfSewa = CursorUtil.getColumnIndexOrThrow(_cursor, "sewa");
      final List<Customer> _result = new ArrayList<Customer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Customer _item;
        _item = new Customer();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _item.nama = _cursor.getString(_cursorIndexOfNama);
        _item.alamat = _cursor.getString(_cursorIndexOfAlamat);
        _item.nomortelepon = _cursor.getInt(_cursorIndexOfNomortelepon);
        _item.nomorktp = _cursor.getInt(_cursorIndexOfNomorktp);
        _item.motor = _cursor.getString(_cursorIndexOfMotor);
        _item.sewa = _cursor.getInt(_cursorIndexOfSewa);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
