<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web TV</title>
    <style>
        /* Reset CSS per assicurare una base uniforme */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Stile globale per il body */
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            background-color: #f9f9f9;
        }

        /* Stile per l'header */
        #search-bar {
            text-align: center;
        }

        #search-bar input {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 20rem;
        }

        #search-bar button {
            padding: 8px 15px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-left: 5px;
        }

        #header-container {
            display: flex;
            align-items: center;
            justify-content: space-between;
            max-width: 1240px;
            margin: 0 auto;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        /* Stile per il titolo dell'header */
        header h1 {
            font-size: 2em;
        }

        #search {
            width: 20rem;
        }

        /* Stile per il main */
        main {
            padding: 20px;
        }

        /* Stile per la sezione dei video */
        #video-list {
            display: flex;
            justify-content: center;
            max-width: 1240px;
            margin: 2rem auto;
        }

        /* Stile per il titolo della sezione dei video */
        #video-list h2 {
            font-size: 1.5em;
            margin-bottom: 15px;
        }

        /* Stile per il container dei video */
        .video-container {
            display: grid;
            grid-template-columns: 35rem 35rem;
            gap: 20px;
        }

        /* Stile per il singolo video */
        .video {
            background-color: #fff;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        /* Stile per il titolo del video */
        .video h3 {
            font-size: 1.2em;
            margin-bottom: 10px;
        }

        /* Stile per il video stesso */
        .video video {
            width: 100%;
            border-radius: 5px;
        }

        /* Stile per il footer */
        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            left: 0;
            width: 100%;
        }

        /* Stile per il paragrafo del footer */
        footer p {
            font-size: 0.8em;
        }
    </style>
</head>
<body>
<header>
    <div id="header-container">
        <h1>Web TV</h1>
        <div id="search-bar">
            <form action="<c:url value='/utenteVideo' />" method="get">
                <input id="search" type="text" name="keyword" placeholder="Inserisci la parola chiave">
                <button type="submit" style="background-color:white; color:#333;">Cerca</button>
            </form>
        </div>
    </div>
</header>
<main>
    <section id="video-list">
        <div class="video-container">
            <!-- Loop per visualizzare i video recuperati dalla servlet -->
            <c:forEach var="video" items="${videos}">
                <div class="video">
                    <h3><c:out value="${video.titolo}" /></h3>
                    <video controls>
                        <source src="<c:url value='${video.url}' />" type="video/mp4">
                        Il tuo browser non supporta il tag video.
                    </video>
                </div>
            </c:forEach>
            <!-- Fine dell'elenco dei video -->
        </div>
    </section>
</main>
<footer>
    <p>&copy; 2024 Streaming App. Tutti i diritti riservati.</p>
</footer>
</body>
</html>