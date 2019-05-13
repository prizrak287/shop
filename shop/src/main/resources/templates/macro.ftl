<#macro page title>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
        <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
        <link rel="stylesheet" href="/style.css"/>
    </head>
    <body>
    <div id="main">
        <@sidebar></@sidebar>
        <div id="content">
            <#nested>
        </div>
    </div>
    </body>
    </html>
</#macro>

<#macro sidebar>
    <div id="left">
        <li><a href="http://localhost:8081/">Main</a></li>
        <li><a href="http://localhost:8081/authors">Authors</a></li>
        <li><a href="http://localhost:8081/books">Books</a></li>
    </div>
</#macro>

<#macro search entity>
    <#if entity == "author">
        <form action="/authors/search" method="get">
            <input type="text" name="author_name"/>
            <input type="submit" value="Search"/>
        </form>
    <#else>
        <form action="/books/search" method="get">
            <input type="text" name=book_name/>
            <input type="submit" value="Search"/>
        </form>
    </#if>
</#macro>

<#macro actionButtons entityMap entity>
    <@delete '${entityMap}' entity></@delete>
    <input type="button" value="Info" onclick="document.location = '/${entityMap}/info?id=${entity.id}'"/>
    <button onclick=del()>Delete</button>
</#macro>

<#macro tableAuthors listAuthors>
    <table>
        <tr>
            <th>Name</th>
            <th>Books</th>
            <th>Actions</th>
        </tr>
        <#list listAuthors as author>
            <tr>
                <td>${author.name}</td>
                <td>
                    <#list author.books as book>
                        <li>${book.name}</li>
                    <#else>
                        Книги отсутствуют
                    </#list>
                </td>
                <td>
                    <@actionButtons "authors" author></@actionButtons>
                </td>
            </tr>
        <#else>
            <h3>Таблица авторов пуста!!!</h3>
        </#list>
    </table>
</#macro>

<#macro tableBooks listBooks>
    <table>
        <tr>
            <th>Name</th>
            <th>Authors</th>
            <th>Action</th>
        </tr>
        <#list listBooks as book>
            <tr>
                <td>${book.name}</td>
                <td>
                    <#list book.authors as author>
                        <li>${author.name}</li>
                    <#else>
                        Авторы отсутсвуют
                    </#list>
                </td>
                <td>
                    <@actionButtons "books" book></@actionButtons>
                </td>
            </tr>
        <#else>
            <h3>Таблица авторов пуста!!!</h3>
        </#list>
    </table>
</#macro>

<#macro delete entityMap entity>
    <script type="text/javascript">
        function del() {
            $.ajax({
                url: '${entityMap}/delete',
                type: 'post',
                data: {
                    id: ${entity.id}
                },
                success: function (status) {
                    console.log(status);
                    if (status) {
                        $('table').on('click', 'input[type="button"]', function (e) {
                            $(this).closest('tr').remove()
                        })
                    }
                }
            })
        }
    </script>
</#macro>

<#macro add>
    <form>
        Author name <input type="text" name="author" id="author"/>
        Age <input type="text" name="age" id="age"/>
        Address <input type="text" name="address" id="address"/><br>
        Book name <input type="text" name="book_name" id="book_name"/>
        Publishing House <input type="text" name="publishingHouse" id="publishingHouse"/>
        Date of publishing <input type="text" name="datePublishing" id="datePublishing"/>
    </form>
    <input type="submit" onclick="add()"/>
    <script type="text/javascript">
        function add() {
            const json = {
                author_name: document.getElementById('author').value,
                age: document.getElementById('age').value,
                address: document.getElementById('address').value,
                books: [{
                    book_name: document.getElementById('book_name').value,
                    publishingHouse: document.getElementById('publishingHouse').value,
                    datePublishing: document.getElementById('datePublishing').value
                }]
            };
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: '/authors/add',
                type: 'POST',
                data: JSON.stringify(json),
                dataType: 'json',
                success: function (result) {
                    alert(result.responseText)
                },
                error: function (err) {
                    alert(err.responseText)
                }
            })
        }
    </script>
</#macro>