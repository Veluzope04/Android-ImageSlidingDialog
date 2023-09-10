package com.example.imageslider;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ImageSliderDialog extends Dialog{
   private TextView txtTitle, txtImageNo;

   private ImageView imageView;
   private Button btnCancel;
    int index =0;

    public ImageSliderDialog(@NonNull Context context){
        super(context);
        setContentView(R.layout.activity_imageslider);
        inThisView();
        btnCancel.setOnClickListener(new onCancelBtnClickListener());
        ImagesliderThread img1 = new ImagesliderThread();
        img1.execute();
    }

    private void inThisView(){
        txtTitle = findViewById(R.id.txtTitle);
        imageView = findViewById(R.id.imgView);
        btnCancel = findViewById(R.id.btnCancel);
        txtImageNo = findViewById(R.id.txtImgNo);
    }

    private class onCancelBtnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            dismiss();
        }
    }

    public static int[] images = {R.drawable.natures,R.drawable.draw,R.drawable.design,R.drawable.sketch};

    public class ImagesliderThread extends AsyncTask<Integer,Integer,Integer>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {

            for (int i = 0; i < images.length; i++) {
                publishProgress(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            return doInBackground();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (index>=images.length){
                index=0;
            }

            imageView.setImageResource(images[index]);
            txtImageNo.setText(index+1 + " of " + images.length);
            index++;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }
    }

}


