package com.ljc93.nettest.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.ljc93.nettest.Bean.User;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ljc93 on 2016/7/12 0012.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
  private static final String TABLE_NAME = "sqlite-test.db";
  /**
   * userDao ，每张表对于一个
   */
  private Map<String, Dao> daos = new HashMap<String, Dao>();

  private DatabaseHelper(Context context)
  {
    super(context, TABLE_NAME, null, 2);
  }

  @Override
  public void onCreate(SQLiteDatabase database,
      ConnectionSource connectionSource)
  {
    try
    {
      TableUtils.createTable(connectionSource, User.class);
    } catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase database,
      ConnectionSource connectionSource, int oldVersion, int newVersion)
  {
    try
    {
      TableUtils.dropTable(connectionSource, User.class, true);
      onCreate(database, connectionSource);
    } catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private static DatabaseHelper instance;

  /**
   * 单例获取该Helper
   *
   * @param context
   * @return
   */
  public static synchronized DatabaseHelper getHelper(Context context)
  {
    if (instance == null)
    {
      synchronized (DatabaseHelper.class)
      {
        if (instance == null)
          instance = new DatabaseHelper(context);
      }
    }

    return instance;
  }

  /**
   * 获得userDao
   *
   * @return
   * @throws SQLException
   */
  public synchronized Dao getDao(Class clazz) throws SQLException
  {
    Dao dao = null;
    String className = clazz.getSimpleName();

    if (daos.containsKey(className))
    {
      dao = daos.get(className);
    }
    if (dao == null)
    {
      dao = super.getDao(clazz);
      daos.put(className, dao);
    }
    return dao;
  }

  /**
   * 释放资源
   */
  @Override
  public void close()
  {
    for (String key : daos.keySet())
    {
      Dao dao = daos.get(key);
      dao = null;
    }
  }
}
