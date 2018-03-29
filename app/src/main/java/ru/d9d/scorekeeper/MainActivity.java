package ru.d9d.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreForPlayerA = 0;
    int scoreForPlayerB = 0;
    String moveA = "";
    String moveB = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void countAR(View v) {
        moveA = "R";
        countScore();
    }

    public void countAP(View v) {
        moveA = "P";
        countScore();
    }

    public void countAS(View v) {
        moveA = "S";
        countScore();
    }

    public void countBR(View v) {
        moveB = "R";
        countScore();
    }

    public void countBP(View v) {
        moveB = "P";
        countScore();
    }

    public void countBS(View v) {
        moveB = "S";
        countScore();
    }

    public void countScore() {
        if (moveA.length() > 0 && moveB.length() > 0) {
            if (moveA == moveB) {
                displayToast(getString(R.string.tie));
            } else {
                if (moveA == "R") {
                    if (moveB == "S") {
                        scoreForPlayerA++;
                        displayToast(getString(R.string.win, getString(R.string.playerA), getString(R.string.rock)));
                    } else {
                        scoreForPlayerB++;
                        displayToast(getString(R.string.win, getString(R.string.playerB), getString(R.string.paper)));
                    }
                }
                if (moveA == "P") {
                    if (moveB == "R") {
                        scoreForPlayerA++;
                        displayToast(getString(R.string.win, getString(R.string.playerA), getString(R.string.paper)));

                    } else {
                        scoreForPlayerB++;
                        displayToast(getString(R.string.win, getString(R.string.playerB), getString(R.string.scissors)));
                    }
                }
                if (moveA == "S") {
                    if (moveB == "P") {
                        scoreForPlayerA++;
                        displayToast(getString(R.string.win, getString(R.string.playerA), getString(R.string.scissors)));
                    } else {
                        scoreForPlayerB++;
                        displayToast(getString(R.string.win, getString(R.string.playerB), getString(R.string.rock)));
                    }
                }
            }
            displayScore();
            moveA = "";
            moveB = "";
        } else if (moveB.length() > 0) { // waiting for move
            displayToast(getString(R.string.waiting, getString(R.string.playerA)));
        } else {
            displayToast(getString(R.string.waiting, getString(R.string.playerB)));
        }
    }

    public void scoreReset(View v) {
        scoreForPlayerA = 0;
        scoreForPlayerB = 0;
        displayScore();
    }

    public void displayScore() {
        TextView scoreViewA = findViewById(R.id.player_a_score);
        scoreViewA.setText(String.valueOf(scoreForPlayerA));
        TextView scoreViewB = findViewById(R.id.player_b_score);
        scoreViewB.setText(String.valueOf(scoreForPlayerB));
    }

    public void displayToast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}

