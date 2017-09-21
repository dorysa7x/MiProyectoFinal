package com.example.dorys.proyectos;

import com.example.dorys.proyectos.model.DatosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dorys on 20/09/2017.
 */

public interface DatosGobBoService {

    @GET("action/datastore_search")
    Call<DatosResponse> proyectitos(@Query("resource_id") String resourceId, @Query("limit") int limit);

    @GET("action/datastore_search")
    Call<DatosResponse> proyectitos2(@Query("resource_id") String resourceId, @Query("q") String query);



}
