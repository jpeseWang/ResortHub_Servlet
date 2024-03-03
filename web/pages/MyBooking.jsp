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


        <br>
        <jsp:include page="../layout/header.jsp"/>  
        <div class="px-4 sm:px-6 lg:px-8">


            <div class="px-4 sm:px-6 lg:px-8">

                <div class="mt-8 flow-root">
                    <div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                        <div class="inline-block min-w-full py-2 align-middle sm:px-6 lg:px-8">
                            <table class="min-w-full divide-y divide-gray-300">
                                <thead>
                                    <tr class="divide-x divide-gray-200">
                                        <th scope="col" class="py-3.5 pl-4 pr-4 text-left text-sm font-semibold text-gray-900 sm:pl-0">Facility ID</th>

                                        <th scope="col" class="px-4 py-3.5 text-left text-sm font-semibold text-gray-900">Start Date</th>
                                        <th scope="col" class="py-3.5 pl-4 pr-4 text-left text-sm font-semibold text-gray-900 sm:pr-0">End Date</th>
                                        <th scope="col" class="py-3.5 pl-4 pr-4 text-left text-sm font-semibold text-gray-900 sm:pr-0">Booking Date</th>
                                    </tr>
                                </thead>
                                <tbody class="divide-y divide-gray-200 bg-white">

                                    <c:forEach items="${bookings}" var="c">

                                        <tr class="divide-x divide-gray-200">
                                            <td class="whitespace-nowrap py-4 pl-4 pr-4 text-sm font-medium text-gray-900 sm:pl-0">${c.facilityId}</td>

                                            <td class="whitespace-nowrap p-4 text-sm text-gray-500">${c.startDate}</td>
                                            <td class="whitespace-nowrap py-4 pl-4 pr-4 text-sm text-gray-500 sm:pr-0">${c.endDate}</td>
                                            <td class="whitespace-nowrap py-4 pl-4 pr-4 text-sm text-gray-500 sm:pr-0">${c.bookingDate}</td>
                                        </tr>


                                    </c:forEach>


                                    <!-- More people... -->
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!--            <div class="bg-white">
                            <div class="mx-auto max-w-4xl py-16 sm:px-6 sm:py-24">
                                <div class="px-4 sm:px-0">
                                    <h1 class="text-2xl font-bold tracking-tight text-gray-900 sm:text-3xl">My booking history</h1>
                                    <p class="mt-2 text-sm text-gray-500">Check the status of recent orders, manage returns, and download invoices.</p>
                                </div>
            
                                <div class="mt-16">
                                    <h2 class="sr-only">Recent orders</h2>
            
                                    <div class="space-y-16 sm:space-y-24">
                                        <div>
                                            <h3 class="sr-only">Order placed on <time datetime="2021-01-22">January 22, 2021</time></h3>
            
            
            
                                            <div class="mt-6 flow-root px-4 sm:mt-10 sm:px-0">
                                                <div class="-my-6 divide-y divide-gray-200 sm:-my-10">
            
            <c:forEach items="${bookings}" var="c">
                <div class="flex py-6 sm:py-10">
                    <div class="min-w-0 flex-1 lg:flex lg:flex-col">
                        <div class="lg:flex-1">
                            <div class="sm:flex">
                                <div>
                                    <h4 class="font-medium text-gray-900">Nomad Tumbler</h4>
                                    <p class="mt-2 hidden text-sm text-gray-500 sm:block">This durable double-walled insulated tumbler keeps your beverages at the perfect temperature all day long. Hot, cold, or even lukewarm if you&#039;re weird like that, this bottle is ready for your next adventure.</p>
                                </div>
                                <p class="mt-1 font-medium text-gray-900 sm:ml-6 sm:mt-0">$35.00</p>
                            </div>
                            <div class="mt-2 flex text-sm font-medium sm:mt-4">
                                <a href="#" class="text-indigo-600 hover:text-indigo-500">View Product</a>
                                <div class="ml-4 border-l border-gray-200 pl-4 sm:ml-6 sm:pl-6">
                                    <a href="#" class="text-indigo-600 hover:text-indigo-500">Buy Again</a>
                                </div>
                            </div>
                        </div>
                        <div class="mt-6 font-medium">
                            <p>Out for delivery</p>
                        </div>
                    </div>
                    <div class="ml-4 flex-shrink-0 sm:order-first sm:m-0 sm:mr-6">
                        <img src="https://tailwindui.com/img/ecommerce-images/order-history-page-06-product-01.jpg" alt="Olive drab green insulated bottle with flared screw lid and flat top." class="col-start-2 col-end-3 h-20 w-20 rounded-lg object-cover object-center sm:col-start-1 sm:row-span-2 sm:row-start-1 sm:h-40 sm:w-40 lg:h-52 lg:w-52">
                    </div>
                </div>

            </c:forEach>


            <div class="flex py-6 sm:py-10">
                <div class="min-w-0 flex-1 lg:flex lg:flex-col">
                    <div class="lg:flex-1">
                        <div class="sm:flex">
                            <div>
                                <h4 class="font-medium text-gray-900">Nomad Tumbler</h4>
                                <p class="mt-2 hidden text-sm text-gray-500 sm:block">This durable double-walled insulated tumbler keeps your beverages at the perfect temperature all day long. Hot, cold, or even lukewarm if you&#039;re weird like that, this bottle is ready for your next adventure.</p>
                            </div>
                            <p class="mt-1 font-medium text-gray-900 sm:ml-6 sm:mt-0">$35.00</p>
                        </div>
                        <div class="mt-2 flex text-sm font-medium sm:mt-4">
                            <a href="#" class="text-indigo-600 hover:text-indigo-500">View Product</a>
                            <div class="ml-4 border-l border-gray-200 pl-4 sm:ml-6 sm:pl-6">
                                <a href="#" class="text-indigo-600 hover:text-indigo-500">Buy Again</a>
                            </div>
                        </div>
                    </div>
                    <div class="mt-6 font-medium">
                        <p>Out for delivery</p>
                    </div>
                </div>
                <div class="ml-4 flex-shrink-0 sm:order-first sm:m-0 sm:mr-6">
                    <img src="https://tailwindui.com/img/ecommerce-images/order-history-page-06-product-01.jpg" alt="Olive drab green insulated bottle with flared screw lid and flat top." class="col-start-2 col-end-3 h-20 w-20 rounded-lg object-cover object-center sm:col-start-1 sm:row-span-2 sm:row-start-1 sm:h-40 sm:w-40 lg:h-52 lg:w-52">
                </div>
            </div>

             More products... 
        </div>
    </div>
</div>

 More orders... 
</div>
</div>
</div>
</div>-->

   <!--Pagination-->
                        <nav class="flex items-center justify-between border-t border-gray-200 px-4 sm:px-0 mt-6">
                            <div class="-mt-px flex w-0 flex-1">
                                <c:if test="${meta.page > 1}">
                                    <a href='BookingController?action=getMyBooking&Page=${meta.page - 1}&PageSize=10' class="inline-flex items-center border-t-2 border-transparent pr-1 pt-4 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700">
                                        <svg class="mr-3 h-5 w-5 text-gray-400" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                        <path fill-rule="evenodd" d="M18 10a.75.75 0 01-.75.75H4.66l2.1 1.95a.75.75 0 11-1.02 1.1l-3.5-3.25a.75.75 0 010-1.1l3.5-3.25a.75.75 0 111.02 1.1l-2.1 1.95h12.59A.75.75 0 0118 10z" clip-rule="evenodd" />
                                        </svg>
                                        Previous
                                    </a>
                                </c:if>
                            </div>

                            <div class="hidden md:-mt-px md:flex">
                                <c:forEach begin="1" end="${meta.pageCount}" varStatus="page">
                                    <c:choose>
                                        <c:when test="${page.index == meta.page}">
                                            <a href="#" class="inline-flex items-center border-t-2 border-indigo-500 px-4 pt-4 text-sm font-medium text-indigo-600" aria-current="page">${page.index}</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href='BookingController?action=getMyBooking&Page=${page.index}&PageSize=10' class="inline-flex items-center border-t-2 border-transparent px-4 pt-4 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700">${page.index}</a>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </div>

                            <div class="-mt-px flex w-0 flex-1 justify-end">
                                <c:if test="${meta.page < meta.pageSize && meta.page < meta.pageCount}">
                                    <a href='BookingController?action=getMyBooking&Page=${meta.page + 1}&PageSize=10' class="inline-flex items-center border-t-2 border-transparent pl-1 pt-4 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700">
                                        Next
                                        <svg class="ml-3 h-5 w-5 text-gray-400" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                        <path fill-rule="evenodd" d="M2 10a.75.75 0 01.75-.75h12.59l-2.1-1.95a.75.75 0 111.02-1.1l3.5 3.25a.75.75 0 010 1.1l-3.5 3.25a.75.75 0 11-1.02-1.1l2.1-1.95H2.75A.75.75 0 012 10z" clip-rule="evenodd" />
                                        </svg>
                                    </a>
                                </c:if>
                            </div>
                        </nav>
        </div>

        <%@ include file="/layout/footer.jsp" %>
    </body>
</html>