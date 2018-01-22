package brandjunhoe89.recycleriewlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by jh on 2018-01-22.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Item> itemArrayList;
    private int itemLayout;
    private Context context;

    public RecyclerAdapter(ArrayList<Item> itemArrayList, int itemLayout, Context context) {
        this.itemArrayList = itemArrayList;
        this.itemLayout = itemLayout;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Item item = itemArrayList.get(position);

        Glide.with(context)
                .load(item.getImage())
                .into(holder.image);

        holder.name.setText(item.getName());


    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView name;

    ViewHolder(View v){
        super(v);

        image = (ImageView)v.findViewById(R.id.imageView);
        name = (TextView)v.findViewById(R.id.imageName);
    }
    }
}
