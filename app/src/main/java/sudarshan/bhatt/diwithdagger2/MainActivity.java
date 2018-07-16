package sudarshan.bhatt.diwithdagger2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress);

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

//                    while (progressBar.getProgress() < 101) {
//                        progress += 10;
//                        progressBar.setProgress(progress);
                        Thread.sleep(2000);
//                    }


                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }).start();


        MediaPlayer mp = MediaPlayer.create(this, R.raw.thetrip);
        mp.start();
    }
}
