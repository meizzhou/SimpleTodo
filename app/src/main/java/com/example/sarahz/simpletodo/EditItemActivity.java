package com.example.sarahz.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    String itemText;
    Integer itemPos;
    EditText editText;
    Button saveText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        Bundle bundle = this.getIntent().getExtras();
        itemText = bundle.getString("itemText");
        itemPos  = bundle.getInt("itemPos");
        editText = (EditText) findViewById(R.id.editText);
        saveText = (Button) findViewById(R.id.saveText);

        editText.setText(itemText);
        editText.setSelection(editText.getText().length());

    }

    public void onSubmit(View v) {
        itemText = editText.getText().toString();

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("itemText", itemText);
        bundle.putInt("itemPos", itemPos);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }
}
