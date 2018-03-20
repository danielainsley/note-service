package com.api.rest.vo.notes;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.api.rest.vo.notes.note.Note;

public class Notes {
  private AtomicInteger key;
  private ConcurrentMap<Integer, Note> map;

  public Notes() {
    key = new AtomicInteger();
    map = new ConcurrentHashMap<Integer, Note>();
  }

  public AtomicInteger getKey() {
    return key;
  }

  public ConcurrentMap<Integer, Note> getMap() {
    return map;
  }

  public void setKey(AtomicInteger key) {
    this.key = key;
  }

  public void setMap(ConcurrentMap<Integer, Note> map) {
    this.map = map;
  }
}


