package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.todolist.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {
ActivityDataInsertBinding binding;

@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    String type = getIntent().getStringExtra("type");
    if (type.equals("update")) {
        setTitle("update");
        binding.titleid.setText(getIntent().getStringExtra("title"));
        binding.descid.setText(getIntent().getStringExtra("disp"));
        int id=getIntent().getIntExtra("id",0);
        binding.button3.setText("update note");
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title", binding.titleid.getText().toString());
                intent.putExtra("disp", binding.descid.getText().toString());
                intent.putExtra("id",id);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    } else {
        setTitle("Add Mode");
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title", binding.titleid.getText().toString());
                intent.putExtra("disp", binding.descid.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataInsertActivity.this,MainActivity.class));
    }
}