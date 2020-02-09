package com.example.gradecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button calc = (Button) findViewById(R.id.calculateButton);
        calc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                double individualAssignmentEarned, individualAssignmentPossible, teamProjectEarned, midtermEarned, midtermPossible, finalEarned, teamPossible, finalPossible, finalGrade;

                String letterGrade = "";

                DecimalFormat FORMAT = new DecimalFormat("#.#");

                EditText individualAssignmentEarn = (EditText) findViewById(R.id.individualAssignmentEarned);
                individualAssignmentEarned = Double.parseDouble(individualAssignmentEarn.getText().toString());

                EditText teamProjectEarn = (EditText) findViewById(R.id.teamProjectEarned);
                teamProjectEarned = Double.parseDouble(teamProjectEarn.getText().toString());

                EditText midtermEarn = (EditText) findViewById(R.id.midtermEarned);
                midtermEarned = Double.parseDouble(midtermEarn.getText().toString());

                EditText finalEarn = (EditText) findViewById(R.id.finalEarned);
                finalEarned = Double.parseDouble(finalEarn.getText().toString());

                EditText individualAssignmentP = (EditText) findViewById(R.id.individualAssignmentPossible);
                individualAssignmentPossible = Double.parseDouble(individualAssignmentP.getText().toString());

                EditText teamProjectP = (EditText) findViewById(R.id.teamPossible);
                teamPossible = Double.parseDouble(teamProjectP.getText().toString());

                EditText midtermP = (EditText) findViewById(R.id.midtermPossible);
                midtermPossible = Double.parseDouble(midtermP.getText().toString());

                EditText finalP = (EditText) findViewById(R.id.finalPossible);
                finalPossible = Double.parseDouble(finalP.getText().toString());

                TextView resultBox = (TextView) findViewById(R.id.resultBox);


                if(individualAssignmentPossible== 0 || teamPossible== 0 || midtermPossible== 0 || finalPossible== 0) {
                    Toast popup = Toast.makeText(getApplicationContext(), "You cannot divide by zero.", Toast.LENGTH_SHORT);
                    popup.show();
                }
                else {

                    finalGrade = ((.20 * (individualAssignmentEarned / individualAssignmentPossible)) + (.30 * (teamProjectEarned / teamPossible)) +
                            (.30 * (midtermEarned / midtermPossible)) + (.20 * (finalEarned / finalPossible))) * 100;

                    if (finalGrade >= 90) {
                        letterGrade = "A";
                    } else if ((finalGrade >= 80)) {
                        letterGrade = "B";
                    } else if (finalGrade >= 70) {
                        letterGrade = "C";
                    } else if (finalGrade >= 60) {
                        letterGrade = "D";
                    } else if (finalGrade < 60) {
                        letterGrade = "F";
                    }

                    resultBox.setText(letterGrade + " " + FORMAT.format(finalGrade) + "%");
                }
            }
        });

    }




}

