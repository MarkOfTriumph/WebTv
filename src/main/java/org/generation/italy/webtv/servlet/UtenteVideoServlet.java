package org.generation.italy.webtv.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.generation.italy.webtv.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebServlet(urlPatterns = {"/utenteVideo", "/utenteVideo/searchVideo"})
public class UtenteVideoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private UtenteVideoDAO utenteVideoDAO;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch(action) {
            case "/utenteVideo":
                if (request.getParameter("keyword") != null && !request.getParameter("keyword").isEmpty()) {
                    searchVideos(request, response);
                } else {
                    showAllVideos(request, response);
                }
                break;
            default:
                showAllVideos(request, response);
        }
    }

    private void searchVideos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Video> videos = utenteVideoDAO.getVideosByKeyword(keyword);
        request.setAttribute("videos", videos);
        request.setAttribute("keyword", keyword); // Set the keyword attribute for display in JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/utenteVideo.jsp");
        dispatcher.forward(request, response);
    }

    private void showAllVideos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Video> videos = utenteVideoDAO.getAllVideos();
        request.setAttribute("videos", videos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/utenteVideo.jsp");
        dispatcher.forward(request, response);
    }
}

