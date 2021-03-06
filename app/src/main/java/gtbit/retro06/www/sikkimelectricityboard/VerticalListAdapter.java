package gtbit.retro06.www.sikkimelectricityboard;

/**
 * Created by HPG6 on 30-03-18.
 */

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class VerticalListAdapter extends RecyclerView.Adapter<VerticalListAdapter.ViewHolder> {

    private Activity activity;

    public VerticalListAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_vertical_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Position clicked: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    /**
     * View holder to display each RecylerView item
     */
    protected class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;

        public ViewHolder(View view) {
            super(view);
            linearLayout = view.findViewById(R.id.layout2);
        }

    }
}