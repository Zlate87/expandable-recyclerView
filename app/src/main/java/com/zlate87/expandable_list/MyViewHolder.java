package com.zlate87.expandable_list;

import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

  private int closedHeight;
  private int expandedHeight;

  private boolean isViewExpanded = false;

  private View view;
  private TextView titleTextView;

  public MyViewHolder(View view, int closedHeight, int expandedHeight) {
    super(view);
    titleTextView = (TextView) view.findViewById(R.id.textView);
    view.setOnClickListener(this);
    this.view = view;
    this.closedHeight = closedHeight;
    this.expandedHeight = expandedHeight;
  }

  public void reUseView(String title) {
    isViewExpanded = false;
    view.getLayoutParams().height = closedHeight;
    titleTextView.setText(title);
  }

  @Override
  public void onClick(final View view) {
    ValueAnimator valueAnimator;
    if (!isViewExpanded) {
      isViewExpanded = true;
      valueAnimator = ValueAnimator.ofInt(closedHeight, expandedHeight);
    } else {
      isViewExpanded = false;
      valueAnimator = ValueAnimator.ofInt(expandedHeight, closedHeight);
    }

    valueAnimator.setDuration(100);
    valueAnimator.setInterpolator(new LinearInterpolator());
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      public void onAnimationUpdate(ValueAnimator animation) {
        Integer value = (Integer) animation.getAnimatedValue();
        view.getLayoutParams().height = value.intValue();
        view.requestLayout();
      }
    });
    valueAnimator.start();
  }
}
