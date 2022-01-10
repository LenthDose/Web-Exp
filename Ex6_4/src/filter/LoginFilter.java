package filter;
import java.io.IOException;
import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;
@WebFilter(
        urlPatterns = { "/bookAdd.html" },
        initParams = {
                @WebInitParam(name = "backurl", value = "login.jsp")
})
public class LoginFilter implements Filter { String backUrl;
    public void destroy() { }
    public void init(FilterConfig fConfig) throws ServletException {
        //从过滤器的配置中获得初始化参数，如果没有就使用默认值 inde.jsp
         if(fConfig.getInitParameter("backurl")!=null) {
             backUrl = fConfig.getInitParameter("backurl");
        }
        else {
            backUrl = "index.jsp";
         }
    }
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        //doFilter()方法的参数并不是HTTP对象，如果必要，需要将 ServletResponse
        //如果没有登录，就返回到指定页面
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpServletResponse httpResponse=(HttpServletResponse)response;
        HttpSession session = httpRequest.getSession();
        String flag = (String)session.getAttribute("isLogin");
        if(flag == null || !flag.equals("true")) {
            httpResponse.sendRedirect(backUrl);
        }
        else
        {
            chain.doFilter(request, response);
        }
    }
}

