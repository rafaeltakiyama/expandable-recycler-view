package com.thoughtbot.expandablerecyclerview.sample.multitypeandcheck;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.thoughtbot.expandablerecyclerview.sample.R;

import static com.thoughtbot.expandablerecyclerview.sample.GenreDataFactory.makeSingleCheckGenres;

public class MultiTypeCheckGenreActivity extends AppCompatActivity {

  private MultiTypeCheckGenreAdapter adapter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_multi_type_and_check);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setTitle(getClass().getSimpleName());

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);

    adapter = new MultiTypeCheckGenreAdapter(makeSingleCheckGenres());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);

    Button clear = (Button) findViewById(R.id.clear_button);
    clear.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        adapter.clearChoices();
      }
    });
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    adapter.onSaveInstanceState(outState);
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    adapter.onRestoreInstanceState(savedInstanceState);
  }
}

