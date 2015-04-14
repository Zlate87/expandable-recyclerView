package com.zlate87.expandable_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

  private static final int CLOSED_HEIGHT_DP = 20;
  private static final int EXPANDED_HEIGHT_DP = 80;

  private float closedHeight;
  private float expandedHeight;

  private String[] elements;

  public MyAdapter(String[] elements, Context context) {
    this.elements = elements;
    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
    int complexUnitDip = TypedValue.COMPLEX_UNIT_DIP;
    closedHeight = TypedValue.applyDimension(complexUnitDip, CLOSED_HEIGHT_DP, displayMetrics);
    expandedHeight = TypedValue.applyDimension(complexUnitDip, EXPANDED_HEIGHT_DP, displayMetrics);
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View view = layoutInflater.inflate(R.layout.my_element, parent, false);
    view.getLayoutParams().height = (int) closedHeight;
    return new MyViewHolder(view, (int) closedHeight, (int) expandedHeight);
  }

  @Override
  public void onBindViewHolder(MyViewHolder viewHolder, int i) {
    viewHolder.reUseView(elements[i]);
  }

  @Override
  public int getItemCount() {
    return elements.length;
  }
}
