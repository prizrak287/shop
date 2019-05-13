<#import "macro.ftl" as m>
<@m.page "${bookInfo.name}">
    <div id="main">
        <@m.sidebar></@m.sidebar>
        <div id="content">
            <li>Название: ${bookInfo.name}</li>
            <#list bookInfo.authors as author>
                <a href="http://localhost:8081/authors/info?id=${author.id}">
                    <li>Автор: ${author.name}</li>
                </a>
            <#else>
                Нет авторов
            </#list>
            <li>Издательство: ${bookInfo.publishingHouse}</li>
            <li>Дата издательства: ${bookInfo.datePublishing}</li>
        </div>
    </div>
</@m.page>