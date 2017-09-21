package com.example.dorys.proyectos.model;

import java.util.List;

/**
 * Created by Dorys on 20/09/2017.
 */

public class ResultResponse {

    private List<Proyecto> records;

    public List<Proyecto> getRecords()
    {
        return records;
    }

    public void setRecords(List<Proyecto> records)
    {
        this.records = records;
    }
}
