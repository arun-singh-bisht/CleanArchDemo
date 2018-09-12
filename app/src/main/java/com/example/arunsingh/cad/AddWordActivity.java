package com.example.arunsingh.cad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddWordActivity extends AppCompatActivity {

    @BindView(R.id.ed_word)
    EditText ed_word;
    @BindView(R.id.ed_description)
    EditText ed_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.txt_add)
    public void onAddButtonClick()
    {
        String s_word = ed_word.getText().toString();
        String s_description = ed_description.getText().toString();

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


}
