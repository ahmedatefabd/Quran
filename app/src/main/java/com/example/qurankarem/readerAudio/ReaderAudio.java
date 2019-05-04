package com.example.qurankarem.readerAudio;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.Toolbar;
import model.Readers;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.qurankarem.R;
import com.example.qurankarem.readers.ReaderActivity;
import com.example.qurankarem.surah.HomeActivity;

public class ReaderAudio extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener{
    private ImageButton buttonPlayPause;
    private AppCompatSeekBar seekBarProgress;
    private MediaPlayer mediaPlayer;
    private int mediaFileLengthInMilliseconds;
    private String link ;
    private final Handler handler = new Handler();
    public static Toolbar toolbar ;
    private TextView AudioName ;
    private TextView SoraAudioName ;
    private TextView ReaderAudioName ;
    private TextView NumberAudioName ;
    private TextView PageNumberAudioName ;
    private TextView SoraTypeAudioName ;
    private TextView AyahNumbersAudioName ;
    private AppCompatButton Readers_Ayah ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reader_audio);
        AudioName = findViewById(R.id.audioName);
        SoraAudioName = findViewById(R.id.soraAudioName);
        ReaderAudioName = findViewById(R.id.readerAudioName);
        NumberAudioName = findViewById(R.id.numberAudioName);
        PageNumberAudioName = findViewById(R.id.pageNumberAudioName);
        SoraTypeAudioName = findViewById(R.id.soraTypeAudioName);
        AyahNumbersAudioName = findViewById(R.id.ayahNumbersAudioName);
        Readers_Ayah = findViewById(R.id.readers_Ayah);

        Readers_Ayah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReaderAudio.this, HomeActivity.class));
            }
        });

        Bundle intent = getIntent().getExtras();
        Readers readers = intent.getParcelable("Audio");
        controlToolbar(readers);

        SoraAudioName.setText(readers.getSora());
        ReaderAudioName.setText(readers.getReaderName());
        NumberAudioName.setText(String.valueOf(readers.getSoraNumber()));
        PageNumberAudioName.setText(String.valueOf(readers.getPageNumber()));
        SoraTypeAudioName.setText(readers.getSoraType());
        AyahNumbersAudioName.setText(String.valueOf(readers.getAyatsNumber()));

        link =  readers.getLink().substring(0 , 4) + "s:" + readers.getLink().substring(5 , readers.getLink().length());
        initView();
    }

    private void controlToolbar(Readers readers) {
        toolbar = findViewById(R.id.audio_Toolbar);
        AudioName.setText(readers.getSora());
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    private void initView() {
        buttonPlayPause = findViewById(R.id.ButtonTestPlayPause);
        buttonPlayPause.setOnClickListener(this);
        seekBarProgress = findViewById(R.id.SeekBarTestPlay);
        seekBarProgress.setMax(99);
        seekBarProgress.setOnTouchListener(this);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.setOnCompletionListener(this);
    }

    private void primarySeekBarProgressUpdater() {
        seekBarProgress.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaFileLengthInMilliseconds) * 100)); // This math construction give a percentage of "was playing"/"song length"
        if (mediaPlayer.isPlaying()) {
            Runnable notification = new Runnable() {
                public void run() {
                    primarySeekBarProgressUpdater();
                }
            };
            handler.postDelayed(notification, 1000);
        }
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        seekBarProgress.setSecondaryProgress(percent);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        buttonPlayPause.setImageResource(R.drawable.play);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.ButtonTestPlayPause) {
            try {
                mediaPlayer.setDataSource(link);
                mediaPlayer.prepare();
            } catch (Exception e) {
                e.printStackTrace();
            }

            mediaFileLengthInMilliseconds = mediaPlayer.getDuration();

            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                buttonPlayPause.setImageResource(R.drawable.pause);
            } else {
                mediaPlayer.pause();
                buttonPlayPause.setImageResource(R.drawable.play);
            }
            primarySeekBarProgressUpdater();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.SeekBarTestPlay) {
            if (mediaPlayer.isPlaying()) {
                SeekBar sb = (SeekBar) v;
                int playPositionInMillisecconds = (mediaFileLengthInMilliseconds / 100) * sb.getProgress();
                mediaPlayer.seekTo(playPositionInMillisecconds);
            }
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        startActivity(new Intent(ReaderAudio.this , ReaderActivity.class));
    }
}