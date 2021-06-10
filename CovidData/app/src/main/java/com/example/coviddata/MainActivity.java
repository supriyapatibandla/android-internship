package com.example.coviddata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText country;
    TextView Confirmed,Active,Recovered,Dead;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        country = findViewById(R.id.country);
        Confirmed = findViewById(R.id.confirmed);
        Active = findViewById(R.id.active);
        Recovered = findViewById(R.id.recovered);
        Dead = findViewById(R.id.deaths);
        pd = new ProgressDialog(this);
        pd.setMessage("Please Wait ....");
        pd.setProgress(ProgressDialog.STYLE_SPINNER);
    }

    public void Search(View view) {
        String c = country.getText().toString().trim();
        pd.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.covid19api.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        Call<String> response = retrofit.create(MyInterface.class).getValue(c);
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String res = response.body();
                try {
                    JSONArray root = new JSONArray(res);
                    JSONObject obj = root.getJSONObject(root.length()-1);
                    String confirmed = obj.getString("Confirmed");
                    String active = obj.getString("Active");
                    String  recovered =obj.getString("Recovered");
                    String death = obj.getString("Deaths");

                    Confirmed.setText("Confirmed : "+confirmed);
                    Active.setText("Active : "+active);
                    Recovered.setText("Recovered : "+recovered);
                    Dead.setText("Deaths : "+death);
                    pd.dismiss();


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();

            }
        });

    }
}