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

        <%@ include file="../../AdminNav.jsp" %>
        <br>

        <div class="px-4 sm:px-6 lg:px-8">
            <div class="sm:flex sm:items-center">
                <div class="sm:flex-auto">
                    <h1 class="text-base font-semibold leading-6 text-gray-900">Promotion</h1>
                    <p class="mt-2 text-sm text-gray-700">A list of all the users in your account including their name, title, email and role.</p>
                </div>
              
            </div>
            <ul role="list" class="divide-y divide-gray-100 mx-6 mt-4">
                <li class="flex items-center justify-between gap-x-9 py-5">
                    <div class="min-w-0">
                        <div class="flex items-start gap-x-3">
                            <p class="text-sm font-semibold leading-6 text-gray-900">GraphQL API</p>
                            <p class="rounded-md whitespace-nowrap mt-0.5 px-1.5 py-0.5 text-xs font-medium ring-1 ring-inset text-green-700 bg-green-50 ring-green-600/20">Complete</p>
                        </div>
                        <div class="mt-1 flex items-center gap-x-2 text-xs leading-5 text-gray-500">
                            <p class="whitespace-nowrap">Due on <time datetime="2023-03-17T00:00Z">March 17, 2023</time></p>
                            <svg viewBox="0 0 2 2" class="h-0.5 w-0.5 fill-current">
                            <circle cx="1" cy="1" r="1" />
                            </svg>
                            <p class="truncate">Created by Leslie Alexander</p>
                        </div>
                    </div>
                    <div class="flex flex-none items-center gap-x-4">
                        <a href="#" class="hidden rounded-md bg-white px-2.5 py-1.5 text-sm font-semibold text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50 sm:block">View project<span class="sr-only">, GraphQL API</span></a>
                        <div class="relative flex-none">
                            <button type="button" class="-m-2.5 block p-2.5 text-gray-500 hover:text-gray-900" id="options-menu-0-button" aria-expanded="false" aria-haspopup="true">
                                <span class="sr-only">Open options</span>
                                <svg class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                <path d="M10 3a1.5 1.5 0 110 3 1.5 1.5 0 010-3zM10 8.5a1.5 1.5 0 110 3 1.5 1.5 0 010-3zM11.5 15.5a1.5 1.5 0 10-3 0 1.5 1.5 0 003 0z" />
                                </svg>
                            </button>

                        </div>
                    </div>
                </li>

                <li class="flex items-center justify-between gap-x-6 py-5">
                    <div class="min-w-0">
                        <div class="flex items-start gap-x-3">
                            <p class="text-sm font-semibold leading-6 text-gray-900">Onboarding emails</p>
                            <p class="rounded-md whitespace-nowrap mt-0.5 px-1.5 py-0.5 text-xs font-medium ring-1 ring-inset text-gray-600 bg-gray-50 ring-gray-500/10">In progress</p>
                        </div>
                        <div class="mt-1 flex items-center gap-x-2 text-xs leading-5 text-gray-500">
                            <p class="whitespace-nowrap">Due on <time datetime="2023-05-25T00:00Z">May 25, 2023</time></p>
                            <svg viewBox="0 0 2 2" class="h-0.5 w-0.5 fill-current">
                            <circle cx="1" cy="1" r="1" />
                            </svg>
                            <p class="truncate">Created by Courtney Henry</p>
                        </div>
                    </div>
                    <div class="flex flex-none items-center gap-x-4">
                        <a href="#" class="hidden rounded-md bg-white px-2.5 py-1.5 text-sm font-semibold text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50 sm:block">View project<span class="sr-only">, Onboarding emails</span></a>
                        <div class="relative flex-none">
                            <button type="button" class="-m-2.5 block p-2.5 text-gray-500 hover:text-gray-900" id="options-menu-2-button" aria-expanded="false" aria-haspopup="true">
                                <span class="sr-only">Open options</span>
                                <svg class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                <path d="M10 3a1.5 1.5 0 110 3 1.5 1.5 0 010-3zM10 8.5a1.5 1.5 0 110 3 1.5 1.5 0 010-3zM11.5 15.5a1.5 1.5 0 10-3 0 1.5 1.5 0 003 0z" />
                                </svg>
                            </button>

                        </div>
                    </div>
                </li>

                <li class="flex items-center justify-between gap-x-6 py-5">
                    <div class="min-w-0">
                        <div class="flex items-start gap-x-3">
                            <p class="text-sm font-semibold leading-6 text-gray-900">Marketing site redesign</p>
                            <p class="rounded-md whitespace-nowrap mt-0.5 px-1.5 py-0.5 text-xs font-medium ring-1 ring-inset text-yellow-800 bg-yellow-50 ring-yellow-600/20">Archived</p>
                        </div>
                        <div class="mt-1 flex items-center gap-x-2 text-xs leading-5 text-gray-500">
                            <p class="whitespace-nowrap">Due on <time datetime="2023-06-10T00:00Z">June 10, 2023</time></p>
                            <svg viewBox="0 0 2 2" class="h-0.5 w-0.5 fill-current">
                            <circle cx="1" cy="1" r="1" />
                            </svg>
                            <p class="truncate">Created by Courtney Henry</p>
                        </div>
                    </div>
                    <div class="flex flex-none items-center gap-x-4">
                        <a href="#" class="hidden rounded-md bg-white px-2.5 py-1.5 text-sm font-semibold text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50 sm:block">View project<span class="sr-only">, Marketing site redesign</span></a>
                        <div class="relative flex-none">
                            <button type="button" class="-m-2.5 block p-2.5 text-gray-500 hover:text-gray-900" id="options-menu-4-button" aria-expanded="false" aria-haspopup="true">
                                <span class="sr-only">Open options</span>
                                <svg class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                <path d="M10 3a1.5 1.5 0 110 3 1.5 1.5 0 010-3zM10 8.5a1.5 1.5 0 110 3 1.5 1.5 0 010-3zM11.5 15.5a1.5 1.5 0 10-3 0 1.5 1.5 0 003 0z" />
                                </svg>
                            </button>


                        </div>
                    </div>
                </li>
            </ul>

        </div>

    </body>
</html>