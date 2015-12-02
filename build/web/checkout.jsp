<!--2015 Betsey McCarthy and Colin Hiriak-->


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
    <h2>Checkout a book</h2>

    <form action="library.jsp" method="post">
        <input class="inputs" type="hidden" name="action" value="add">        
        <label>Email:</label>
        <input id="email_input"  type="email" name="email"  ><br>
        <label>First Name:</label>
        <input class="inputs" type="text" name="firstName" ><br>
        <label>Last Name:</label>
        <input class="inputs" type="text" name="lastName" ><br> 
        <label>Book Title:</label>
        <input id="book_input" type="text" name="bookTitle" ><br>
        <label>&nbsp;</label>
        <input type="submit" value="checkout" id="check_button">
    </form>
</div>
    
    <p>To enter another email address, click on the Back 
    button in your browser or the Return button shown 
    below.</p>

    <form action="" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>

</body>
</html>