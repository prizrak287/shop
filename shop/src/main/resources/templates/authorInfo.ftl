<#import "macro.ftl" as m>
<@m.page "${authorInfo.name}">
    <div id="main">
        <@m.sidebar></@m.sidebar>
        <div id="content">
            <li>Имя: ${authorInfo.name}</li>
            <li>Возраст: ${authorInfo.age}</li>
            <li>Адрес: ${authorInfo.address}</li>
            <#list authorInfo.books as book>
                <a href="http://localhost:8081/books/info?id=${book.id}">
                    <li>Книга: ${book.name}</li>
                </a>
            <#else>
                Нет авторов
            </#list>
        </div>
    </div>
</@m.page>