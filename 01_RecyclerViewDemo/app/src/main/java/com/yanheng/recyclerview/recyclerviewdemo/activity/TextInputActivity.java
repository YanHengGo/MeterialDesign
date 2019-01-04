package com.yanheng.recyclerview.recyclerviewdemo.activity;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.yanheng.recyclerview.recyclerviewdemo.R;

public class TextInputActivity extends AppCompatActivity {

    private TextInputLayout textInputId;
    private EditText editId;
    private TextInputLayout textInputPassword;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        initView();

        checkInput();
    }

    private void checkInput() {
        editId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String tmp = s.toString();
                if(tmp.contains("@")){
                    textInputId.setError("输入格式不对");
                    textInputId.setHint("输入格式不对");
                }else{
                    textInputId.setErrorEnabled(false);
                    textInputId.setHint("Username");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initView() {
        textInputId = ((TextInputLayout) findViewById(R.id.textinput_id));
        editId = ((EditText) findViewById(R.id.edit_id));
        textInputPassword = ((TextInputLayout) findViewById(R.id.textinput_password));
        editPassword = ((EditText) findViewById(R.id.edit_password));
    }
}
