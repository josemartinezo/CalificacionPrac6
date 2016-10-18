package edu.tecii.android.calificacion;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.inputPA)
    EditText inputPA;
    @Bind(R.id.inputPA2)
    EditText inputPA2;
    @Bind(R.id.inputPA3)
    EditText inputPA3;
    @Bind(R.id.inputPA4)
    EditText inputPA4;
    @Bind(R.id.inputPB1)
    EditText inputPB1;
    @Bind(R.id.inputPB2)
    EditText inputPB2;
    @Bind(R.id.inputPB3)
    EditText inputPB3;
    @Bind(R.id.inputPB4)
    EditText inputPB4;
    @Bind(R.id.btnSumbit)
    Button btnSumbit;
    @Bind(R.id.Resu)
    TextView Resu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSumbit)
    public void handleClickSubmit() {
        hideKeyboard();
        double PPA,PPB,PY;
        String pa1 = inputPA.getText().toString().trim();
        String pa2 = inputPA2.getText().toString().trim();
        String pa3 = inputPA3.getText().toString().trim();
        String pa4 = inputPA4.getText().toString().trim();
        String pb1 = inputPB1.getText().toString().trim();
        String pb2 = inputPB2.getText().toString().trim();
        String pb3 = inputPB3.getText().toString().trim();
        String pb4 = inputPB4.getText().toString().trim();

        double paa1 = Double.parseDouble(pa1);
        double paa2 = Double.parseDouble(pa2);
        double paa3 = Double.parseDouble(pa3);
        double paa4 = Double.parseDouble(pa4);
        double pbb1 = Double.parseDouble(pb1);
        double pbb2 = Double.parseDouble(pb2);
        double pbb3 = Double.parseDouble(pb3);
        double pbb4 = Double.parseDouble(pb4);


        if (!pa1.isEmpty()) {
            //double hip = Math.sqrt(Math.pow(cat01, 2) + Math.pow(cat02, 2));
            PPA = (0.20*paa1)+(0.20*paa2)+(0.25*paa3)+(0.35*paa4);
            PPB = (0.20*pbb1)+(0.20*pbb2)+(0.25*pbb3)+(0.35*pbb4);
            PY = ((0.3*PPA)+(0.35*PPB)-10.5/-0.35);

            String Resul = "Se debe sacar en el proyecto: " +PY+" para poder aprobar";


            Resu.setVisibility(View.VISIBLE);
            Resu.setText(Resul);

        }
    }


    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        try {
            inputManager.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        } catch (NullPointerException npe) {
            Log.e(getLocalClassName(), Log.getStackTraceString(npe));
        }
    }
}
