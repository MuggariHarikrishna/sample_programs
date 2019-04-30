<%@page import="com.dto.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- <link rel="stylesheet" href="todo.css"> -->
<style type="text/css">
@charset "UTF-8";

body {
	margin: 0;
	min-width: 250px;
}

/* Include the padding and border in an element's total width and height */
* {
	box-sizing: border-box;
}

/* Remove margins and padding from the list */
tr {
	margin: 0;
	padding: 0;
}

/* Style the list items */
tr td {
	cursor: pointer;
	position: relative;
	padding: 12px 8px 12px 40px;
	list-style-type: none;
	background: #eee;
	font-size: 18px;
	transition: 0.2s;
	/* make the list items unselectable */
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

/* Set all odd list items to a different color (zebra-stripes) */
tr td:nth-child(odd) {
	background: #f9f9f9;
}

/* Darker background-color on hover */
tr td:hover {
	background: #ddd;
}

/* When clicked on, add a background color and strike out text */
tr td.checked {
	background: #888;
	color: #fff;
	text-decoration: line-through;
}

/* Add a "checked" mark when clicked on */
tr td.checked::before {
	content: '';
	position: absolute;
	border-color: #fff;
	border-style: solid;
	border-width: 0 2px 2px 0;
	top: 10px;
	left: 16px;
	transform: rotate(45deg);
	height: 15px;
	width: 7px;
}

/* Style the close button */
.close {
	position: absolute;
	right: 0;
	top: 0;
	padding: 12px 16px 12px 16px;
}

<
style>body {
	margin: 0;
	min-width: 250px;
}

/* Include the padding and border in an element's total width and height */
* {
	box-sizing: border-box;
}

/* Remove margins and padding from the list */
tr {
	margin: 0;
	padding: 0;
}

/* Style the list items */
tr td {
	cursor: pointer;
	position: relative;
	padding: 12px 8px 12px 40px;
	list-style-type: none;
	background: #eee;
	font-size: 18px;
	transition: 0.2s;
	/* make the list items unselectable */
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

/* Set all odd list items to a different color (zebra-stripes) */
tr td:nth-child(odd) {
	background: #f9f9f9;
}

/* Darker background-color on hover */
tr td:hover {
	background: #ddd;
}

/* When clicked on, add a background color and strike out text */
tr td.checked {
	background: #888;
	color: #fff;
	text-decoration: line-through;
}

/* Add a "checked" mark when clicked on */
tr td.checked::before {
	content: '';
	position: absolute;
	border-color: #fff;
	border-style: solid;
	border-width: 0 2px 2px 0;
	top: 10px;
	left: 16px;
	transform: rotate(45deg);
	height: 15px;
	width: 7px;
}

/* Style the close button */
.close {
	position: absolute;
	right: 0;
	top: 0;
	padding: 12px 16px 12px 16px;
}

.close:hover {
	background-color: #bfbfbf;
	color: white;
}

/* Style the header */
.header {
	background-color: #bfbfbf;
	padding: 30px 40px;
	color: white;
	text-align: center;
}

/* Clear floats after the header */
.header:after {
	content: "";
	display: table;
	clear: both;
}

/* Style the input */
.input1 {
	margin: 0;
	border: none;
	border-radius: 0;
	width: 75%;
	padding: 10px;
	float: left;
	font-size: 16px;
	color: black;
	width: -webkit-fill-available;
}

/* Style the "Add" button */
.addBtn {
	padding: 10px;
	width: 25%;
	background: #d9d9d9;
	color: #555;
	float: left;
	text-align: center;
	font-size: 16px;
	cursor: pointer;
	transition: 0.3s;
	border-radius: 0;
	width: -webkit-fill-available;"
}

.addBtn1 {
	padding: 10px;
	width: 25%;
	background: #d9d9d9;
	color: #555;
	float: left;
	text-align: center;
	font-size: 16px;
	cursor: pointer;
	transition: 0.3s;
	border-radius: 0;
	}

.addBtn:hover {
	background-color: #bbb;
}
.myInput{
	margin: 0;
	border: none;
	padding: 10px;
	font-size: 16px;
}
</style>
</head>
<body>

	<%
		List<Order> orders = (List<Order>) request.getAttribute("orders");
	%>

<body>

 

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Update Order</h4>
        </div>
        <div class="modal-body">
        	<input type="hidden" id="orderId"/>
          Order:<input type="text" class="myInput" id="ModelOrderName"/><br>
          Quantity :<input type="text" class="myInput" id="ModelQuantity"/><br>
          <input type="button" class="addBtn" onclick="updateItem()" value="Update" style="padding: 5px"/><br>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>


	<div id="myDIV" class="header"
		style="width: 50%; margin-left: auto; margin-right: auto;">
		<span style="float: left; color: green;">Welcome</span>

		<h2 style="margin: 5px">Orders List</h2>
		<input type="text" placeholder="Title..." class="input1" id="myInput"/> 
		<input type="text" id="quantity" placeholder="Quantity" class="input1"/> 
		<input type="button" onclick="addItem()" class="addBtn" value="Add"/>
	</div>

	<table id="myUL"
		style="width: 50%; margin-left: auto; margin-right: auto;">
		<tr>
			<td><b>Name</b></td>
			<td><b>Quantity</b></td>
			<td><b>Action</b></td>
		
		</tr>
			<%
						for (Order order : orders) {
			%>
		<tr>
			<td id="item<%=order.getOrderNo()%>"><%=order.getOrderName()%></td>
			<td><%=order.getQuantity()%></td>
			<td><button class="addBtn1" onclick='UpdateItemBlock(<%=order.getOrderNo()%>,<%=order.getQuantity()%>,"<%=order.getOrderName()%>")'>Update</button>&nbsp;&nbsp;&nbsp;&nbsp;<button class="addBtn1" onclick='removeItem(<%=order.getOrderNo()%>,"<%=order.getOrderName()%>")'>Delete</button></td>
		</tr>
		<%
			}
		%>
	</table>
	
	<script type="text/javascript">
	
	
	 
		function UpdateItemBlock(OrderId,quantity,OrderName){
			$("#myModal").modal();
			$("#ModelOrderName").val(OrderName);
			$("#ModelQuantity").val(quantity);
			$("#orderId").val(OrderId);
		}
	
		function removeItem(itemId,itemName){
			if(confirm("are you sure to delete item : "+itemName)){
				 var parms = "id=" + itemId;
                 $.ajax({
                     type: "POST",
                     url: "deleteOrderbyId",
                     dataType: "html",
                     data: parms,
                     success: function(html) {
                         console.log(html);
                     	 alert("deleted");   
                     	location.reload();
                     },
                     error: function(e) {
                 		alert(JSON.stringify(e));
                 	 	console.log(e.message);
                 	  }
              	
                 });
			}
			else{
				return false;
			}
			
		}
		
		function addItem(){
			var itemName=document.getElementById("myInput").value;
			var quantity=document.getElementById("quantity").value;
			if(confirm("are you sure to add item : "+itemName)){
				 var parms = "OrderName=" + itemName+"&quantity="+quantity;
                 $.ajax({
                     type: "POST",
                     url: "addOrder",
                     dataType: "html",
                     data: parms,
                     success: function(html) {
                         console.log(html);
                         alert("added"); 
                     	location.reload();
                     },
                     error: function(e) {
                    		alert(JSON.stringify(e));
                    	 	console.log(e.message);
                    	  }
                 	
                 });
			}
			else{
				return false;
			}
			
		}
		
		function updateItem(){
			var itemName=document.getElementById("ModelOrderName").value;
			var itemId=document.getElementById("orderId").value;
			var quantity=document.getElementById("ModelQuantity").value;
			if(confirm("are you sure to Update item : "+itemName)){
				 var parms = "orderName=" + itemName+"&orderId="+itemId+"&quantity="+quantity;
                 $.ajax({
                     type: "POST",
                     url: "updateOrder",
                     dataType: "html",
                     data: parms,
                     success: function(html) {
                         console.log(html);
                         alert("updated"); 
                     	location.reload();
                     },
                     error: function(e) {
                    		alert(JSON.stringify(e));
                    	 	console.log(e.message);
                    	  }
                 	
                 });
			}
			else{
				return false;
			}
			
		}
		
	</script>

</body>
</body>

</html>