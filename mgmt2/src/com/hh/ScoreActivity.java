package com.hh;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;

public class ScoreActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score);
		TableLayout t = (TableLayout) findViewById(R.id.scoretable);
		String scores = getIntent().getExtras().getString("score");
		TableRow tr = new TableRow(this);
		tr.setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));

		EditText cell = new EditText(this);
		cell.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		cell.setHorizontallyScrolling(true);
		cell.setText(scores.toString());
		tr.addView(cell);
		t.addView(tr);
	}

}
