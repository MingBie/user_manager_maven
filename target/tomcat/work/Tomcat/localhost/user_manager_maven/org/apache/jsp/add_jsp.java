/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-09-05 02:00:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- HTML5文档-->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!-- 网页使用的语言 -->\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("    <!-- 指定字符集 -->\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <!-- 使用Edge最新的浏览器的渲染方式 -->\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。\r\n");
      out.write("    width: 默认宽度与设备的宽度相同\r\n");
      out.write("    initial-scale: 初始的缩放比，为1:1 -->\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->\r\n");
      out.write("    <title>添加用户</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- 1. 导入CSS的全局样式 -->\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-2.1.0.min.js\"></script>\r\n");
      out.write("    <!-- 3. 导入bootstrap的js文件 -->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        $(function() {\r\n");
      out.write("            // 返回按钮 显示所有用户信息list页面\r\n");
      out.write("            $(\"#return\").click(function() {\r\n");
      out.write("                // 改变当前地址\r\n");
      out.write("                // 跳转 查询所有用户信息Servlet\r\n");
      out.write("                location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/FindByPageServlet\";\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <center><h3>添加联系人页面</h3></center>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/InsertUserServlet\" method=\"post\">\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"name\">姓名：</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" placeholder=\"请输入姓名\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label>性别：</label>\r\n");
      out.write("            <input type=\"radio\" name=\"gender\" value=\"男\" checked=\"checked\"/>男\r\n");
      out.write("            <input type=\"radio\" name=\"gender\" value=\"女\"/>女\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"age\">年龄：</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"age\" name=\"age\" placeholder=\"请输入年龄\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"address\">籍贯：</label>\r\n");
      out.write("            <select name=\"address\" id=\"address\" class=\"form-control\" id=\"jiguan\">\r\n");
      out.write("                <option value=\"广东\">广东</option>\r\n");
      out.write("                <option value=\"广西\">广西</option>\r\n");
      out.write("                <option value=\"湖南\">湖南</option>\r\n");
      out.write("            </select>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"qq\">QQ：</label>\r\n");
      out.write("            <input type=\"text\" id=\"qq\" class=\"form-control\" name=\"qq\" placeholder=\"请输入QQ号码\"/>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"email\">Email：</label>\r\n");
      out.write("            <input type=\"text\" id=\"email\" class=\"form-control\" name=\"email\" placeholder=\"请输入邮箱地址\"/>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\" style=\"text-align: center\">\r\n");
      out.write("            <input class=\"btn btn-primary\" type=\"submit\" value=\"提交\" />\r\n");
      out.write("            <input class=\"btn btn-default\" type=\"reset\" value=\"重置\" />\r\n");
      out.write("            <input class=\"btn btn-default\" type=\"button\" id=\"return\" value=\"返回\" />\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
