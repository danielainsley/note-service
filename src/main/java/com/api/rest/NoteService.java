package com.api.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.rest.vo.NotesHandler;

@Component
@Path("/notes")
public class NoteService {

  @Autowired
  NotesHandler handler;

  @DELETE
  @Path("/delete")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteNote(@QueryParam("id") Integer id) {
    Response response = handler.doDeleteNote(id);
    return response;
  }

  @GET
  @Path("/get")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getNote(@QueryParam("id") Integer id) {
    Response response = handler.doGetNote(id);
    return response;
  }

  @POST
  @Path("/post")
  @Produces(MediaType.APPLICATION_JSON)
  public Response postNote(@QueryParam("text") String text) {
    Response response = handler.doPostNote(text);
    return response;
  }

  @PUT
  @Path("/put")
  @Produces(MediaType.APPLICATION_JSON)
  public Response putNote(@QueryParam("id") Integer id, @QueryParam("text") String text) {
    Response response = handler.doPutNote(id, text);
    return response;
  }
}
