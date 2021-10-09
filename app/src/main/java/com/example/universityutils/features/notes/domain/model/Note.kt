package com.example.universityutils.features.notes.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "text")
    var text : String,
    @ColumnInfo(name = "time")
    var time : Long){

    override fun toString(): String {
        return "Note(id=$id, title='$title', text='$text', time=$time)"
    }
}