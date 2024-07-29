package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException;
}
