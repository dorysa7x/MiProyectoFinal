package com.example.dorys.proyectos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dorys.proyectos.adapters.ProyectoAdapter;
import com.example.dorys.proyectos.model.DatosResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProyectoActivity extends AppCompatActivity {

    private RecyclerView proyectosRecyclerView;
    private ProyectoAdapter proyectosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyecto);

        proyectosRecyclerView = (RecyclerView) findViewById(R.id.proyectosRecyclerView);
        proyectosRecyclerView.setHasFixedSize(true);
        proyectosRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //proyectosAdapter = new ProyectoAdapter(this, this);

        proyectosRecyclerView.setAdapter(proyectosAdapter);

        DatosGobBoService service = ServiceGenerator.createService(DatosGobBoService.class);
        Call<DatosResponse> call = service.proyectitos2("cb8219f3-5c05-4230-942e-6fb436df450b", "CAPINOTA");

        call.enqueue(new Callback<DatosResponse>() {
            @Override
            public void onResponse(Call<DatosResponse> call, Response<DatosResponse> response) {

                // swipeRefreshLayout.set

                if (response.isSuccessful()) {

                    proyectosAdapter.setDataset(response.body().getResult().getRecords());

                } else {
                    Log.e("MIAPP ", "No se puede obtener los proyectos");
                }
            }
            @Override
            public void onFailure(Call<DatosResponse> call, Throwable t) {

                Log.e("MIAPP", "Error obteniendo proyectos: " + t.getMessage());

            }
        });

    }

}
