<%@ include file="../common/header.jspf"%>
<%@ include file="../common/footer.jspf"%>
<%@ page import="java.util.Random"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("submit").click(function(){
        $("#div1").load("demo_test.txt");
    });
});
</script>


<meta name="viewport" content="width=device-width, initial-scale=1">


<nav class="navbar navbar-default">

	<a href="#" class="navbar-brand">KH</a>
		<ul class="nav navbar-nav">
		<li class="active"><a href="/wel.do">Home</a></li>
	</ul>

	<ul class="nav navbar-nav">
		<li><a href="/wel.do">blog</a></li>

	</ul>
	<ul class="nav navbar-nav">
		<li><a href="/wel.do">about</a></li> 

	</ul>


	<ul class="nav navbar-nav navbar-right">
		<li><a href="wel.do">Login</a></li>
	</ul>

</nav>
<div class="container">
	<form action="wel.do" method="POST" class="form">
		<H1>Welcome to my Application</H1> ${errorMessage} <br>
		Please Enter Text: <input type="text" name="name" /> <input
			type="submit" value="Enter" /> <input type="radio"
			value="palindrome" name="radiobutton"> Palindrome  <input
			type="radio" value="reverse" name="radiobutton">Reverse  <input
			type="radio" value="count" name="radiobutton" >Count


	</form>
	<br>
	<br>
	<textarea rows="8" cols="70">
  ${input}	
     </textarea>
</div>
