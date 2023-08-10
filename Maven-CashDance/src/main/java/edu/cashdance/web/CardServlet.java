package edu.cashdance.web;

import edu.cashdance.SQL.PoolConnectionBuilder;
import edu.cashdance.SQL.SqlDataGetter;
import edu.cashdance.domain.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CardServlet", urlPatterns = {"/AddNewCard","/cards/AddNewCard"} ) // WebServlet (name) is called by (urlPatterns)
public class CardServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger("StatusLogger");
    private SqlDataGetter sqlDataGetter;

    public void init(){
        logger.info("Servlet created");
        sqlDataGetter = new SqlDataGetter();
        sqlDataGetter.setConnectionBuilder(new PoolConnectionBuilder()); // makes connection
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String cardName = req.getParameter("cardName");
        String bankName = req.getParameter("bankName");
        Card card = new Card(cardName, bankName);
        boolean success = sqlDataGetter.addNewCard(card);

        if (success){
            resp.getWriter().write("Card added: " + card.getName() + " - " + card.getBankName());

        }else {
            resp.getWriter().write("Card was not added");
        }

    }
}

