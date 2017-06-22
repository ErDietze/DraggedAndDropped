package com.example.eric.draggedanddropped;

import android.content.ClipData;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView target;
    MediaPlayer mediaPlayer;

    public TextView getTxt1() {
        return txt1;
    }

    public void setTxt1(TextView txt1) {
        this.txt1 = txt1;
    }

    public TextView getTxt2() {
        return txt2;
    }

    public void setTxt2(TextView txt2) {
        this.txt2 = txt2;
    }

    public TextView getTxt3() {
        return txt3;
    }

    public void setTxt3(TextView txt3) {
        this.txt3 = txt3;
    }

    public TextView getTarget() {
        return target;
    }

    public void setTarget(TextView target) {
        this.target = target;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);

       this.setTxt1((TextView) findViewById(R.id.txt1));
        this.setTxt2((TextView) findViewById(R.id.txt2));
        this.setTxt3((TextView) findViewById(R.id.txt3));
        this.setTarget((TextView) findViewById(R.id.target));

        this.getTxt1().setOnLongClickListener(longClickListener);
        this.getTxt2().setOnLongClickListener(longClickListener);
        this.getTxt3().setOnLongClickListener(longClickListener);
        this.getTarget().setOnDragListener(dragListener);

    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {


        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            return true;
        }

    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:

//                    if (view.getId() == R.id.txt1){
//                        target.setText("TextView 1 is Entered");
//                    }
//
//                    if (view.getId() == R.id.txt2){
//                        target.setText("TextView 2 is Entered");
//                    }
//
//                    if (view.getId() == R.id.txt3){
//                        target.setText("TextView 3 is Entered");
//                    }

                    break;
                case DragEvent.ACTION_DRAG_EXITED:


//                    if (view.getId() == R.id.txt1){
//                        target.setText("TextView 1 is Exited");
//                    }
//
//                    if (view.getId() == R.id.txt2){
//                        target.setText("TextView 2 is Exited");
//                    }
//
//                    if (view.getId() == R.id.txt3){
//                        target.setText("TextView 3 is Exited");
//                    }
                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.txt1) {
                        view.animate()
                                .x(target.getX())
                                .y(target.getY())
                                .setDuration(700)
                                .start();
                        setMediaPlayer(MediaPlayer.create(MainActivity.this, R.raw.right));
                        getMediaPlayer().start();
                    } else {
                        setMediaPlayer(MediaPlayer.create(MainActivity.this, R.raw.wrong));
                        getMediaPlayer().start();
                    }

//                    if (view.getId() == R.id.txt2){
//                        target.setText("TextView 2 is Dropped");
//                    }
//
//                    if (view.getId() == R.id.txt3){
//                        target.setText("TextView 3 is Dropped");
//                    }
//                    view.animate()
//                            .x(target.getX())
//                            .y(target.getY())
//                            .setDuration(700)
//                            .start();
                    break;
            }

            return true;
        }
    };
}
