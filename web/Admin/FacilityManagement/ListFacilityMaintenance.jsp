<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Employee</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>

       
<%@ include file="../AdminNav.jsp" %>
            <a href="/ResortHub/Admin/FacilityManagement/ListFacility.jsp" class="pl-4 py-9 text-sm font-semibold leading-6 hover:text-indigo-500 text-gray-600"><span aria-hidden="true">←</span> Back to Facility main page</a>

        <div class="px-4 sm:px-6 lg:px-8 mt-6">
            <div class="sm:flex sm:items-center">
                <div class="sm:flex-auto">
                    <h1 class="text-base font-semibold leading-6 text-gray-900">Facility Maintenance</h1>
                    <p class="mt-2 text-sm text-gray-700">A list of all the users in your account including their name, title, email and role.</p>
                </div>
             
            </div>

            <div class="px-4 sm:px-6 lg:px-8">

                <div class="mt-8 flow-root">
                    <div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                        <div class="inline-block min-w-full py-2 align-middle sm:px-6 lg:px-8">
                            <table class="min-w-full divide-y divide-gray-300">
                                <thead>
                                    <tr class="divide-x divide-gray-200">
                                        <th scope="col" class="py-3.5 pl-4 pr-4 text-left text-sm font-semibold text-gray-900 sm:pl-0">Facility ID</th>
                                        <th scope="col" class="px-4 py-3.5 text-left text-sm font-semibold text-gray-900">Facility Name</th>
                                        <th scope="col" class="py-3.5 pl-4 pr-4 text-left text-sm font-semibold text-gray-900 sm:pr-0">Usage count</th>
                                        <th
                                        scope="col"
                                        class="py-3.5 pl-4 pr-4 text-left text-sm font-semibold text-gray-900 sm:pr-0"
                                      >
                                       Status
                                      </th>
                                    </tr>
                                </thead>
                                <tbody class="divide-y divide-gray-200 bg-white">
                                    
                                    <c:forEach items="${maintenanceFacility}" var="c">
                                        <tr class="divide-x divide-gray-200">
                                        <td class="whitespace-nowrap py-4 pl-4 pr-4 text-sm font-medium text-gray-900 sm:pl-0">${c.id}</td>
                                        <td class="whitespace-nowrap p-4 text-sm text-gray-500">${c.name}</td>
                                        <td class="whitespace-nowrap py-4 pl-4 pr-4 text-sm text-gray-500 sm:pr-0">${c.usageCount}</td>
                                        <td
                                        class="whitespace-nowrap py-4 pl-4 pr-4 text-sm text-gray-500 sm:pr-0"
                                      >
                    
                                      <c:choose>
                    
                                        <c:when test="${c.usageCount < 4}">
                                            <span class="bg-green-100 text-green-800 text-sm font-medium me-2 px-2.5 py-1 rounded dark:bg-green-900 dark:text-green-300">Normal</span>
                                        </c:when>
                    
                                        <c:when test="${c.usageCount == 4}">
                                            <span class="bg-yellow-100 text-yellow-800 text-sm font-medium me-2 px-2.5 py-1 rounded dark:bg-yellow-900 dark:text-yellow-300">Warning</span>
                                        </c:when>
                    
                                        <c:when test="${c.usageCount >= 5}">
                                            <span class="bg-red-100 text-red-800 text-sm font-medium me-2 px-2.5 py-1 rounded dark:bg-red-900 dark:text-red-300">Need Maintenance</span>
                                        </c:when>
                    
                                      </c:choose>
                    
                                      
                                     
                                      </td>

                                    </tr>
                                    </c:forEach>
                                

                                    <!-- More people... -->
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <%@ include file="/layout/footer.jsp" %>
    </body>
</html>