package com.api.rest.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.core.Response;

import com.api.rest.vo.notes.Notes;
import com.api.rest.vo.notes.note.Note;

public class NotesHandlerImpl implements NotesHandler {

  Notes notes = new Notes();

  public NotesHandlerImpl() {

  }

  @Override
  public Response doDeleteNote(Integer id) {
    try {
      List<Note> values = handleDelete(id);
      return Response.status(Response.Status.OK).entity(values).build();
    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  @Override
  public Response doGetNote(Integer id) {
    try {
      List<Note> values = handleGet(id);
      return Response.status(Response.Status.OK).entity(values).build();
    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  @Override
  public Response doPostNote(String text) {
    try {
      List<Note> values = handlePost(text);
      return Response.status(Response.Status.OK).entity(values).build();
    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  @Override
  public Response doPutNote(Integer id, String text) {
    try {
      List<Note> values = handlePut(id, text);
      return Response.status(Response.Status.OK).entity(values).build();
    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  private List<Note> handleDelete(Integer id) {
    if (id != null) {
      if (notes.getMap().containsKey(id)) {
        notes.getMap().remove(id);
      }
    }
    return readNotes();
  }

  private List<Note> handleGet(Integer id) {
    List<Note> list = new ArrayList<Note>();
    if (id != null) {
      Note note = notes.getMap().get(id);
      if (note != null) {
        list.add(note);
      }
      return list;
    }
    return readNotes();
  }

  private List<Note> handlePost(String text) {
    if (text != null) {
      Integer id = notes.getKey().incrementAndGet();

      Note note = new Note();
      note.setId(id);
      note.setText(text);

      notes.getMap().put(note.getId(), note);
    }
    return readNotes();
  }

  private List<Note> handlePut(Integer id, String text) {
    if (id != null) {
      if (notes.getMap().containsKey(id)) {
        Note note = notes.getMap().get(id);
        note.setText(text);
        notes.getMap().put(id, note);
      }
    }
    return readNotes();
  }

  private List<Note> readNotes() {
    List<Note> list = new ArrayList<Note>();
    for (Entry<Integer, Note> entry : notes.getMap().entrySet()) {
      Note note = entry.getValue();
      list.add(note);
    }
    return list;
  }
}
