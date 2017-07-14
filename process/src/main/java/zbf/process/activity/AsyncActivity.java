package zbf.process.activity;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import zbf.process.R;

public class AsyncActivity extends AppCompatActivity
{

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        iv = (ImageView) findViewById(R.id.iv);
        new DownLoadImageTask().execute("http://example.com/image.png");
    }

    private class DownLoadImageTask extends AsyncTask<String,Void,Bitmap>
    {
        protected Bitmap doInBackground(String... urls)
        {
            return null;
            //TODO
//            return loadImageFromNetwork(urls[0]);
        }

        protected void onPostExecute(Bitmap result)
        {
            iv.setImageBitmap(result);
        }
    }
}
