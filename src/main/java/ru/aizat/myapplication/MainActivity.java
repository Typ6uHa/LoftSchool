package ru.aizat.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etConsumption;
    private TextInputEditText etName;
    private Button btnAdd;
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (etConsumption.getText() != null && etConsumption.getText().toString().trim().length() > 0 && etName.getText() != null && etName.getText().toString().trim().length() > 0) {
                btnAdd.setEnabled(true);
                btnAdd.setTextColor(getApplicationContext().getResources().getColor(R.color.main_button_color_enable));
                Drawable img = getApplicationContext().getResources().getDrawable(R.drawable.ic_arrow_enable);
                btnAdd.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
            } else {
                btnAdd.setEnabled(false);
                btnAdd.setTextColor(getApplicationContext().getResources().getColor(R.color.main_button_color_disable));
                Drawable img = getApplicationContext().getResources().getDrawable(R.drawable.ic_arrow_disable);
                btnAdd.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etConsumption = findViewById(R.id.etConsumption);
        etName = findViewById(R.id.etName);
        btnAdd = findViewById(R.id.btnAddItem);

        etConsumption.addTextChangedListener(textWatcher);
        etName.addTextChangedListener(textWatcher);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "я могу нажать на кнопку", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
