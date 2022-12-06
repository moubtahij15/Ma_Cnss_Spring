<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <div class="relative flex flex-col min-w-0 break-words bg-[#FEFEFE] w-full mb-6 shadow-lg rounded p-4 ">
            <%--            steps--%>
            <div>
                <h2 class="sr-only">Steps</h2>

                <div>
                    <div class="overflow-hidden rounded-full bg-gray-200">
                        <div class="h-2  ${sessionScope.step==1?'w-1/6':sessionScope.step==2 ?'w-3/6':sessionScope.step==3?'4/6':'w-full'}  rounded-full  bg-[#1E4584]"></div>
                    </div>

                    <ol class="mt-4 grid grid-cols-4 text-sm font-medium text-[#1E4584] ">
                        <li class="flex items-center justify-start  ">
                            <span class="hidden sm:inline"> Consultation </span>
                            <svg class="h-6 w-6 sm:ml-2 sm:h-5 sm:w-5"
                                 xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512"
                                 stroke="currentColor"
                                 stroke-width="2">

                                <path d="M64 0C28.7 0 0 28.7 0 64V448c0 35.3 28.7 64 64 64H320c35.3 0 64-28.7 64-64V160H256c-17.7 0-32-14.3-32-32V0H64zM256 0V128H384L256 0zM160 240c0-8.8 7.2-16 16-16h32c8.8 0 16 7.2 16 16v48h48c8.8 0 16 7.2 16 16v32c0 8.8-7.2 16-16 16H224v48c0 8.8-7.2 16-16 16H176c-8.8 0-16-7.2-16-16V352H112c-8.8 0-16-7.2-16-16V304c0-8.8 7.2-16 16-16h48V240z"/>
                            </svg>
                        </li>
                        <li class="flex items-center justify-center  ${sessionScope.step!=1?'text-[#1E4584]':'text-[#1FAAAC]'}">
                            <span class="hidden sm:inline"> Medicament </span>

                            <svg class="h-6 w-6 sm:ml-2 sm:h-5 sm:w-5"
                                 xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512"
                                 stroke="currentColor"
                                 stroke-width="2">
                                <path d="M0 32C0 14.3 14.3 0 32 0H352c17.7 0 32 14.3 32 32V64c0 17.7-14.3 32-32 32H32C14.3 96 0 81.7 0 64V32zm32 96H352V448c0 35.3-28.7 64-64 64H96c-35.3 0-64-28.7-64-64V416H144c8.8 0 16-7.2 16-16s-7.2-16-16-16H32V320H144c8.8 0 16-7.2 16-16s-7.2-16-16-16H32V224H144c8.8 0 16-7.2 16-16s-7.2-16-16-16H32V128z"/>
                            </svg>
                        </li>

                        <li class="flex items-center justify-end text-[#1FAAAC] ">
                            <span class="hidden sm:inline"> Document </span>

                            <svg class="h-6 w-6 sm:ml-2 sm:h-5 sm:w-5"
                                 xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512"
                                 stroke="currentColor"
                                 stroke-width="2">
                                <path d="M64 0C28.7 0 0 28.7 0 64V448c0 35.3 28.7 64 64 64H320c35.3 0 64-28.7 64-64V160H256c-17.7 0-32-14.3-32-32V0H64zM256 0V128H384L256 0zM160 240c0-8.8 7.2-16 16-16h32c8.8 0 16 7.2 16 16v48h48c8.8 0 16 7.2 16 16v32c0 8.8-7.2 16-16 16H224v48c0 8.8-7.2 16-16 16H176c-8.8 0-16-7.2-16-16V352H112c-8.8 0-16-7.2-16-16V304c0-8.8 7.2-16 16-16h48V240z"/>
                            </svg>
                        </li>
                        <li class="flex items-center justify-end text-[#1FAAAC]">
                            <span class="hidden sm:inline"> Validation </span>

                            <svg class="h-6 w-6 sm:ml-2 sm:h-5 sm:w-5"
                                 xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"

                                 stroke="currentColor"
                                 stroke-width="2">
                                <path d="M256 512c141.4 0 256-114.6 256-256S397.4 0 256 0S0 114.6 0 256S114.6 512 256 512zM369 209L241 337c-9.4 9.4-24.6 9.4-33.9 0l-64-64c-9.4-9.4-9.4-24.6 0-33.9s24.6-9.4 33.9 0l47 47L335 175c9.4-9.4 24.6-9.4 33.9 0s9.4 24.6 0 33.9z"/>
                            </svg>
                        </li>
                    </ol>
                </div>
            </div>
            <%--            step1--%>
            <div class=" mx-auto w-full max-w-screen-xl bg-white px-4 py-16 sm:px-6 lg:px-8
                        ">
                <div class="mx-auto max-w-lg text-center">
                    <h1 class="text-2xl font-bold sm:text-3xl"> ${sessionScope.step==1?'Patient Info':sessionScope.step==2?'Medicament : ':sessionScope.step==3?'Document : ':' Validation Dossier'} </h1>
                    <h1 class="text-2xl font-bold sm:text-3xl"> ${sessionScope.step==4?' le mentant remboyrssable est '+sessionScope.cc :''} </h1>

                </div>

                <form action="/dossier/add" method="post" class="mx-auto mt-8 mb-0 max-w-md space-y-4">
                    <c:if test="${sessionScope.step!=4}">
                        <div>

                            <div class="relative">

                                <input
                                        id="code"
                                        name="code"
                                        type="text"
                                        class="w-full border-2 rounded-lg border-gray-200 p-4 pr-12 text-sm shadow-sm"
                                        placeholder="Entrer le ${sessionScope.step==1?' Matricule':sessionScope.step==2?'Barr Code : ':sessionScope.step==3?'Code de document : ':''}"
                                />

                            </div>


                        </div>
                    </c:if>
                    <c:if test="${sessionScope.step!=4 &&sessionScope.step==3 }">
                        <div class="mt-3">
                            <input
                                    id="prix"
                                    name="prix"
                                    type="text"
                                    class="w-full border-2 rounded-lg border-gray-200 p-4 pr-12 text-sm shadow-sm"
                                    placeholder="Entrer le Prix"
                            />

                        </div>
                    </c:if>


                    <c:if test="${sessionScope.step==1||sessionScope.step==3}">

                        <div>
                            <label for="type"
                                   class="sr-only">Type ${sessionScope.step==1?'Consultation':'Document'} </label>

                            <select id="type"
                                    name="type"
                                    class="w-full rounded-lg border-2 border-gray-200 p-4 pr-12 text-sm shadow-sm">
                                <option selected disabled> Choisir le Type</option>
                                <c:if test="${sessionScope.step==1}">
                                    <c:forEach items="${consultations}" var="consultation">
                                        <option value=${consultation.id}>${consultation.type}</option>
                                    </c:forEach>

                                </c:if>
                                <c:if test="${sessionScope.step==3}">
                                    <option value=1>Scanner</option>
                                    <option value=2>Radio</option>
                                    <option value=3>Analyse</option>
                                </c:if>


                            </select>
                                <%--                        <c:out value="${sessionScope.test}"/>--%>


                        </div>
                    </c:if>

                    <button
                            type="submit"
                            class=" w-full inline-block rounded-lg bg-[#1FAAAC] px-5 py-3 mx-auto text-sm font-medium text-white"
                    >
                        Valider
                    </button>


                </form>

            </div>

            <c:if test="${sessionScope.step==2||sessionScope.step==3}">
                <form action="/dossier/next" method="post" class="flex justify-end">

                    <BUTTON
                            type="submit"
                            class="group flex   items-center justify-between rounded-lg border border-[#1E4584] px-5 py-3  transition-colors hover:bg-[#1FAAAC] focus:outline-none hover:border-[#1FAAAC] focus:ring active:bg-[#1FAAAC]"
                    >
                    <span class="font-medium text-[#1E4584] transition-colors group-hover:text-white">
                    passer à l'étape suivant
                    </span>

                        <span
                                class="ml-4 flex-shrink-0 rounded-full border border-indigo-600 bg-white p-2 group-active:border-indigo-500"
                        >
    <svg
            class="h-5 w-5"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
    >
      <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M17 8l4 4m0 0l-4 4m4-4H3"
      />
    </svg>
  </span>
                    </BUTTON>
                </form>

            </c:if>


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
