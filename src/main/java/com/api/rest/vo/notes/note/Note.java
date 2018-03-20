package com.api.rest.vo.notes.note;

import java.io.Serializable;

public class Note implements Serializable, Comparable<Note> {
  private static final long serialVersionUID = 1L;

  private int id;
  private String text;

  public Note() {

  }

  public int compareTo(Note note) {
    return this.id - note.id;
  }

  public int getId() {
    return this.id;
  }

  public String getText() {
    return text;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setText(String text) {
    this.text = text;
  }
}
