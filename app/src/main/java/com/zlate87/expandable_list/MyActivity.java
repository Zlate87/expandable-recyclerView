package com.zlate87.expandable_list;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MyActivity extends ActionBarActivity {

  public static final int ELEMENTS_NUMBER = 50;

  private RecyclerView recyclerView;
  private RecyclerView.Adapter adapter;
  private RecyclerView.LayoutManager layoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.my_activity);

    recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);

    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    String[] items = prepareElements();
    adapter = new MyAdapter(items, this);
    recyclerView.setAdapter(adapter);
  }

  private String[] prepareElements() {
    String[] items = new String [ELEMENTS_NUMBER];
    for (int i = 0; i < ELEMENTS_NUMBER; i++) {
      items[i] = String.format("Element %s", i);
    }
    return items;
  }

}
