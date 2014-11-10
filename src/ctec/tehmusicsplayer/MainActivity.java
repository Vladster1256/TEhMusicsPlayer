package ctec.tehmusicsplayer;

import java.util.ArrayList;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends Activity implements Runnable
{
	private Button startButton;
	private Button stopButton;
	private Button pauseButton;
	private Button videoButton;
	private MediaPlayer soundPlayer;
	private SeekBar soundSeekBar;
	private Thread soundThread;
	private ArrayList<String> songList;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		startButton = (Button) findViewById(R.id.playButton);
		pauseButton = (Button) findViewById(R.id.pauseButton);
		stopButton = (Button) findViewById(R.id.stopButton);
		soundSeekBar = (SeekBar) findViewById(R.id.soundSeekBar);
		videoButton = (Button) findViewById(R.id.videoButton);
		soundPlayer = MediaPlayer.create(this, 0);

		setupListeners();

		soundThread = new Thread(this);
		soundThread.start();
		
		fillTheSongList();

	}
	
	private void fillTheSongList()
	{
		songList.add(1,"R.raw.mustbethefeeling");
		songList.add(2,"R.raw.sandstorm");
	}

	private void setupListeners()
	{
		startButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				soundPlayer.start();
			}
		});
		
		pauseButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				soundPlayer.pause();
			}
		});
		
		stopButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				soundPlayer.stop();
				soundPlayer = MediaPlayer.create(getBaseContext(),R.raw.mustbethefeeling);
			}
		});
		
		
		soundSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
		{
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar)
			{}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				if(fromUser)
				{
					soundPlayer.seekTo(progress);
				}
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
			{}
		});
	}

	/**
	 * Required since we are implementing Runnable. Allows the seekbar to update.
	 */
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
		int currentPosition = 0;
		int soundTotal = soundPlayer.getDuration();
		soundSeekBar.setMax(soundTotal);
		
		while (soundPlayer != null && currentPosition < soundTotal)
		{
			try
			{
				Thread.sleep(50);
				currentPosition = soundPlayer.getCurrentPosition();
				soundPlayer.
			}
			catch(InterruptedException soundException)
			{
				return;
			}
			catch(Exception otherException)
			{
				return;
			}
			soundSeekBar.setProgress(currentPosition);
			
			if()
		}
	}

}
