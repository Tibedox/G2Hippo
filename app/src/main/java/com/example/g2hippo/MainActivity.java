package com.example.g2hippo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int n = 0;
    TextView textTitle;
    TextView textCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textTitle = findViewById(R.id.textView2);
        textCount = findViewById(R.id.textView3);
    }

    public void tapHippo(View view) {
        n += 1;

        if(n%10>1 && n%10<5 && n/10%10!=1){
            textCount.setText("Потапано " + n + " раза");
        } else {
            textCount.setText("Потапано " + n + " раз");
        }

        //String s = "Потапано " + n + ((n%10>1 && n%10<5 && n/10%10!=1)?" раза":" раз");
        //textCount.setText(s);

        switch (n){
            case 10: textTitle.setText("Хорошо тапаешь! Продолжай!"); break;
            case 20: textTitle.setText("Да ты просто гений!"); break;
            case 30: textTitle.setText("Ты крут!"); break;
            default: textTitle.setText("Потапай бегемота!");
        }
    }
}