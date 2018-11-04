package com.example.evitacindys.aplikasimodul2kelompok29.ui.home;

import com.example.evitacindys.aplikasimodul2kelompok29.data.model.DataCar;

import java.util.List;

public interface HomeView {
    void successShowCar(List<DataCar> dataCars);
    void failedShowCar(String message);

}
