package com.example.evitacindys.aplikasimodul2kelompok29.ui.detailCar;

import android.util.Log;

import com.example.evitacindys.aplikasimodul2kelompok29.data.model.DataCar;
import com.example.evitacindys.aplikasimodul2kelompok29.data.network.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detailPresenter {

    private final detailView mview;

    public detailPresenter(detailView view) {
        this.mview = view;
    }


    public void getCarById(DataCar dataC) {
        RetrofitClient.getInstance()
                .getApi()
                .GetCarById(dataC.getId())
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {

                            JsonObject body = response.body();
                            JsonObject a = body.get("<3").getAsJsonObject();
                            Type type = new TypeToken<List<DataCar>>() {
                            }.getType();
                            List<DataCar> dataC = new Gson().fromJson(a, type);
                            mview.showSuccessCarById(dataC);

                        } else {
                            mview.showErrorCarById("Heya Brother!");
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.d("GOTCHA", t.getMessage());
                        mview.showErrorCarById(t.getMessage());
                    }

                });
    }
    }
