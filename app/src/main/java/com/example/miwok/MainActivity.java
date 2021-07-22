/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.miwok;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file

        setContentView(R.layout.activity_main);


        // Find the views that shows the number category
        TextView number = findViewById(R.id.numbers);

        // Set on click Listener on that view..
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating An Intent to Open the NumbersActivity
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);

                //Start the new activity
                startActivity(numbersIntent);
            }
        });
        TextView phrases = findViewById(R.id.phrases);

        // Set on click Listener on that view.
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating An Intent to link NumbersActivity
                Intent numbersIntent = new Intent(MainActivity.this, PhrasesActivity.class);

                //Start the new activity
                startActivity(numbersIntent);
            }
        });

        TextView family = findViewById(R.id.family);
        // Set on click Listener on that view.
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating An Intent to open FamilyActivity
                Intent numbersIntent = new Intent(MainActivity.this, FamilyActivity.class);

                //Start the new activity
                startActivity(numbersIntent);
            }
        });

        TextView colors = findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating An Intent to Open ColorsActivity
                Intent numbersIntent = new Intent(MainActivity.this, ColorsActivity.class);

                //Start the new activity
                startActivity(numbersIntent);
            }

        });


    }
}

