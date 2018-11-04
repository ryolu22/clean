package com.example.evitacindys.aplikasimodul2kelompok29.ui.detailCar;

import com.example.evitacindys.aplikasimodul2kelompok29.data.model.DataCar;

import java.util.List;

public interface detailView {
        void showErrorCarById(String message);
        void showSuccessCarById(List<DataCar> dataC);

}
