package com.example.evitacindys.aplikasimodul2kelompok29.ui.detailCar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evitacindys.aplikasimodul2kelompok29.R;
import com.example.evitacindys.aplikasimodul2kelompok29.data.model.DataCar;
import com.example.evitacindys.aplikasimodul2kelompok29.utility.Constant;

import java.util.List;

public class detailActivity extends AppCompatActivity implements detailView {

    private detailPresenter presenter;
    private DataCar dataC;


    private TextView textYear;
    private TextView textName;
    private TextView textModel;
    private TextView textMerk;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        initIntentData();
        initPresenter();
        initData();
    }

    private void initData() {
        presenter.getCarById(dataC);
    }

    private void initPresenter() {
        presenter = new detailPresenter(this);
    }

    private void initView() {
        textName =  findViewById(R.id.text_Name);
        textMerk =  findViewById(R.id.text_Merk);
        textModel =  findViewById(R.id.text_Model);
        textYear =  findViewById(R.id.text_Year);


    }

    private void initIntentData() {
        dataC = getIntent().getParcelableExtra(Constant.Extra.DATA);
        if (dataC == null) finish();
    }

    @Override
    public void showErrorCarById(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessCarById(List<DataCar> dataC) {
        textName.setText(dataC.get(0).getName());
        textModel.setText(dataC.get(0).getModel());
        textYear.setText(dataC.get(0).getYear());
        textMerk.setText(dataC.get(0).getMerk());
    }

    //public void onBackPressed() {
      //  back();
    //}

    //private void back() {
      //  Intent reg = new Intent(this, HomeActivity.class);
        //startActivity(reg);
        //finish();
    //}
}
