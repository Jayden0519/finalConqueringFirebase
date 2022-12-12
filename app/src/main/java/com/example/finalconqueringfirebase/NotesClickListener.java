package com.example.finalconqueringfirebase;

import androidx.cardview.widget.CardView;

import com.example.finalconqueringfirebase.Models.Notes;

public interface NotesClickListener
{
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
