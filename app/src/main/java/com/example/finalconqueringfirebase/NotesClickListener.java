package com.example.finalconqueringfirebase;

import androidx.cardview.widget.CardView;

public interface NotesClickListener
{
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}