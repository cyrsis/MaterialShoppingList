package tech.onpaper.victor.shoppinglist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cyber on 2017-01-04.
 */

public class InActiveItemViewHolder extends RecyclerView.ViewHolder {

  CheckBox itemStatus;
  TextView itemName;
  ImageView itemAction;

  public InActiveItemViewHolder(View itemView, CheckBox itemStatus, TextView itemName, ImageView itemAction) {
    super(itemView);
    this.itemStatus = itemStatus;
    this.itemName = itemName;
    this.itemAction = itemAction;
  }
}
