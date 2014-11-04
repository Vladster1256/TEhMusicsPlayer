package ctec.tehmusicsplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		private Button startButton;
		private Button stopButton;
		private Button pauseButton;
		private Button videoButton;
		private MediaPlayer soundPlayer;
		private SeekBar soundSeekBar;
		private Thread soundThread;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		startButton = (Button) findViewById(R.id.playButton);
		pauseButton = (Button) findViewById(R.id.pauseButton);
		stopButton = (Button) findViewById(R.id.stopButton);
		soundSeekBar = (SeekBar) findViewById(R.id.soundSeekBar);
		videoButton = (Button) findViewById(R.id.videoButton);
		soundPlayer = MediaPlayer.create(this.getBaseContext(), R.raw.MustBeTheFeeling.mp3);
		
				setupListeners();
		
		soundThread = new Thread(this);
		soundThread.start();
		
	}
	
	private void setupListeners()
	{
		startButton.setOnClickListener(new view.OnclickListener()
		{
			@Override
			public void onClick(View v)
			{
				soundPlayer.start();
			}
		});
	}
}