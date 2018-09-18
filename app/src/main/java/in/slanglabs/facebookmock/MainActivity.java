package in.slanglabs.facebookmock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String activity_mode;

        ImageView image= (ImageView) findViewById(R.id.image);

        Intent intent = getIntent();

        if(intent.getStringExtra(ActivityList.ACTIVITY_MODE) != null)
        {
            activity_mode = intent.getStringExtra(ActivityList.ACTIVITY_MODE);
        }
        else
        {
            activity_mode = ActivityList.MODE_HOME;

        }

        int screen = ActivityList.getImage(activity_mode);

        if(image !=null)
        {
            image.setImageResource(screen);
        }
    }
}
