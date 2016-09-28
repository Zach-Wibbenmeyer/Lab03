package edu.calvin.zdw3.lab03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/*****************************************
 * CS262 Lab03 - Build a basic password app
 * Professor: Keith Vanderlinden
 * Author: Zach Wibbenmeyer
 * Date: 09/25/2016
 */

public class MainActivity extends AppCompatActivity {

    // set up private variables
    private EditText passwordEditText;
    private TextView invalidTextView;
    private ImageView androidImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initiate the widgets
        invalidTextView = (TextView) findViewById(R.id.invalidTextView);
        invalidTextView.setVisibility(View.GONE);
        androidImageView = (ImageView) findViewById(R.id.androidImageView);
        androidImageView.setVisibility(View.GONE);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* onEditorAction() - method that determines if the password is correct or not
             * @param: v (type = TextView), actionId (type = int), event (type = KeyEvent)
             * @return: image if password is correct, invalidTextView if password is incorrect
             */
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String password = passwordEditText.getText().toString();
                if (password.equals("thisarthurtme")) {
                    invalidTextView.setVisibility(View.GONE);
                    androidImageView.setVisibility(View.VISIBLE);
                } else {
                    androidImageView.setVisibility(View.GONE);
                    invalidTextView.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
    }
}
