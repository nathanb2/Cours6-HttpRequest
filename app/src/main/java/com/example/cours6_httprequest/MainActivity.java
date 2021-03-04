package com.example.cours6_httprequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mReponseTv;
    private View mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVars();

        doHttpRequest();
    }

    private void doHttpRequest() {
        mProgressBar.setVisibility(View.VISIBLE);

        //On cree un objet request en passant par l'instance de APIService implemente dans notre instance de retrofit
        // et en appleant la methode de create de la request voulu dans l'APIService
        Call<List<GithubUser>> call = RetrofitHelper.getRetrofitApiService().getFollowing("JakeWharton");
        //on execute la request de maniere asynchrone (donc PAS sur le MainThread) en appelant enqueu sur notre objet call qui est notre request
        //on passe en parametre l'implementation de l'interface callback dont retrofit appelera les fonction lorsqu'il recevra la reponse
        call.enqueue(new Callback<List<GithubUser>>() {
            @Override
            public void onResponse(@NotNull Call<List<GithubUser>> call, @NotNull Response<List<GithubUser>> response) {
                //retour au MainThread
                mProgressBar.setVisibility(View.GONE);
                if (response.body() != null && response.body().size() > 0) {
                    mReponseTv.setText(response.body().get(0).getLogin());
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<GithubUser>> call, @NotNull Throwable t) {
                //retour au MainThread
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, getString(R.string.sorry_an_error_occurred), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initVars() {
        mProgressBar = findViewById(R.id.AM_progress);
        mReponseTv = findViewById(R.id.AM_response_tv);
    }

}