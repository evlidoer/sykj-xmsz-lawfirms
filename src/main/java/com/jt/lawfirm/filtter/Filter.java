package com.jt.lawfirm.filtter;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import sun.nio.cs.ext.MacTurkish;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Filter extends HttpServlet implements javax.servlet.Filter {

    /**
     * Called by the web container to indicate to a filter that it is
     * being placed into service.
     *
     * <p>The servlet container calls the init
     * method exactly once after instantiating the filter. The init
     * method must complete successfully before the filter is asked to do any
     * filtering work.
     *
     * <p>The web container cannot place the filter into service if the init
     * method either
     * <ol>
     * <li>Throws a ServletException
     * <li>Does not return within a time period defined by the web container
     * </ol>
     *
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * The <code>doFilter</code> method of the Filter is called by the
     * container each time a request/response pair is passed through the
     * chain due to a client request for a resource at the end of the chain.
     * The FilterChain passed in to this method allows the Filter to pass
     * on the request and response to the next entity in the chain.
     *
     * <p>A typical implementation of this method would follow the following
     * pattern:
     * <ol>
     * <li>Examine the request
     * <li>Optionally wrap the request object with a custom implementation to
     * filter content or headers for input filtering
     * <li>Optionally wrap the response object with a custom implementation to
     * filter content or headers for output filtering
     * <li>
     * <ul>
     * <li><strong>Either</strong> invoke the next entity in the chain
     * using the FilterChain object
     * (<code>chain.doFilter()</code>),
     * <li><strong>or</strong> not pass on the request/response pair to
     * the next entity in the filter chain to
     * block the request processing
     * </ul>
     * <li>Directly set headers on the response after invocation of the
     * next entity in the filter chain.
     * </ol>
     *
     * @param "request"
     * @param "response"
     * @param chain
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(true);
        String url = request.getRequestURI();//获取地址栏的url
        String uname = (String) session.getAttribute("userName");//获取登录时存放的session
        System.out.println("url = " + url);
        if (url.indexOf("/static/") != -1) {
            System.out.println("static       本次放行的url为 : " + url);
            chain.doFilter(request, response);
        }
        if (url.indexOf("login.html") != -1) {
            System.out.println("本次放行的url为 : " + url);
            chain.doFilter(request, response);
        }
        if (url.equals("/lawfirms/")) {
            System.out.println("本次放行的url为 : " + url);
            chain.doFilter(request, response);
        }
        if (uname.equals("admin")) {
            System.out.println("本次放行的url为 : " + url);
            chain.doFilter(request, response);
        }
        System.out.println(uname);
        if (uname == null || uname.equals("")) {
            request.getRequestDispatcher("login.html").forward(request, response);
        } else if (!url.equals("http://localhost:8888/lawfirms/")) {
            request.getRequestDispatcher("unauthorizedPermissionEmpty.html").forward(request, response);
        }
        chain.doFilter(request, response);
    }
}
