package com.api.rest.vo;

import javax.ws.rs.core.Response;

public interface NotesHandler {
  public Response doDeleteNote(Integer id);

  public Response doGetNote(Integer id);

  public Response doPostNote(String text);

  public Response doPutNote(Integer id, String text);
}
