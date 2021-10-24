package com.example.jpa.servlets;
import com.example.jpa.common.Contact;
import com.example.jpa.common.ContactRepositoryImpl;
import java.io.*;
import javax.management.Attribute;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "putContactServlet", value = "/updateanycontactfieldbyid")
public class PutContactServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "To go back, click on the arrow back in the browser";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException  {
        String idParam = (String) request.getAttribute("idAttr");
        String firstNameParam = (String) request.getAttribute("firstNameAttr");
        String lastNameParam = (String) request.getAttribute("lastNameAttr");
        String phoneParam = (String) request.getAttribute("phoneAttr");
        int id = Integer.parseInt(idParam);
        PrintWriter writer = response.getWriter();
        Contact entity = new Contact(id,firstNameParam,lastNameParam,phoneParam);
        writer.println(message);
        writer.println();
        writer.println("You can change any field values in the address bar to make changes, see the list of existing contacts at the link (Get All Contacts)");
        writer.println();
        new ContactRepositoryImpl(entity).update(entity);
        writer.println("Contact id = " + id + " updated");
        writer.flush();
        writer.close();
    }
    public void destroy() {
    }
}
