package users.shashank.projects.emergenspeech;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private final int REQ_CODE_SPEECH_INPUT = 100;


    private TextView outputText;
    private RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_howtouse:
                    outputText.setText("In a medical emergency such as an accident, cardiac arrest, or similar event, it often takes 4-5 minutes for emergency aid to arrive. In the mean time, a family member or bystander needs to know what to do to help the patient. In many cases this family member is not knowledgeable about what to do");
                    return true;
                case R.id.nav_probableconditions:
                    outputText.setText("Probable Conditions");
//                    outputText.setText(algorithm.getProbableConditions());
                    return true;
                case R.id.nav_recommendations:
                    outputText.setText("Recommendations");
//                    outputText.setText(algorithm.getRecommendationText());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        outputText = findViewById(R.id.text);

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Describe the symptoms");
                try {
                    startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
                } catch (ActivityNotFoundException ignored) {}
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Scanner sc = new Scanner("AndroidProjects/app/src/main/java/users/shashank/project/emergenspeech/data.csv");

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Toast.makeText(this, result.get(0), Toast.LENGTH_SHORT).show();
//                    algorithm.processText(result.get(0));
//                    while (sc.hasNext()) {
//                        String next = sc.next();
//                        if (next.equalsIgnoreCase(result.get(0))) {
//                            Toast.makeText(this, "0", Toast.LENGTH_SHORT).show();
//                        }
//                    }
                    Toast.makeText(this, "0", Toast.LENGTH_SHORT).show();
                }
                break;
            }

            default:
                Toast.makeText(this, "Default", Toast.LENGTH_LONG).show();
                break;
        }
    }


}
