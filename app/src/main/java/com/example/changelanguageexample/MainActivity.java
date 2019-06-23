package com.example.changelanguageexample;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout changeLangLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeLangLayout = findViewById(R.id.changeLangLayout);
        changeLangLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final ArrayAdapter<String> languages = new ArrayAdapter<>(MainActivity.this, android.R.layout.select_dialog_item);
                languages.add(getString(R.string.english));
                languages.add(getString(R.string.arabic));
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.select_language)
                        .setSingleChoiceItems(languages, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String languageToLoad = languages.getItem(which);
                                String code = "";
                                if (languageToLoad.equals(getString(R.string.english)))
                                    code = "en";
                                else if (languageToLoad.equals(getString(R.string.arabic)))
                                    code = "ar";

                                dialog.dismiss();
                                //if (ConfigurationFile.getCurrentLanguage(getActivity()).equals(code))
                                //  return;
                                ConfigurationFile.setCurrentLanguage(MainActivity.this, code);
                                Intent refresh = new Intent(MainActivity.this, SplashActivity.class);
                                refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(refresh);
                                finish();
                            }
                        })
                        .show();

            }
        });



    }
}
