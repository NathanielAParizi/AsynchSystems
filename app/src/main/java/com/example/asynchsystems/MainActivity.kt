package com.example.asynchsystems

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TEXT_STATE = "currentText"


class MainActivity : AppCompatActivity() {

    private lateinit var mTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextView = findViewById(R.id.txtView);

        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }


    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)


        // Save the state of the TextView
        outState.putString(
            TEXT_STATE,
            mTextView.getText().toString()
        );
    }

    fun onClick(view: View) {


        mTextView.text = "napping";

        // Start the AsyncTask.
        MyAsyncTask(mTextView).execute();

    }
}
