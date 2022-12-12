package com.example.finalconqueringfirebase.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalconqueringfirebase.R;

import java.util.ArrayList;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder>
{
    Context context;
    List<Notes> list;
    NotesClickListener Listener;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener)
    {
        this.context = context;
        this.list = list;
        Listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position)
    {
        holder.textView_title.setText(list.get(position).getTitle());
        holder.textView_title.setSelected(true);

        holder.textView_notes.setText(list.get(position).getNotes());

        holder.textView_date.setText(list.get(position).getDate());
        holder.textView_date.setSelected(true);

        if (list.get(position).isPinned())
        {
            holder.imageView_pin.setImageResource(R.drawable.ic_baseline_push_pin_24);
        } else {
            holder.imageView_pin.setImageResource(0); //in the case that the item isn't pinned then the returned value would be zero otherwise returned true
        }

        int color_code = getRandomColor();
        holder.notes_container.setCardBackgroundColor(holder.itemView.getRecources().getColor(color_code, null));

        holder.notes_container.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });


        holder.notes_container.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view) {
                Listener.onLongClick(list.get(holder.getAdapterPosition()), holder.notes_container);
                return true;
            }
        });

        private int getRandomColor()
        {
            List<Integer> colorCode = new ArrayList<>();

            colorCode.add(R.color.color1);
            colorCode.add(R.color.color2);
            colorCode.add(R.color.color3);
            colorCode.add(R.color.color4);
            colorCode.add(R.color.color5);

            Random random = new Random();
            int random_color = random.nextInt(colorCode.size());
            return random_color; //to make pretty colors randomize mostly greens and blues by preference.
        }

        @Override
        public int getItemCount()
        {
            return list.size();
        }
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {
        CardView notes_container;
        TextView textView_title, textView_notes, textView_date;
        ImageView imageView_pin;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            notes_container = itemView.findViewId(R.id.notes_container);
            textView_title = itemView.findViewId(R.id.textView_title);
            textView_notes = itemView.findViewId(R.id.textView_notes);
            textView_date = itemView.findViewId(R.id.textView_dated);
            imageView_pin = itemView.findViewId(R.id.imageView_pined);
        }

    }
}
