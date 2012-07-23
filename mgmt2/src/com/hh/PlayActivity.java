package com.hh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;

public class PlayActivity extends Activity {
	static final String MGMT = "mgmt";

	public static final String COUNT_PLAYERS = "countPlayers";

	private int playersCount;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play);
		playersCount = getIntent().getExtras().getInt(COUNT_PLAYERS);
		Log.e(MGMT, "count that was entered:" + playersCount);
		
		addPlayers();
	}

	private List<Integer> score(View view) {
		TableLayout t = (TableLayout) findViewById(R.id.mainTable);
		Integer[] scores = new Integer[playersCount];
		for (int i = 0; i < playersCount; i++) {
			scores[i] = 0;
		}

		int noOfGames = t.getChildCount();
		for (int i = 0; i < noOfGames; i++) {
			TableRow game = (TableRow) t.getChildAt(i);
			int count = game.getChildCount();
			for (int j = 0; j < count; j++) {
				EditText cell = (EditText) game.getChildAt(j);
				int score = 0;
				try {
					score = Integer.valueOf(cell.getText().toString());
					scores[j] = scores[j] + score;
				} catch (Exception e) {
					// Do nothing, may be a parse error
				}

			}
		}

		List<Integer> res = new ArrayList<Integer>();
		Collections.addAll(res, scores);
		return res;
	}

	public void nextGame(View view) {
		TableLayout t = (TableLayout) findViewById(R.id.mainTable);
		
		for (int i = 0; i < playersCount; i++) {
			TableRow tr = (TableRow) t.getChildAt(i);
			EditText totCell = (EditText) tr.getChildAt(1);
			Integer aggScore=0, currScore=0;
			try {
				aggScore = Integer.valueOf(totCell.getText().toString());
			} catch (Exception e) {
			}
			EditText currCell = (EditText) tr.getChildAt(2);
			try {
				currScore = Integer.valueOf(currCell.getText().toString());
			} catch (Exception e) {
			}
			
			totCell.setText(String.valueOf(aggScore+currScore));
			
			currCell.setText("0");
		}
	}

//	private TableRow playerNames() {
//		Log.e(MGMT, "adding new row for player names");
//		TableLayout t = (TableLayout) findViewById(R.id.mainTable);
//		TableRow tr = new TableRow(this);
//		tr.setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT,
//				LayoutParams.WRAP_CONTENT));
//		for (int i = 0; i < playersCount; i++) {
//			addCell(tr, null);
//		}
//		t.addView(tr, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT,
//				LayoutParams.WRAP_CONTENT));
//		return tr;
//	}

	private void addPlayers() {
		Log.e(MGMT, "adding new row");
		for (int i = 0; i < playersCount; i++) {
			TableLayout t = (TableLayout) findViewById(R.id.mainTable);
			TableRow tr = new TableRow(this);
			tr.setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT));
			addCells(tr);
			t.addView(tr, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT));
		}
		
	}
	
//	private TableRow addGame() {
//		Log.e(MGMT, "adding new row");
//		TableLayout t = (TableLayout) findViewById(R.id.mainTable);
//		TableRow tr = new TableRow(this);
//		tr.setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT,
//				LayoutParams.WRAP_CONTENT));
//		for (int i = 0; i < playersCount; i++) {
//			addCell(tr, InputType.TYPE_CLASS_NUMBER);
//		}
//		t.addView(tr, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT,
//				LayoutParams.WRAP_CONTENT));
//		return tr;
//	}

	private void addCells(TableRow tr) {

		EditText name = new EditText(this);
		name.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		name.setText("");
		tr.addView(name);
		
		EditText sumScore = new EditText(this);
		sumScore.setInputType(InputType.TYPE_CLASS_NUMBER);
		sumScore.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		sumScore.setText("0");
		sumScore.setEms(3);
		sumScore.setEnabled(false);
		tr.addView(sumScore);
		
		
		EditText score = new EditText(this);
		score.setInputType(InputType.TYPE_CLASS_NUMBER);
		score.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
//		sumScore.setEms(5);
		score.setText("00");
		tr.addView(score);
	}
}