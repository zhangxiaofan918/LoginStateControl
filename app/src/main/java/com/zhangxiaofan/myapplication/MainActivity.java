package com.zhangxiaofan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] mStrData = {"a", "b", "c", "d", "e"};
    private EditText mEditText;
    private Map<Integer, String> maps = new HashMap<>();
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnLogin = (Button) findViewById(R.id.button);
        LinearLayout LlMain = (LinearLayout) findViewById(R.id.ll_main);
        mBtnLogin.setEnabled(false);

        for (int i = 0; i < 5; i++) {
            mEditText = new EditText(this);
            mEditText.setHint(mStrData[i]);
            mEditText.addTextChangedListener(new MyTextWatcher(i));
            LlMain.addView(mEditText);
        }

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "well done!", Toast.LENGTH_LONG).show();
            }
        });

    }

    class MyTextWatcher implements TextWatcher {

        private int index;

        public MyTextWatcher(int i) {
            index = i;
        }


        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            maps.put(index, editable.toString());
            if (maps.size() < 5) {
                mBtnLogin.setEnabled(false);
                return;
            }
            for (int i = 0; i < maps.size(); i++) {
                if (TextUtils.isEmpty(maps.get(index))) {
                    mBtnLogin.setEnabled(false);
                    return;
                }
            }
            mBtnLogin.setEnabled(true);
        }
    }
}
