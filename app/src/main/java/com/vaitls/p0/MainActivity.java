package com.vaitls.p0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG="MainActivity";
    // We can't use an anonymous class in a loop, because the
    // variables would have to be final. Create our own private class.
    private class ToastListener implements View.OnClickListener {
        String toast;
        ToastListener(String toast){
            this.toast=toast;
        }
        @Override
        public void onClick(View view){
            Toast.makeText(getApplicationContext(),toast,Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int buttonIds[]={R.id.button1, R.id.button2, R.id.button3,
                         R.id.button4, R.id.button5, R.id.button6};
        String msgFmt=getString(R.string.toast_format);
        for(int i: buttonIds){
            Button button = (Button)findViewById(i);
            String buttonStr=(String)button.getText();
            button.setOnClickListener(new ToastListener(String.format(msgFmt,buttonStr)));
        }
    }
}
