package com.ljc93.nettest.NetFrameTest;

import com.ljc93.nettest.Bean.User;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ljc93 on 2016/7/6 0006.
 */
public interface MyApiEndpointInterface {
  // Request method and URL specified in the annotation
  // Callback for the parsed response is the last parameter
  @GET("/users/{username}") Call<User> getUser(@Path("username") String username);
  @GET("/group/{id}/users")
  Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);
  @POST("/users/new") Call<User> createUser(@Body User user);
}
