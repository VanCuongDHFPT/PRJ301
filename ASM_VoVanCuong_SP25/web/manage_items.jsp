<!DOCTYPE html>
<html>
<head>
    <title>Manage Item</title>
</head>
<body>
    <h1>MANAGE ITEM</h1>
    <form action="MainController" method="get"> 
        items ID: <input type="text" name="itemsID" value="" /><br/>
        items Name: <input type="text" name="itemsName" value="" /><br/>
        price: <input type="number" name="price" value="" /><br/>
        quantity: <input type="number" name="quantity" value="" /><br/>
        category ID: <input type="text" name="categoryID" value="" /><br/>
        <input type="submit" name="btAction" value="Update" />
    </form>
</body>
</html>
