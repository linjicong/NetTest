package com.ljc93.nettest.Dao;

import android.content.Context;
import com.j256.ormlite.dao.Dao;
import com.ljc93.nettest.Bean.User;
import java.sql.SQLException;

/**
 * Created by ljc93 on 2016/7/12 0012.
 */
public class UserDao {
  private Context context;
  private Dao<User, Integer> userDaoOpe;
  private DatabaseHelper helper;

  public UserDao(Context context)
  {
    this.context = context;
    try
    {
      helper = DatabaseHelper.getHelper(context);
      userDaoOpe = helper.getDao(User.class);
    } catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * 增加一个用户
   * @param user
   */
  public void add(User user)
  {
    try
    {
      userDaoOpe.create(user);
    } catch (SQLException e)
    {
      e.printStackTrace();
    }

  }//...other operations
}
