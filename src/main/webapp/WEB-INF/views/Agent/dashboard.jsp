<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 02/12/2022
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dossier Medical</title>
    <script src="https://cdn.tailwindcss.com"></script>

    <script defer src="https://unpkg.com/alpinejs@3.10.2/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"/>

</head>
<body>
<div class="absolute w-60 h-60 rounded-xl bg-[#1E4584] -top-5 -left-16 z-0 transform rotate-45 hidden md:block">
</div>
<div class="absolute w-48 h-48 rounded-xl bg-[#1E4584] bottom-10 right-10 transform rotate-12 hidden md:block">
</div>
<section class="py-1 bg-blueGray-50">
    <div class="w-full xl:w-8/12 mb-8 xl:mb-0 px-4 mx-auto mt-15">
        <div class="container mx-auto px-4">
            <div class="mb-8 flex justify-center">
                <img class="w-48" src="https://wadifa.barlamane.com/wp-content/uploads/2016/08/CNSS.png" alt=""/>
            </div>

        </div>
        <div class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded ">
            <div class="rounded-t mb-0 px-4 py-3 border-0">
                <div class="flex flex-wrap items-center">
                    <div class="relative w-full px-4 max-w-full flex-grow flex-1">
                        <h3 class="font-semibold text-base text-blueGray-700">Dossier Medical</h3>
                    </div>
                    <div class="relative w-full px-4 max-w-full flex-grow flex-1 text-right">
                        <%--                        <button--%>
                        <%--                                class="bg-[#1E4584] text-white active:bg-[#1FAAAC] text-xs font-bold uppercase px-3 py-1 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"--%>
                        <%--                                type="button">r--%>
                        <%--                        </button>--%>
                        <%--                        <c:url value="addDossier.jsp">--%>
                        <%--                            azertyuio--%>
                        <%--                        </c:url>--%>
                        <a class="bg-[#1E4584] text-white active:bg-[#1FAAAC] text-xs font-bold uppercase px-3 py-1 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"

                           href="<c:url value = "dossier/add"/>">Ajouter nouveau Dossie</a>

                    </div>
                </div>
            </div>

            <div class="block w-full overflow-x-auto">
                <table class="items-center bg-transparent w-full border-collapse ">
                    <thead>
                    <tr>
                        <th class="bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-center">
                            Matricule Patient
                        </th>

                        <th class="bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-center">
                            Mentant de Base
                        </th>
                        <th class="bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-center">
                            Mentant Rembourser
                        </th>
                        <th class="bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-center">
                            Etat
                        </th>
                        <th class="bg-blueGray-50 text-blueGray-500 align-middle border border-solid border-blueGray-100 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-center">
                            Action
                        </th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${listDossier}" var="dossier">


                        <tr>
                            <th class="border-t-0  align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-center text-blueGray-700 ">
                                    ${dossier.patientByIdPatient.matricule}

                            </th>

                            <th class="border-t-0  align-center border-l-0 border-r-0  text-center text-blueGray-700 text-xs whitespace-nowrap p-4">
                                <fmt:formatNumber type="number" maxFractionDigits="3" value="${dossier.mentantBase}"/>DH
                            </th>
                            <th class="border-t-0  align-center border-l-0 border-r-0  text-center text-blueGray-700 text-xs whitespace-nowrap p-4">
                                <fmt:formatNumber type="number" maxFractionDigits="3"
                                                  value="${dossier.mentantRemboussable}"/>DH
                            </th>
                            <td class="border-t-0  text-center align-center border-l-0 border-r-0  text-blueGray-700 text-xs whitespace-nowrap p-4">


                               <span
                                       class="inline-flex items-center justify-center rounded-full  ${dossier.etat.equals("ACCEPTED")?'bg-emerald-100 text-7000':dossier.etat.equals("EN_ATTENTE")?'bg-amber-100 text-amber-700' :'bg-red-100 text-red-700'} px-2.5 py-0.5 ">
                                    <p class="whitespace-nowrap text-sm">${dossier.etat}</p>
                                    </span>

                            </td>
                            <td class="border-t-0  justify-center flex text-center align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">


                                <form:form method="POST" action="dossier/traiter/${dossier.id}">

                                    <c:if test="${dossier.etat.equals('EN_ATTENTE')}">


                                        <%--                                refuser--%>
                                        <button type="submit" name="etat" value="REFUSER">
                                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"
                                                 class="h-6 w-6 ">
                                                <path d="M175 175C184.4 165.7 199.6 165.7 208.1 175L255.1 222.1L303 175C312.4 165.7 327.6 165.7 336.1 175C346.3 184.4 346.3 199.6 336.1 208.1L289.9 255.1L336.1 303C346.3 312.4 346.3 327.6 336.1 336.1C327.6 346.3 312.4 346.3 303 336.1L255.1 289.9L208.1 336.1C199.6 346.3 184.4 346.3 175 336.1C165.7 327.6 165.7 312.4 175 303L222.1 255.1L175 208.1C165.7 199.6 165.7 184.4 175 175V175zM512 256C512 397.4 397.4 512 256 512C114.6 512 0 397.4 0 256C0 114.6 114.6 0 256 0C397.4 0 512 114.6 512 256zM256 48C141.1 48 48 141.1 48 256C48 370.9 141.1 464 256 464C370.9 464 464 370.9 464 256C464 141.1 370.9 48 256 48z"/>
                                            </svg>
                                        </button>
                                        <%--    valider--%>
                                        <button type="submit" name="etat" value="ACCEPTED">
                                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"
                                                 class="h-6 w-6 mx-3">
                                                <path d="M243.8 339.8C232.9 350.7 215.1 350.7 204.2 339.8L140.2 275.8C129.3 264.9 129.3 247.1 140.2 236.2C151.1 225.3 168.9 225.3 179.8 236.2L224 280.4L332.2 172.2C343.1 161.3 360.9 161.3 371.8 172.2C382.7 183.1 382.7 200.9 371.8 211.8L243.8 339.8zM512 256C512 397.4 397.4 512 256 512C114.6 512 0 397.4 0 256C0 114.6 114.6 0 256 0C397.4 0 512 114.6 512 256zM256 48C141.1 48 48 141.1 48 256C48 370.9 141.1 464 256 464C370.9 464 464 370.9 464 256C464 141.1 370.9 48 256 48z"/>
                                            </svg>
                                        </button>
                                    </c:if>

                                </form:form>

                                    <%--                voir--%>
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" class="h-6 w-6 ">
                                    <path d="M160 256C160 185.3 217.3 128 288 128C358.7 128 416 185.3 416 256C416 326.7 358.7 384 288 384C217.3 384 160 326.7 160 256zM288 336C332.2 336 368 300.2 368 256C368 211.8 332.2 176 288 176C287.3 176 286.7 176 285.1 176C287.3 181.1 288 186.5 288 192C288 227.3 259.3 256 224 256C218.5 256 213.1 255.3 208 253.1C208 254.7 208 255.3 208 255.1C208 300.2 243.8 336 288 336L288 336zM95.42 112.6C142.5 68.84 207.2 32 288 32C368.8 32 433.5 68.84 480.6 112.6C527.4 156 558.7 207.1 573.5 243.7C576.8 251.6 576.8 260.4 573.5 268.3C558.7 304 527.4 355.1 480.6 399.4C433.5 443.2 368.8 480 288 480C207.2 480 142.5 443.2 95.42 399.4C48.62 355.1 17.34 304 2.461 268.3C-.8205 260.4-.8205 251.6 2.461 243.7C17.34 207.1 48.62 156 95.42 112.6V112.6zM288 80C222.8 80 169.2 109.6 128.1 147.7C89.6 183.5 63.02 225.1 49.44 256C63.02 286 89.6 328.5 128.1 364.3C169.2 402.4 222.8 432 288 432C353.2 432 406.8 402.4 447.9 364.3C486.4 328.5 512.1 286 526.6 256C512.1 225.1 486.4 183.5 447.9 147.7C406.8 109.6 353.2 80 288 80V80z"/>
                                </svg>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>

                </table>
            </div>
        </div>
    </div>
    <footer class="relative pt-8 pb-6 mt-16">

    </footer>
</section>
<div class="w-40 h-40 absolute bg-[#1FAAAC] rounded-full top-0 right-1 hidden md:block"></div>
<div
        class="w-20 h-40 absolute bg-[#1FAAAC] rounded-full bottom-20 left-10 transform rotate-45 hidden md:block">
</div>
</body>
</html>
