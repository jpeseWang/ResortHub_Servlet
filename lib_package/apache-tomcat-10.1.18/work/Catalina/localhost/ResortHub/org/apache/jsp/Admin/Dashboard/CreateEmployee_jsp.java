/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.18
 * Generated at: 2024-01-21 14:19:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Admin.Dashboard;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import Domain.DTOs.EmployeeDto.CreateEmployeeDto;

public final class CreateEmployee_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/Admin/Dashboard/../AdminNav.jsp", Long.valueOf(1705844799499L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("Domain.DTOs.EmployeeDto.CreateEmployeeDto");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write('\n');
      out.write('\n');
      out.write('\n');

    CreateEmployeeDto formData = (CreateEmployeeDto) request.getAttribute("formData");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Create Employee</title>\n");
      out.write("        <script src=\"https://cdn.tailwindcss.com\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"https://cdn.tailwindcss.com\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      \n");
      out.write("        <div class=\" mx-6\">\n");
      out.write("            <div class=\"sm:hidden\">\n");
      out.write("                <label for=\"tabs\" class=\"sr-only\">Select a tab</label>\n");
      out.write("                <!-- Use an \"onChange\" listener to redirect the user to the selected tab URL. -->\n");
      out.write("                <select\n");
      out.write("                    id=\"tabs\"\n");
      out.write("                    name=\"tabs\"\n");
      out.write("                    class=\"block w-full rounded-md border-gray-300 focus:border-indigo-500 focus:ring-indigo-500\"\n");
      out.write("                    >\n");
      out.write("                    <option>My Account</option>\n");
      out.write("                    <option>Company</option>\n");
      out.write("                    <option selected>Team Members</option>\n");
      out.write("                    <option>Billing</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"hidden sm:block\">\n");
      out.write("                <div class=\"border-b border-gray-200\">\n");
      out.write("                    <nav class=\"-mb-px flex space-x-8\" aria-label=\"Tabs\">\n");
      out.write("                     \n");
      out.write("                        <a\n");
      out.write("                            href=\"/ResortHub/ListEmployee\"\n");
      out.write("                            class=\"border-transparent text-gray-500 hover:border-gray-300 hover:text-gray-700 group inline-flex items-center border-b-2 py-4 px-1 text-sm font-medium\"\n");
      out.write("                            >\n");
      out.write("                            <svg\n");
      out.write("                                class=\"text-gray-400 group-hover:text-gray-500 -ml-0.5 mr-2 h-5 w-5\"\n");
      out.write("                                viewBox=\"0 0 20 20\"\n");
      out.write("                                fill=\"currentColor\"\n");
      out.write("                                aria-hidden=\"true\"\n");
      out.write("                                >\n");
      out.write("                            <path\n");
      out.write("                                fill-rule=\"evenodd\"\n");
      out.write("                                d=\"M4 16.5v-13h-.25a.75.75 0 010-1.5h12.5a.75.75 0 010 1.5H16v13h.25a.75.75 0 010 1.5h-3.5a.75.75 0 01-.75-.75v-2.5a.75.75 0 00-.75-.75h-2.5a.75.75 0 00-.75.75v2.5a.75.75 0 01-.75.75h-3.5a.75.75 0 010-1.5H4zm3-11a.5.5 0 01.5-.5h1a.5.5 0 01.5.5v1a.5.5 0 01-.5.5h-1a.5.5 0 01-.5-.5v-1zM7.5 9a.5.5 0 00-.5.5v1a.5.5 0 00.5.5h1a.5.5 0 00.5-.5v-1a.5.5 0 00-.5-.5h-1zM11 5.5a.5.5 0 01.5-.5h1a.5.5 0 01.5.5v1a.5.5 0 01-.5.5h-1a.5.5 0 01-.5-.5v-1zm.5 3.5a.5.5 0 00-.5.5v1a.5.5 0 00.5.5h1a.5.5 0 00.5-.5v-1a.5.5 0 00-.5-.5h-1z\"\n");
      out.write("                                clip-rule=\"evenodd\"\n");
      out.write("                                />\n");
      out.write("                            </svg>\n");
      out.write("                            <span>\n");
      out.write("\n");
      out.write("                                Employee List\n");
      out.write("\n");
      out.write("                            </span>\n");
      out.write("                        </a>\n");
      out.write("                        <a\n");
      out.write("                            href=\"/ResortHub/Admin/Dashboard/CreateEmployee.jsp\"\n");
      out.write("                            class=\"border-transparent text-gray-500 hover:border-gray-300 hover:text-gray-700 group inline-flex items-center border-b-2 py-4 px-1 text-sm font-medium\"\n");
      out.write("                            >\n");
      out.write("                            <!-- Current: \"text-indigo-500\", Default: \"text-gray-400 group-hover:text-gray-500\" -->\n");
      out.write("                            <svg\n");
      out.write("                                class=\"text-gray-400 group-hover:text-gray-500 -ml-0.5 mr-2 h-5 w-5\"\n");
      out.write("                                viewBox=\"0 0 20 20\"\n");
      out.write("                                fill=\"currentColor\"\n");
      out.write("                                aria-hidden=\"true\"\n");
      out.write("                                >\n");
      out.write("                            <path\n");
      out.write("                                d=\"M10 8a3 3 0 100-6 3 3 0 000 6zM3.465 14.493a1.23 1.23 0 00.41 1.412A9.957 9.957 0 0010 18c2.31 0 4.438-.784 6.131-2.1.43-.333.604-.903.408-1.41a7.002 7.002 0 00-13.074.003z\"\n");
      out.write("                                />\n");
      out.write("                            </svg>\n");
      out.write("                            <span>Create Employee</span>\n");
      out.write("                        </a>\n");
      out.write("\n");
      out.write("                      \n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"space-y-10 divide-y divide-gray-900/10 mx-6 mt-12\">\n");
      out.write("            <div class=\"grid grid-cols-1 gap-x-8 gap-y-8 md:grid-cols-3\">\n");
      out.write("                <div class=\"px-4 sm:px-0\">\n");
      out.write("                    <h2 class=\"text-base font-semibold leading-7 text-gray-900\">Create new Employee</h2>\n");
      out.write("                    <p class=\"mt-1 text-sm leading-6 text-gray-600\">This information will be displayed publicly so be careful what you share.</p>\n");
      out.write("                    ");
 String error = (String) request.getAttribute("error");
      out.write("\n");
      out.write("                    <span class=\"text-red-400 font-medium text-lg\">");
      out.print( error != null ? error : "");
      out.write("</span>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <form class=\"bg-white shadow-sm ring-1 ring-gray-900/5 sm:rounded-xl md:col-span-2\"\n");
      out.write("                      name=\"CreateEmployee\"\n");
      out.write("                      method=\"POST\"\n");
      out.write("                      action=\"../../EmployeeController?action=create\">\n");
      out.write("                    <div class=\"px-4 py-6 sm:p-8\">\n");
      out.write("                        <div class=\"grid max-w-2xl grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6\">\n");
      out.write("\n");
      out.write("                            <div class=\"sm:col-span-4\">\n");
      out.write("                                <label for=\"website\" class=\"block text-sm font-medium leading-6 text-gray-900\">Employee ID</label>\n");
      out.write("                                <div class=\"mt-2\">\n");
      out.write("                                    <div class=\"flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md\">\n");
      out.write("                                        <input ");
 if (formData != null) {
      out.write("value=\"");
      out.print( formData.getId());
      out.write('"');
 } 
      out.write(" type=\"text\" name=\"Id\" placeholder=\"Ex: NV-0000\" id=\"website\" class=\"block flex-1 border-0 bg-transparent py-1.5 px-1.5 pl-1 text-gray-900 placeholder:text-gray-400 focus:ring-0 sm:text-sm sm:leading-6\" >\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"sm:col-span-4\">\n");
      out.write("                                <label for=\"website\" class=\"block text-sm font-medium leading-6 text-gray-900\">Full name</label>\n");
      out.write("                                <div class=\"mt-2\">\n");
      out.write("                                    <div class=\"flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md\">\n");
      out.write("                                        <input  ");
 if (formData != null) {
      out.write("value=\"");
      out.print( formData.getFullName());
      out.write('"');
 } 
      out.write(" type=\"text\" name=\"FullName\" placeholder=\"Ex: Tran Quang Huy\" id=\"website\" class=\"block flex-1 border-0 bg-transparent py-1.5 px-1.5 pl-1 text-gray-900 placeholder:text-gray-400 focus:ring-0 sm:text-sm sm:leading-6\" >\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"sm:col-span-4\">\n");
      out.write("                                <label for=\"website\" class=\"block text-sm font-medium leading-6 text-gray-900\">Birthday</label>\n");
      out.write("                                <div class=\"mt-2\">\n");
      out.write("                                    <div class=\"flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md\">\n");
      out.write("                                        <input type=\"date\" name=\"BirthDate\" id=\"website\" class=\"block flex-1 border-0 bg-transparent py-1.5 px-1.5 pl-1 text-gray-900 placeholder:text-gray-400 focus:ring-0 sm:text-sm sm:leading-6\" >\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"sm:col-span-4\">\n");
      out.write("                                <label for=\"country\" class=\"block text-sm font-medium leading-6 text-gray-900\">Gender</label>\n");
      out.write("                                <div class=\"mt-2\">\n");
      out.write("                                    <select ");
 if (formData != null) {
      out.write("value=\"");
      out.print( formData.getGender());
      out.write('"');
 } 
      out.write(" id=\"country\" name=\"Gender\" autocomplete=\"country-name\" class=\"block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:max-w-xs sm:text-sm sm:leading-6\">\n");
      out.write("                                        <option>Male</option>\n");
      out.write("                                        <option>Female</option>                          \n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"sm:col-span-3\">\n");
      out.write("                                <label for=\"first-name\" class=\"block text-sm font-medium leading-6 text-gray-900\">Identification Number</label>\n");
      out.write("                                <div class=\"mt-2\">\n");
      out.write("                                    <input ");
 if (formData != null) {
      out.write("value=\"");
      out.print( formData.getIdNumber());
      out.write('"');
 } 
      out.write(" type=\"text\" name=\"IdNumber\" placeholder=\"It should have 9 or 12 digits\" id=\"first-name\" class=\"block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"sm:col-span-3\">\n");
      out.write("                                <label for=\"last-name\" class=\"block text-sm font-medium leading-6 text-gray-900\">Phone Number</label>\n");
      out.write("                                <div class=\"mt-2\">\n");
      out.write("                                    <input ");
 if (formData != null) {
      out.write("value=\"");
      out.print( formData.getPhoneNumber());
      out.write('"');
 } 
      out.write(" type=\"text\" name=\"PhoneNumber\" placeholder=\"It should start with 0 and have 10 digits\" id=\"last-name\" class=\"block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"sm:col-span-4\">\n");
      out.write("                                <label for=\"website\" class=\"block text-sm font-medium leading-6 text-gray-900\">Email</label>\n");
      out.write("                                <div class=\"mt-2\">\n");
      out.write("                                    <div class=\"flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md\">\n");
      out.write("                                        <input ");
 if (formData != null) {
      out.write("value=\"");
      out.print( formData.getEmail());
      out.write('"');
 } 
      out.write(" type=\"text\" name=\"Email\" placeholder=\"Ex: employe0@gmail.com\" id=\"website\" class=\"block flex-1 border-0 bg-transparent py-1.5 px-1.5 pl-1 text-gray-900 placeholder:text-gray-400 focus:ring-0 sm:text-sm sm:leading-6\" >\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"sm:col-span-2 sm:col-start-1\">\n");
      out.write("                                <label for=\"city\" class=\"block text-sm font-medium leading-6 text-gray-900\">Qualification</label>\n");
      out.write("                                <div class=\"mt-2\">           \n");
      out.write("                                    <select ");
 if (formData != null) {
      out.write("value=\"");
      out.print( formData.getQualification());
      out.write('"');
 } 
      out.write(" id=\"country\" name=\"Qualification\" autocomplete=\"country-name\" class=\"block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:max-w-xs sm:text-sm sm:leading-6\">\n");
      out.write("                                        <option value=1>Intermediate</option>  \n");
      out.write("                                        <option value=\"2\">College</option> \n");
      out.write("                                        <option value=\"3\">University</option> \n");
      out.write("                                        <option value=\"4\">PostGraduate</option> \n");
      out.write("                                    </select> \n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"sm:col-span-2\">\n");
      out.write("                                <label for=\"region\" class=\"block text-sm font-medium leading-6 text-gray-900\">Position</label>\n");
      out.write("                                <div class=\"mt-2\">\n");
      out.write("                                    <select ");
 if (formData != null) {
      out.write("value=\"");
      out.print( formData.getPosition());
      out.write('"');
 }
      out.write(" id=\"country\" name=\"Position\" autocomplete=\"country-name\" class=\"block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:max-w-xs sm:text-sm sm:leading-6\">\n");
      out.write("                                        <option value=\"1\">Receptionist</option>  \n");
      out.write("                                        <option value=\"2\">Server</option> \n");
      out.write("                                        <option value=\"3\">Specialist</option> \n");
      out.write("                                        <option value=\"4\">Supervisor</option> \n");
      out.write("                                        <option value=\"5\">Manager</option> \n");
      out.write("                                        <option value=\"6\">Director</option>  \n");
      out.write("                                    </select>                                    \n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"sm:col-span-2\">\n");
      out.write("                                <label for=\"postal-code\" class=\"block text-sm font-medium leading-6 text-gray-900\">Salary</label>\n");
      out.write("                                <div class=\"mt-2\">\n");
      out.write("                                    <input  type=\"text\" name=\"Salary\" placeholder=\"Ex: 50,000,000\" id=\"website\" class=\"block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:max-w-xs sm:text-sm sm:leading-6\" >\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"flex items-center justify-end gap-x-6 border-t border-gray-900/10 px-4 py-4 sm:px-8\">\n");
      out.write("                        <button type=\"button\" class=\"text-sm font-semibold leading-6 text-gray-900\">Cancel</button>\n");
      out.write("                        <button type=\"submit\" value=\"Submit\" class=\"rounded-md bg-indigo-600 px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600\">Save</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
