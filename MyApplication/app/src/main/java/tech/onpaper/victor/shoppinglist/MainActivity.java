package tech.onpaper.victor.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

  private RecyclerView shoppingItems;

  private Realm realm ;



  private RecyclerView.Adapter shoppingItemsAdapter = new RecyclerView.Adapter() {

    public static final int ACTIVE_VIEW = 1;
    public static final int INACTIVE_VIEW = 2;
    public static final int SUBHEADER_VIEW = 3;

    //View Holder mean Contain the Views
    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      if (viewType == ACTIVE_VIEW) {

        View v = getLayoutInflater().inflate(R.layout.active_item, parent, false);
        return new ActiveItemViewHolder(v,
            (CheckBox) v.findViewById(R.id.item_status),
            (TextView) v.findViewById(R.id.item_name),
            (TextView) v.findViewById(R.id.item_qty),
            (ImageView) v.findViewById(R.id.item_action));
      } else if (viewType == INACTIVE_VIEW) {
        View v = getLayoutInflater().inflate(R.layout.inactive_item, parent, false);
        return new InActiveItemViewHolder(v,
            (CheckBox) v.findViewById(R.id.item_status),
            (TextView) v.findViewById(R.id.item_name),
            (ImageView) v.findViewById(R.id.item_action));
      } else {
        View v = getLayoutInflater().inflate(R.layout.subheader, parent, false);
        return  new SubheadViewHolder(v);
      }
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override public int getItemCount() {
      return 0;
    }
  };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    RealmConfiguration configuration = new RealmConfiguration.Builder(this).build();

    //FAB
    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Intent i = new Intent(MainActivity.this, itemActivity.class);
        i.putExtra("Title", "Add item");
        startActivity(i);
      }
    });

    shoppingItems = (RecyclerView) findViewById(R.id.shopping_items);
    shoppingItems.setLayoutManager(new LinearLayoutManager(this));
  }
}
