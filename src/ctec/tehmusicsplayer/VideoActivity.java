package ctec.tehmusicsplayer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity
{

	private VideoView myPlayer;
	private Button returnButton;
	private MediaController myvideoController;
	private Uri videoLocation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		myPlayer = (VideoView) findViewbyId(R.id.videoView);
		returnButton = (Button) findViewById(R.id.videoView);
		
		videoLocation = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.party);
		myVideoController = new MediaController(this);
	}
	private void setupMedia()
	{
		myPlayer.setMediaController(myVideoController);
		myPlayer.setVideoURI(videoLocation);
	}
	private void setupListeners()
	{
		returnButton.setOnClickListener(new view.OnClickListener()
		{
			@Override
			public void onClick(View currentView)
			{
				Intent returnIntent = new Intent();
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});
	}
}
