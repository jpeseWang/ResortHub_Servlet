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
        <br>

        <div class="px-4 sm:px-6 lg:px-8">
            <div class="sm:flex sm:items-center">
                <div class="sm:flex-auto">
                    <h1 class="text-base font-semibold leading-6 text-gray-900">Bookings</h1>
                    <p class="mt-2 text-sm text-gray-700">A list of all the users in your account including their name, title, email and role.</p>
                </div>
                
                <div class="mt-4 sm:ml-16 sm:mt-0 sm:flex gap-x-4">
                    <button type="button" class="text-white bg-gradient-to-r from-purple-500 via-purple-600 to-purple-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-purple-300 dark:focus:ring-purple-800 shadow-lg shadow-purple-500/50 dark:shadow-lg dark:shadow-purple-800/80 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">Add booking</button>
                    <button type="button" class="text-white bg-gradient-to-r from-cyan-400 via-cyan-500 to-cyan-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-cyan-300 dark:focus:ring-cyan-800 shadow-lg shadow-cyan-500/50 dark:shadow-lg dark:shadow-cyan-800/80 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">Create Contract</button>
                
                  </div>
            </div>
      
            <div class="px-4 sm:px-6 lg:px-8">
      
                <div class="mt-8 flow-root">
                    <div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                        <div class="inline-block min-w-full py-2 align-middle sm:px-6 lg:px-8">
                            <table class="min-w-full divide-y divide-gray-300">
                                <thead>
                                    <tr class="divide-x divide-gray-200">
                                      <th scope="col" class="py-3.5 pl-4 pr-4 text-left text-sm font-semibold text-gray-900 sm:pl-0"></th>
                                        <th scope="col" class="py-3.5 pl-4 pr-4 text-left text-sm font-semibold text-gray-900 ">Facility ID</th>
                                        <th scope="col" class="px-4 py-3.5 text-left text-sm font-semibold text-gray-900">Customer ID</th>
                                        <th scope="col" class="px-4 py-3.5 text-left text-sm font-semibold text-gray-900">Start Date</th>
                                        <th scope="col" class="py-3.5 pl-4 pr-4 text-left text-sm font-semibold text-gray-900 sm:pr-0">End Date</th>
                                        <th scope="col" class="py-3.5 pl-4 pr-4 text-left text-sm font-semibold text-gray-900 sm:pr-0">Booking Date</th>
                                    </tr>
                                </thead>
                                <tbody class="divide-y divide-gray-200 bg-white">
      
                                    <c:forEach items="${bookings}" var="c">
                                        <tr class="divide-x divide-gray-200">
                                          <td class="whitespace-nowrap py-4 pl-4 pr-4 text-sm font-medium text-gray-900 sm:pl-0">
                                            
                                            <input type="checkbox" class="accent-pink-300 focus:accent-pink-500 w-[18px] h-[18px] ml-4" ></td>
                                            <td class="whitespace-nowrap py-4 pl-4 pr-4 text-sm font-medium text-gray-900">${c.facilityId}</td>
                                            <td class="whitespace-nowrap p-4 text-sm text-gray-500">${c.customerId}</td>
                                            <td class="whitespace-nowrap p-4 text-sm text-gray-500">${c.startDate}</td>
                                            <td class="whitespace-nowrap py-4 pl-4 pr-4 text-sm text-gray-500 sm:pr-0">${c.endDate}</td>
                                            <td class="whitespace-nowrap py-4 pl-4 pr-4 text-sm text-gray-500 sm:pr-0">${c.bookingDate}</td>
                                        </tr>
      
                                        
                                    </c:forEach>
      
      
                                    <!-- More people... -->
                                </tbody>
                            </table>
                            <nav class="flex items-center justify-between border-t border-gray-200 px-4 sm:px-0">
                                <div class="-mt-px flex w-0 flex-1">
                                    <a href="#" class="inline-flex items-center border-t-2 border-transparent pr-1 pt-4 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700">
                                        <svg class="mr-3 h-5 w-5 text-gray-400" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                        <path fill-rule="evenodd" d="M18 10a.75.75 0 01-.75.75H4.66l2.1 1.95a.75.75 0 11-1.02 1.1l-3.5-3.25a.75.75 0 010-1.1l3.5-3.25a.75.75 0 111.02 1.1l-2.1 1.95h12.59A.75.75 0 0118 10z" clip-rule="evenodd" />
                                        </svg>
                                        Previous
                                    </a>
                                </div>
                                <div class="hidden md:-mt-px md:flex">
                                    <a href="#" class="inline-flex items-center border-t-2 border-transparent px-4 pt-4 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700">1</a>
                                    <!-- Current: "border-indigo-500 text-indigo-600", Default: "border-transparent text-gray-500 hover:text-gray-700 hover:border-gray-300" -->
                                    <a href="#" class="inline-flex items-center border-t-2 border-indigo-500 px-4 pt-4 text-sm font-medium text-indigo-600" aria-current="page">2</a>
                                    <a href="#" class="inline-flex items-center border-t-2 border-transparent px-4 pt-4 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700">3</a>
                                    <span class="inline-flex items-center border-t-2 border-transparent px-4 pt-4 text-sm font-medium text-gray-500">...</span>
                                    <a href="#" class="inline-flex items-center border-t-2 border-transparent px-4 pt-4 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700">8</a>
                                    <a href="#" class="inline-flex items-center border-t-2 border-transparent px-4 pt-4 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700">9</a>
                                    <a href="#" class="inline-flex items-center border-t-2 border-transparent px-4 pt-4 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700">10</a>
                                </div>
                                <div class="-mt-px flex w-0 flex-1 justify-end">
                                    <a href="#" class="inline-flex items-center border-t-2 border-transparent pl-1 pt-4 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700">
                                        Next
                                        <svg class="ml-3 h-5 w-5 text-gray-400" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                        <path fill-rule="evenodd" d="M2 10a.75.75 0 01.75-.75h12.59l-2.1-1.95a.75.75 0 111.02-1.1l3.5 3.25a.75.75 0 010 1.1l-3.5 3.25a.75.75 0 11-1.02-1.1l2.1-1.95H2.75A.75.75 0 012 10z" clip-rule="evenodd" />
                                        </svg>
                                    </a>
                                </div>
                            </nav>
      
                        </div>
                    </div>
                </div>
            </div>
      
        </div>

        <%@ include file="/layout/footer.jsp" %>
    </body>
</html>