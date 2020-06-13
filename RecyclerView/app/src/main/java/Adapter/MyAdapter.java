package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import Model.ListItem;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<ListItem> listItems;


    public MyAdapter(Context context, List listitem) {
        this.context = context;
        this.listItems = listitem;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
