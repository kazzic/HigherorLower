package com.gordonzeng.higherorlower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.Random;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void clickGuess(View view) {
        EditText guess = (EditText) findViewById(R.id.guess);
        String guessString = guess.getText().toString();

        if(guessString.length() == 0) {
            Toast.makeText(getApplicationContext(), "Please enter a guess", Toast.LENGTH_SHORT).show();
            return;
        }


        int guessInt = Integer.parseInt(guess.getText().toString());
        String message = "";

        if(guessInt > randomNumber) message = "You guessed too HIGH";

        else if(guessInt < randomNumber) message = "You guessed too LOW";

        else {
            message = "You got it!!! Choosing a new number now...";
            Random randomGenerator = new Random();
            randomNumber = randomGenerator.nextInt(10) + 1;
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random randomGenerator = new Random();
        randomNumber = randomGenerator.nextInt(10) + 1;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
