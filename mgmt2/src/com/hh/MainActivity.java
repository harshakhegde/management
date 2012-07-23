package com.hh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.hh.PlayActivity.*;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button b = (Button) findViewById(R.id.start);
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				EditText noOfPlayers = (EditText) findViewById(R.id.playersNum);
				Intent playArea = new Intent(MainActivity.this,
						PlayActivity.class);
				try {
					int players = Integer.valueOf(noOfPlayers.getText().toString());
					Log.e(MGMT, "value captured: "+players);
					playArea.putExtra(COUNT_PLAYERS, players);
				} catch (Exception e) {

				}
				startActivity(playArea);
			}
		});

	}

}
