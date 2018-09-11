package com.example.arunsingh.cad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arunsingh.cad.adapters.WordAdapter;

public class AddWordActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView mRecyclerView;
    private WordAdapter wordAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        findViewById(R.id.txt_add).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.txt_add:{
                String s_word = ((EditText) findViewById(R.id.ed_word)).getText().toString();
                String s_description = ((EditText) findViewById(R.id.ed_description)).getText().toString();

                if(s_word.isEmpty() || s_description.isEmpty())
                {
                    Toast.makeText(AddWordActivity.this,"Enter valid values before adding.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("new_word",s_word);
                intent.putExtra("new_description",s_description);
                setResult(RESULT_OK,intent);
                finish();
            }
            break;
        }
    }
}
