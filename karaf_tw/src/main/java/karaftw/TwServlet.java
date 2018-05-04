package karaftw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
* model the TwServlet to get twitter api call from TwController class and connect it with the jsp file
* @author Samnang Sok, Matthew Morin, Payam Khosravi
*/
public class TwServlet extends HttpServlet {

    TwController tc = new TwController();

    //do get resquest and response from TwCalls.jsp files
    protected void doGet(HttpServletRequest requests, HttpServletResponse responses) throws ServletException, IOException {
        requests.getRequestDispatcher("/WEB-INF/TwCalls.jsp").forward(requests, responses);  
    }
    
    //do post restquests and response from the TwResponse.jsp files which receive the call from TwController
    protected void doPost(HttpServletRequest requests, HttpServletResponse responses) throws ServletException, IOException {
        String proc = requests.getParameter("process");

        //TwCall class call for followers and it return the response from follower list from TwController to TwResponse class
        if(proc.equals("followers")){
            requests.setAttribute("res", tc.followersList());
        } else if (proc.equals("block")){
            //return blocklist method call from TwController when the TwCall class call for block to TwResponse class
            requests.setAttribute("res", tc.blockList());
        }else if (proc.equals("suggest")){
            //return the suggestion method call from TwController when the Tw class call for suggest to TwResponse class
            requests.setAttribute("res", tc.suggestions());
        } else if(proc.equals("settin")) {
            //return settings method call from TwController when the TwCall class call for settings to TwResponse class
            requests.setAttribute("res", tc.settings());
        } else if(proc.equals("language")){
            //return helpLanguage method call from TwController when the TwCall class call for languageHelp to TwResponse class
            requests.setAttribute("res", tc.helpLanguage());
        } else if(proc.equals("mute")){
            //return muteUsers method call from TwController when the TwCall class call for mute to TwResponse class
            requests.setAttribute("res", tc.muteUsers());
        } else if(proc.equals("privacy")){
            //return helpPrivacy method call from TwController when the TwCall class call for privcay to TwResponse class
            requests.setAttribute("res", tc.helpPrivacy());
        } else if(proc.equals("timeline")){
            //return timelineMention method call from TwController when the TwCall class call for timeline to TwResponse class
            requests.setAttribute("res", tc.timelineMention());
        }else{
            //return error if none of those are not match
            requests.setAttribute("res", "error!");
        }

        requests.getRequestDispatcher("/WEB-INF/TwResponse.jsp").forward(requests, responses);           
    }
}
