package com.example.dorys.proyectos;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dorys.proyectos.adapters.ProyectoAdapter;
import com.example.dorys.proyectos.model.DatosResponse;
import com.example.dorys.proyectos.model.Proyecto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity implements ProyectoAdapter.OnProyectoSelectedListener{

    private RecyclerView proyectosRecyclerView;
    private ProyectoAdapter proyectosAdapter;

    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        proyectosRecyclerView = (RecyclerView) findViewById(R.id.proyectosRecyclerView);
        proyectosRecyclerView.setHasFixedSize(true);
        proyectosRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        proyectosAdapter = new ProyectoAdapter(this, this);

        proyectosRecyclerView.setAdapter(proyectosAdapter);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                cargarDatos();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        swipeRefreshLayout.setRefreshing(true);
        cargarDatos();
    }

    private void cargarDatos() {

        // TODO: Hacer el request

        DatosGobBoService service =ServiceGenerator.createService(DatosGobBoService.class);
        Call<DatosResponse> call= service.proyectitos("cb8219f3-5c05-4230-942e-6fb436df450b",5);

        call.enqueue(new Callback<DatosResponse>() {
            @Override
            public void onResponse(Call<DatosResponse> call, Response<DatosResponse> response) {

                // swipeRefreshLayout.set

                if(response.isSuccessful()) {

                    proyectosAdapter.setDataset(response.body().getResult().getRecords());
                    //  List<Proyecto> lista= response.body().getResult().getRecords();

                    // proyectosAdapter.setDataset(lista);
                }
                else{
                    Log.e("MIAPP ", "No se puede obtener los proyectos");

                }

            }
            @Override
            public void onFailure(Call<DatosResponse> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Log.e("MIAPP", "Error obteniendo proyectos: " + t.getMessage());

            }
        });

    }

    @Override
    public void onProyectoSelected(Proyecto proyecto) {

        Intent intent = new Intent (this, ProyectoActivity.class);
        intent.putExtra ("id",proyecto.getClass());
        startActivity(intent);


    }
}
