<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 02/12/2022
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.0.2/tailwind.min.css">

    <script defer src="https://unpkg.com/alpinejs@3.10.2/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"/>
</head>
<body class="">
<div class="min-h-screen flex justify-center items-center">
    <!-- Login Container -->
    <div class="absolute w-60 h-60 rounded-xl bg-[#1E4584] -top-5 -left-16 z-0 transform rotate-45 hidden md:block">
    </div>
    <div class="absolute w-48 h-48 rounded-xl bg-[#1E4584] -bottom-6 right-10 transform rotate-12 hidden md:block">
    </div>
    <div class="py-12 px-12 bg-white rounded-2xl shadow-xl z-20">
        <div class="mb-8 flex justify-center">
            <img class="w-32" src="https://wadifa.barlamane.com/wp-content/uploads/2016/08/CNSS.png" alt=""/>
        </div>
        <div>
            <h1 class="text-3xl font-bold text-center mb-4 cursor-pointer"> Bonjour Agent</h1>
            <p class="w-80 text-center text-sm mb-8 font-semibold text-gray-700 tracking-wide cursor-pointer">
                Connecter à votre compte</p>
        </div>
<%--        <c:out value="${sessionScope.step}"/>--%>

        <c:if test="${error.equals('true')}">
            <div class="bg-red-50 border-l-8 rounded-xl border-red-900 mb-1">
                <div class="flex items-center">
                    <div class="p-2">
                        <div class="flex items-center">
                            <div class="ml-2">
                                <svg class="h-8 w-8 text-red-900 mr-2 cursor-pointer"
                                     xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                     stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round"
                                          stroke-width="2"
                                          d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                                </svg>
                            </div>
                            <p class="px-6 py-4 text-red-900 font-semibold text-md">
                                email ou le mot de pass est incorrect


                            </p>
                        </div>

                    </div>
                </div>
            </div>
        </c:if>

        <form:form action="login" method="post" modelAttribute="agent">

            <div class="space-y-4">
                <form:input type="text" placeholder="Email Addres" path="email"
                            class="block text-sm py-3 px-4 rounded-lg w-full border outline-none"/>
                <form:input type="password" placeholder="Password" path="password"
                            class="block text-sm py-3 px-4 rounded-lg w-full border outline-none"/>
            </div>
            <div class="text-center mt-6">
                <button type="submit" class="py-3 w-64 text-xl text-white bg-[#1E4584] rounded-2xl">Login</button>

            </div>
        </form:form>
    </div>
    <div class="w-40 h-40 absolute bg-[#1FAAAC] rounded-full top-0 right-1 hidden md:block"></div>
    <div
            class="w-20 h-40 absolute bg-[#1FAAAC] rounded-full bottom-20 left-10 transform rotate-45 hidden md:block">
    </div>
</div>
</body>
</html>
