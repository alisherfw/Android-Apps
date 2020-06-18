package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.Details;
import com.example.recyclerview.R;

import org.w3c.dom.Text;

import java.util.List;
import Model.ListItem;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<ListItem> listItems;


    public MyAdapter(Context context, List listitem) {
        this.context = context;
        this.listItems = listitem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        ListItem item = listItems.get(position);


        holder.rating.setText(item.getRating());
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView description;
        public TextView rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            name = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            rating = (TextView) itemView.findViewById(R.id.rating);

        }

        @Override
        public void onClick(View v) {
//            Get postion of the row clicked or tapped.
            int position = getAdapterPosition();

            ListItem item = listItems.get(position);
            Intent intent = new Intent(context, Details.class);
            intent.putExtra("name", item.getName());
            intent.putExtra("description", item.getDescription());
            intent.putExtra("rating", item.getRating());

            context.startActivity(intent);

//            Toast.makeText(context, item.getName(), Toast.LENGTH_LONG).show();
        }
    }
}
