<!-- 2015 Betsey McCarthy and Colin Hiriak -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Checkout</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css">    
</head>

<body>
    <img border="0" alt="belk_logo" src="images/belk-02.jpg">
    
    <h1>Belk Library</h1>
<div class ="border">
    <h2>Currently checked out books</h2>
    <section>   
        <table id="checkedOut">
            <tr id="table_header">
                <th>Patron Name</th>
                <th></th>
                <th>Email Address</th>
                <th></th>
                <th>Book Title</th>
                <th></th>
                <th>Due Date</th>
                <th></th>
                <th>Overdue</th>
                <th></th>
            </tr>
            
        
        </table>
        
        <p><a id="return" href="index.jsp?action=goToIndex&amp;">Return to front page</a><br><br>
        </p>
    </section>

   
</div>
    
    <%@include file="footer.jsp" %>


</body>
</html>